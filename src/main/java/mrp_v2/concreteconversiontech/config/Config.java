package mrp_v2.concreteconversiontech.config;

import mrp_v2.concreteconversiontech.ConcreteConversionTech;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.config.ModConfig;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.logging.log4j.LogManager;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, modid = ConcreteConversionTech.ID) public class Config
{
    public static final ForgeConfigSpec SERVER_SPEC;
    public static final Server SERVER;
    private static final String TRANSLATION_STEM = ConcreteConversionTech.ID + ".config.gui.";

    static
    {
        final Pair<Server, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Server::new);
        SERVER_SPEC = specPair.getRight();
        SERVER = specPair.getLeft();
    }

    @SubscribeEvent public static void onLoad(final ModConfig.Loading configEvent)
    {
        LogManager.getLogger()
                .debug("Loaded " + ConcreteConversionTech.DISPLAY_NAME + " config file {}",
                        configEvent.getConfig().getFileName());
    }

    @SubscribeEvent public static void onFileChange(final ModConfig.Reloading configEvent)
    {
        LogManager.getLogger()
                .debug(ConcreteConversionTech.DISPLAY_NAME + " config just got changed on the file system!");
    }

    public static class Server
    {
        private static final String HARDER_CRAFTING_ID = "harder_crafting";
        private static final String PROGRESSIVE_CRAFTING_ID = "progressive_crafting";
        public final BooleanValue harder_crafting;
        public final BooleanValue progressive_crafting;

        Server(final ForgeConfigSpec.Builder builder)
        {
            builder.comment(" Server configuration settings.").push("server");
            harder_crafting = builder.comment(
                    " Whether to increase the costs of crafting recipes by replacing ingots and gems with their compacted equivalents.",
                    " e.g. Iron Ingots -> Iron Blocks.")
                    .translation(TRANSLATION_STEM + HARDER_CRAFTING_ID)
                    .worldRestart()
                    .define(HARDER_CRAFTING_ID, false);
            progressive_crafting = builder.comment(
                    " Whether to include the previous tier of concrete converter in each concrete converter's crafting recipe.")
                    .translation(TRANSLATION_STEM + PROGRESSIVE_CRAFTING_ID)
                    .worldRestart()
                    .define(PROGRESSIVE_CRAFTING_ID, true);
            builder.pop();
        }
    }
}