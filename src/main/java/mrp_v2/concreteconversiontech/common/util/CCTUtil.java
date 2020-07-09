package mrp_v2.concreteconversiontech.common.util;

import mrp_v2.concreteconversiontech.ConcreteConversionTech;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TranslationTextComponent;

public class CCTUtil {

	public static TranslationTextComponent makeTranslation(String id) {
		return new TranslationTextComponent(ConcreteConversionTech.MODID + "." + id);
	}

	public static TranslationTextComponent makeTranslation(String... idParts) {
		return makeTranslation(String.join(".", idParts));
	}

	public static ResourceLocation createLocation(String id) {
		return new ResourceLocation(ConcreteConversionTech.MODID, id);
	}
}
