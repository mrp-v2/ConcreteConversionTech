package mrp_v2.concreteconversiontech.common.tileentity;

import java.util.ArrayList;

import mrp_v2.concreteconversiontech.common.util.CCTObjectHolder;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ConcretePowderBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;

public class ConcreteConverterTileEntityTier1 extends ConcreteConverterTileEntityBase {

	public static final String ID = ID_STEM + "tier_1";

	private NonNullList<ItemStack> items = NonNullList.withSize(2, ItemStack.EMPTY);

	private static final int TICKS_PER_ITEM = 16;
	private static final String CONVERSION_TICKS_NBT_ID = "TickProgress";

	private int ticksSpentConverting;
	private boolean isConverting;
	private ConversionInfo currentConversion;

	public ConcreteConverterTileEntityTier1() {
		super(CCTObjectHolder.CONCRETE_CONVERTER_TILE_ENTITY_TYPE_TIER_1);
	}

	@Override
	public void func_230337_a_(BlockState state, CompoundNBT nbt) {
		super.func_230337_a_(state, nbt);
		items = NonNullList.withSize(items.size(), ItemStack.EMPTY);
		ItemStackHelper.loadAllItems(nbt, items);
		ticksSpentConverting = nbt.getInt(CONVERSION_TICKS_NBT_ID);
		currentConversion = new ConversionInfo(nbt);
	}

	@Override
	public void tick() {
		if (isConverting) {
			ticksSpentConverting++;
			if (ticksSpentConverting >= TICKS_PER_ITEM) {
				convertItem(currentConversion.sourceIndex, currentConversion.destinationIndex);
				ticksSpentConverting = 0;
			}
			this.markDirty();
		}
	}

	private void contentsChanged() {
		ConversionInfo conversionInfo = calculateConversionInfo();
		if (isConverting && !conversionInfo.canConvert) {
			ticksSpentConverting = 0;
			currentConversion = conversionInfo;
			isConverting = conversionInfo.canConvert;
			this.markDirty();
		} else if (!isConverting && conversionInfo.canConvert) {
			currentConversion = conversionInfo;
			isConverting = conversionInfo.canConvert;
			this.markDirty();
		} else if (isConverting && conversionInfo.canConvert) {
			if (!currentConversion.equals(conversionInfo)) {
				if (!isValid(currentConversion)) {
					ticksSpentConverting = 0;
					currentConversion = conversionInfo;
					this.markDirty();
				}
			}
		}
	}

	private boolean isValid(ConversionInfo conversionInfo) {
		if (items.get(conversionInfo.sourceIndex).getItem() != conversionInfo.itemConverting) {
			return false;
		}
		if (!items.get(conversionInfo.destinationIndex).isEmpty() && items.get(conversionInfo.destinationIndex)
				.getItem() != POWDER_TO_CONCRETE.get(items.get(conversionInfo.sourceIndex).getItem())) {
			return false;
		}
		return true;
	}

	private void convertItem(int sourceIndex, int destinationIndex) {
		ItemStack sourceStack = items.get(sourceIndex);
		Item sourceItem = sourceStack.getItem();
		sourceStack.setCount(sourceStack.getCount() - 1);
		if (items.get(destinationIndex).isEmpty()) {
			items.set(destinationIndex, new ItemStack(POWDER_TO_CONCRETE.get(sourceItem), 1));
		} else {
			items.get(destinationIndex).setCount(items.get(destinationIndex).getCount() + 1);
		}
		this.markDirty();
		contentsChanged();
	}

	private ConversionInfo calculateConversionInfo() {
		ArrayList<Integer> viableSourceSlots = new ArrayList<Integer>();
		for (int i = items.size() / 2 - 1; i >= 0; i--) {
			if (isConcretePowder(items.get(i))) {
				viableSourceSlots.add(i);
			}
		}
		if (viableSourceSlots.size() <= 0) {
			return new ConversionInfo(false);
		}
		for (int i1 : viableSourceSlots) {
			for (int i2 = items.size() / 2; i2 < items.size(); i2++) {
				if (items.get(i2).getCount() < items.get(i2).getMaxStackSize()) {
					if (items.get(i2).getItem() == POWDER_TO_CONCRETE.get(items.get(i1).getItem())) {
						return new ConversionInfo(true, i1, i2, items.get(i1).getItem());
					}
				}
			}
			for (int i2 = items.size() / 2; i2 < items.size(); i2++) {
				if (items.get(i2).isEmpty()) {
					return new ConversionInfo(true, i1, i2, items.get(i1).getItem());
				}
			}
		}
		return new ConversionInfo(false);
	}

	private class ConversionInfo {
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

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + (canConvert ? 1231 : 1237);
			result = prime * result + destinationIndex;
			result = prime * result + sourceIndex;
			return result;
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

		@SuppressWarnings("deprecation")
		public CompoundNBT write(CompoundNBT nbt) {
			CompoundNBT sub = new CompoundNBT();
			ResourceLocation resourceLocation = Registry.ITEM.getKey(itemConverting);
			sub.putString(ID_ID, resourceLocation == null ? "minecraft:air" : resourceLocation.toString());
			sub.putBoolean(CAN_CONVERT_ID, canConvert);
			sub.putInt(SOURCE_INDEX_ID, sourceIndex);
			sub.putInt(DESTINATION_INDEX_ID, destinationIndex);
			nbt.put(CONVERSION_INFO_ID, sub);
			return nbt;
		}

		private static final String ID_ID = "id";
		private static final String CAN_CONVERT_ID = "CanConvert";
		private static final String SOURCE_INDEX_ID = "SourceIndex";
		private static final String DESTINATION_INDEX_ID = "DestinationIndex";
		private static final String CONVERSION_INFO_ID = "ConversionInfo";

		public ConversionInfo(CompoundNBT nbt) {
			CompoundNBT sub = nbt.getCompound(CONVERSION_INFO_ID);
			itemConverting = Registry.ITEM.getOrDefault(new ResourceLocation(sub.getString(ID_ID)));
			canConvert = sub.getBoolean(CAN_CONVERT_ID);
			sourceIndex = sub.getInt(SOURCE_INDEX_ID);
			destinationIndex = sub.getInt(DESTINATION_INDEX_ID);
		}
	}

	private boolean isConcretePowder(ItemStack stack) {
		return Block.getBlockFromItem(stack.getItem()) instanceof ConcretePowderBlock;
	}

	@Override
	public CompoundNBT write(CompoundNBT compound) {
		super.write(compound);
		ItemStackHelper.saveAllItems(compound, items);
		compound.putInt(CONVERSION_TICKS_NBT_ID, ticksSpentConverting);
		currentConversion.write(compound);
		return compound;
	}

	@Override
	public int[] getSlotsForFace(Direction side) {
		int[] slots = new int[items.size()];
		for (int i = 0; i < items.size(); i++) {
			slots[i] = i;
		}
		return slots;
	}

	@Override
	public boolean canInsertItem(int index, ItemStack itemStackIn, Direction direction) {
		if (index >= items.size() / 2) {
			return false;
		}
		if (!isConcretePowder(itemStackIn)) {
			return false;
		}
		return true;
	}

	@Override
	public boolean canExtractItem(int index, ItemStack stack, Direction direction) {
		if (index < items.size() / 2) {
			return false;
		}
		if (isConcretePowder(stack)) {
			return false;
		}
		return true;
	}

	@Override
	public int getSizeInventory() {
		return items.size();
	}

	@Override
	public boolean isEmpty() {
		for (ItemStack itemStack : items) {
			if (!itemStack.isEmpty()) {
				return false;
			}
		}
		return true;
	}

	@Override
	public ItemStack getStackInSlot(int index) {
		return items.get(index);
	}

	@Override
	public ItemStack decrStackSize(int index, int count) {
		contentsChanged();
		return ItemStackHelper.getAndSplit(items, index, count);
	}

	@Override
	public ItemStack removeStackFromSlot(int index) {
		contentsChanged();
		return ItemStackHelper.getAndRemove(items, index);
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) {
		items.set(index, stack);
		if (stack.getCount() > this.getInventoryStackLimit()) {
			stack.setCount(this.getInventoryStackLimit());
		}
		this.markDirty();
	}

	@Override
	public boolean isUsableByPlayer(PlayerEntity player) {
		if (this.world.getTileEntity(this.pos) != this) {
			return false;
		} else {
			return player.getDistanceSq((double) this.pos.getX() + 0.5D, (double) this.pos.getY() + 0.5D,
					(double) this.pos.getZ() + 0.5D) <= 64.0D;
		}
	}

	@Override
	public void clear() {
		items.clear();
		contentsChanged();
	}
}
