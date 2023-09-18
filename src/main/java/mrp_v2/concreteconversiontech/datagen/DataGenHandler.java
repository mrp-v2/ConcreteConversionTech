package mrp_v2.concreteconversiontech.datagen;

import mrp_v2.concreteconversiontech.ConcreteConversionTech;
import mrp_v2.mrplibrary.datagen.DataGeneratorHelper;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ConcreteConversionTech.ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenHandler {
    @SubscribeEvent
    public static void gatherDataEvent(final GatherDataEvent event) {
        DataGeneratorHelper helper = new DataGeneratorHelper(event, ConcreteConversionTech.ID);
        helper.addRecipeProvider(RecipeGenerator::new);
        helper.addLootTables(new LootTableProvider.SubProviderEntry(LootTables::new, LootContextParamSets.BLOCK));
        helper.addBlockStateProvider(BlockStateGenerator::new);
        helper.addLanguageProvider(EN_USTranslationGenerator::new);
        helper.addBlockTagsProvider(BlockTagsGenerator::new);
    }
}
