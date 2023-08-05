package mrp_v2.concreteconversiontech.datagen;

import mrp_v2.concreteconversiontech.util.ObjectHolder;
import net.minecraft.world.level.block.Block;
import net.minecraft.data.loot.BlockLoot;

import java.util.function.Consumer;

public class LootTables extends mrp_v2.mrplibrary.datagen.BlockLootTables
{
    public LootTables()
    {
        Consumer<Block> dropWithNameFunction =
                (block) -> this.add(block, BlockLoot::createNameableBlockEntityTable);
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
