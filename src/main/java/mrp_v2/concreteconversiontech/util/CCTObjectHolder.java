package mrp_v2.concreteconversiontech.util;

import mrp_v2.concreteconversiontech.block.ConcreteConverterBase;
import mrp_v2.concreteconversiontech.block.ConcreteConverterTier1;
import net.minecraft.item.BlockItem;

public class CCTObjectHolder {

	public static final ConcreteConverterBase CONCRETE_CONVERTER_TIER_1;
	public static final BlockItem CONCRETE_CONVERTER_TIER_1_ITEM;
	static {
		CONCRETE_CONVERTER_TIER_1 = new ConcreteConverterTier1();
		CONCRETE_CONVERTER_TIER_1_ITEM = CONCRETE_CONVERTER_TIER_1.createBlockItem();
	}
}
