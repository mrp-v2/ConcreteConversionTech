package mrp_v2.concreteconversiontech.common.inventory;

import net.minecraft.item.ItemStack;

public interface IConcreteConverter {

	void contentsChanged();
	
	boolean isConcretePowder(ItemStack stack);
}
