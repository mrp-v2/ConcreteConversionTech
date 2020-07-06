package mrp_v2.concreteconversiontech.common.block;

import mrp_v2.concreteconversiontech.common.tileentity.ConcreteConverterTier1TileEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

public class ConcreteConverterTier1Block extends AbstractConcreteConverterBlock {

	public static final String ID = ID_STEM_PRE + "tier_1" + ID_STEM_POST;

	public ConcreteConverterTier1Block() {
		super(Blocks.OAK_PLANKS, ID);
	}

	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return new ConcreteConverterTier1TileEntity();
	}
}
