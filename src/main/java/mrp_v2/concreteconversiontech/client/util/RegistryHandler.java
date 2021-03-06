package mrp_v2.concreteconversiontech.client.util;

import mrp_v2.concreteconversiontech.ConcreteConversionTech;
import mrp_v2.concreteconversiontech.client.gui.screen.inventory.*;
import mrp_v2.concreteconversiontech.util.ObjectHolder;
import net.minecraft.block.BlockState;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.BlockItem;
import net.minecraft.world.biome.BiomeColors;
import net.minecraft.world.biome.BiomeRegistry;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@EventBusSubscriber(modid = ConcreteConversionTech.ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class RegistryHandler
{
    @SubscribeEvent public static void clientSetup(final FMLClientSetupEvent event)
    {
        RenderTypeLookup.setRenderLayer(ObjectHolder.CONCRETE_CONVERTER_TIER_1_BLOCK.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ObjectHolder.CONCRETE_CONVERTER_TIER_2_BLOCK.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ObjectHolder.CONCRETE_CONVERTER_TIER_3_BLOCK.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ObjectHolder.CONCRETE_CONVERTER_TIER_4_BLOCK.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ObjectHolder.CONCRETE_CONVERTER_TIER_5_BLOCK.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ObjectHolder.CONCRETE_CONVERTER_TIER_6_BLOCK.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ObjectHolder.CONCRETE_CONVERTER_TIER_7_BLOCK.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ObjectHolder.CONCRETE_CONVERTER_TIER_8_BLOCK.get(), RenderType.getCutout());
        ScreenManager.registerFactory(ObjectHolder.CONCRETE_CONVERTER_TIER_1_CONTAINER_TYPE.get(),
                ConcreteConverterTier1Screen::new);
        ScreenManager.registerFactory(ObjectHolder.CONCRETE_CONVERTER_TIER_2_CONTAINER_TYPE.get(),
                ConcreteConverterTier2Screen::new);
        ScreenManager.registerFactory(ObjectHolder.CONCRETE_CONVERTER_TIER_3_CONTAINER_TYPE.get(),
                ConcreteConverterTier3Screen::new);
        ScreenManager.registerFactory(ObjectHolder.CONCRETE_CONVERTER_TIER_4_CONTAINER_TYPE.get(),
                ConcreteConverterTier4Screen::new);
        ScreenManager.registerFactory(ObjectHolder.CONCRETE_CONVERTER_TIER_5_CONTAINER_TYPE.get(),
                ConcreteConverterTier5Screen::new);
        ScreenManager.registerFactory(ObjectHolder.CONCRETE_CONVERTER_TIER_6_CONTAINER_TYPE.get(),
                ConcreteConverterTier6Screen::new);
        ScreenManager.registerFactory(ObjectHolder.CONCRETE_CONVERTER_TIER_7_CONTAINER_TYPE.get(),
                ConcreteConverterTier7Screen::new);
        ScreenManager.registerFactory(ObjectHolder.CONCRETE_CONVERTER_TIER_8_CONTAINER_TYPE.get(),
                ConcreteConverterTier8Screen::new);
    }

    @SubscribeEvent public static void registerBlockColors(final ColorHandlerEvent.Block event)
    {
        event.getBlockColors()
                .register((state, reader, pos, tint) -> reader != null && pos != null ?
                                BiomeColors.getWaterColor(reader, pos) :
                                BiomeRegistry.PLAINS.getWaterColor(), ObjectHolder.CONCRETE_CONVERTER_TIER_1_BLOCK.get(),
                        ObjectHolder.CONCRETE_CONVERTER_TIER_2_BLOCK.get(),
                        ObjectHolder.CONCRETE_CONVERTER_TIER_3_BLOCK.get(),
                        ObjectHolder.CONCRETE_CONVERTER_TIER_4_BLOCK.get(),
                        ObjectHolder.CONCRETE_CONVERTER_TIER_5_BLOCK.get(),
                        ObjectHolder.CONCRETE_CONVERTER_TIER_6_BLOCK.get(),
                        ObjectHolder.CONCRETE_CONVERTER_TIER_7_BLOCK.get(),
                        ObjectHolder.CONCRETE_CONVERTER_TIER_8_BLOCK.get());
    }

    @SubscribeEvent public static void registerItemColors(final ColorHandlerEvent.Item event)
    {
        event.getItemColors().register((itemStack, tint) ->
                {
                    BlockState blockstate = ((BlockItem) itemStack.getItem()).getBlock().getDefaultState();
                    return event.getBlockColors().getColor(blockstate, null, null, tint);
                }, ObjectHolder.CONCRETE_CONVERTER_TIER_1_BLOCK_ITEM.get(),
                ObjectHolder.CONCRETE_CONVERTER_TIER_2_BLOCK_ITEM.get(),
                ObjectHolder.CONCRETE_CONVERTER_TIER_3_BLOCK_ITEM.get(),
                ObjectHolder.CONCRETE_CONVERTER_TIER_4_BLOCK_ITEM.get(),
                ObjectHolder.CONCRETE_CONVERTER_TIER_5_BLOCK_ITEM.get(),
                ObjectHolder.CONCRETE_CONVERTER_TIER_6_BLOCK_ITEM.get(),
                ObjectHolder.CONCRETE_CONVERTER_TIER_7_BLOCK_ITEM.get(),
                ObjectHolder.CONCRETE_CONVERTER_TIER_8_BLOCK_ITEM.get());
    }
}
