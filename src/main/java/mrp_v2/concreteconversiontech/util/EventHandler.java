package mrp_v2.concreteconversiontech.util;

import mrp_v2.concreteconversiontech.ConcreteConversionTech;
import mrp_v2.concreteconversiontech.config.Config;
import mrp_v2.configurablerecipeslibrary.item.crafting.ConfigurableCraftingRecipe;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = ConcreteConversionTech.ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EventHandler
{
    @SubscribeEvent public static void setup(final FMLCommonSetupEvent event)
    {
        ConfigurableCraftingRecipe.addConditionMapping("progressive_crafting", Config.SERVER.progressive_crafting::get);
        ConfigurableCraftingRecipe.addConditionMapping("harder_crafting", Config.SERVER.harder_crafting::get);
    }
}
