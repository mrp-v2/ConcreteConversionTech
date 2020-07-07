package mrp_v2.concreteconversiontech.common.tileentity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import mrp_v2.concreteconversiontech.common.inventory.ConcreteConverterItemStackHandler;
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
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

abstract public class AbstractConcreteConverterTileEntity extends TileEntity
		implements ICapabilityProvider, ITickableTileEntity, INamedContainerProvider {

	private class ConversionInfo {
		private static final String ITEM_ID_NBT_ID = "ItemId";
		private static final String CAN_CONVERT_NBT_ID = "CanConvert";
		private static final String SOURCE_INDEX_NBT_ID = "SourceIndex";
		private static final String DESTINATION_INDEX_NBT_ID = "DestinationIndex";

		boolean canConvert;

		int sourceIndex;

		int destinationIndex;

		Item itemConverting;

		public ConversionInfo(boolean canConvert) {
			this(canConvert, -1, -1, Items.AIR);
		}

		public ConversionInfo(boolean canConvert, int sourceIndex, int destinationIndex, Item itemConverting) {
			this.canConvert = canConvert;
			this.sourceIndex = sourceIndex;
			this.destinationIndex = destinationIndex;
			this.itemConverting = itemConverting;
		}

		@SuppressWarnings("deprecation")
		public ConversionInfo(CompoundNBT nbt) {
			canConvert = nbt.getBoolean(CAN_CONVERT_NBT_ID);
			sourceIndex = nbt.getInt(SOURCE_INDEX_NBT_ID);
			destinationIndex = nbt.getInt(DESTINATION_INDEX_NBT_ID);
			itemConverting = Registry.ITEM.getOrDefault(new ResourceLocation(nbt.getString(ITEM_ID_NBT_ID)));
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (getClass() != obj.getClass()) {
				return false;
			}
			ConversionInfo other = (ConversionInfo) obj;
			if (canConvert != other.canConvert) {
				return false;
			}
			if (destinationIndex != other.destinationIndex) {
				return false;
			}
			if (sourceIndex != other.sourceIndex) {
				return false;
			}
			if (itemConverting != other.itemConverting) {
				return false;
			}
			return true;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + (canConvert ? 1231 : 1237);
			result = prime * result + destinationIndex;
			result = prime * result + sourceIndex;
			return result;
		}

		@SuppressWarnings("deprecation")
		public CompoundNBT write() {
			CompoundNBT nbt = new CompoundNBT();
			nbt.putBoolean(CAN_CONVERT_NBT_ID, canConvert);
			nbt.putInt(SOURCE_INDEX_NBT_ID, sourceIndex);
			nbt.putInt(DESTINATION_INDEX_NBT_ID, destinationIndex);
			ResourceLocation resourceLocation = Registry.ITEM.getKey(itemConverting);
			nbt.putString(ITEM_ID_NBT_ID, resourceLocation == null ? "minecraft:air" : resourceLocation.toString());
			return nbt;
		}
	}

	protected static final String ID_STEM_PRE = "concrete_converter_";
	protected static final String ID_STEM_POST = "_tile_entity";
	private static final String INVENTORY_NBT_ID = "Inventory";
	private static final String TICKS_SPENT_CONVERTING_NBT_ID = "TicksSpentConverting";

	private static final String CURRENT_CONVERSION_NBT_ID = "ConversionInfo";
	protected static final Map<Item, Item> POWDER_TO_CONCRETE;

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

	private final int ticksPerItem;
	private int ticksSpentConverting;

	private ConversionInfo currentConversion;

	public AbstractConcreteConverterTileEntity(TileEntityType<?> tileEntityTypeIn, int ioSlots, int ticksPerItem) {
		super(tileEntityTypeIn);
		this.ticksPerItem = ticksPerItem;
		this.ticksSpentConverting = 0;
		this.currentConversion = new ConversionInfo(false);
		this.inventory = new ConcreteConverterItemStackHandler(ioSlots * 2, this);
		this.inventoryLazyOptional = LazyOptional.of(() -> inventory);
	}

	private ConversionInfo calculateConversionInfo() {
		ArrayList<Integer> viableSourceSlots = new ArrayList<Integer>();
		for (int i = inventory.getSlots() / 2 - 1; i >= 0; i--) {
			if (isConcretePowder(inventory.getStackInSlot(i))) {
				viableSourceSlots.add(i);
			}
		}
		if (viableSourceSlots.size() <= 0) {
			return new ConversionInfo(false);
		}
		for (int i1 : viableSourceSlots) {
			for (int i2 = inventory.getSlots() / 2; i2 < inventory.getSlots(); i2++) {
				if (inventory.getStackInSlot(i2).getCount() < inventory.getStackInSlot(i2).getMaxStackSize()) {
					if (inventory.getStackInSlot(i2).getItem() == POWDER_TO_CONCRETE
							.get(inventory.getStackInSlot(i1).getItem())) {
						return new ConversionInfo(true, i1, i2, inventory.getStackInSlot(i1).getItem());
					}
				}
			}
			for (int i2 = inventory.getSlots() / 2; i2 < inventory.getSlots(); i2++) {
				if (inventory.getStackInSlot(i2).isEmpty()) {
					return new ConversionInfo(true, i1, i2, inventory.getStackInSlot(i1).getItem());
				}
			}
		}
		return new ConversionInfo(false);
	}

	public void contentsChanged() {
		ConversionInfo conversionInfo = calculateConversionInfo();
		if (currentConversion.canConvert && !conversionInfo.canConvert) {
			ticksSpentConverting = 0;
			currentConversion = conversionInfo;
			this.markDirty();
		} else if (!currentConversion.canConvert && conversionInfo.canConvert) {
			currentConversion = conversionInfo;
			this.markDirty();
		} else if (currentConversion.canConvert && conversionInfo.canConvert) {
			if (!currentConversion.equals(conversionInfo)) {
				if (!isValid(currentConversion)) {
					ticksSpentConverting = 0;
					currentConversion = conversionInfo;
					this.markDirty();
				}
			}
		}
	}

	private void convertItem(int sourceIndex, int destinationIndex) {
		Item sourceItem = inventory.getStackInSlot(sourceIndex).getItem();
		inventory.extractItem(sourceIndex, 1);
		inventory.insertItem(destinationIndex, new ItemStack(POWDER_TO_CONCRETE.get(sourceItem), 1));
	}

	@Override
	public abstract Container createMenu(int id, PlayerInventory playerInventoryIn, PlayerEntity playerIn);

	@Override
	public void func_230337_a_(BlockState state, CompoundNBT nbt) {
		super.func_230337_a_(state, nbt);
		((ItemStackHandler) inventory).deserializeNBT(nbt.getCompound(INVENTORY_NBT_ID));
		ticksSpentConverting = nbt.getInt(TICKS_SPENT_CONVERTING_NBT_ID);
		currentConversion = new ConversionInfo(nbt.getCompound(CURRENT_CONVERSION_NBT_ID));
	}

	@Override
	public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
		if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
			return inventoryLazyOptional.cast();
		}
		return super.getCapability(cap, side);
	}

	private boolean isValid(ConversionInfo conversionInfo) {
		if (inventory.getStackInSlot(conversionInfo.sourceIndex).getItem() != conversionInfo.itemConverting) {
			return false;
		}
		if (!inventory.getStackInSlot(conversionInfo.destinationIndex).isEmpty()
				&& inventory.getStackInSlot(conversionInfo.destinationIndex).getItem() != POWDER_TO_CONCRETE
						.get(inventory.getStackInSlot(conversionInfo.sourceIndex).getItem())) {
			return false;
		}
		return true;
	}

	@Override
	public void tick() {
		if (currentConversion.canConvert) {
			ticksSpentConverting++;
			if (ticksSpentConverting >= ticksPerItem) {
				convertItem(currentConversion.sourceIndex, currentConversion.destinationIndex);
				ticksSpentConverting = 0;
			} else {
				this.markDirty();
			}
		}
	}

	@Override
	public CompoundNBT write(CompoundNBT compound) {
		super.write(compound);
		compound.put(INVENTORY_NBT_ID, ((ItemStackHandler) inventory).serializeNBT());
		compound.putInt(TICKS_SPENT_CONVERTING_NBT_ID, ticksSpentConverting);
		compound.put(CURRENT_CONVERSION_NBT_ID, currentConversion.write());
		return compound;
	}
}
