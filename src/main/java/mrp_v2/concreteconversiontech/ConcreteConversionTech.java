package mrp_v2.concreteconversiontech;

import mrp_v2.concreteconversiontech.config.CCTConfig;
import mrp_v2.concreteconversiontech.util.CCTConstants;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(CCTConstants.MODID)
public class ConcreteConversionTech {

	public ConcreteConversionTech() {
		ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, CCTConfig.SERVER_SPEC);
		final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		modEventBus.register(CCTConfig.class);
	}
}
