package mrp_v2.concreteconversiontech.client.util;

import mrp_v2.concreteconversiontech.ConcreteConversionTech;
import mrp_v2.concreteconversiontech.util.ObjectHolder;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@EventBusSubscriber(modid = ConcreteConversionTech.ID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public class EventHandler
{
    @SubscribeEvent public static void clientSetup(final FMLClientSetupEvent event)
    {
        RenderTypeLookup.setRenderLayer(ObjectHolder.CONCRETE_CONVERTER_TIER_1_BLOCK, RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ObjectHolder.CONCRETE_CONVERTER_TIER_2_BLOCK, RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ObjectHolder.CONCRETE_CONVERTER_TIER_3_BLOCK, RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ObjectHolder.CONCRETE_CONVERTER_TIER_4_BLOCK, RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ObjectHolder.CONCRETE_CONVERTER_TIER_5_BLOCK, RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ObjectHolder.CONCRETE_CONVERTER_TIER_6_BLOCK, RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ObjectHolder.CONCRETE_CONVERTER_TIER_7_BLOCK, RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ObjectHolder.CONCRETE_CONVERTER_TIER_8_BLOCK, RenderType.getCutout());
    }
}
