package mrp_v2.concreteconversiontech.util;

import mrp_v2.concreteconversiontech.ConcreteConversionTech;
import mrp_v2.concreteconversiontech.config.ServerConfig;
import mrp_v2.concreteconversiontech.datagen.RecipeGenerator;
import mrp_v2.configurablerecipeslibrary.item.crafting.ConfigurableCraftingRecipe;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = ConcreteConversionTech.ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EventHandler
{
    @SubscribeEvent public static void setup(final FMLCommonSetupEvent event)
    {
        ConfigurableCraftingRecipe.addConditionMapping(RecipeGenerator.PROGRESSIVE_CRAFTING_ID,
                ServerConfig.SERVER.progressive_crafting::get);
        ConfigurableCraftingRecipe.addConditionMapping(RecipeGenerator.HARDER_CRAFTING_ID,
                ServerConfig.SERVER.harder_crafting::get);
    }
}
