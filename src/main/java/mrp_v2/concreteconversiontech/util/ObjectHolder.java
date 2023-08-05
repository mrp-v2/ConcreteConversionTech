package mrp_v2.concreteconversiontech.util;

import mrp_v2.concreteconversiontech.ConcreteConversionTech;
import mrp_v2.concreteconversiontech.block.ConcreteConverterBlock;
import mrp_v2.concreteconversiontech.inventory.container.*;
import mrp_v2.concreteconversiontech.tileentity.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ObjectHolder
{
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, ConcreteConversionTech.ID);
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ConcreteConversionTech.ID);
    public static final DeferredRegister<BlockEntityType<?>> TILE_ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, ConcreteConversionTech.ID);
    public static final DeferredRegister<MenuType<?>> CONTAINERS =
            DeferredRegister.create(ForgeRegistries.CONTAINERS, ConcreteConversionTech.ID);
    public static final RegistryObject<ConcreteConverterBlock> CONCRETE_CONVERTER_TIER_1_BLOCK;
    public static final RegistryObject<ConcreteConverterBlock> CONCRETE_CONVERTER_TIER_2_BLOCK;
    public static final RegistryObject<ConcreteConverterBlock> CONCRETE_CONVERTER_TIER_3_BLOCK;
    public static final RegistryObject<ConcreteConverterBlock> CONCRETE_CONVERTER_TIER_4_BLOCK;
    public static final RegistryObject<ConcreteConverterBlock> CONCRETE_CONVERTER_TIER_5_BLOCK;
    public static final RegistryObject<ConcreteConverterBlock> CONCRETE_CONVERTER_TIER_6_BLOCK;
    public static final RegistryObject<ConcreteConverterBlock> CONCRETE_CONVERTER_TIER_7_BLOCK;
    public static final RegistryObject<ConcreteConverterBlock> CONCRETE_CONVERTER_TIER_8_BLOCK;
    public static final RegistryObject<BlockItem> CONCRETE_CONVERTER_TIER_1_BLOCK_ITEM;
    public static final RegistryObject<BlockItem> CONCRETE_CONVERTER_TIER_2_BLOCK_ITEM;
    public static final RegistryObject<BlockItem> CONCRETE_CONVERTER_TIER_3_BLOCK_ITEM;
    public static final RegistryObject<BlockItem> CONCRETE_CONVERTER_TIER_4_BLOCK_ITEM;
    public static final RegistryObject<BlockItem> CONCRETE_CONVERTER_TIER_5_BLOCK_ITEM;
    public static final RegistryObject<BlockItem> CONCRETE_CONVERTER_TIER_6_BLOCK_ITEM;
    public static final RegistryObject<BlockItem> CONCRETE_CONVERTER_TIER_7_BLOCK_ITEM;
    public static final RegistryObject<BlockItem> CONCRETE_CONVERTER_TIER_8_BLOCK_ITEM;
    public static final RegistryObject<BlockEntityType<ConcreteConverterTier1TileEntity>>
            CONCRETE_CONVERTER_TIER_1_TILE_ENTITY_TYPE;
    public static final RegistryObject<BlockEntityType<ConcreteConverterTier2TileEntity>>
            CONCRETE_CONVERTER_TIER_2_TILE_ENTITY_TYPE;
    public static final RegistryObject<BlockEntityType<ConcreteConverterTier3TileEntity>>
            CONCRETE_CONVERTER_TIER_3_TILE_ENTITY_TYPE;
    public static final RegistryObject<BlockEntityType<ConcreteConverterTier4TileEntity>>
            CONCRETE_CONVERTER_TIER_4_TILE_ENTITY_TYPE;
    public static final RegistryObject<BlockEntityType<ConcreteConverterTier5TileEntity>>
            CONCRETE_CONVERTER_TIER_5_TILE_ENTITY_TYPE;
    public static final RegistryObject<BlockEntityType<ConcreteConverterTier6TileEntity>>
            CONCRETE_CONVERTER_TIER_6_TILE_ENTITY_TYPE;
    public static final RegistryObject<BlockEntityType<ConcreteConverterTier7TileEntity>>
            CONCRETE_CONVERTER_TIER_7_TILE_ENTITY_TYPE;
    public static final RegistryObject<BlockEntityType<ConcreteConverterTier8TileEntity>>
            CONCRETE_CONVERTER_TIER_8_TILE_ENTITY_TYPE;
    public static final RegistryObject<MenuType<ConcreteConverterTier1Container>>
            CONCRETE_CONVERTER_TIER_1_CONTAINER_TYPE;
    public static final RegistryObject<MenuType<ConcreteConverterTier2Container>>
            CONCRETE_CONVERTER_TIER_2_CONTAINER_TYPE;
    public static final RegistryObject<MenuType<ConcreteConverterTier3Container>>
            CONCRETE_CONVERTER_TIER_3_CONTAINER_TYPE;
    public static final RegistryObject<MenuType<ConcreteConverterTier4Container>>
            CONCRETE_CONVERTER_TIER_4_CONTAINER_TYPE;
    public static final RegistryObject<MenuType<ConcreteConverterTier5Container>>
            CONCRETE_CONVERTER_TIER_5_CONTAINER_TYPE;
    public static final RegistryObject<MenuType<ConcreteConverterTier6Container>>
            CONCRETE_CONVERTER_TIER_6_CONTAINER_TYPE;
    public static final RegistryObject<MenuType<ConcreteConverterTier7Container>>
            CONCRETE_CONVERTER_TIER_7_CONTAINER_TYPE;
    public static final RegistryObject<MenuType<ConcreteConverterTier8Container>>
            CONCRETE_CONVERTER_TIER_8_CONTAINER_TYPE;
    public static final CreativeModeTab CONCRETE_CONVERSION_TECH_ITEM_GROUP = new CreativeModeTab(ConcreteConversionTech.ID)
    {
        @OnlyIn(Dist.CLIENT) public ItemStack makeIcon()
        {
            return new ItemStack(ObjectHolder.CONCRETE_CONVERTER_TIER_1_BLOCK.get());
        }
    };

    static
    {
        CONCRETE_CONVERTER_TIER_1_BLOCK = BLOCKS.register(ConcreteConverterTier1TileEntity.ID,
                () -> new ConcreteConverterBlock(Blocks.OAK_PLANKS, ConcreteConverterTier1TileEntity::new));
        CONCRETE_CONVERTER_TIER_2_BLOCK = BLOCKS.register(ConcreteConverterTier2TileEntity.ID,
                () -> new ConcreteConverterBlock(Blocks.STONE, ConcreteConverterTier2TileEntity::new));
        CONCRETE_CONVERTER_TIER_3_BLOCK = BLOCKS.register(ConcreteConverterTier3TileEntity.ID,
                () -> new ConcreteConverterBlock(Blocks.IRON_BLOCK, ConcreteConverterTier3TileEntity::new));
        CONCRETE_CONVERTER_TIER_4_BLOCK = BLOCKS.register(ConcreteConverterTier4TileEntity.ID,
                () -> new ConcreteConverterBlock(Blocks.GOLD_BLOCK, ConcreteConverterTier4TileEntity::new));
        CONCRETE_CONVERTER_TIER_5_BLOCK = BLOCKS.register(ConcreteConverterTier5TileEntity.ID,
                () -> new ConcreteConverterBlock(Blocks.DIAMOND_BLOCK, ConcreteConverterTier5TileEntity::new));
        CONCRETE_CONVERTER_TIER_6_BLOCK = BLOCKS.register(ConcreteConverterTier6TileEntity.ID,
                () -> new ConcreteConverterBlock(Blocks.EMERALD_BLOCK, ConcreteConverterTier6TileEntity::new));
        CONCRETE_CONVERTER_TIER_7_BLOCK = BLOCKS.register(ConcreteConverterTier7TileEntity.ID,
                () -> new ConcreteConverterBlock(Blocks.QUARTZ_BLOCK, ConcreteConverterTier7TileEntity::new));
        CONCRETE_CONVERTER_TIER_8_BLOCK = BLOCKS.register(ConcreteConverterTier8TileEntity.ID,
                () -> new ConcreteConverterBlock(Blocks.NETHERITE_BLOCK, ConcreteConverterTier8TileEntity::new));
        CONCRETE_CONVERTER_TIER_1_BLOCK_ITEM = ITEMS.register(ConcreteConverterTier1TileEntity.ID,
                () -> createBlockItem(CONCRETE_CONVERTER_TIER_1_BLOCK));
        CONCRETE_CONVERTER_TIER_2_BLOCK_ITEM = ITEMS.register(ConcreteConverterTier2TileEntity.ID,
                () -> createBlockItem(CONCRETE_CONVERTER_TIER_2_BLOCK));
        CONCRETE_CONVERTER_TIER_3_BLOCK_ITEM = ITEMS.register(ConcreteConverterTier3TileEntity.ID,
                () -> createBlockItem(CONCRETE_CONVERTER_TIER_3_BLOCK));
        CONCRETE_CONVERTER_TIER_4_BLOCK_ITEM = ITEMS.register(ConcreteConverterTier4TileEntity.ID,
                () -> createBlockItem(CONCRETE_CONVERTER_TIER_4_BLOCK));
        CONCRETE_CONVERTER_TIER_5_BLOCK_ITEM = ITEMS.register(ConcreteConverterTier5TileEntity.ID,
                () -> createBlockItem(CONCRETE_CONVERTER_TIER_5_BLOCK));
        CONCRETE_CONVERTER_TIER_6_BLOCK_ITEM = ITEMS.register(ConcreteConverterTier6TileEntity.ID,
                () -> createBlockItem(CONCRETE_CONVERTER_TIER_6_BLOCK));
        CONCRETE_CONVERTER_TIER_7_BLOCK_ITEM = ITEMS.register(ConcreteConverterTier7TileEntity.ID,
                () -> createBlockItem(CONCRETE_CONVERTER_TIER_7_BLOCK));
        CONCRETE_CONVERTER_TIER_8_BLOCK_ITEM = ITEMS.register(ConcreteConverterTier8TileEntity.ID,
                () -> createBlockItem(CONCRETE_CONVERTER_TIER_8_BLOCK));
        CONCRETE_CONVERTER_TIER_1_TILE_ENTITY_TYPE = TILE_ENTITY_TYPES.register(ConcreteConverterTier1TileEntity.ID,
                ConcreteConverterTier1TileEntity::createTileEntityType);
        CONCRETE_CONVERTER_TIER_2_TILE_ENTITY_TYPE = TILE_ENTITY_TYPES.register(ConcreteConverterTier2TileEntity.ID,
                ConcreteConverterTier2TileEntity::createTileEntityType);
        CONCRETE_CONVERTER_TIER_3_TILE_ENTITY_TYPE = TILE_ENTITY_TYPES.register(ConcreteConverterTier3TileEntity.ID,
                ConcreteConverterTier3TileEntity::createTileEntityType);
        CONCRETE_CONVERTER_TIER_4_TILE_ENTITY_TYPE = TILE_ENTITY_TYPES.register(ConcreteConverterTier4TileEntity.ID,
                ConcreteConverterTier4TileEntity::createTileEntityType);
        CONCRETE_CONVERTER_TIER_5_TILE_ENTITY_TYPE = TILE_ENTITY_TYPES.register(ConcreteConverterTier5TileEntity.ID,
                ConcreteConverterTier5TileEntity::createTileEntityType);
        CONCRETE_CONVERTER_TIER_6_TILE_ENTITY_TYPE = TILE_ENTITY_TYPES.register(ConcreteConverterTier6TileEntity.ID,
                ConcreteConverterTier6TileEntity::createTileEntityType);
        CONCRETE_CONVERTER_TIER_7_TILE_ENTITY_TYPE = TILE_ENTITY_TYPES.register(ConcreteConverterTier7TileEntity.ID,
                ConcreteConverterTier7TileEntity::createTileEntityType);
        CONCRETE_CONVERTER_TIER_8_TILE_ENTITY_TYPE = TILE_ENTITY_TYPES.register(ConcreteConverterTier8TileEntity.ID,
                ConcreteConverterTier8TileEntity::createTileEntityType);
        CONCRETE_CONVERTER_TIER_1_CONTAINER_TYPE = CONTAINERS.register(ConcreteConverterTier1TileEntity.ID,
                ConcreteConverterTier1Container::createContainerType);
        CONCRETE_CONVERTER_TIER_2_CONTAINER_TYPE = CONTAINERS.register(ConcreteConverterTier2TileEntity.ID,
                ConcreteConverterTier2Container::createContainerType);
        CONCRETE_CONVERTER_TIER_3_CONTAINER_TYPE = CONTAINERS.register(ConcreteConverterTier3TileEntity.ID,
                ConcreteConverterTier3Container::createContainerType);
        CONCRETE_CONVERTER_TIER_4_CONTAINER_TYPE = CONTAINERS.register(ConcreteConverterTier4TileEntity.ID,
                ConcreteConverterTier4Container::createContainerType);
        CONCRETE_CONVERTER_TIER_5_CONTAINER_TYPE = CONTAINERS.register(ConcreteConverterTier5TileEntity.ID,
                ConcreteConverterTier5Container::createContainerType);
        CONCRETE_CONVERTER_TIER_6_CONTAINER_TYPE = CONTAINERS.register(ConcreteConverterTier6TileEntity.ID,
                ConcreteConverterTier6Container::createContainerType);
        CONCRETE_CONVERTER_TIER_7_CONTAINER_TYPE = CONTAINERS.register(ConcreteConverterTier7TileEntity.ID,
                ConcreteConverterTier7Container::createContainerType);
        CONCRETE_CONVERTER_TIER_8_CONTAINER_TYPE = CONTAINERS.register(ConcreteConverterTier8TileEntity.ID,
                ConcreteConverterTier8Container::createContainerType);
    }

    public static void registerListeners(IEventBus bus)
    {
        BLOCKS.register(bus);
        ITEMS.register(bus);
        TILE_ENTITY_TYPES.register(bus);
        CONTAINERS.register(bus);
    }

    public static <T extends Block> BlockItem createBlockItem(RegistryObject<T> blockObject)
    {
        T block = blockObject.get();
        BlockState state = block.defaultBlockState();
        return new BlockItem(block,
                new Item.Properties().addToolType(block.getHarvestTool(state), block.getHarvestLevel(state))
                        .tab(CONCRETE_CONVERSION_TECH_ITEM_GROUP));
    }
}
