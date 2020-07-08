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
	public static final ConcreteConverterBlock CONCRETE_CONVERTER_TIER_3_BLOCK;
	public static final ConcreteConverterBlock CONCRETE_CONVERTER_TIER_4_BLOCK;
	public static final ConcreteConverterBlock CONCRETE_CONVERTER_TIER_5_BLOCK;
	public static final ConcreteConverterBlock CONCRETE_CONVERTER_TIER_6_BLOCK;
	public static final ConcreteConverterBlock CONCRETE_CONVERTER_TIER_7_BLOCK;
	public static final ConcreteConverterBlock CONCRETE_CONVERTER_TIER_8_BLOCK;
	public static final BlockItem CONCRETE_CONVERTER_TIER_1_BLOCK_ITEM;
	public static final BlockItem CONCRETE_CONVERTER_TIER_2_BLOCK_ITEM;
	public static final BlockItem CONCRETE_CONVERTER_TIER_3_BLOCK_ITEM;
	public static final BlockItem CONCRETE_CONVERTER_TIER_4_BLOCK_ITEM;
	public static final BlockItem CONCRETE_CONVERTER_TIER_5_BLOCK_ITEM;
	public static final BlockItem CONCRETE_CONVERTER_TIER_6_BLOCK_ITEM;
	public static final BlockItem CONCRETE_CONVERTER_TIER_7_BLOCK_ITEM;
	public static final BlockItem CONCRETE_CONVERTER_TIER_8_BLOCK_ITEM;
	public static final TileEntityType<ConcreteConverterTier1TileEntity> CONCRETE_CONVERTER_TIER_1_TILE_ENTITY_TYPE;
	public static final TileEntityType<ConcreteConverterTier2TileEntity> CONCRETE_CONVERTER_TIER_2_TILE_ENTITY_TYPE;
	public static final TileEntityType<ConcreteConverterTier2TileEntity> CONCRETE_CONVERTER_TIER_3_TILE_ENTITY_TYPE;
	public static final TileEntityType<ConcreteConverterTier2TileEntity> CONCRETE_CONVERTER_TIER_4_TILE_ENTITY_TYPE;
	public static final TileEntityType<ConcreteConverterTier2TileEntity> CONCRETE_CONVERTER_TIER_5_TILE_ENTITY_TYPE;
	public static final TileEntityType<ConcreteConverterTier2TileEntity> CONCRETE_CONVERTER_TIER_6_TILE_ENTITY_TYPE;
	public static final TileEntityType<ConcreteConverterTier2TileEntity> CONCRETE_CONVERTER_TIER_7_TILE_ENTITY_TYPE;
	public static final TileEntityType<ConcreteConverterTier2TileEntity> CONCRETE_CONVERTER_TIER_8_TILE_ENTITY_TYPE;
	public static final ContainerType<ConcreteConverterTier1Container> CONCRETE_CONVERTER_TIER_1_CONTAINER_TYPE;
	public static final ContainerType<ConcreteConverterTier2Container> CONCRETE_CONVERTER_TIER_2_CONTAINER_TYPE;
	public static final ContainerType<ConcreteConverterTier2Container> CONCRETE_CONVERTER_TIER_3_CONTAINER_TYPE;
	public static final ContainerType<ConcreteConverterTier2Container> CONCRETE_CONVERTER_TIER_4_CONTAINER_TYPE;
	public static final ContainerType<ConcreteConverterTier2Container> CONCRETE_CONVERTER_TIER_5_CONTAINER_TYPE;
	public static final ContainerType<ConcreteConverterTier2Container> CONCRETE_CONVERTER_TIER_6_CONTAINER_TYPE;
	public static final ContainerType<ConcreteConverterTier2Container> CONCRETE_CONVERTER_TIER_7_CONTAINER_TYPE;
	public static final ContainerType<ConcreteConverterTier2Container> CONCRETE_CONVERTER_TIER_8_CONTAINER_TYPE;
	static {
		CONCRETE_CONVERTER_TIER_1_BLOCK = new ConcreteConverterBlock(Blocks.OAK_PLANKS, 1,
				ConcreteConverterTier1TileEntity::new);
		CONCRETE_CONVERTER_TIER_2_BLOCK = new ConcreteConverterBlock(Blocks.STONE, 2,
				ConcreteConverterTier2TileEntity::new);
		CONCRETE_CONVERTER_TIER_3_BLOCK = new ConcreteConverterBlock(Blocks.IRON_BLOCK, 3, () -> null);
		CONCRETE_CONVERTER_TIER_4_BLOCK = new ConcreteConverterBlock(Blocks.GOLD_BLOCK, 4, () -> null);
		CONCRETE_CONVERTER_TIER_5_BLOCK = new ConcreteConverterBlock(Blocks.DIAMOND_BLOCK, 5, () -> null);
		CONCRETE_CONVERTER_TIER_6_BLOCK = new ConcreteConverterBlock(Blocks.EMERALD_BLOCK, 6, () -> null);
		CONCRETE_CONVERTER_TIER_7_BLOCK = new ConcreteConverterBlock(Blocks.QUARTZ_BLOCK, 7, () -> null);
		CONCRETE_CONVERTER_TIER_8_BLOCK = new ConcreteConverterBlock(Blocks.field_235397_ng_, 8, () -> null);
		CONCRETE_CONVERTER_TIER_1_BLOCK_ITEM = CONCRETE_CONVERTER_TIER_1_BLOCK.createBlockItem();
		CONCRETE_CONVERTER_TIER_2_BLOCK_ITEM = CONCRETE_CONVERTER_TIER_2_BLOCK.createBlockItem();
		CONCRETE_CONVERTER_TIER_3_BLOCK_ITEM = CONCRETE_CONVERTER_TIER_3_BLOCK.createBlockItem();
		CONCRETE_CONVERTER_TIER_4_BLOCK_ITEM = CONCRETE_CONVERTER_TIER_4_BLOCK.createBlockItem();
		CONCRETE_CONVERTER_TIER_5_BLOCK_ITEM = CONCRETE_CONVERTER_TIER_5_BLOCK.createBlockItem();
		CONCRETE_CONVERTER_TIER_6_BLOCK_ITEM = CONCRETE_CONVERTER_TIER_6_BLOCK.createBlockItem();
		CONCRETE_CONVERTER_TIER_7_BLOCK_ITEM = CONCRETE_CONVERTER_TIER_7_BLOCK.createBlockItem();
		CONCRETE_CONVERTER_TIER_8_BLOCK_ITEM = CONCRETE_CONVERTER_TIER_8_BLOCK.createBlockItem();
		CONCRETE_CONVERTER_TIER_1_TILE_ENTITY_TYPE = ConcreteConverterTier1TileEntity.createTileEntityType();
		CONCRETE_CONVERTER_TIER_2_TILE_ENTITY_TYPE = ConcreteConverterTier2TileEntity.createTileEntityType();
		CONCRETE_CONVERTER_TIER_3_TILE_ENTITY_TYPE = null;
		CONCRETE_CONVERTER_TIER_4_TILE_ENTITY_TYPE = null;
		CONCRETE_CONVERTER_TIER_5_TILE_ENTITY_TYPE = null;
		CONCRETE_CONVERTER_TIER_6_TILE_ENTITY_TYPE = null;
		CONCRETE_CONVERTER_TIER_7_TILE_ENTITY_TYPE = null;
		CONCRETE_CONVERTER_TIER_8_TILE_ENTITY_TYPE = null;
		CONCRETE_CONVERTER_TIER_1_CONTAINER_TYPE = ConcreteConverterTier1Container.createContainerType();
		CONCRETE_CONVERTER_TIER_2_CONTAINER_TYPE = ConcreteConverterTier2Container.createContainerType();
		CONCRETE_CONVERTER_TIER_3_CONTAINER_TYPE = null;
		CONCRETE_CONVERTER_TIER_4_CONTAINER_TYPE = null;
		CONCRETE_CONVERTER_TIER_5_CONTAINER_TYPE = null;
		CONCRETE_CONVERTER_TIER_6_CONTAINER_TYPE = null;
		CONCRETE_CONVERTER_TIER_7_CONTAINER_TYPE = null;
		CONCRETE_CONVERTER_TIER_8_CONTAINER_TYPE = null;
	}
}
