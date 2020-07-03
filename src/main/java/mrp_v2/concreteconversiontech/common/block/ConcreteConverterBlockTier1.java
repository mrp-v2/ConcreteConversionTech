package mrp_v2.concreteconversiontech.common.block;

import net.minecraft.block.Blocks;

/**
 * Wooden
 */
public class ConcreteConverterBlockTier1 extends ConcreteConverterBlockBase {

	public static final String ID = ID_STEM + "tier_1";

	public ConcreteConverterBlockTier1() {
		// super(Material.WOOD, MaterialColor.WOOD, ToolType.AXE, 2.0F, 3.0F,
		// SoundType.WOOD, ID);
		super(Blocks.OAK_PLANKS, ID);
	}
}
