package mrp_v2.concreteconversiontech.common.inventory.container;

import mrp_v2.concreteconversiontech.common.util.CCTObjectHolder;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;

public class ConcreteConverterTier1Container extends Container {

	public static String ID = "concrete_converter_tier_1_container";

	public ConcreteConverterTier1Container(int id, PlayerInventory playerInventoryIn) {
		super(CCTObjectHolder.CONCRETE_CONVERTER_TIER_1_CONTAINER_TYPE, id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canInteractWith(PlayerEntity playerIn) {
		// TODO Auto-generated method stub
		return false;
	}

}
