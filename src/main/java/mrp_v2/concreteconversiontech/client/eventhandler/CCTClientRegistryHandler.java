package mrp_v2.concreteconversiontech.client.eventhandler;

import mrp_v2.concreteconversiontech.common.util.CCTConstants;
import mrp_v2.concreteconversiontech.common.util.CCTObjectHolder;
import net.minecraft.world.biome.BiomeColors;
import net.minecraft.world.biome.Biomes;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@OnlyIn(Dist.CLIENT)
@EventBusSubscriber(modid = CCTConstants.MODID, bus = EventBusSubscriber.Bus.MOD)
public class CCTClientRegistryHandler {

	@SubscribeEvent
	public static void registerBlockColors(final ColorHandlerEvent.Block event) {
		event.getBlockColors().register((state, reader, pos, tint) -> {
			return reader != null && pos != null ? BiomeColors.getWaterColor(reader, pos) : -1;
		}, CCTObjectHolder.CONCRETE_CONVERTER_TIER_1);
	}

	@SubscribeEvent
	public static void registerItemColors(final ColorHandlerEvent.Item event) {
		event.getItemColors().register((itemStack, tint) -> {
			return Biomes.PLAINS.getWaterColor();
		}, CCTObjectHolder.CONCRETE_CONVERTER_TIER_1_ITEM);
	}
}
