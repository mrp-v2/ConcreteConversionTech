package mrp_v2.concreteconversiontech.datagen;

import mrp_v2.concreteconversiontech.block.ConcreteConverterBlock;
import mrp_v2.concreteconversiontech.util.ObjectHolder;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LootTables extends mrp_v2.mrplibrary.datagen.BlockLootTables
{
    private final List<RegistryObject<ConcreteConverterBlock>> knownBlocks;

    public LootTables()
    {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
        knownBlocks = List.of(ObjectHolder.CONCRETE_CONVERTER_TIER_1_BLOCK,
                ObjectHolder.CONCRETE_CONVERTER_TIER_2_BLOCK,
                ObjectHolder.CONCRETE_CONVERTER_TIER_3_BLOCK,
                ObjectHolder.CONCRETE_CONVERTER_TIER_4_BLOCK,
                ObjectHolder.CONCRETE_CONVERTER_TIER_5_BLOCK,
                ObjectHolder.CONCRETE_CONVERTER_TIER_6_BLOCK,
                ObjectHolder.CONCRETE_CONVERTER_TIER_7_BLOCK,
                ObjectHolder.CONCRETE_CONVERTER_TIER_8_BLOCK);
    }

    @Override
    protected void generate() {
        add(ObjectHolder.CONCRETE_CONVERTER_TIER_1_BLOCK.get(), this::createNameableBlockEntityTable);
        add(ObjectHolder.CONCRETE_CONVERTER_TIER_2_BLOCK.get(), this::createNameableBlockEntityTable);
        add(ObjectHolder.CONCRETE_CONVERTER_TIER_3_BLOCK.get(), this::createNameableBlockEntityTable);
        add(ObjectHolder.CONCRETE_CONVERTER_TIER_4_BLOCK.get(), this::createNameableBlockEntityTable);
        add(ObjectHolder.CONCRETE_CONVERTER_TIER_5_BLOCK.get(), this::createNameableBlockEntityTable);
        add(ObjectHolder.CONCRETE_CONVERTER_TIER_6_BLOCK.get(), this::createNameableBlockEntityTable);
        add(ObjectHolder.CONCRETE_CONVERTER_TIER_7_BLOCK.get(), this::createNameableBlockEntityTable);
        add(ObjectHolder.CONCRETE_CONVERTER_TIER_8_BLOCK.get(), this::createNameableBlockEntityTable);
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return knownBlocks.stream().map(RegistryObject::get).collect(Collectors.toCollection(ArrayList::new));
    }
}
