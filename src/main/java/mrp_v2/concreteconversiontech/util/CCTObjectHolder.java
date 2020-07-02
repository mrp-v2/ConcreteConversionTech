package mrp_v2.concreteconversiontech.util;

import mrp_v2.concreteconversiontech.block.ConcreteConverterBase;
import mrp_v2.concreteconversiontech.block.ConcreteConverterTier1;
import net.minecraft.item.BlockItem;
import net.minecraftforge.registries.ObjectHolder;

public class CCTObjectHolder {

	@ObjectHolder(CCTConstants.MODID + ":" + ConcreteConverterTier1.ID)
	public static final ConcreteConverterBase CONCRETE_CONVERTER_TIER_1 = null;

	@ObjectHolder(CCTConstants.MODID + ":" + ConcreteConverterTier1.ID)
	public static final BlockItem CONCRETE_CONVERTER_TIER_1_ITEM = null;
}
