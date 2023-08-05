package mrp_v2.concreteconversiontech.util;

import mrp_v2.concreteconversiontech.ConcreteConversionTech;
import mrp_v2.concreteconversiontech.block.ConcreteConverterBlock;
import mrp_v2.concreteconversiontech.blockentity.*;
import mrp_v2.concreteconversiontech.inventory.container.*;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class ObjectHolder {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, ConcreteConversionTech.ID);
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ConcreteConversionTech.ID);
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, ConcreteConversionTech.ID);
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
    public static final RegistryObject<BlockEntityType<? extends AbstractConcreteConverterBlockEntity>>
            CONCRETE_CONVERTER_TIER_1_BLOCK_ENTITY_TYPE;
    public static final RegistryObject<BlockEntityType<? extends AbstractConcreteConverterBlockEntity>>
            CONCRETE_CONVERTER_TIER_2_BLOCK_ENTITY_TYPE;
    public static final RegistryObject<BlockEntityType<? extends AbstractConcreteConverterBlockEntity>>
            CONCRETE_CONVERTER_TIER_3_BLOCK_ENTITY_TYPE;
    public static final RegistryObject<BlockEntityType<? extends AbstractConcreteConverterBlockEntity>>
            CONCRETE_CONVERTER_TIER_4_BLOCK_ENTITY_TYPE;
    public static final RegistryObject<BlockEntityType<? extends AbstractConcreteConverterBlockEntity>>
            CONCRETE_CONVERTER_TIER_5_BLOCK_ENTITY_TYPE;
    public static final RegistryObject<BlockEntityType<? extends AbstractConcreteConverterBlockEntity>>
            CONCRETE_CONVERTER_TIER_6_BLOCK_ENTITY_TYPE;
    public static final RegistryObject<BlockEntityType<? extends AbstractConcreteConverterBlockEntity>>
            CONCRETE_CONVERTER_TIER_7_BLOCK_ENTITY_TYPE;
    public static final RegistryObject<BlockEntityType<? extends AbstractConcreteConverterBlockEntity>>
            CONCRETE_CONVERTER_TIER_8_BLOCK_ENTITY_TYPE;
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
    public static final CreativeModeTab CONCRETE_CONVERSION_TECH_ITEM_GROUP = new CreativeModeTab(ConcreteConversionTech.ID) {
        @OnlyIn(Dist.CLIENT)
        public @NotNull ItemStack makeIcon() {
            return new ItemStack(ObjectHolder.CONCRETE_CONVERTER_TIER_1_BLOCK.get());
        }
    };

    public static final Map<Integer, RegistryObject<BlockEntityType<? extends AbstractConcreteConverterBlockEntity>>> ENTITY_TYPE_MAP;

    static {
        ENTITY_TYPE_MAP = new HashMap<>(8);
        CONCRETE_CONVERTER_TIER_1_BLOCK = BLOCKS.register(ConcreteConverterTier1BlockEntity.ID,
                () -> new ConcreteConverterBlock(Blocks.OAK_PLANKS, ConcreteConverterTier1BlockEntity::new, () -> ENTITY_TYPE_MAP.get(1).get()));
        CONCRETE_CONVERTER_TIER_2_BLOCK = BLOCKS.register(ConcreteConverterTier2BlockEntity.ID,
                () -> new ConcreteConverterBlock(Blocks.STONE, ConcreteConverterTier2BlockEntity::new, () -> ENTITY_TYPE_MAP.get(2).get()));
        CONCRETE_CONVERTER_TIER_3_BLOCK = BLOCKS.register(ConcreteConverterTier3BlockEntity.ID,
                () -> new ConcreteConverterBlock(Blocks.IRON_BLOCK, ConcreteConverterTier3BlockEntity::new, () -> ENTITY_TYPE_MAP.get(3).get()));
        CONCRETE_CONVERTER_TIER_4_BLOCK = BLOCKS.register(ConcreteConverterTier4BlockEntity.ID,
                () -> new ConcreteConverterBlock(Blocks.GOLD_BLOCK, ConcreteConverterTier4BlockEntity::new, () -> ENTITY_TYPE_MAP.get(4).get()));
        CONCRETE_CONVERTER_TIER_5_BLOCK = BLOCKS.register(ConcreteConverterTier5BlockEntity.ID,
                () -> new ConcreteConverterBlock(Blocks.DIAMOND_BLOCK, ConcreteConverterTier5BlockEntity::new, () -> ENTITY_TYPE_MAP.get(5).get()));
        CONCRETE_CONVERTER_TIER_6_BLOCK = BLOCKS.register(ConcreteConverterTier6BlockEntity.ID,
                () -> new ConcreteConverterBlock(Blocks.EMERALD_BLOCK, ConcreteConverterTier6BlockEntity::new, () -> ENTITY_TYPE_MAP.get(6).get()));
        CONCRETE_CONVERTER_TIER_7_BLOCK = BLOCKS.register(ConcreteConverterTier7BlockEntity.ID,
                () -> new ConcreteConverterBlock(Blocks.QUARTZ_BLOCK, ConcreteConverterTier7BlockEntity::new, () -> ENTITY_TYPE_MAP.get(7).get()));
        CONCRETE_CONVERTER_TIER_8_BLOCK = BLOCKS.register(ConcreteConverterTier8BlockEntity.ID,
                () -> new ConcreteConverterBlock(Blocks.NETHERITE_BLOCK, ConcreteConverterTier8BlockEntity::new, () -> ENTITY_TYPE_MAP.get(8).get()));
        CONCRETE_CONVERTER_TIER_1_BLOCK_ITEM = ITEMS.register(ConcreteConverterTier1BlockEntity.ID,
                () -> createBlockItem(CONCRETE_CONVERTER_TIER_1_BLOCK));
        CONCRETE_CONVERTER_TIER_2_BLOCK_ITEM = ITEMS.register(ConcreteConverterTier2BlockEntity.ID,
                () -> createBlockItem(CONCRETE_CONVERTER_TIER_2_BLOCK));
        CONCRETE_CONVERTER_TIER_3_BLOCK_ITEM = ITEMS.register(ConcreteConverterTier3BlockEntity.ID,
                () -> createBlockItem(CONCRETE_CONVERTER_TIER_3_BLOCK));
        CONCRETE_CONVERTER_TIER_4_BLOCK_ITEM = ITEMS.register(ConcreteConverterTier4BlockEntity.ID,
                () -> createBlockItem(CONCRETE_CONVERTER_TIER_4_BLOCK));
        CONCRETE_CONVERTER_TIER_5_BLOCK_ITEM = ITEMS.register(ConcreteConverterTier5BlockEntity.ID,
                () -> createBlockItem(CONCRETE_CONVERTER_TIER_5_BLOCK));
        CONCRETE_CONVERTER_TIER_6_BLOCK_ITEM = ITEMS.register(ConcreteConverterTier6BlockEntity.ID,
                () -> createBlockItem(CONCRETE_CONVERTER_TIER_6_BLOCK));
        CONCRETE_CONVERTER_TIER_7_BLOCK_ITEM = ITEMS.register(ConcreteConverterTier7BlockEntity.ID,
                () -> createBlockItem(CONCRETE_CONVERTER_TIER_7_BLOCK));
        CONCRETE_CONVERTER_TIER_8_BLOCK_ITEM = ITEMS.register(ConcreteConverterTier8BlockEntity.ID,
                () -> createBlockItem(CONCRETE_CONVERTER_TIER_8_BLOCK));
        CONCRETE_CONVERTER_TIER_1_BLOCK_ENTITY_TYPE = BLOCK_ENTITY_TYPES.register(ConcreteConverterTier1BlockEntity.ID,
                ConcreteConverterTier1BlockEntity::createTileEntityType);
        ENTITY_TYPE_MAP.put(1, CONCRETE_CONVERTER_TIER_1_BLOCK_ENTITY_TYPE);
        CONCRETE_CONVERTER_TIER_2_BLOCK_ENTITY_TYPE = BLOCK_ENTITY_TYPES.register(ConcreteConverterTier2BlockEntity.ID,
                ConcreteConverterTier2BlockEntity::createTileEntityType);
        ENTITY_TYPE_MAP.put(2, CONCRETE_CONVERTER_TIER_2_BLOCK_ENTITY_TYPE);
        CONCRETE_CONVERTER_TIER_3_BLOCK_ENTITY_TYPE = BLOCK_ENTITY_TYPES.register(ConcreteConverterTier3BlockEntity.ID,
                ConcreteConverterTier3BlockEntity::createTileEntityType);
        ENTITY_TYPE_MAP.put(3, CONCRETE_CONVERTER_TIER_3_BLOCK_ENTITY_TYPE);
        CONCRETE_CONVERTER_TIER_4_BLOCK_ENTITY_TYPE = BLOCK_ENTITY_TYPES.register(ConcreteConverterTier4BlockEntity.ID,
                ConcreteConverterTier4BlockEntity::createTileEntityType);
        ENTITY_TYPE_MAP.put(4, CONCRETE_CONVERTER_TIER_4_BLOCK_ENTITY_TYPE);
        CONCRETE_CONVERTER_TIER_5_BLOCK_ENTITY_TYPE = BLOCK_ENTITY_TYPES.register(ConcreteConverterTier5BlockEntity.ID,
                ConcreteConverterTier5BlockEntity::createTileEntityType);
        ENTITY_TYPE_MAP.put(5, CONCRETE_CONVERTER_TIER_5_BLOCK_ENTITY_TYPE);
        CONCRETE_CONVERTER_TIER_6_BLOCK_ENTITY_TYPE = BLOCK_ENTITY_TYPES.register(ConcreteConverterTier6BlockEntity.ID,
                ConcreteConverterTier6BlockEntity::createTileEntityType);
        ENTITY_TYPE_MAP.put(6, CONCRETE_CONVERTER_TIER_6_BLOCK_ENTITY_TYPE);
        CONCRETE_CONVERTER_TIER_7_BLOCK_ENTITY_TYPE = BLOCK_ENTITY_TYPES.register(ConcreteConverterTier7BlockEntity.ID,
                ConcreteConverterTier7BlockEntity::createTileEntityType);
        ENTITY_TYPE_MAP.put(7, CONCRETE_CONVERTER_TIER_7_BLOCK_ENTITY_TYPE);
        CONCRETE_CONVERTER_TIER_8_BLOCK_ENTITY_TYPE = BLOCK_ENTITY_TYPES.register(ConcreteConverterTier8BlockEntity.ID,
                ConcreteConverterTier8BlockEntity::createTileEntityType);
        ENTITY_TYPE_MAP.put(8, CONCRETE_CONVERTER_TIER_8_BLOCK_ENTITY_TYPE);
        CONCRETE_CONVERTER_TIER_1_CONTAINER_TYPE = CONTAINERS.register(ConcreteConverterTier1BlockEntity.ID,
                ConcreteConverterTier1Container::createContainerType);
        CONCRETE_CONVERTER_TIER_2_CONTAINER_TYPE = CONTAINERS.register(ConcreteConverterTier2BlockEntity.ID,
                ConcreteConverterTier2Container::createContainerType);
        CONCRETE_CONVERTER_TIER_3_CONTAINER_TYPE = CONTAINERS.register(ConcreteConverterTier3BlockEntity.ID,
                ConcreteConverterTier3Container::createContainerType);
        CONCRETE_CONVERTER_TIER_4_CONTAINER_TYPE = CONTAINERS.register(ConcreteConverterTier4BlockEntity.ID,
                ConcreteConverterTier4Container::createContainerType);
        CONCRETE_CONVERTER_TIER_5_CONTAINER_TYPE = CONTAINERS.register(ConcreteConverterTier5BlockEntity.ID,
                ConcreteConverterTier5Container::createContainerType);
        CONCRETE_CONVERTER_TIER_6_CONTAINER_TYPE = CONTAINERS.register(ConcreteConverterTier6BlockEntity.ID,
                ConcreteConverterTier6Container::createContainerType);
        CONCRETE_CONVERTER_TIER_7_CONTAINER_TYPE = CONTAINERS.register(ConcreteConverterTier7BlockEntity.ID,
                ConcreteConverterTier7Container::createContainerType);
        CONCRETE_CONVERTER_TIER_8_CONTAINER_TYPE = CONTAINERS.register(ConcreteConverterTier8BlockEntity.ID,
                ConcreteConverterTier8Container::createContainerType);
    }

    public static void registerListeners(IEventBus bus) {
        BLOCKS.register(bus);
        ITEMS.register(bus);
        BLOCK_ENTITY_TYPES.register(bus);
        CONTAINERS.register(bus);
    }

    public static <T extends Block> BlockItem createBlockItem(RegistryObject<T> blockObject) {
        T block = blockObject.get();
        return new BlockItem(block, new Item.Properties().tab(CONCRETE_CONVERSION_TECH_ITEM_GROUP));
    }
}
