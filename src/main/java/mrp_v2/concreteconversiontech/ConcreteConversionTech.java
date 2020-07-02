package mrp_v2.concreteconversiontech;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ConcreteConversionTech.MODID)
public class ConcreteConversionTech {

	public static final String MODID = "concreteconversiontech";
	public static final String TRANSLATION_STEM = "mrp_v2." + MODID + ".";

	public ConcreteConversionTech() {
		final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
	}
}
