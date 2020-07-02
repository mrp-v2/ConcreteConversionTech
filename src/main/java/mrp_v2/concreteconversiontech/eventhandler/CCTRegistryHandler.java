package mrp_v2.concreteconversiontech.eventhandler;

import mrp_v2.concreteconversiontech.block.ConcreteConverterTier1;
import mrp_v2.concreteconversiontech.util.CCTConstants;
import mrp_v2.concreteconversiontech.util.CCTObjectHolder;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = CCTConstants.MODID, bus = EventBusSubscriber.Bus.MOD)
public class CCTRegistryHandler {

	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(new ConcreteConverterTier1());
	}

	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(CCTObjectHolder.CONCRETE_CONVERTER_TIER_1.createBlockItem());
	}
}
