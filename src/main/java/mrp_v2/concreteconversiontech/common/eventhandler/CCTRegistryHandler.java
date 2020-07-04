package mrp_v2.concreteconversiontech.common.eventhandler;

import mrp_v2.concreteconversiontech.common.tileentity.ConcreteConverterTier1TileEntity;
import mrp_v2.concreteconversiontech.common.util.CCTConstants;
import mrp_v2.concreteconversiontech.common.util.CCTObjectHolder;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = CCTConstants.MODID, bus = EventBusSubscriber.Bus.MOD)
public class CCTRegistryHandler {

	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(CCTObjectHolder.CONCRETE_CONVERTER_TIER_1_BLOCK);
	}

	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(CCTObjectHolder.CONCRETE_CONVERTER_TIER_1_BLOCK_ITEM);
	}

	@SubscribeEvent
	public static void registerTileEntities(final RegistryEvent.Register<TileEntityType<?>> event) {
		event.getRegistry().register(CCTObjectHolder.CONCRETE_CONVERTER_TIER_1_TILE_ENTITY_TYPE);
	}

	@SubscribeEvent
	public static void registrtTileEntityCapabilities(AttachCapabilitiesEvent<TileEntity> event) {
		if (event.getObject() instanceof ConcreteConverterTier1TileEntity) {
			event.addCapability(new ResourceLocation(CCTConstants.MODID, "concrete_converter_capability"),
					new ConcreteConverterTier1TileEntity());
		}
	}
}
