package mrp_v2.concreteconversiontech.common.inventory.container;

import mrp_v2.concreteconversiontech.common.inventory.ConcreteConverterItemStackHandler;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;

public class ConcreteConverterOutputSlot extends Slot {

	public ConcreteConverterOutputSlot(ConcreteConverterItemStackHandler inventoryIn, int index, int xPosition,
			int yPosition) {
		super(inventoryIn, index, xPosition, yPosition);
	}

	@Override
	public boolean isItemValid(ItemStack stack) {
		return false;
	}
}
