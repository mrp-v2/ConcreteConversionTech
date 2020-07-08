package mrp_v2.concreteconversiontech.client.eventhandler;

import mrp_v2.concreteconversiontech.ConcreteConversionTech;
import mrp_v2.concreteconversiontech.common.util.CCTObjectHolder;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@EventBusSubscriber(modid = ConcreteConversionTech.MODID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public class CCTClientEventHandler {

	@SubscribeEvent
	public static void clientSetup(final FMLClientSetupEvent event) {
		RenderTypeLookup.setRenderLayer(CCTObjectHolder.CONCRETE_CONVERTER_TIER_1_BLOCK, RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(CCTObjectHolder.CONCRETE_CONVERTER_TIER_2_BLOCK, RenderType.getCutout());
	}
}
