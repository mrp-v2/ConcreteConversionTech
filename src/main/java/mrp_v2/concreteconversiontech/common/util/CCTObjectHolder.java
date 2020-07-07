package mrp_v2.concreteconversiontech.common.util;

import mrp_v2.concreteconversiontech.common.block.ConcreteConverterBlock;
import mrp_v2.concreteconversiontech.common.inventory.container.ConcreteConverterTier1Container;
import mrp_v2.concreteconversiontech.common.inventory.container.ConcreteConverterTier2Container;
import mrp_v2.concreteconversiontech.common.tileentity.ConcreteConverterTier1TileEntity;
import mrp_v2.concreteconversiontech.common.tileentity.ConcreteConverterTier2TileEntity;
import net.minecraft.block.Blocks;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.BlockItem;
import net.minecraft.tileentity.TileEntityType;

public class CCTObjectHolder {

	public static final ConcreteConverterBlock CONCRETE_CONVERTER_TIER_1_BLOCK;
	public static final ConcreteConverterBlock CONCRETE_CONVERTER_TIER_2_BLOCK;
	public static final BlockItem CONCRETE_CONVERTER_TIER_1_BLOCK_ITEM;
	public static final BlockItem CONCRETE_CONVERTER_TIER_2_BLOCK_ITEM;
	public static final TileEntityType<ConcreteConverterTier1TileEntity> CONCRETE_CONVERTER_TIER_1_TILE_ENTITY_TYPE;
	public static final TileEntityType<ConcreteConverterTier2TileEntity> CONCRETE_CONVERTER_TIER_2_TILE_ENTITY_TYPE;
	public static final ContainerType<ConcreteConverterTier1Container> CONCRETE_CONVERTER_TIER_1_CONTAINER_TYPE;
	public static final ContainerType<ConcreteConverterTier2Container> CONCRETE_CONVERTER_TIER_2_CONTAINER_TYPE;
	static {
		CONCRETE_CONVERTER_TIER_1_BLOCK = new ConcreteConverterBlock(Blocks.OAK_PLANKS, 1,
				ConcreteConverterTier1TileEntity::new);
		CONCRETE_CONVERTER_TIER_2_BLOCK = new ConcreteConverterBlock(Blocks.STONE, 2,
				ConcreteConverterTier2TileEntity::new);
		CONCRETE_CONVERTER_TIER_1_BLOCK_ITEM = CONCRETE_CONVERTER_TIER_1_BLOCK.createBlockItem();
		CONCRETE_CONVERTER_TIER_2_BLOCK_ITEM = CONCRETE_CONVERTER_TIER_2_BLOCK.createBlockItem();
		CONCRETE_CONVERTER_TIER_1_TILE_ENTITY_TYPE = ConcreteConverterTier1TileEntity.createTileEntityType();
		CONCRETE_CONVERTER_TIER_2_TILE_ENTITY_TYPE = ConcreteConverterTier2TileEntity.createTileEntityType();
		CONCRETE_CONVERTER_TIER_1_CONTAINER_TYPE = ConcreteConverterTier1Container.createContainerType();
		CONCRETE_CONVERTER_TIER_2_CONTAINER_TYPE = ConcreteConverterTier2Container.createContainerType();
	}
}
