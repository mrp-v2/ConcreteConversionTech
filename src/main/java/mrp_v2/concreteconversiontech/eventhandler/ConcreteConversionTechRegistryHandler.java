package mrp_v2.concreteconversiontech.eventhandler;

import mrp_v2.concreteconversiontech.ConcreteConversionTech;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = ConcreteConversionTech.MODID, bus = EventBusSubscriber.Bus.MOD)
public class ConcreteConversionTechRegistryHandler {

	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) {

	}

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {

	}
}
