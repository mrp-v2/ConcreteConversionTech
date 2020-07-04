package mrp_v2.concreteconversiontech.common.inventory;

import net.minecraft.item.ItemStack;
import net.minecraftforge.items.ItemStackHandler;

public class ConcreteConverterItemStackHandler extends ItemStackHandler {

	private final IConcreteConverter concreteConverter;

	public ConcreteConverterItemStackHandler(int slots, IConcreteConverter concreteConverter) {
		super(slots);
		this.concreteConverter = concreteConverter;
	}

	public ItemStack extractItem(int slot, int amount) {
		return super.extractItem(slot, amount, false);
	}

	@Override
	public ItemStack extractItem(int slot, int amount, boolean simulate) {
		if (slot < stacks.size() / 2) {
			return ItemStack.EMPTY;
		}
		return super.extractItem(slot, amount, simulate);
	}

	public ItemStack insertItem(int slot, ItemStack stack) {
		return super.insertItem(slot, stack, false);
	}

	@Override
	public ItemStack insertItem(int slot, ItemStack stack, boolean simulate) {
		if (slot >= stacks.size() / 2 || !concreteConverter.isConcretePowder(stack)) {
			return stack;
		}
		return super.insertItem(slot, stack, simulate);
	}

	@Override
	protected void onContentsChanged(int slot) {
		super.onContentsChanged(slot);
		concreteConverter.contentsChanged();
	}
}
