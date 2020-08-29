package mrp_v2.concreteconversiontech;

import mrp_v2.concreteconversiontech.config.Config;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

@Mod(ConcreteConversionTech.ID) public class ConcreteConversionTech
{
    public static final String ID = "concreteconversiontech";
    public static final String DISPLAY_NAME = "Concrete Conversion Tech";

    public ConcreteConversionTech()
    {
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Config.SERVER_SPEC);
    }
}
