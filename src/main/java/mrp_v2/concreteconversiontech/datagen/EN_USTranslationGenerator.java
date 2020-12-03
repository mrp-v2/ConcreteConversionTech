package mrp_v2.concreteconversiontech.datagen;

import mrp_v2.concreteconversiontech.ConcreteConversionTech;
import mrp_v2.concreteconversiontech.util.ObjectHolder;
import mrp_v2.mrplibrary.datagen.providers.LanguageProvider;
import net.minecraft.data.DataGenerator;

public class EN_USTranslationGenerator extends LanguageProvider
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
        this.add(ObjectHolder.CONCRETE_CONVERTER_TIER_1_BLOCK.get(), wcc);
        this.add(ObjectHolder.CONCRETE_CONVERTER_TIER_2_BLOCK.get(), scc);
        this.add(ObjectHolder.CONCRETE_CONVERTER_TIER_3_BLOCK.get(), icc);
        this.add(ObjectHolder.CONCRETE_CONVERTER_TIER_4_BLOCK.get(), gcc);
        this.add(ObjectHolder.CONCRETE_CONVERTER_TIER_5_BLOCK.get(), dcc);
        this.add(ObjectHolder.CONCRETE_CONVERTER_TIER_6_BLOCK.get(), ecc);
        this.add(ObjectHolder.CONCRETE_CONVERTER_TIER_7_BLOCK.get(), qcc);
        this.add(ObjectHolder.CONCRETE_CONVERTER_TIER_8_BLOCK.get(), ncc);
        this.add(ObjectHolder.CONCRETE_CONVERSION_TECH_ITEM_GROUP, ConcreteConversionTech.DISPLAY_NAME);
    }
}
