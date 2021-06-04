package mrp_v2.concreteconversiontech.tileentity.util;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import mrp_v2.concreteconversiontech.tileentity.AbstractConcreteConverterTileEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.text.ITextComponent;

import javax.annotation.Nullable;

public class ConcreteConverterData
{
    private static final String NULL_STRING = "null";
    public static final Codec<ConcreteConverterData> CODEC = RecordCodecBuilder.create((builder) -> builder.group(
            Codec.INT.fieldOf("TicksSpentConverting").forGetter(ConcreteConverterData::getTicksSpentConverting),
            Codec.INT.fieldOf("TicksPerConversion").forGetter(ConcreteConverterData::getTicksPerConversion),
            CompoundNBT.CODEC.fieldOf("Inventory").forGetter(ConcreteConverterData::getInventoryData),
            Codec.STRING.fieldOf("CustomName").forGetter(ConcreteConverterData::getCustomNameString))
            .apply(builder, ConcreteConverterData::new));
    private final int ticksSpentConverting;
    private final int ticksPerConversion;
    private final CompoundNBT inventoryData;
    @Nullable private final ITextComponent customName;

    public ConcreteConverterData(AbstractConcreteConverterTileEntity concreteConverter)
    {
        this(concreteConverter.getTicksSpentConverting(), concreteConverter.getTicksPerItem(),
                concreteConverter.getInventory().parent.serializeNBT(), concreteConverter.getCustomName());
    }

    private ConcreteConverterData(int ticksSpentConverting, int ticksPerConversion, CompoundNBT inventoryData,
            @Nullable ITextComponent customName)
    {
        this.ticksSpentConverting = ticksSpentConverting;
        this.ticksPerConversion = ticksPerConversion;
        this.inventoryData = inventoryData;
        this.customName = customName;
    }

    private ConcreteConverterData(int ticksSpentConverting, int ticksPerConversion, CompoundNBT inventoryData,
            String customName)
    {
        this(ticksSpentConverting, ticksPerConversion, inventoryData, makeITextComponent(customName));
    }

    @Nullable private static ITextComponent makeITextComponent(String str)
    {
        return str.equals(NULL_STRING) ? null : ITextComponent.Serializer.fromJson(str);
    }

    public int getTicksSpentConverting()
    {
        return this.ticksSpentConverting;
    }

    public ITextComponent getCustomName()
    {
        return this.customName;
    }

    public int getTicksPerConversion()
    {
        return this.ticksPerConversion;
    }

    public CompoundNBT getInventoryData()
    {
        return this.inventoryData;
    }

    private String getCustomNameString()
    {
        return this.customName == null ? NULL_STRING : ITextComponent.Serializer.toJson(this.customName);
    }
}
