package mrp_v2.concreteconversiontech.util;

import mrp_v2.concreteconversiontech.ConcreteConversionTech;
import net.minecraft.util.text.TranslationTextComponent;

public class Util
{

	public static TranslationTextComponent makeTranslation(String id) {
		return new TranslationTextComponent(ConcreteConversionTech.MODID + "." + id);
	}

	public static TranslationTextComponent makeTranslation(String... idParts) {
		return makeTranslation(String.join(".", idParts));
	}
}
