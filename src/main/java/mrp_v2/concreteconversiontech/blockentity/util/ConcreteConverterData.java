package mrp_v2.concreteconversiontech.blockentity.util;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import mrp_v2.concreteconversiontech.blockentity.AbstractConcreteConverterBlockEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;

import javax.annotation.Nullable;

public class ConcreteConverterData
{
    private static final String NULL_STRING = "null";
    public static final Codec<ConcreteConverterData> CODEC = RecordCodecBuilder.create((builder) -> builder.group(
            Codec.INT.fieldOf("TicksSpentConverting").forGetter(ConcreteConverterData::getTicksSpentConverting),
            Codec.INT.fieldOf("TicksPerConversion").forGetter(ConcreteConverterData::getTicksPerConversion),
            CompoundTag.CODEC.fieldOf("Inventory").forGetter(ConcreteConverterData::getInventoryData),
            Codec.STRING.fieldOf("CustomName").forGetter(ConcreteConverterData::getCustomNameString))
            .apply(builder, ConcreteConverterData::new));
    private final int ticksSpentConverting;
    private final int ticksPerConversion;
    private final CompoundTag inventoryData;
    @Nullable private final Component customName;

    public ConcreteConverterData(AbstractConcreteConverterBlockEntity concreteConverter)
    {
        this(concreteConverter.getTicksSpentConverting(), concreteConverter.getTicksPerItem(),
                concreteConverter.getInventory().parent.serializeNBT(), concreteConverter.getCustomName());
    }

    private ConcreteConverterData(int ticksSpentConverting, int ticksPerConversion, CompoundTag inventoryData,
            @Nullable Component customName)
    {
        this.ticksSpentConverting = ticksSpentConverting;
        this.ticksPerConversion = ticksPerConversion;
        this.inventoryData = inventoryData;
        this.customName = customName;
    }

    private ConcreteConverterData(int ticksSpentConverting, int ticksPerConversion, CompoundTag inventoryData,
            String customName)
    {
        this(ticksSpentConverting, ticksPerConversion, inventoryData, makeITextComponent(customName));
    }

    @Nullable private static Component makeITextComponent(String str)
    {
        return str.equals(NULL_STRING) ? null : Component.Serializer.fromJson(str);
    }

    public int getTicksSpentConverting()
    {
        return this.ticksSpentConverting;
    }

    public Component getCustomName()
    {
        return this.customName;
    }

    public int getTicksPerConversion()
    {
        return this.ticksPerConversion;
    }

    public CompoundTag getInventoryData()
    {
        return this.inventoryData;
    }

    private String getCustomNameString()
    {
        return this.customName == null ? NULL_STRING : Component.Serializer.toJson(this.customName);
    }
}
