package mrp_v2.concreteconversiontech;

import mrp_v2.concreteconversiontech.common.config.CCTConfig;
import mrp_v2.concreteconversiontech.common.util.CCTConstants;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

@Mod(CCTConstants.MODID)
public class ConcreteConversionTech {

	public ConcreteConversionTech() {
		ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, CCTConfig.SERVER_SPEC);
	}
}
