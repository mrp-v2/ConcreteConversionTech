package mrp_v2.concreteconversiontech.common.block;

import mrp_v2.concreteconversiontech.common.tileentity.ConcreteConverterTier2TileEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

public class ConcreteConverterTier2Block extends AbstractConcreteConverterBlock {

	public static final String ID = ID_STEM_PRE + "tier_2" + ID_STEM_POST;

	public ConcreteConverterTier2Block() {
		super(Blocks.STONE, ID);
	}

	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return new ConcreteConverterTier2TileEntity();
	}
}
