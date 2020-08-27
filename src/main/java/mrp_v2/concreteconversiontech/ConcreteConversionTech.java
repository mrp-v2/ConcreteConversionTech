package mrp_v2.concreteconversiontech;

import mrp_v2.concreteconversiontech.config.CCTConfig;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

@Mod(ConcreteConversionTech.MODID)
public class ConcreteConversionTech {

	public static final String MODID = "concreteconversiontech";
	public static final String DISPLAY_NAME = "Concrete Conversion Tech";

	public ConcreteConversionTech() {
		ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, CCTConfig.SERVER_SPEC);
	}
}
