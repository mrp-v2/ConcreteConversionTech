package mrp_v2.concreteconversiontech.common.tileentity;

import mrp_v2.concreteconversiontech.common.inventory.ConcreteConverterItemStackHandler;
import mrp_v2.concreteconversiontech.common.util.CCTUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ConcretePowderBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

abstract public class AbstractConcreteConverterTileEntity extends TileEntity
		implements ICapabilityProvider, ITickableTileEntity, INamedContainerProvider {

	protected static final String ID_STEM_PRE = "concrete_converter_";
	protected static final String ID_STEM_POST = "_tile_entity";
	private static final String INVENTORY_NBT_ID = "Inventory";
	private static final String TICKS_SPENT_CONVERTING_NBT_ID = "TicksSpentConverting";

	public static final int TICKS_PER_ITEM = 16;

	public static final Map<Item, Item> POWDER_TO_CONCRETE;

	static {
		HashMap<Item, Item> temp = new HashMap<Item, Item>();
		temp.put(Items.BLACK_CONCRETE_POWDER, Items.BLACK_CONCRETE);
		temp.put(Items.BLUE_CONCRETE_POWDER, Items.BLUE_CONCRETE);
		temp.put(Items.BROWN_CONCRETE_POWDER, Items.BROWN_CONCRETE);
		temp.put(Items.CYAN_CONCRETE_POWDER, Items.CYAN_CONCRETE);
		temp.put(Items.GRAY_CONCRETE_POWDER, Items.GRAY_CONCRETE);
		temp.put(Items.GREEN_CONCRETE_POWDER, Items.GREEN_CONCRETE);
		temp.put(Items.LIGHT_BLUE_CONCRETE_POWDER, Items.LIGHT_BLUE_CONCRETE);
		temp.put(Items.LIGHT_GRAY_CONCRETE_POWDER, Items.LIGHT_GRAY_CONCRETE);
		temp.put(Items.LIME_CONCRETE_POWDER, Items.LIME_CONCRETE);
		temp.put(Items.MAGENTA_CONCRETE_POWDER, Items.MAGENTA_CONCRETE);
		temp.put(Items.ORANGE_CONCRETE_POWDER, Items.ORANGE_CONCRETE);
		temp.put(Items.PINK_CONCRETE_POWDER, Items.PINK_CONCRETE);
		temp.put(Items.PURPLE_CONCRETE_POWDER, Items.PURPLE_CONCRETE);
		temp.put(Items.RED_CONCRETE_POWDER, Items.RED_CONCRETE);
		temp.put(Items.WHITE_CONCRETE_POWDER, Items.WHITE_CONCRETE);
		temp.put(Items.YELLOW_CONCRETE_POWDER, Items.YELLOW_CONCRETE);
		POWDER_TO_CONCRETE = Collections.unmodifiableMap(temp);
	}

	public static boolean isConcretePowder(ItemStack stack) {
		return Block.getBlockFromItem(stack.getItem()) instanceof ConcretePowderBlock;
	}

	protected final ConcreteConverterItemStackHandler inventory;
	private LazyOptional<ConcreteConverterItemStackHandler> inventoryLazyOptional;

	private int ticksSpentConverting;

	private String id;

	public AbstractConcreteConverterTileEntity(TileEntityType<?> tileEntityTypeIn, int ioSlots, String id) {
		super(tileEntityTypeIn);
		this.ticksSpentConverting = 0;
		this.inventory = new ConcreteConverterItemStackHandler(ioSlots * 2, this);
		this.inventoryLazyOptional = LazyOptional.of(() -> inventory);
		this.id = id;
	}

	private void attemptConversions() {
		for (int i = 0; i < inventory.getSlots() / 2; i++) {
			int destination = this.calculateDestinationSlot(i);
			if (destination < 0) {
				continue;
			}
			convertItem(i, destination);
		}
	}

	private int calculateDestinationSlot(int slot) {
		Item powderItem = inventory.getStackInSlot(slot).getItem();
		for (int i = inventory.getSlots() / 2; i < inventory.getSlots(); i++) {
			if (inventory.getStackInSlot(i).getCount() < inventory.getStackInSlot(i).getMaxStackSize()) {
				if (inventory.getStackInSlot(i).getItem() == POWDER_TO_CONCRETE.get(powderItem)) {
					return i;
				}
			}
		}
		for (int i = inventory.getSlots() / 2; i < inventory.getSlots(); i++) {
			if (inventory.getStackInSlot(i).isEmpty()) {
				return i;
			}
		}
		return -1;
	}

	private void convertItem(int sourceIndex, int destinationIndex) {
		Item sourceItem = inventory.getStackInSlot(sourceIndex).getItem();
		inventory.extractItem(sourceIndex, 1);
		inventory.insertItem(destinationIndex, new ItemStack(POWDER_TO_CONCRETE.get(sourceItem), 1));
	}

	@Override
	public abstract Container createMenu(int id, PlayerInventory playerInventoryIn, PlayerEntity playerIn);

	@Override
	public void read(BlockState state, CompoundNBT nbt) {
		super.read(state, nbt);
		((ItemStackHandler) inventory).deserializeNBT(nbt.getCompound(INVENTORY_NBT_ID));
		ticksSpentConverting = nbt.getInt(TICKS_SPENT_CONVERTING_NBT_ID);
	}

	@Override
	public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
		if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
			return inventoryLazyOptional.cast();
		}
		return super.getCapability(cap, side);
	}

	@Override
	public ITextComponent getDisplayName() {
		return CCTUtil.makeTranslation(this.id, "display_name");
	}

	@Override
	public void remove() {
		super.remove();
		inventoryLazyOptional.invalidate();
	}

	@Override
	public void tick() {
		if (!inventory.isInputEmpty()) {
			this.ticksSpentConverting++;
			if (this.ticksSpentConverting >= TICKS_PER_ITEM) {
				this.ticksSpentConverting = 0;
				attemptConversions();
			}
			this.markDirty();
		} else if (this.ticksSpentConverting != 0) {
			this.ticksSpentConverting = 0;
			this.markDirty();
		}
	}

	@Override
	public CompoundNBT write(CompoundNBT compound) {
		super.write(compound);
		compound.put(INVENTORY_NBT_ID, ((ItemStackHandler) inventory).serializeNBT());
		compound.putInt(TICKS_SPENT_CONVERTING_NBT_ID, ticksSpentConverting);
		return compound;
	}
}
