package mrp_v2.concreteconversiontech.common.recipe;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.gson.*;
import mrp_v2.concreteconversiontech.ConcreteConversionTech;
import mrp_v2.concreteconversiontech.common.config.CCTConfig;
import mrp_v2.concreteconversiontech.common.util.CCTObjectHolder;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.ICraftingRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.common.crafting.IShapedRecipe;
import net.minecraftforge.registries.ForgeRegistryEntry;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class CCTShapedRecipe implements ICraftingRecipe, IShapedRecipe<CraftingInventory>
{
    static int MAX_WIDTH = 3;
    static int MAX_HEIGHT = 3;
    private final int recipeWidth;
    private final int recipeHeight;
    private final NonNullList<Ingredient> recipeItems;
    private final ItemStack recipeOutput;
    private final ResourceLocation id;
    private final String group;
    private final String[] pattern;
    private final List<Override> overrides;

    public CCTShapedRecipe(ResourceLocation idIn, String groupIn, int recipeWidthIn, int recipeHeightIn,
            NonNullList<Ingredient> recipeItemsIn, ItemStack recipeOutputIn, String[] pattern, List<Override> overrides)
    {
        this.id = idIn;
        this.group = groupIn;
        this.recipeWidth = recipeWidthIn;
        this.recipeHeight = recipeHeightIn;
        this.recipeItems = recipeItemsIn;
        this.recipeOutput = recipeOutputIn;
        this.pattern = pattern;
        this.overrides = overrides;
    }

    private static NonNullList<Ingredient> deserializeIngredients(String[] pattern, Map<String, Ingredient> keys,
            int patternWidth, int patternHeight)
    {
        NonNullList<Ingredient> nonnulllist = NonNullList.withSize(patternWidth * patternHeight, Ingredient.EMPTY);
        Set<String> set = Sets.newHashSet(keys.keySet());
        set.remove(" ");
        for (int i = 0; i < pattern.length; ++i)
        {
            for (int j = 0; j < pattern[i].length(); ++j)
            {
                String s = pattern[i].substring(j, j + 1);
                Ingredient ingredient = keys.get(s);
                if (ingredient == null)
                {
                    throw new JsonSyntaxException(
                            "Pattern references symbol '" + s + "' but it's not defined in the key");
                }
                set.remove(s);
                nonnulllist.set(j + patternWidth * i, ingredient);
            }
        }
        if (!set.isEmpty())
        {
            throw new JsonSyntaxException("Key defines symbols that aren't used in pattern: " + set);
        } else
        {
            return nonnulllist;
        }
    }

    @VisibleForTesting static String[] shrink(String... toShrink)
    {
        int i = Integer.MAX_VALUE;
        int j = 0;
        int k = 0;
        int l = 0;
        for (int i1 = 0; i1 < toShrink.length; ++i1)
        {
            String s = toShrink[i1];
            i = Math.min(i, firstNonSpace(s));
            int j1 = lastNonSpace(s);
            j = Math.max(j, j1);
            if (j1 < 0)
            {
                if (k == i1)
                {
                    ++k;
                }
                ++l;
            } else
            {
                l = 0;
            }
        }
        if (toShrink.length == l)
        {
            return new String[0];
        } else
        {
            String[] astring = new String[toShrink.length - l - k];
            for (int k1 = 0; k1 < astring.length; ++k1)
            {
                astring[k1] = toShrink[k1 + k].substring(i, j + 1);
            }
            return astring;
        }
    }

    private static int firstNonSpace(String str)
    {
        int i;
        for (i = 0; i < str.length() && str.charAt(i) == ' '; ++i)
        {
        }
        return i;
    }

    private static int lastNonSpace(String str)
    {
        int i;
        for (i = str.length() - 1; i >= 0 && str.charAt(i) == ' '; --i)
        {
        }
        return i;
    }

    private static String[] patternFromJson(JsonArray jsonArr)
    {
        String[] astring = new String[jsonArr.size()];
        if (astring.length > MAX_HEIGHT)
        {
            throw new JsonSyntaxException("Invalid pattern: too many rows, " + MAX_HEIGHT + " is maximum");
        } else if (astring.length == 0)
        {
            throw new JsonSyntaxException("Invalid pattern: empty pattern not allowed");
        } else
        {
            for (int i = 0; i < astring.length; ++i)
            {
                String s = JSONUtils.getString(jsonArr.get(i), "pattern[" + i + "]");
                if (s.length() > MAX_WIDTH)
                {
                    throw new JsonSyntaxException("Invalid pattern: too many columns, " + MAX_WIDTH + " is maximum");
                }
                if (i > 0 && astring[0].length() != s.length())
                {
                    throw new JsonSyntaxException("Invalid pattern: each row must be the same width");
                }
                astring[i] = s;
            }
            return astring;
        }
    }

    /**
     * Returns a key json object as a Java HashMap.
     */
    private static Map<String, Ingredient> deserializeKey(JsonObject json)
    {
        Map<String, Ingredient> map = Maps.newHashMap();
        for (Entry<String, JsonElement> entry : json.entrySet())
        {
            if (entry.getKey().length() != 1)
            {
                throw new JsonSyntaxException("Invalid key entry: '" +
                        (String) entry.getKey() +
                        "' is an invalid symbol (must be 1 character only).");
            }
            if (" ".equals(entry.getKey()))
            {
                throw new JsonSyntaxException("Invalid key entry: ' ' is a reserved symbol.");
            }
            map.put(entry.getKey(), Ingredient.deserialize(entry.getValue()));
        }
        map.put(" ", Ingredient.EMPTY);
        return map;
    }

    @SuppressWarnings({"unused", "deprecation"}) public static ItemStack deserializeItem(JsonObject p_199798_0_)
    {
        String s = JSONUtils.getString(p_199798_0_, "item");
        Item item = Registry.ITEM.getOrDefault(new ResourceLocation(s));
        if (item == Registry.ITEM.getOrDefault(null))
        {
            throw new JsonSyntaxException("Unknown item '" + s + "'");
        }
        if (p_199798_0_.has("data"))
        {
            throw new JsonParseException("Disallowed data tag found");
        } else
        {
            int i = JSONUtils.getInt(p_199798_0_, "count", 1);
            return CraftingHelper.getItemStack(p_199798_0_, true);
        }
    }

    /**
     * Used to check if a recipe matches current crafting inventory
     */
    public boolean matches(CraftingInventory inv, World worldIn)
    {
        for (int i = 0; i <= inv.getWidth() - this.recipeWidth; ++i)
        {
            for (int j = 0; j <= inv.getHeight() - this.recipeHeight; ++j)
            {
                if (this.checkMatch(inv, i, j, true))
                {
                    return true;
                }
                if (this.checkMatch(inv, i, j, false))
                {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks if the region of a crafting inventory is match for the recipe.
     */
    private boolean checkMatch(CraftingInventory craftingInventory, int p_77573_2_, int p_77573_3_, boolean p_77573_4_)
    {
        for (int i = 0; i < craftingInventory.getWidth(); ++i)
        {
            for (int j = 0; j < craftingInventory.getHeight(); ++j)
            {
                int k = i - p_77573_2_;
                int l = j - p_77573_3_;
                Ingredient ingredient = Ingredient.EMPTY;
                if (k >= 0 && l >= 0 && k < this.recipeWidth && l < this.recipeHeight)
                {
                    if (p_77573_4_)
                    {
                        ingredient = this.getIngredients().get(this.recipeWidth - k - 1 + l * this.recipeWidth);
                    } else
                    {
                        ingredient = this.getIngredients().get(k + l * this.recipeWidth);
                    }
                }
                if (!ingredient.test(craftingInventory.getStackInSlot(i + j * craftingInventory.getWidth())))
                {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Returns an Item that is the result of this recipe
     */
    public ItemStack getCraftingResult(CraftingInventory inv)
    {
        return this.getRecipeOutput().copy();
    }

    /**
     * Used to determine if this recipe can fit in a grid of the given width/height
     */
    public boolean canFit(int width, int height)
    {
        return width >= this.recipeWidth && height >= this.recipeHeight;
    }

    /**
     * Get the result of this recipe, usually for display purposes (e.g. recipe
     * book). If your recipe has more than one possible result (e.g. it's dynamic
     * and depends on its inputs), then return an empty stack.
     */
    public ItemStack getRecipeOutput()
    {
        return this.recipeOutput;
    }

    public NonNullList<Ingredient> getIngredients()
    {
        NonNullList<Ingredient> ingredients = this.recipeItems;
        for (Override override : overrides)
        {
            ingredients = override.apply(ingredients, pattern, CCTConfig.SERVER.getCraftingConditions());
        }
        return ingredients;
    }

    /**
     * Recipes with equal group are combined into one button in the recipe book
     */
    public String getGroup()
    {
        return this.group;
    }

    public ResourceLocation getId()
    {
        return this.id;
    }

    public IRecipeSerializer<?> getSerializer()
    {
        return CCTObjectHolder.CCT_SHAPED_RECIPE_SERIALIZER;
    }

    @java.lang.Override public int getRecipeWidth()
    {
        return getWidth();
    }

    public int getWidth()
    {
        return this.recipeWidth;
    }

    @java.lang.Override public int getRecipeHeight()
    {
        return getHeight();
    }

    public int getHeight()
    {
        return this.recipeHeight;
    }

    public static class Serializer extends ForgeRegistryEntry<IRecipeSerializer<?>>
            implements IRecipeSerializer<CCTShapedRecipe>
    {
        private static final String OVERRIDES_KEY = "overrides";

        public Serializer()
        {
            this.setRegistryName(new ResourceLocation(ConcreteConversionTech.MODID, "crafting_shaped_overridable"));
        }

        public CCTShapedRecipe read(ResourceLocation recipeId, JsonObject json)
        {
            String group = JSONUtils.getString(json, "group", "");
            Map<String, Ingredient> key = CCTShapedRecipe.deserializeKey(JSONUtils.getJsonObject(json, "key"));
            String[] pattern =
                    CCTShapedRecipe.shrink(CCTShapedRecipe.patternFromJson(JSONUtils.getJsonArray(json, "pattern")));
            int i = pattern[0].length();
            int j = pattern.length;
            NonNullList<Ingredient> ingredients = CCTShapedRecipe.deserializeIngredients(pattern, key, i, j);
            ItemStack itemstack = CCTShapedRecipe.deserializeItem(JSONUtils.getJsonObject(json, "result"));
            List<Override> overrides = json.has(OVERRIDES_KEY) ?
                    Override.deserializeOverrides(JSONUtils.getJsonArray(json, OVERRIDES_KEY)) :
                    Lists.newArrayList();
            String[] splitPattern = new String[pattern.length * pattern[0].length()];
            int k = 0;
            for (String str : pattern)
            {
                for (int l = 0; l < str.length(); l++)
                {
                    splitPattern[k] = str.substring(l, l + 1);
                    k++;
                }
            }
            return new CCTShapedRecipe(recipeId, group, i, j, ingredients, itemstack, splitPattern, overrides);
        }

        public CCTShapedRecipe read(ResourceLocation recipeId, PacketBuffer buffer)
        {
            int width = buffer.readVarInt();
            int height = buffer.readVarInt();
            String group = buffer.readString(32767);
            NonNullList<Ingredient> ingredients = NonNullList.withSize(width * height, Ingredient.EMPTY);
            String[] pattern = new String[width * height];
            for (int k = 0; k < ingredients.size(); ++k)
            {
                ingredients.set(k, Ingredient.read(buffer));
                pattern[k] = buffer.readString();
            }
            ItemStack result = buffer.readItemStack();
            int overridesSize = buffer.readInt();
            List<Override> overrides = Lists.newArrayListWithCapacity(overridesSize);
            for (int i = 0; i < overridesSize; i++)
            {
                overrides.add(Override.read(buffer));
            }
            return new CCTShapedRecipe(recipeId, group, width, height, ingredients, result, pattern, overrides);
        }

        public void write(PacketBuffer buffer, CCTShapedRecipe recipe)
        {
            buffer.writeVarInt(recipe.recipeWidth);
            buffer.writeVarInt(recipe.recipeHeight);
            buffer.writeString(recipe.group);
            for (int i = 0; i < recipe.recipeItems.size(); i++)
            {
                recipe.recipeItems.get(i).write(buffer);
                buffer.writeString(recipe.pattern[i]);
            }
            buffer.writeItemStack(recipe.recipeOutput);
            buffer.writeInt(recipe.overrides.size());
            for (Override override : recipe.overrides)
            {
                override.write(buffer);
            }
        }
    }

    public static class Override
    {
        String condition;
        Map<String, Ingredient> keyOverrides;

        private Override(String condition, Map<String, Ingredient> keyOverrides)
        {
            this.condition = condition;
            this.keyOverrides = keyOverrides;
        }

        public static List<Override> deserializeOverrides(JsonArray json)
        {
            List<Override> overrides = Lists.newArrayList();
            for (JsonElement jsonObj : json)
            {
                if (!jsonObj.isJsonObject())
                {
                    throw new JsonSyntaxException("Invalid override: expected an object");
                }
                overrides.add(Override.deserializeOverride((JsonObject) jsonObj));
            }
            return overrides;
        }

        public static Override deserializeOverride(JsonObject json)
        {
            String condition = JSONUtils.getString(json, "condition");
            Map<String, Ingredient> keyOverrides =
                    CCTShapedRecipe.deserializeKey(JSONUtils.getJsonObject(json, "key_overrides"));
            return new Override(condition, keyOverrides);
        }

        public static Override read(PacketBuffer buffer)
        {
            String condition = buffer.readString();
            int keyOverridesSize = buffer.readInt();
            Map<String, Ingredient> keyOverrides = Maps.newHashMapWithExpectedSize(keyOverridesSize);
            for (int i = 0; i < keyOverridesSize; i++)
            {
                String key = buffer.readString();
                Ingredient ingredient = Ingredient.read(buffer);
                keyOverrides.put(key, ingredient);
            }
            return new Override(condition, keyOverrides);
        }

        public NonNullList<Ingredient> apply(NonNullList<Ingredient> original, String[] pattern, Set<String> conditions)
        {
            NonNullList<Ingredient> newList = NonNullList.create();
            newList.addAll(original);
            if (conditions.contains(condition))
            {
                for (int i = 0; i < original.size(); i++)
                {
                    if (this.keyOverrides.containsKey(pattern[i]))
                    {
                        newList.set(i, this.keyOverrides.get(pattern[i]));
                    }
                }
            }
            return newList;
        }

        public void write(PacketBuffer buffer)
        {
            buffer.writeString(condition);
            buffer.writeInt(keyOverrides.size());
            for (Entry<String, Ingredient> entry : keyOverrides.entrySet())
            {
                buffer.writeString(entry.getKey());
                entry.getValue().write(buffer);
            }
        }
    }
}
