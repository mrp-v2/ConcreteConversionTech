package mrp_v2.concreteconversiontech.client.eventhandler;

import mrp_v2.concreteconversiontech.ConcreteConversionTech;
import mrp_v2.concreteconversiontech.client.gui.screen.inventory.ConcreteConverterTier1Screen;
import mrp_v2.concreteconversiontech.client.gui.screen.inventory.ConcreteConverterTier2Screen;
import mrp_v2.concreteconversiontech.common.util.CCTObjectHolder;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.world.biome.BiomeColors;
import net.minecraft.world.biome.Biomes;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@OnlyIn(Dist.CLIENT)
@EventBusSubscriber(modid = ConcreteConversionTech.MODID, bus = EventBusSubscriber.Bus.MOD)
public class CCTClientRegistryHandler {

	@SubscribeEvent
	public static void registerBlockColors(final ColorHandlerEvent.Block event) {
		event.getBlockColors().register((state, reader, pos, tint) -> {
			return reader != null && pos != null ? BiomeColors.getWaterColor(reader, pos) : -1;
		}, CCTObjectHolder.CONCRETE_CONVERTER_TIER_1_BLOCK, CCTObjectHolder.CONCRETE_CONVERTER_TIER_2_BLOCK);
	}

	@SubscribeEvent
	public static void registerItemColors(final ColorHandlerEvent.Item event) {
		event.getItemColors().register((itemStack, tint) -> {
			return Biomes.PLAINS.getWaterColor();
		}, CCTObjectHolder.CONCRETE_CONVERTER_TIER_1_BLOCK_ITEM, CCTObjectHolder.CONCRETE_CONVERTER_TIER_2_BLOCK_ITEM);
	}

	static {
		ScreenManager.registerFactory(CCTObjectHolder.CONCRETE_CONVERTER_TIER_1_CONTAINER_TYPE,
				ConcreteConverterTier1Screen::new);
		ScreenManager.registerFactory(CCTObjectHolder.CONCRETE_CONVERTER_TIER_2_CONTAINER_TYPE,
				ConcreteConverterTier2Screen::new);
	}
}
