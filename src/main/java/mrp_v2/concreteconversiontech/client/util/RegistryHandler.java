package mrp_v2.concreteconversiontech.client.util;

import mrp_v2.concreteconversiontech.ConcreteConversionTech;
import mrp_v2.concreteconversiontech.client.gui.screen.inventory.*;
import mrp_v2.concreteconversiontech.util.ObjectHolder;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@EventBusSubscriber(modid = ConcreteConversionTech.ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class RegistryHandler
{
    @SubscribeEvent public static void clientSetup(final FMLClientSetupEvent event)
    {
        ItemBlockRenderTypes.setRenderLayer(ObjectHolder.CONCRETE_CONVERTER_TIER_1_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ObjectHolder.CONCRETE_CONVERTER_TIER_2_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ObjectHolder.CONCRETE_CONVERTER_TIER_3_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ObjectHolder.CONCRETE_CONVERTER_TIER_4_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ObjectHolder.CONCRETE_CONVERTER_TIER_5_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ObjectHolder.CONCRETE_CONVERTER_TIER_6_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ObjectHolder.CONCRETE_CONVERTER_TIER_7_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ObjectHolder.CONCRETE_CONVERTER_TIER_8_BLOCK.get(), RenderType.cutout());
        MenuScreens.register(ObjectHolder.CONCRETE_CONVERTER_TIER_1_CONTAINER_TYPE.get(),
                ConcreteConverterTier1Screen::new);
        MenuScreens.register(ObjectHolder.CONCRETE_CONVERTER_TIER_2_CONTAINER_TYPE.get(),
                ConcreteConverterTier2Screen::new);
        MenuScreens.register(ObjectHolder.CONCRETE_CONVERTER_TIER_3_CONTAINER_TYPE.get(),
                ConcreteConverterTier3Screen::new);
        MenuScreens.register(ObjectHolder.CONCRETE_CONVERTER_TIER_4_CONTAINER_TYPE.get(),
                ConcreteConverterTier4Screen::new);
        MenuScreens.register(ObjectHolder.CONCRETE_CONVERTER_TIER_5_CONTAINER_TYPE.get(),
                ConcreteConverterTier5Screen::new);
        MenuScreens.register(ObjectHolder.CONCRETE_CONVERTER_TIER_6_CONTAINER_TYPE.get(),
                ConcreteConverterTier6Screen::new);
        MenuScreens.register(ObjectHolder.CONCRETE_CONVERTER_TIER_7_CONTAINER_TYPE.get(),
                ConcreteConverterTier7Screen::new);
        MenuScreens.register(ObjectHolder.CONCRETE_CONVERTER_TIER_8_CONTAINER_TYPE.get(),
                ConcreteConverterTier8Screen::new);
    }

    @SubscribeEvent
    public static void registerBlockColors(final RegisterColorHandlersEvent.Block event)
    {

        event.getBlockColors()
                .register((state, reader, pos, tint) -> reader != null && pos != null ?
                                BiomeColors.getAverageWaterColor(reader, pos) : -1, ObjectHolder.CONCRETE_CONVERTER_TIER_1_BLOCK.get(),
                        ObjectHolder.CONCRETE_CONVERTER_TIER_2_BLOCK.get(),
                        ObjectHolder.CONCRETE_CONVERTER_TIER_3_BLOCK.get(),
                        ObjectHolder.CONCRETE_CONVERTER_TIER_4_BLOCK.get(),
                        ObjectHolder.CONCRETE_CONVERTER_TIER_5_BLOCK.get(),
                        ObjectHolder.CONCRETE_CONVERTER_TIER_6_BLOCK.get(),
                        ObjectHolder.CONCRETE_CONVERTER_TIER_7_BLOCK.get(),
                        ObjectHolder.CONCRETE_CONVERTER_TIER_8_BLOCK.get());
    }

    @SubscribeEvent
    public static void registerItemColors(final RegisterColorHandlersEvent.Item event)
    {
        event.getItemColors().register((itemStack, tint) ->
                {
                    BlockState blockstate = ((BlockItem) itemStack.getItem()).getBlock().defaultBlockState();
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
