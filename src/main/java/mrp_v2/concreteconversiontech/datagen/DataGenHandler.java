package mrp_v2.concreteconversiontech.datagen;

import mrp_v2.concreteconversiontech.ConcreteConversionTech;
import mrp_v2.mrplibrary.datagen.DataGeneratorHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = ConcreteConversionTech.ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenHandler {
    @SubscribeEvent
    public static void gatherDataEvent(final GatherDataEvent event) {
        DataGeneratorHelper helper = new DataGeneratorHelper(event, ConcreteConversionTech.ID);
        helper.addRecipeProvider(RecipeGenerator::new);
        helper.addLootTables(new LootTables());
        helper.addBlockStateProvider(BlockStateGenerator::new);
        helper.addLanguageProvider(EN_USTranslationGenerator::new);
        helper.addBlockTagsProvider(BlockTagsGenerator::new);
    }
}
