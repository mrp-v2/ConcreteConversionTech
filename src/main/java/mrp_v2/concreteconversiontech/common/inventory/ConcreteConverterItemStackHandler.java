package mrp_v2.concreteconversiontech.common.inventory;

import mrp_v2.concreteconversiontech.common.tileentity.AbstractConcreteConverterTileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.NonNullSupplier;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class ConcreteConverterItemStackHandler extends ItemStackHandler
		implements NonNullSupplier<IItemHandler>, IInventory {

	private final AbstractConcreteConverterTileEntity concreteConverter;

	public ConcreteConverterItemStackHandler(int slots, AbstractConcreteConverterTileEntity concreteConverter) {
		super(slots);
		this.concreteConverter = concreteConverter;
	}

	/** Ignores slot limitations */
	public ItemStack extractItem(int slot, int amount) {
		return super.extractItem(slot, amount, false);
	}

	@Override
	public ItemStack extractItem(int slot, int amount, boolean simulate) {
		if (slot < this.stacks.size() / 2) {
			return ItemStack.EMPTY;
		}
		return super.extractItem(slot, amount, simulate);
	}

	@Override
	public IItemHandler get() {
		return this;
	}

	/** Ignores slot limitations */
	public ItemStack insertItem(int slot, ItemStack stack) {
		return super.insertItem(slot, stack, false);
	}

	@Override
	public ItemStack insertItem(int slot, ItemStack stack, boolean simulate) {
		if (slot >= this.stacks.size() / 2 || !AbstractConcreteConverterTileEntity.isConcretePowder(stack)) {
			return stack;
		}
		return super.insertItem(slot, stack, simulate);
	}

	@Override
	protected void onContentsChanged(int slot) {
		super.onContentsChanged(slot);
	}

	public boolean isInputEmpty() {
		for (int i = 0; i < this.stacks.size() / 2; i++) {
			if (!this.stacks.get(i).isEmpty()) {
				return false;
			}
		}
		return true;
	}

	// start of IIventory code

	@Override
	public void clear() {
		for (int i = 0; i < super.getSlots(); i++) {
			super.setStackInSlot(i, ItemStack.EMPTY);
		}
	}

	@Override
	public int getSizeInventory() {
		return super.getSlots();
	}

	@Override
	public boolean isEmpty() {
		for (int i = 0; i < super.getSlots(); i++) {
			if (!super.getStackInSlot(i).isEmpty()) {
				return false;
			}
		}
		return true;
	}

	@Override
	public ItemStack decrStackSize(int index, int count) {
		return super.extractItem(index, count, false);
	}

	@Override
	public ItemStack removeStackFromSlot(int index) {
		return super.extractItem(index, super.getStackInSlot(index).getCount(), false);
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) {
		super.setStackInSlot(index, stack);
	}

	@Override
	public void markDirty() {
		if (concreteConverter != null) {
			concreteConverter.markDirty();
		}
	}

	@Override
	public boolean isUsableByPlayer(PlayerEntity player) {
		return true;
	}
}
