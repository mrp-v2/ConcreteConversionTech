package mrp_v2.concreteconversiontech.tileentity;

import com.mojang.serialization.DataResult;
import mrp_v2.concreteconversiontech.ConcreteConversionTech;
import mrp_v2.concreteconversiontech.inventory.AutomationConcreteConverterItemStackHandler;
import mrp_v2.concreteconversiontech.inventory.ConcreteConverterItemStackHandler;
import mrp_v2.concreteconversiontech.tileentity.util.ConcreteConverterData;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.ConcretePowderBlock;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.world.level.block.entity.TickableBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.core.Direction;
import net.minecraft.world.Nameable;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

abstract public class AbstractConcreteConverterTileEntity extends BlockEntity
        implements ICapabilityProvider, TickableBlockEntity, MenuProvider, Nameable
{
    public static final int BASE_TICKS_PER_ITEM = 16;
    public static final String ID_STEM_PRE = "concrete_converter_";
    public static final HashMap<Item, Item> POWDER_TO_CONCRETE = new HashMap<>();
    private static final String DATA_NBT_ID = "ConcreteConverterData";
    protected final AutomationConcreteConverterItemStackHandler inventory;
    protected final LazyOptional<AutomationConcreteConverterItemStackHandler> inventoryLazyOptional;
    protected final String id;
    protected int ticksSpentConverting;
    protected int ticksPerItem;
    @Nullable private Component customName;

    public AbstractConcreteConverterTileEntity(BlockEntityType<?> tileEntityTypeIn, int ioSlots, String id)
    {
        super(tileEntityTypeIn);
        this.ticksSpentConverting = 0;
        this.inventory = new AutomationConcreteConverterItemStackHandler(
                new ConcreteConverterItemStackHandler(ioSlots * 2, this));
        this.inventoryLazyOptional = LazyOptional.of(() -> this.inventory);
        this.id = id;
        this.ticksPerItem = BASE_TICKS_PER_ITEM;
    }

    public static boolean isConcretePowder(ItemStack stack)
    {
        return Block.byItem(stack.getItem()) instanceof ConcretePowderBlock;
    }

    public AutomationConcreteConverterItemStackHandler getInventory()
    {
        return this.inventory;
    }

    public int getTicksSpentConverting()
    {
        return ticksSpentConverting;
    }

    public int getTicksPerItem()
    {
        return ticksPerItem;
    }

    @Override public abstract AbstractContainerMenu createMenu(int id, Inventory playerInventoryIn, Player playerIn);

    @Override public void load(BlockState state, CompoundTag compound)
    {
        super.load(state, compound);
        if (compound.contains(DATA_NBT_ID, 10))
        {
            CompoundTag dataNBT = compound.getCompound(DATA_NBT_ID);
            DataResult<ConcreteConverterData> dataResult =
                    ConcreteConverterData.CODEC.parse(NbtOps.INSTANCE, dataNBT);
            dataResult.resultOrPartial(ConcreteConversionTech.LOGGER::error).ifPresent((data) ->
            {
                this.ticksSpentConverting = data.getTicksSpentConverting();
                this.ticksPerItem = data.getTicksPerConversion();
                this.inventory.parent.deserializeNBT(data.getInventoryData());
                this.customName = data.getCustomName();
            });
        }
    }

    @Override public CompoundTag save(CompoundTag compound)
    {
        super.save(compound);
        ConcreteConverterData.CODEC.encodeStart(NbtOps.INSTANCE, new ConcreteConverterData(this))
                .resultOrPartial(ConcreteConversionTech.LOGGER::error)
                .ifPresent((data) -> compound.put(DATA_NBT_ID, data));
        return compound;
    }

    @Override public void setRemoved()
    {
        super.setRemoved();
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

    @Override public Component getName()
    {
        return hasCustomName() ? getCustomName() : getDefaultName();
    }

    @Nullable @Override public Component getCustomName()
    {
        return this.customName;
    }

    public void setCustomName(@Nullable Component customName)
    {
        this.customName = customName;
    }

    private Component getDefaultName()
    {
        return new TranslatableComponent(
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
            this.setChanged();
        } else if (this.ticksSpentConverting != 0)
        {
            this.ticksSpentConverting = 0;
            this.setChanged();
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
                if (enchantments.containsKey(Enchantments.BLOCK_EFFICIENCY))
                {
                    level += enchantments.get(Enchantments.BLOCK_EFFICIENCY);
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
            Block block = Block.byItem(sourceItem);
            if (block instanceof ConcretePowderBlock)
            {
                POWDER_TO_CONCRETE.put(sourceItem, ((ConcretePowderBlock) block).concrete.getBlock().asItem());
            } else
            {
                return;
            }
        }
        this.inventory.parent.extractItem(sourceIndex, 1, false);
        this.inventory.parent.insertItem(destinationIndex, new ItemStack(POWDER_TO_CONCRETE.get(sourceItem), 1), false);
    }

    @Override public Component getDisplayName()
    {
        return Nameable.super.getDisplayName();
    }
}
