package mrp_v2.concreteconversiontech.datagen;

import mrp_v2.concreteconversiontech.util.ObjectHolder;
import mrp_v2.mrplibrary.datagen.providers.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;

public class BlockTagsGenerator extends BlockTagsProvider {
    public BlockTagsGenerator(DataGenerator generatorIn, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(generatorIn, modId, existingFileHelper);
    }

    @Override
    protected void addTags() {
        tag(BlockTags.MINEABLE_WITH_AXE).add(ObjectHolder.CONCRETE_CONVERTER_TIER_1_BLOCK.get());
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(ObjectHolder.CONCRETE_CONVERTER_TIER_2_BLOCK.get())
                .add(ObjectHolder.CONCRETE_CONVERTER_TIER_3_BLOCK.get())
                .add(ObjectHolder.CONCRETE_CONVERTER_TIER_4_BLOCK.get())
                .add(ObjectHolder.CONCRETE_CONVERTER_TIER_5_BLOCK.get())
                .add(ObjectHolder.CONCRETE_CONVERTER_TIER_6_BLOCK.get())
                .add(ObjectHolder.CONCRETE_CONVERTER_TIER_7_BLOCK.get())
                .add(ObjectHolder.CONCRETE_CONVERTER_TIER_8_BLOCK.get());
        tag(BlockTags.NEEDS_STONE_TOOL).add(ObjectHolder.CONCRETE_CONVERTER_TIER_3_BLOCK.get());
        tag(BlockTags.NEEDS_IRON_TOOL).add(ObjectHolder.CONCRETE_CONVERTER_TIER_4_BLOCK.get())
                .add(ObjectHolder.CONCRETE_CONVERTER_TIER_5_BLOCK.get())
                .add(ObjectHolder.CONCRETE_CONVERTER_TIER_6_BLOCK.get());
        tag(BlockTags.NEEDS_DIAMOND_TOOL).add(ObjectHolder.CONCRETE_CONVERTER_TIER_8_BLOCK.get());
    }
}
