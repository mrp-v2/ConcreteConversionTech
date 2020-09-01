package mrp_v2.concreteconversiontech.util;

import mrp_v2.concreteconversiontech.ConcreteConversionTech;
import net.minecraft.block.Block;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = ConcreteConversionTech.ID, bus = EventBusSubscriber.Bus.MOD) public class RegistryHandler
{
    @SubscribeEvent public static void registerBlocks(final RegistryEvent.Register<Block> event)
    {
        event.getRegistry()
                .registerAll(ObjectHolder.CONCRETE_CONVERTER_TIER_1_BLOCK, ObjectHolder.CONCRETE_CONVERTER_TIER_2_BLOCK,
                        ObjectHolder.CONCRETE_CONVERTER_TIER_3_BLOCK, ObjectHolder.CONCRETE_CONVERTER_TIER_4_BLOCK,
                        ObjectHolder.CONCRETE_CONVERTER_TIER_5_BLOCK, ObjectHolder.CONCRETE_CONVERTER_TIER_6_BLOCK,
                        ObjectHolder.CONCRETE_CONVERTER_TIER_7_BLOCK, ObjectHolder.CONCRETE_CONVERTER_TIER_8_BLOCK);
    }

    @SubscribeEvent public static void registerItems(final RegistryEvent.Register<Item> event)
    {
        event.getRegistry()
                .registerAll(ObjectHolder.CONCRETE_CONVERTER_TIER_1_BLOCK_ITEM,
                        ObjectHolder.CONCRETE_CONVERTER_TIER_2_BLOCK_ITEM,
                        ObjectHolder.CONCRETE_CONVERTER_TIER_3_BLOCK_ITEM,
                        ObjectHolder.CONCRETE_CONVERTER_TIER_4_BLOCK_ITEM,
                        ObjectHolder.CONCRETE_CONVERTER_TIER_5_BLOCK_ITEM,
                        ObjectHolder.CONCRETE_CONVERTER_TIER_6_BLOCK_ITEM,
                        ObjectHolder.CONCRETE_CONVERTER_TIER_7_BLOCK_ITEM,
                        ObjectHolder.CONCRETE_CONVERTER_TIER_8_BLOCK_ITEM);
    }

    @SubscribeEvent public static void registerTileEntities(final RegistryEvent.Register<TileEntityType<?>> event)
    {
        event.getRegistry()
                .registerAll(ObjectHolder.CONCRETE_CONVERTER_TIER_1_TILE_ENTITY_TYPE,
                        ObjectHolder.CONCRETE_CONVERTER_TIER_2_TILE_ENTITY_TYPE,
                        ObjectHolder.CONCRETE_CONVERTER_TIER_3_TILE_ENTITY_TYPE,
                        ObjectHolder.CONCRETE_CONVERTER_TIER_4_TILE_ENTITY_TYPE,
                        ObjectHolder.CONCRETE_CONVERTER_TIER_5_TILE_ENTITY_TYPE,
                        ObjectHolder.CONCRETE_CONVERTER_TIER_6_TILE_ENTITY_TYPE,
                        ObjectHolder.CONCRETE_CONVERTER_TIER_7_TILE_ENTITY_TYPE,
                        ObjectHolder.CONCRETE_CONVERTER_TIER_8_TILE_ENTITY_TYPE);
    }

    @SubscribeEvent public static void registerContainers(final RegistryEvent.Register<ContainerType<?>> event)
    {
        event.getRegistry()
                .registerAll(ObjectHolder.CONCRETE_CONVERTER_TIER_1_CONTAINER_TYPE,
                        ObjectHolder.CONCRETE_CONVERTER_TIER_2_CONTAINER_TYPE,
                        ObjectHolder.CONCRETE_CONVERTER_TIER_3_CONTAINER_TYPE,
                        ObjectHolder.CONCRETE_CONVERTER_TIER_4_CONTAINER_TYPE,
                        ObjectHolder.CONCRETE_CONVERTER_TIER_5_CONTAINER_TYPE,
                        ObjectHolder.CONCRETE_CONVERTER_TIER_6_CONTAINER_TYPE,
                        ObjectHolder.CONCRETE_CONVERTER_TIER_7_CONTAINER_TYPE,
                        ObjectHolder.CONCRETE_CONVERTER_TIER_8_CONTAINER_TYPE);
    }
}
