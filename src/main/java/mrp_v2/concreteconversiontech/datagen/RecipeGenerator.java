package mrp_v2.concreteconversiontech.datagen;

import mrp_v2.concreteconversiontech.ConcreteConversionTech;
import mrp_v2.concreteconversiontech.util.ObjectHolder;
import net.minecraft.world.level.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.tags.Tag;
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

    @Override protected void buildShapelessRecipes(Consumer<FinishedRecipe> consumer)
    {
        ShapedRecipeBuilder.shaped(ObjectHolder.CONCRETE_CONVERTER_TIER_1_BLOCK.get()).pattern("BPB").pattern("WCW")
                .pattern("BPB").define('C', Tags.Items.GLASS).define('W', Items.WATER_BUCKET)
                .define('B', ItemTags.PLANKS).define('P', Items.WOODEN_PICKAXE)
                .unlockedBy("has_planks", has(ItemTags.PLANKS)).save(consumer);
        ShapedRecipeBuilder.shaped(ObjectHolder.CONCRETE_CONVERTER_TIER_2_BLOCK.get()).pattern("BPB").pattern("WCW")
                .pattern("BPB").define('C', ObjectHolder.CONCRETE_CONVERTER_TIER_1_BLOCK.get())
                .define('W', Items.WATER_BUCKET).define('B', Tags.Items.STONE).define('P', Items.STONE_PICKAXE)
                .unlockedBy("has_stone", has(Tags.Items.STONE)).save(consumer);
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
        ShapedRecipeBuilder.shaped(ObjectHolder.CONCRETE_CONVERTER_TIER_8_BLOCK.get()).pattern("BPB").pattern("WCW")
                .pattern("BQB").define('C', ObjectHolder.CONCRETE_CONVERTER_TIER_7_BLOCK.get())
                .define('W', Items.WATER_BUCKET).define('B', Tags.Items.INGOTS_NETHERITE)
                .define('P', Items.NETHERITE_PICKAXE).define('Q', Tags.Items.NETHER_STARS)
                .unlockedBy("has_netherite", has(Tags.Items.INGOTS_NETHERITE)).save(consumer);
    }

    private void makeNormalConcreteConverterRecipe(Block converter, Block previousTier, Tag<Item> craftingBase,
            Item pickaxe, String tierName, Consumer<FinishedRecipe> consumer)
    {
        ShapedRecipeBuilder.shaped(converter).pattern("BPB").pattern("WCW").pattern("BPB").define('C', previousTier)
                .define('W', Items.WATER_BUCKET).define('B', craftingBase).define('P', pickaxe)
                .unlockedBy("has_" + tierName, has(craftingBase)).save(consumer);
    }
}
