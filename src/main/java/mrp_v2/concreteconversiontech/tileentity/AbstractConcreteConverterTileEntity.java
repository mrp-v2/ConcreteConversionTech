package mrp_v2.concreteconversiontech.tileentity;

import mrp_v2.concreteconversiontech.ConcreteConversionTech;
import mrp_v2.concreteconversiontech.inventory.AutomationConcreteConverterItemStackHandler;
import mrp_v2.concreteconversiontech.inventory.ConcreteConverterItemStackHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ConcretePowderBlock;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
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
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

abstract public class AbstractConcreteConverterTileEntity extends TileEntity
        implements ICapabilityProvider, ITickableTileEntity, INamedContainerProvider
{
    public static final int BASE_TICKS_PER_ITEM = 16;
    public static final String ID_STEM_PRE = "concrete_converter_";
    public static final String ID_STEM_POST = "_tile_entity";
    public static final HashMap<Item, Item> POWDER_TO_CONCRETE = new HashMap<>();
    public static final String INVENTORY_NBT_ID = "Inventory";
    public static final String TICKS_SPENT_CONVERTING_NBT_ID = "TicksSpentConverting";
    protected final AutomationConcreteConverterItemStackHandler inventory;
    protected final LazyOptional<AutomationConcreteConverterItemStackHandler> inventoryLazyOptional;
    protected final String id;
    protected int ticksSpentConverting;
    protected int ticksPerItem;

    public AbstractConcreteConverterTileEntity(TileEntityType<?> tileEntityTypeIn, int ioSlots, String id)
    {
        super(tileEntityTypeIn);
        this.ticksSpentConverting = 0;
        this.inventory =
                new AutomationConcreteConverterItemStackHandler(new ConcreteConverterItemStackHandler(ioSlots * 2));
        this.inventoryLazyOptional = LazyOptional.of(() -> this.inventory);
        this.id = id;
        this.ticksPerItem = BASE_TICKS_PER_ITEM;
    }

    public static boolean isConcretePowder(ItemStack stack)
    {
        return Block.getBlockFromItem(stack.getItem()) instanceof ConcretePowderBlock;
    }

    @Override public abstract Container createMenu(int id, PlayerInventory playerInventoryIn, PlayerEntity playerIn);

    @Override public void read(BlockState state, CompoundNBT nbt)
    {
        super.read(state, nbt);
        this.inventory.parent.deserializeNBT(nbt.getCompound(INVENTORY_NBT_ID));
        this.ticksSpentConverting = nbt.getInt(TICKS_SPENT_CONVERTING_NBT_ID);
    }

    @Override public CompoundNBT write(CompoundNBT compound)
    {
        super.write(compound);
        compound.put(INVENTORY_NBT_ID, this.inventory.parent.serializeNBT());
        compound.putInt(TICKS_SPENT_CONVERTING_NBT_ID, this.ticksSpentConverting);
        return compound;
    }

    @Override public void remove()
    {
        super.remove();
        this.inventoryLazyOptional.invalidate();
    }

    @Override public <T> LazyOptional<T> getCapability(Capability<T> cap, @Nullable Direction side)
    {
        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
        {
            return this.inventoryLazyOptional.cast();
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
        if (!this.inventory.parent.isInputEmpty())
        {
            if (this.ticksSpentConverting == 0)
            {
                this.ticksPerItem = Math.max(BASE_TICKS_PER_ITEM - getEfficiencyLevel(), 1);
            }
            this.ticksSpentConverting++;
            if (this.ticksSpentConverting >= ticksPerItem)
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

    private int getEfficiencyLevel()
    {
        int level = 0;
        for (int i = this.inventory.parent.getSlots() - 4; i < this.inventory.parent.getSlots(); i++)
        {
            ItemStack stack = this.inventory.parent.getStackInSlot(i);
            if (stack.getItem() == Items.ENCHANTED_BOOK)
            {
                Map<Enchantment, Integer> enchantments = EnchantmentHelper.getEnchantments(stack);
                if (enchantments.containsKey(Enchantments.EFFICIENCY))
                {
                    level += enchantments.get(Enchantments.EFFICIENCY);
                }
            }
        }
        return level;
    }

    private void attemptConversions()
    {
        for (int i = 0; i < (this.inventory.parent.getSlots() - 3) / 2; i++)
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
        Item powderItem = this.inventory.parent.getStackInSlot(slot).getItem();
        for (int i = (this.inventory.parent.getSlots() - 3) / 2; i < (this.inventory.parent.getSlots() - 3); i++)
        {
            if (this.inventory.parent.getStackInSlot(i).getCount() <
                    this.inventory.parent.getStackInSlot(i).getMaxStackSize())
            {
                if (this.inventory.parent.getStackInSlot(i).getItem() == POWDER_TO_CONCRETE.get(powderItem))
                {
                    return i;
                }
            }
        }
        for (int i = (this.inventory.parent.getSlots() - 3) / 2; i < (this.inventory.parent.getSlots() - 3); i++)
        {
            if (this.inventory.parent.getStackInSlot(i).isEmpty())
            {
                return i;
            }
        }
        return -1;
    }

    private void convertItem(int sourceIndex, int destinationIndex)
    {
        Item sourceItem = this.inventory.parent.getStackInSlot(sourceIndex).getItem();
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
        this.inventory.parent.extractItem(sourceIndex, 1);
        this.inventory.parent.insertItem(destinationIndex, new ItemStack(POWDER_TO_CONCRETE.get(sourceItem), 1));
    }
}
