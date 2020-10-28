package mrp_v2.concreteconversiontech.datagen;

import mrp_v2.concreteconversiontech.ConcreteConversionTech;
import mrp_v2.concreteconversiontech.block.ConcreteConverterBlock;
import mrp_v2.concreteconversiontech.util.ObjectHolder;
import mrp_v2.mrp_v2datagenlibrary.datagen.TranslationGenerator;
import net.minecraft.data.DataGenerator;

public class EN_USTranslationGenerator extends TranslationGenerator
{
    public EN_USTranslationGenerator(DataGenerator gen, String modid)
    {
        super(gen, modid, "en_us");
    }

    @Override protected void addTranslations()
    {
        String cc = " Concrete Converter";
        String wcc = "Wooden" + cc, scc = "Stone" + cc, icc = "Iron" + cc, gcc = "Gold" + cc, dcc = "Diamond" + cc,
                ecc = "Emerald" + cc, qcc = "Quartz" + cc, ncc = "Netherite" + cc;
        this.add(ObjectHolder.CONCRETE_CONVERTER_TIER_1_BLOCK, wcc);
        this.add(ObjectHolder.CONCRETE_CONVERTER_TIER_2_BLOCK, scc);
        this.add(ObjectHolder.CONCRETE_CONVERTER_TIER_3_BLOCK, icc);
        this.add(ObjectHolder.CONCRETE_CONVERTER_TIER_4_BLOCK, gcc);
        this.add(ObjectHolder.CONCRETE_CONVERTER_TIER_5_BLOCK, dcc);
        this.add(ObjectHolder.CONCRETE_CONVERTER_TIER_6_BLOCK, ecc);
        this.add(ObjectHolder.CONCRETE_CONVERTER_TIER_7_BLOCK, qcc);
        this.add(ObjectHolder.CONCRETE_CONVERTER_TIER_8_BLOCK, ncc);
        this.add(ConcreteConverterBlock.CONCRETE_CONVERSION_TECH_ITEM_GROUP, ConcreteConversionTech.DISPLAY_NAME);
    }
}
