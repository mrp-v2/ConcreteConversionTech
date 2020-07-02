package mrp_v2.concreteconversiontech.block;

import net.minecraft.block.Blocks;

/**
 * Wooden
 */
public class ConcreteConverterTier1 extends ConcreteConverterBase {

	public static final String ID = ConcreteConverterBase.ID_STEM + "tier_1";

	public ConcreteConverterTier1() {
		// super(Material.WOOD, MaterialColor.WOOD, ToolType.AXE, 2.0F, 3.0F,
		// SoundType.WOOD, ID);
		super(Blocks.OAK_PLANKS, ID);
	}
}
