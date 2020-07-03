package mrp_v2.concreteconversiontech.common.util;

import mrp_v2.concreteconversiontech.common.block.ConcreteConverterBlockBase;
import mrp_v2.concreteconversiontech.common.block.ConcreteConverterBlockTier1;
import net.minecraft.item.BlockItem;

public class CCTObjectHolder {

	public static final ConcreteConverterBlockBase CONCRETE_CONVERTER_TIER_1;
	public static final BlockItem CONCRETE_CONVERTER_TIER_1_ITEM;
	static {
		CONCRETE_CONVERTER_TIER_1 = new ConcreteConverterBlockTier1();
		CONCRETE_CONVERTER_TIER_1_ITEM = CONCRETE_CONVERTER_TIER_1.createBlockItem();
	}
}
