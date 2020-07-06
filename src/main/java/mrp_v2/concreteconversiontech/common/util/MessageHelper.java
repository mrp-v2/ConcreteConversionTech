package mrp_v2.concreteconversiontech.common.util;

import net.minecraft.util.text.TranslationTextComponent;

public class MessageHelper {

	public static TranslationTextComponent makeTranslation(String id) {
		return new TranslationTextComponent(CCTConstants.MODID + "." + id);
	}

	public static TranslationTextComponent makeTranslation(String... idParts) {
		return makeTranslation(String.join(".", idParts));
	}
}
