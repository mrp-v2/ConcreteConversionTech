package mrp_v2.concreteconversiontech.datagen;

import mrp_v2.concreteconversiontech.ConcreteConversionTech;
import mrp_v2.mrp_v2datagenlibrary.datagen.DataGeneratorHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = ConcreteConversionTech.ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenHandler
{
    @SubscribeEvent public static void gatherDataEvent(final GatherDataEvent event)
    {
        DataGeneratorHelper helper = new DataGeneratorHelper(event, ConcreteConversionTech.ID);
        if (event.includeServer())
        {
            helper.addRecipeGenerator(RecipeGenerator::new);
            helper.addLootTables(new LootTables());
        }
        if (event.includeClient())
        {
            helper.addBlockStateProvider(BlockStateGenerator::new);
            helper.addLanguageProvider(EN_USTranslationGenerator::new);
        }
    }
}
