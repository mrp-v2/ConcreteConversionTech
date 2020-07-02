package mrp_v2.concreteconversiontech;

import mrp_v2.concreteconversiontech.config.ConcreteConversionTechConfig;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ConcreteConversionTech.MODID)
public class ConcreteConversionTech {

	public static final String MODID = "concreteconversiontech";
	public static final String TRANSLATION_STEM = "mrp_v2." + MODID + ".";
	public static final String DISPLAY_NAME = "Concrete Conversion Tech";

	public ConcreteConversionTech() {
		ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, ConcreteConversionTechConfig.SERVER_SPEC);
		final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		modEventBus.register(ConcreteConversionTechConfig.class);
	}
}
