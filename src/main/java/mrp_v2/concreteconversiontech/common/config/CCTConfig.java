package mrp_v2.concreteconversiontech.common.config;

import java.util.Set;

import org.apache.commons.lang3.tuple.Pair;
import org.apache.logging.log4j.LogManager;

import com.google.common.collect.Sets;

import mrp_v2.concreteconversiontech.ConcreteConversionTech;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.config.ModConfig;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, modid = ConcreteConversionTech.MODID)
public class CCTConfig {

	public static class Server {

		private static final String HARDER_CRAFTING_ID = "harder_crafting";
		private static final String PROGRESSIVE_CRAFTING_ID = "progressive_crafting";

		private static final Set<String> EMPTY_SET = Sets.newHashSet();

		private final BooleanValue harder_crafting;
		private final BooleanValue progressive_crafting;

		private final LazyOptional<Set<String>> craftingConditions;

		Server(final ForgeConfigSpec.Builder builder) {
			builder.comment("Server configuration settings.").push("server");

			harder_crafting = builder.comment(
					"Whether to increase the costs of crafting recipes by replacing ingots and gems with their compacted equivalents.",
					"e.g. Iron Ingots -> Iron Blocks.").translation(TRANSLATION_STEM + HARDER_CRAFTING_ID)
					.define(HARDER_CRAFTING_ID, false);

			progressive_crafting = builder.comment(
					"Whether to include the previous tier of concrete converter in each concrete converter's crafting recipe.")
					.translation(TRANSLATION_STEM + PROGRESSIVE_CRAFTING_ID).define(PROGRESSIVE_CRAFTING_ID, true);

			builder.pop();

			craftingConditions = LazyOptional.of(() -> {
				return Sets.newHashSet(
						SERVER.harder_crafting.get() ? Server.HARDER_CRAFTING_ID : "!" + Server.HARDER_CRAFTING_ID,
						SERVER.progressive_crafting.get() ? Server.PROGRESSIVE_CRAFTING_ID
								: "!" + Server.PROGRESSIVE_CRAFTING_ID);
			});
		}

		public Set<String> getCraftingConditions() {
			return craftingConditions.orElse(EMPTY_SET);
		}

		public void updateCraftingConditions() {
			craftingConditions.invalidate();
		}
	}

	private static final String TRANSLATION_STEM = ConcreteConversionTech.MODID + ".configgui.";

	public static final ForgeConfigSpec SERVER_SPEC;
	public static final Server SERVER;
	static {
		final Pair<Server, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Server::new);
		SERVER_SPEC = specPair.getRight();
		SERVER = specPair.getLeft();
	}

	@SubscribeEvent
	public static void onLoad(final ModConfig.Loading configEvent) {
		LogManager.getLogger().debug("Loaded " + ConcreteConversionTech.DISPLAY_NAME + " config file {}",
				configEvent.getConfig().getFileName());
		SERVER.updateCraftingConditions();
	}

	@SubscribeEvent
	public static void onFileChange(final ModConfig.Reloading configEvent) {
		LogManager.getLogger()
				.debug(ConcreteConversionTech.DISPLAY_NAME + " config just got changed on the file system!");
		SERVER.updateCraftingConditions();
	}
}