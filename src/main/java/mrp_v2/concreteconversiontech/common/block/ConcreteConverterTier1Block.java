package mrp_v2.concreteconversiontech.common.block;

import mrp_v2.concreteconversiontech.common.tileentity.ConcreteConverterTier1TileEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

/**
 * Wooden
 */
public class ConcreteConverterTier1Block extends AbstractConcreteConverterBlock {

	public static final String ID = ID_STEM + "tier_1";

	public ConcreteConverterTier1Block() {
		// super(Material.WOOD, MaterialColor.WOOD, ToolType.AXE, 2.0F, 3.0F,
		// SoundType.WOOD, ID);
		super(Blocks.OAK_PLANKS, ID);
	}

	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return new ConcreteConverterTier1TileEntity();
	}

	@Override
	protected void interactWith(World worldIn, BlockPos pos, PlayerEntity player) {
		// TODO Auto-generated method stub
		TileEntity tileEntity = worldIn.getTileEntity(pos);
		if (tileEntity instanceof ConcreteConverterTier1TileEntity) {
			player.openContainer((INamedContainerProvider) tileEntity);
		}
	}
}
