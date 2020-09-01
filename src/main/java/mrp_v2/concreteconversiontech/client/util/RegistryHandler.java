package mrp_v2.concreteconversiontech.client.util;

import mrp_v2.concreteconversiontech.ConcreteConversionTech;
import mrp_v2.concreteconversiontech.client.gui.screen.inventory.*;
import mrp_v2.concreteconversiontech.util.ObjectHolder;
import net.minecraft.block.BlockState;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.item.BlockItem;
import net.minecraft.world.biome.BiomeColors;
import net.minecraft.world.biome.BiomeRegistry;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = ConcreteConversionTech.ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class RegistryHandler
{
    public static void init()
    {
        ScreenManager.registerFactory(ObjectHolder.CONCRETE_CONVERTER_TIER_1_CONTAINER_TYPE,
                ConcreteConverterTier1Screen::new);
        ScreenManager.registerFactory(ObjectHolder.CONCRETE_CONVERTER_TIER_2_CONTAINER_TYPE,
                ConcreteConverterTier2Screen::new);
        ScreenManager.registerFactory(ObjectHolder.CONCRETE_CONVERTER_TIER_3_CONTAINER_TYPE,
                ConcreteConverterTier3Screen::new);
        ScreenManager.registerFactory(ObjectHolder.CONCRETE_CONVERTER_TIER_4_CONTAINER_TYPE,
                ConcreteConverterTier4Screen::new);
        ScreenManager.registerFactory(ObjectHolder.CONCRETE_CONVERTER_TIER_5_CONTAINER_TYPE,
                ConcreteConverterTier5Screen::new);
        ScreenManager.registerFactory(ObjectHolder.CONCRETE_CONVERTER_TIER_6_CONTAINER_TYPE,
                ConcreteConverterTier6Screen::new);
        ScreenManager.registerFactory(ObjectHolder.CONCRETE_CONVERTER_TIER_7_CONTAINER_TYPE,
                ConcreteConverterTier7Screen::new);
        ScreenManager.registerFactory(ObjectHolder.CONCRETE_CONVERTER_TIER_8_CONTAINER_TYPE,
                ConcreteConverterTier8Screen::new);
    }

    @SubscribeEvent public static void registerBlockColors(final ColorHandlerEvent.Block event)
    {
        event.getBlockColors()
                .register((state, reader, pos, tint) -> reader != null && pos != null ?
                                BiomeColors.getWaterColor(reader, pos) :
                                BiomeRegistry.field_244200_a.getWaterColor(), ObjectHolder.CONCRETE_CONVERTER_TIER_1_BLOCK,
                        ObjectHolder.CONCRETE_CONVERTER_TIER_2_BLOCK,
                        ObjectHolder.CONCRETE_CONVERTER_TIER_3_BLOCK,
                        ObjectHolder.CONCRETE_CONVERTER_TIER_4_BLOCK,
                        ObjectHolder.CONCRETE_CONVERTER_TIER_5_BLOCK,
                        ObjectHolder.CONCRETE_CONVERTER_TIER_6_BLOCK,
                        ObjectHolder.CONCRETE_CONVERTER_TIER_7_BLOCK,
                        ObjectHolder.CONCRETE_CONVERTER_TIER_8_BLOCK);
    }

    @SubscribeEvent public static void registerItemColors(final ColorHandlerEvent.Item event)
    {
        event.getItemColors().register((itemStack, tint) ->
                {
                    BlockState blockstate = ((BlockItem) itemStack.getItem()).getBlock().getDefaultState();
                    return event.getBlockColors().getColor(blockstate, null, null, tint);
                }, ObjectHolder.CONCRETE_CONVERTER_TIER_1_BLOCK_ITEM, ObjectHolder.CONCRETE_CONVERTER_TIER_2_BLOCK_ITEM,
                ObjectHolder.CONCRETE_CONVERTER_TIER_3_BLOCK_ITEM,
                ObjectHolder.CONCRETE_CONVERTER_TIER_4_BLOCK_ITEM,
                ObjectHolder.CONCRETE_CONVERTER_TIER_5_BLOCK_ITEM,
                ObjectHolder.CONCRETE_CONVERTER_TIER_6_BLOCK_ITEM,
                ObjectHolder.CONCRETE_CONVERTER_TIER_7_BLOCK_ITEM,
                ObjectHolder.CONCRETE_CONVERTER_TIER_8_BLOCK_ITEM);
    }
}
