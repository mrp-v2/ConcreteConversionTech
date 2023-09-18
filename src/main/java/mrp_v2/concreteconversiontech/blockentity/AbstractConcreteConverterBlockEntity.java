package mrp_v2.concreteconversiontech.blockentity;

import com.mojang.serialization.DataResult;
import mrp_v2.concreteconversiontech.ConcreteConversionTech;
import mrp_v2.concreteconversiontech.blockentity.util.ConcreteConverterData;
import mrp_v2.concreteconversiontech.inventory.AutomationConcreteConverterItemStackHandler;
import mrp_v2.concreteconversiontech.inventory.ConcreteConverterItemStackHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.contents.TranslatableContents;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.Nameable;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ConcretePowderBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

abstract public class AbstractConcreteConverterBlockEntity extends BlockEntity
        implements ICapabilityProvider, MenuProvider, Nameable {
    public static final int BASE_TICKS_PER_ITEM = 16;
    public static final String ID_STEM_PRE = "concrete_converter_";
    public static final HashMap<Item, Item> POWDER_TO_CONCRETE = new HashMap<>();
    private static final String DATA_NBT_ID = "ConcreteConverterData";
    protected final AutomationConcreteConverterItemStackHandler inventory;
    protected final LazyOptional<AutomationConcreteConverterItemStackHandler> inventoryLazyOptional;
    protected final String id;
    protected int ticksSpentConverting;
    protected int ticksPerItem;
    @Nullable
    private Component customName;

    public AbstractConcreteConverterBlockEntity(BlockEntityType<?> tileEntityTypeIn, int ioSlots, String id, BlockPos pos, BlockState state) {
        super(tileEntityTypeIn, pos, state);
        this.ticksSpentConverting = 0;
        this.inventory = new AutomationConcreteConverterItemStackHandler(
                new ConcreteConverterItemStackHandler(ioSlots * 2, this));
        this.inventoryLazyOptional = LazyOptional.of(() -> this.inventory);
        this.id = id;
        this.ticksPerItem = BASE_TICKS_PER_ITEM;
    }

    public static boolean isConcretePowder(ItemStack stack) {
        return Block.byItem(stack.getItem()) instanceof ConcretePowderBlock;
    }

    public static void tick(Level level, BlockPos pos, BlockState state, AbstractConcreteConverterBlockEntity concreteConverter) {
        if (!concreteConverter.inventory.parent.isInputEmpty()) {
            if (concreteConverter.ticksSpentConverting == 0) {
                concreteConverter.ticksPerItem = Math.max(BASE_TICKS_PER_ITEM - concreteConverter.getEfficiencyLevel(), 1);
            }
            concreteConverter.ticksSpentConverting++;
            if (concreteConverter.ticksSpentConverting >= concreteConverter.ticksPerItem) {
                concreteConverter.ticksSpentConverting = 0;
                concreteConverter.attemptConversions();
            }
            concreteConverter.setChanged();
        } else if (concreteConverter.ticksSpentConverting != 0) {
            concreteConverter.ticksSpentConverting = 0;
            concreteConverter.setChanged();
        }
    }

    public AutomationConcreteConverterItemStackHandler getInventory() {
        return this.inventory;
    }

    public int getTicksSpentConverting() {
        return ticksSpentConverting;
    }

    public int getTicksPerItem() {
        return ticksPerItem;
    }

    @Override
    public abstract AbstractContainerMenu createMenu(int id, Inventory playerInventoryIn, Player playerIn);

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        if (tag.contains(DATA_NBT_ID, 10)) {
            CompoundTag dataNBT = tag.getCompound(DATA_NBT_ID);
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

    @Override
    public void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        ConcreteConverterData.CODEC.encodeStart(NbtOps.INSTANCE, new ConcreteConverterData(this))
                .resultOrPartial(ConcreteConversionTech.LOGGER::error)
                .ifPresent((data) -> tag.put(DATA_NBT_ID, data));
    }

    @Override
    public void setRemoved() {
        super.setRemoved();
        this.inventoryLazyOptional.invalidate();
    }

    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> cap, @Nullable Direction side) {
        if (cap == ForgeCapabilities.ITEM_HANDLER) {
            return this.inventoryLazyOptional.cast();
        }
        return super.getCapability(cap, side);
    }

    @Override
    public Component getName() {
        return hasCustomName() ? getCustomName() : getDefaultName();
    }

    @Nullable
    @Override
    public Component getCustomName() {
        return this.customName;
    }

    public void setCustomName(@Nullable Component customName) {
        this.customName = customName;
    }

    private Component getDefaultName() {
        return MutableComponent.create(new TranslatableContents(
                "block." + ConcreteConversionTech.ID + "." + this.id.replace("tile_entity", "block"), null, new Object[0]));
    }

    private int getEfficiencyLevel() {
        int level = 0;
        for (int i = this.inventory.parent.getSlots() - 4; i < this.inventory.parent.getSlots(); i++) {
            ItemStack stack = this.inventory.parent.getStackInSlot(i);
            if (stack.getItem() == Items.ENCHANTED_BOOK) {
                Map<Enchantment, Integer> enchantments = EnchantmentHelper.getEnchantments(stack);
                if (enchantments.containsKey(Enchantments.BLOCK_EFFICIENCY)) {
                    level += enchantments.get(Enchantments.BLOCK_EFFICIENCY);
                }
            }
        }
        return level;
    }

    private void attemptConversions() {
        for (int i = 0; i < (this.inventory.parent.getSlots() - 3) / 2; i++) {
            int destination = this.calculateDestinationSlot(i);
            if (destination < 0) {
                continue;
            }
            convertItem(i, destination);
        }
    }

    private int calculateDestinationSlot(int slot) {
        Item powderItem = this.inventory.parent.getStackInSlot(slot).getItem();
        for (int i = (this.inventory.parent.getSlots() - 3) / 2; i < (this.inventory.parent.getSlots() - 3); i++) {
            if (this.inventory.parent.getStackInSlot(i).getCount() <
                    this.inventory.parent.getStackInSlot(i).getMaxStackSize()) {
                if (this.inventory.parent.getStackInSlot(i).getItem() == POWDER_TO_CONCRETE.get(powderItem)) {
                    return i;
                }
            }
        }
        for (int i = (this.inventory.parent.getSlots() - 3) / 2; i < (this.inventory.parent.getSlots() - 3); i++) {
            if (this.inventory.parent.getStackInSlot(i).isEmpty()) {
                return i;
            }
        }
        return -1;
    }

    private void convertItem(int sourceIndex, int destinationIndex) {
        Item sourceItem = this.inventory.parent.getStackInSlot(sourceIndex).getItem();
        if (!POWDER_TO_CONCRETE.containsKey(sourceItem)) {
            Block block = Block.byItem(sourceItem);
            if (block instanceof ConcretePowderBlock) {
                POWDER_TO_CONCRETE.put(sourceItem, ((ConcretePowderBlock) block).concrete.getBlock().asItem());
            } else {
                return;
            }
        }
        this.inventory.parent.extractItem(sourceIndex, 1, false);
        this.inventory.parent.insertItem(destinationIndex, new ItemStack(POWDER_TO_CONCRETE.get(sourceItem), 1), false);
    }

    @Override
    public Component getDisplayName() {
        return Nameable.super.getDisplayName();
    }
}
