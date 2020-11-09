package mrp_v2.concreteconversiontech;

import mrp_v2.concreteconversiontech.client.util.RegistryHandler;
import mrp_v2.concreteconversiontech.config.ServerConfig;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(ConcreteConversionTech.ID) public class ConcreteConversionTech
{
    public static final String ID = "concreteconversiontech";
    public static final String DISPLAY_NAME = "Concrete Conversion Tech";
    public static final Logger LOGGER = LogManager.getLogger();

    static
    {
        DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> RegistryHandler::init);
    }

    public ConcreteConversionTech()
    {
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, ServerConfig.SERVER_SPEC);
    }
}
