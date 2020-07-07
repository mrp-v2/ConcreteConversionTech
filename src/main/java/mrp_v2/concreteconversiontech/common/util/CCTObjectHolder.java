package mrp_v2.concreteconversiontech.common.util;

import mrp_v2.concreteconversiontech.common.block.AbstractConcreteConverterBlock;
import mrp_v2.concreteconversiontech.common.block.ConcreteConverterTier1Block;
import mrp_v2.concreteconversiontech.common.inventory.container.ConcreteConverterTier1Container;
import mrp_v2.concreteconversiontech.common.tileentity.ConcreteConverterTier1TileEntity;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.BlockItem;
import net.minecraft.tileentity.TileEntityType;

public class CCTObjectHolder {

	public static final AbstractConcreteConverterBlock CONCRETE_CONVERTER_TIER_1_BLOCK;
	public static final BlockItem CONCRETE_CONVERTER_TIER_1_BLOCK_ITEM;
	public static final TileEntityType<?> CONCRETE_CONVERTER_TIER_1_TILE_ENTITY_TYPE;
	public static final ContainerType<ConcreteConverterTier1Container> CONCRETE_CONVERTER_TIER_1_CONTAINER_TYPE;
	static {
		CONCRETE_CONVERTER_TIER_1_BLOCK = new ConcreteConverterTier1Block();
		CONCRETE_CONVERTER_TIER_1_BLOCK_ITEM = CONCRETE_CONVERTER_TIER_1_BLOCK.createBlockItem();
		CONCRETE_CONVERTER_TIER_1_TILE_ENTITY_TYPE = TileEntityType.Builder
				.create(ConcreteConverterTier1TileEntity::new, CCTObjectHolder.CONCRETE_CONVERTER_TIER_1_BLOCK)
				.build(null).setRegistryName(CCTConstants.MODID, ConcreteConverterTier1TileEntity.ID);
		CONCRETE_CONVERTER_TIER_1_CONTAINER_TYPE = new ContainerType<ConcreteConverterTier1Container>(
				ConcreteConverterTier1Container::new);
		CONCRETE_CONVERTER_TIER_1_CONTAINER_TYPE.setRegistryName(CCTConstants.MODID,
				ConcreteConverterTier1Container.ID);
	}
}
