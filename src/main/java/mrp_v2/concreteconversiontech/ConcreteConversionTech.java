package mrp_v2.concreteconversiontech;

import mrp_v2.concreteconversiontech.util.ObjectHolder;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(ConcreteConversionTech.ID) public class ConcreteConversionTech
{
    public static final String ID = "concreteconversiontech";
    public static final String DISPLAY_NAME = "Concrete Conversion Tech";
    public static final Logger LOGGER = LogManager.getLogger();

    public ConcreteConversionTech()
    {
        ObjectHolder.registerListeners(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
