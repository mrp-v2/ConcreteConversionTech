package mrp_v2.concreteconversiontech.common.util;

import mrp_v2.concreteconversiontech.common.block.ConcreteConverterBlockBase;
import mrp_v2.concreteconversiontech.common.block.ConcreteConverterBlockTier1;
import mrp_v2.concreteconversiontech.common.tileentity.ConcreteConverterTileEntityTier1;
import net.minecraft.item.BlockItem;
import net.minecraft.tileentity.TileEntityType;

public class CCTObjectHolder {

	public static final ConcreteConverterBlockBase CONCRETE_CONVERTER_BLOCK_TIER_1;
	public static final BlockItem CONCRETE_CONVERTER_BLOCK_TIER_1_ITEM;
	public static final TileEntityType<?> CONCRETE_CONVERTER_TILE_ENTITY_TYPE_TIER_1;
	static {
		CONCRETE_CONVERTER_BLOCK_TIER_1 = new ConcreteConverterBlockTier1();
		CONCRETE_CONVERTER_BLOCK_TIER_1_ITEM = CONCRETE_CONVERTER_BLOCK_TIER_1.createBlockItem();
		CONCRETE_CONVERTER_TILE_ENTITY_TYPE_TIER_1 = TileEntityType.Builder
				.create(ConcreteConverterTileEntityTier1::new, CCTObjectHolder.CONCRETE_CONVERTER_BLOCK_TIER_1)
				.build(null).setRegistryName(CCTConstants.MODID, ConcreteConverterTileEntityTier1.ID);
	}

}
