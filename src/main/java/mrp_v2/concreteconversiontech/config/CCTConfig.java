package mrp_v2.concreteconversiontech.config;

import org.apache.commons.lang3.tuple.Pair;
import org.apache.logging.log4j.LogManager;

import mrp_v2.concreteconversiontech.util.CCTConstants;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.config.ModConfig;

public class CCTConfig {

	public static class Server {

		Server(final ForgeConfigSpec.Builder builder) {
			//builder.comment("Server configuration settings.");

			//builder.pop();
		}
	}

	// private static final String TRANSLATION_STEM = CCTConstants.TRANSLATION_STEM + "configgui.";

	public static final ForgeConfigSpec SERVER_SPEC;
	public static final Server SERVER;
	static {
		final Pair<Server, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Server::new);
		SERVER_SPEC = specPair.getRight();
		SERVER = specPair.getLeft();
	}

	@SubscribeEvent
	public static void onLoad(final ModConfig.Loading configEvent) {
		// LogManager.getLogger().debug(FORGEMOD, "Loaded forge config file {}",
		// configEvent.getConfig().getFileName());
		LogManager.getLogger().debug("Loaded " + CCTConstants.DISPLAY_NAME + " config file {}",
				configEvent.getConfig().getFileName());
	}

	@SubscribeEvent
	public static void onFileChange(final ModConfig.Reloading configEvent) {
		// LogManager.getLogger().debug(FORGEMOD, "Forge config just got changed on the
		// file system!");
		LogManager.getLogger().debug(CCTConstants.DISPLAY_NAME + " config just got changed on the file system!");
	}
}
