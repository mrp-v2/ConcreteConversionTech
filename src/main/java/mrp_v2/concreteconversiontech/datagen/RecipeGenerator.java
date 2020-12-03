package mrp_v2.concreteconversiontech.datagen;

import mrp_v2.concreteconversiontech.ConcreteConversionTech;
import mrp_v2.concreteconversiontech.util.ObjectHolder;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.common.Tags;

import java.util.function.Consumer;

public class RecipeGenerator extends mrp_v2.mrplibrary.datagen.providers.RecipeProvider
{
    public static final String HARDER_CRAFTING_ID = ConcreteConversionTech.ID + ":harder_crafting";
    public static final String PROGRESSIVE_CRAFTING_ID = ConcreteConversionTech.ID + ":progressive_crafting";

    protected RecipeGenerator(DataGenerator dataGeneratorIn, String modId)
    {
        super(dataGeneratorIn, modId);
    }

    @Override protected void registerRecipes(Consumer<IFinishedRecipe> consumer)
    {
        ShapedRecipeBuilder.shapedRecipe(ObjectHolder.CONCRETE_CONVERTER_TIER_1_BLOCK.get()).patternLine("BPB")
                .patternLine("WCW").patternLine("BPB").key('C', Tags.Items.GLASS).key('W', Items.WATER_BUCKET)
                .key('B', ItemTags.PLANKS).key('P', Items.WOODEN_PICKAXE)
                .addCriterion("has_planks", hasItem(ItemTags.PLANKS)).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ObjectHolder.CONCRETE_CONVERTER_TIER_2_BLOCK.get()).patternLine("BPB")
                .patternLine("WCW").patternLine("BPB").key('C', ObjectHolder.CONCRETE_CONVERTER_TIER_1_BLOCK.get())
                .key('W', Items.WATER_BUCKET).key('B', Tags.Items.STONE).key('P', Items.STONE_PICKAXE)
                .addCriterion("has_stone", hasItem(Tags.Items.STONE)).build(consumer);
        makeNormalConcreteConverterRecipe(ObjectHolder.CONCRETE_CONVERTER_TIER_3_BLOCK.get(),
                ObjectHolder.CONCRETE_CONVERTER_TIER_2_BLOCK.get(), Tags.Items.INGOTS_IRON, Items.IRON_PICKAXE, "iron",
                consumer);
        makeNormalConcreteConverterRecipe(ObjectHolder.CONCRETE_CONVERTER_TIER_4_BLOCK.get(),
                ObjectHolder.CONCRETE_CONVERTER_TIER_3_BLOCK.get(), Tags.Items.INGOTS_GOLD, Items.GOLDEN_PICKAXE,
                "gold", consumer);
        makeNormalConcreteConverterRecipe(ObjectHolder.CONCRETE_CONVERTER_TIER_5_BLOCK.get(),
                ObjectHolder.CONCRETE_CONVERTER_TIER_4_BLOCK.get(), Tags.Items.GEMS_DIAMOND, Items.DIAMOND_PICKAXE,
                "diamond", consumer);
        makeNormalConcreteConverterRecipe(ObjectHolder.CONCRETE_CONVERTER_TIER_6_BLOCK.get(),
                ObjectHolder.CONCRETE_CONVERTER_TIER_5_BLOCK.get(), Tags.Items.GEMS_EMERALD, Items.DIAMOND_PICKAXE,
                "emerald", consumer);
        makeNormalConcreteConverterRecipe(ObjectHolder.CONCRETE_CONVERTER_TIER_7_BLOCK.get(),
                ObjectHolder.CONCRETE_CONVERTER_TIER_6_BLOCK.get(), Tags.Items.GEMS_QUARTZ, Items.DIAMOND_PICKAXE,
                "quartz", consumer);
        ShapedRecipeBuilder.shapedRecipe(ObjectHolder.CONCRETE_CONVERTER_TIER_8_BLOCK.get()).patternLine("BPB")
                .patternLine("WCW").patternLine("BQB").key('C', ObjectHolder.CONCRETE_CONVERTER_TIER_7_BLOCK.get())
                .key('W', Items.WATER_BUCKET).key('B', Tags.Items.INGOTS_NETHERITE).key('P', Items.NETHERITE_PICKAXE)
                .key('Q', Tags.Items.NETHER_STARS).addCriterion("has_netherite", hasItem(Tags.Items.INGOTS_NETHERITE))
                .build(consumer);
    }

    private void makeNormalConcreteConverterRecipe(Block converter, Block previousTier, ITag<Item> craftingBase,
            Item pickaxe, String tierName, Consumer<IFinishedRecipe> consumer)
    {
        ShapedRecipeBuilder.shapedRecipe(converter).patternLine("BPB").patternLine("WCW").patternLine("BPB")
                .key('C', previousTier).key('W', Items.WATER_BUCKET).key('B', craftingBase).key('P', pickaxe)
                .addCriterion("has_" + tierName, hasItem(craftingBase)).build(consumer);
    }
}
