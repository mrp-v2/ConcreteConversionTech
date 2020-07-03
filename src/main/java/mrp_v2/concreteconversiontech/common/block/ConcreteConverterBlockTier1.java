package mrp_v2.concreteconversiontech.common.block;

import mrp_v2.concreteconversiontech.common.tileentity.ConcreteConverterTileEntityTier1;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

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

	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return new ConcreteConverterTileEntityTier1();
	}
}
