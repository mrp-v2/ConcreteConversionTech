package mrp_v2.concreteconversiontech.datagen;

import mrp_v2.concreteconversiontech.util.ObjectHolder;
import net.minecraft.block.Block;
import net.minecraft.data.loot.BlockLootTables;

import java.util.function.Consumer;

public class LootTables extends mrp_v2.mrp_v2datagenlibrary.datagen.LootTables
{
    public LootTables()
    {
        Consumer<Block> dropWithNameFunction =
                (block) -> this.registerLootTable(block, BlockLootTables::droppingWithName);
        this.addLootTable(ObjectHolder.CONCRETE_CONVERTER_TIER_1_BLOCK.get(), dropWithNameFunction);
        this.addLootTable(ObjectHolder.CONCRETE_CONVERTER_TIER_2_BLOCK.get(), dropWithNameFunction);
        this.addLootTable(ObjectHolder.CONCRETE_CONVERTER_TIER_3_BLOCK.get(), dropWithNameFunction);
        this.addLootTable(ObjectHolder.CONCRETE_CONVERTER_TIER_4_BLOCK.get(), dropWithNameFunction);
        this.addLootTable(ObjectHolder.CONCRETE_CONVERTER_TIER_5_BLOCK.get(), dropWithNameFunction);
        this.addLootTable(ObjectHolder.CONCRETE_CONVERTER_TIER_6_BLOCK.get(), dropWithNameFunction);
        this.addLootTable(ObjectHolder.CONCRETE_CONVERTER_TIER_7_BLOCK.get(), dropWithNameFunction);
        this.addLootTable(ObjectHolder.CONCRETE_CONVERTER_TIER_8_BLOCK.get(), dropWithNameFunction);
    }
}
