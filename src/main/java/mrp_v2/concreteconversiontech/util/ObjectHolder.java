package mrp_v2.concreteconversiontech.util;

import mrp_v2.concreteconversiontech.block.ConcreteConverterBlock;
import mrp_v2.concreteconversiontech.inventory.container.*;
import mrp_v2.concreteconversiontech.tileentity.*;
import net.minecraft.block.Blocks;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.BlockItem;
import net.minecraft.tileentity.TileEntityType;

public class ObjectHolder
{
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
    public static final TileEntityType<ConcreteConverterTier3TileEntity> CONCRETE_CONVERTER_TIER_3_TILE_ENTITY_TYPE;
    public static final TileEntityType<ConcreteConverterTier4TileEntity> CONCRETE_CONVERTER_TIER_4_TILE_ENTITY_TYPE;
    public static final TileEntityType<ConcreteConverterTier5TileEntity> CONCRETE_CONVERTER_TIER_5_TILE_ENTITY_TYPE;
    public static final TileEntityType<ConcreteConverterTier6TileEntity> CONCRETE_CONVERTER_TIER_6_TILE_ENTITY_TYPE;
    public static final TileEntityType<ConcreteConverterTier7TileEntity> CONCRETE_CONVERTER_TIER_7_TILE_ENTITY_TYPE;
    public static final TileEntityType<ConcreteConverterTier8TileEntity> CONCRETE_CONVERTER_TIER_8_TILE_ENTITY_TYPE;
    public static final ContainerType<ConcreteConverterTier1Container> CONCRETE_CONVERTER_TIER_1_CONTAINER_TYPE;
    public static final ContainerType<ConcreteConverterTier2Container> CONCRETE_CONVERTER_TIER_2_CONTAINER_TYPE;
    public static final ContainerType<ConcreteConverterTier3Container> CONCRETE_CONVERTER_TIER_3_CONTAINER_TYPE;
    public static final ContainerType<ConcreteConverterTier4Container> CONCRETE_CONVERTER_TIER_4_CONTAINER_TYPE;
    public static final ContainerType<ConcreteConverterTier5Container> CONCRETE_CONVERTER_TIER_5_CONTAINER_TYPE;
    public static final ContainerType<ConcreteConverterTier6Container> CONCRETE_CONVERTER_TIER_6_CONTAINER_TYPE;
    public static final ContainerType<ConcreteConverterTier7Container> CONCRETE_CONVERTER_TIER_7_CONTAINER_TYPE;
    public static final ContainerType<ConcreteConverterTier8Container> CONCRETE_CONVERTER_TIER_8_CONTAINER_TYPE;

    static
    {
        CONCRETE_CONVERTER_TIER_1_BLOCK =
                new ConcreteConverterBlock(Blocks.OAK_PLANKS, 1, ConcreteConverterTier1TileEntity::new);
        CONCRETE_CONVERTER_TIER_2_BLOCK =
                new ConcreteConverterBlock(Blocks.STONE, 2, ConcreteConverterTier2TileEntity::new);
        CONCRETE_CONVERTER_TIER_3_BLOCK =
                new ConcreteConverterBlock(Blocks.IRON_BLOCK, 3, ConcreteConverterTier3TileEntity::new);
        CONCRETE_CONVERTER_TIER_4_BLOCK =
                new ConcreteConverterBlock(Blocks.GOLD_BLOCK, 4, ConcreteConverterTier4TileEntity::new);
        CONCRETE_CONVERTER_TIER_5_BLOCK =
                new ConcreteConverterBlock(Blocks.DIAMOND_BLOCK, 5, ConcreteConverterTier5TileEntity::new);
        CONCRETE_CONVERTER_TIER_6_BLOCK =
                new ConcreteConverterBlock(Blocks.EMERALD_BLOCK, 6, ConcreteConverterTier6TileEntity::new);
        CONCRETE_CONVERTER_TIER_7_BLOCK =
                new ConcreteConverterBlock(Blocks.QUARTZ_BLOCK, 7, ConcreteConverterTier7TileEntity::new);
        CONCRETE_CONVERTER_TIER_8_BLOCK =
                new ConcreteConverterBlock(Blocks.NETHERITE_BLOCK, 8, ConcreteConverterTier8TileEntity::new);
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
        CONCRETE_CONVERTER_TIER_3_TILE_ENTITY_TYPE = ConcreteConverterTier3TileEntity.createTileEntityType();
        CONCRETE_CONVERTER_TIER_4_TILE_ENTITY_TYPE = ConcreteConverterTier4TileEntity.createTileEntityType();
        CONCRETE_CONVERTER_TIER_5_TILE_ENTITY_TYPE = ConcreteConverterTier5TileEntity.createTileEntityType();
        CONCRETE_CONVERTER_TIER_6_TILE_ENTITY_TYPE = ConcreteConverterTier6TileEntity.createTileEntityType();
        CONCRETE_CONVERTER_TIER_7_TILE_ENTITY_TYPE = ConcreteConverterTier7TileEntity.createTileEntityType();
        CONCRETE_CONVERTER_TIER_8_TILE_ENTITY_TYPE = ConcreteConverterTier8TileEntity.createTileEntityType();
        CONCRETE_CONVERTER_TIER_1_CONTAINER_TYPE = ConcreteConverterTier1Container.createContainerType();
        CONCRETE_CONVERTER_TIER_2_CONTAINER_TYPE = ConcreteConverterTier2Container.createContainerType();
        CONCRETE_CONVERTER_TIER_3_CONTAINER_TYPE = ConcreteConverterTier3Container.createContainerType();
        CONCRETE_CONVERTER_TIER_4_CONTAINER_TYPE = ConcreteConverterTier4Container.createContainerType();
        CONCRETE_CONVERTER_TIER_5_CONTAINER_TYPE = ConcreteConverterTier5Container.createContainerType();
        CONCRETE_CONVERTER_TIER_6_CONTAINER_TYPE = ConcreteConverterTier6Container.createContainerType();
        CONCRETE_CONVERTER_TIER_7_CONTAINER_TYPE = ConcreteConverterTier7Container.createContainerType();
        CONCRETE_CONVERTER_TIER_8_CONTAINER_TYPE = ConcreteConverterTier8Container.createContainerType();
    }
}
