package mrp_v2.concreteconversiontech.tileentity;

import mrp_v2.concreteconversiontech.ConcreteConversionTech;
import mrp_v2.concreteconversiontech.inventory.ConcreteConverterItemStackHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ConcretePowderBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;

import javax.annotation.Nullable;
import java.util.HashMap;

abstract public class AbstractConcreteConverterTileEntity extends TileEntity
        implements ICapabilityProvider, ITickableTileEntity, INamedContainerProvider
{
    protected static final String ID_STEM_PRE = "concrete_converter_";
    protected static final String ID_STEM_POST = "_tile_entity";
    private static final int TICKS_PER_ITEM = 16;
    private static final HashMap<Item, Item> POWDER_TO_CONCRETE = new HashMap<>();
    private static final String INVENTORY_NBT_ID = "Inventory";
    private static final String TICKS_SPENT_CONVERTING_NBT_ID = "TicksSpentConverting";
    protected final ConcreteConverterItemStackHandler inventory;
    private final LazyOptional<ConcreteConverterItemStackHandler> inventoryLazyOptional;
    private final String id;
    private int ticksSpentConverting;

    public AbstractConcreteConverterTileEntity(TileEntityType<?> tileEntityTypeIn, int ioSlots, String id)
    {
        super(tileEntityTypeIn);
        this.ticksSpentConverting = 0;
        this.inventory = new ConcreteConverterItemStackHandler(ioSlots * 2);
        this.inventoryLazyOptional = LazyOptional.of(() -> inventory);
        this.id = id;
    }

    public static boolean isConcretePowder(ItemStack stack)
    {
        return Block.getBlockFromItem(stack.getItem()) instanceof ConcretePowderBlock;
    }

    @Override public abstract Container createMenu(int id, PlayerInventory playerInventoryIn, PlayerEntity playerIn);

    @Override public void read(BlockState state, CompoundNBT nbt)
    {
        super.read(state, nbt);
        inventory.deserializeNBT(nbt.getCompound(INVENTORY_NBT_ID));
        ticksSpentConverting = nbt.getInt(TICKS_SPENT_CONVERTING_NBT_ID);
    }

    @Override public CompoundNBT write(CompoundNBT compound)
    {
        super.write(compound);
        compound.put(INVENTORY_NBT_ID, inventory.serializeNBT());
        compound.putInt(TICKS_SPENT_CONVERTING_NBT_ID, ticksSpentConverting);
        return compound;
    }

    @Override public void remove()
    {
        super.remove();
        inventoryLazyOptional.invalidate();
    }

    @Override public <T> LazyOptional<T> getCapability(Capability<T> cap, @Nullable Direction side)
    {
        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
        {
            return inventoryLazyOptional.cast();
        }
        return super.getCapability(cap, side);
    }

    @Override public ITextComponent getDisplayName()
    {
        return new TranslationTextComponent(
                "block." + ConcreteConversionTech.ID + "." + this.id.replace("tile_entity", "block"));
    }

    @Override public void tick()
    {
        if (!inventory.isInputEmpty())
        {
            this.ticksSpentConverting++;
            if (this.ticksSpentConverting >= TICKS_PER_ITEM)
            {
                this.ticksSpentConverting = 0;
                attemptConversions();
            }
            this.markDirty();
        } else if (this.ticksSpentConverting != 0)
        {
            this.ticksSpentConverting = 0;
            this.markDirty();
        }
    }

    private void attemptConversions()
    {
        for (int i = 0; i < inventory.getSlots() / 2; i++)
        {
            int destination = this.calculateDestinationSlot(i);
            if (destination < 0)
            {
                continue;
            }
            convertItem(i, destination);
        }
    }

    private int calculateDestinationSlot(int slot)
    {
        Item powderItem = inventory.getStackInSlot(slot).getItem();
        for (int i = inventory.getSlots() / 2; i < inventory.getSlots(); i++)
        {
            if (inventory.getStackInSlot(i).getCount() < inventory.getStackInSlot(i).getMaxStackSize())
            {
                if (inventory.getStackInSlot(i).getItem() == POWDER_TO_CONCRETE.get(powderItem))
                {
                    return i;
                }
            }
        }
        for (int i = inventory.getSlots() / 2; i < inventory.getSlots(); i++)
        {
            if (inventory.getStackInSlot(i).isEmpty())
            {
                return i;
            }
        }
        return -1;
    }

    private void convertItem(int sourceIndex, int destinationIndex)
    {
        Item sourceItem = inventory.getStackInSlot(sourceIndex).getItem();
        if (!POWDER_TO_CONCRETE.containsKey(sourceItem))
        {
            Block block = Block.getBlockFromItem(sourceItem);
            if (block instanceof ConcretePowderBlock)
            {
                POWDER_TO_CONCRETE.put(sourceItem, ((ConcretePowderBlock) block).solidifiedState.getBlock().asItem());
            } else
            {
                return;
            }
        }
        inventory.extractItem(sourceIndex, 1);
        inventory.insertItem(destinationIndex, new ItemStack(POWDER_TO_CONCRETE.get(sourceItem), 1));
    }
}
