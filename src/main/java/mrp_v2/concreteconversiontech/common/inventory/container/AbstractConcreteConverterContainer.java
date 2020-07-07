package mrp_v2.concreteconversiontech.common.inventory.container;

import mrp_v2.concreteconversiontech.common.inventory.ConcreteConverterItemStackHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;

public abstract class AbstractConcreteConverterContainer extends Container {

	protected static final String ID_STEM_PRE = "concrete_converter_";
	protected static final String ID_STEM_POST = "_container";

	protected final ConcreteConverterItemStackHandler inventory;

	protected AbstractConcreteConverterContainer(ContainerType<?> type, int id,
			ConcreteConverterItemStackHandler inventoryIn) {
		super(type, id);
		this.inventory = inventoryIn;
	}

	@Override
	public boolean canInteractWith(PlayerEntity playerIn) {
		return this.inventory.isUsableByPlayer(playerIn);
	}

	@Override
	public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
		ItemStack itemStack = ItemStack.EMPTY;
		Slot slot = this.inventorySlots.get(index);
		if (slot != null && slot.getHasStack()) {
			ItemStack itemStack1 = slot.getStack();
			itemStack = itemStack1.copy();
			if (index < this.inventory.getSlots()) {
				if (!this.mergeItemStack(itemStack1, this.inventory.getSlots(), this.inventorySlots.size(), true)) {
					return ItemStack.EMPTY;
				}
			} else if (!this.mergeItemStack(itemStack1, 0, this.inventory.getSlots() / 2, false)) {
				return ItemStack.EMPTY;
			}
			if (itemStack1.isEmpty()) {
				slot.putStack(ItemStack.EMPTY);
			} else {
				slot.onSlotChanged();
			}
		}
		return itemStack;
	}
}
