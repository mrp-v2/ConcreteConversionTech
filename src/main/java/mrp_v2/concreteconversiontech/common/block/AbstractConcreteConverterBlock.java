package mrp_v2.concreteconversiontech.common.block;

import mrp_v2.concreteconversiontech.common.util.CCTConstants;
import mrp_v2.concreteconversiontech.common.util.CCTObjectHolder;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolType;

abstract public class AbstractConcreteConverterBlock extends Block {

	protected static final String ID_STEM = "concrete_converter_block_";

	public static final ItemGroup CONCRETE_CONVERSION_TECH_ITEM_GROUP = new ItemGroup(2, "concreteConversionTech") {
		@OnlyIn(Dist.CLIENT)
		public ItemStack createIcon() {
			return new ItemStack(CCTObjectHolder.CONCRETE_CONVERTER_TIER_1_BLOCK);
		}
	};

	public AbstractConcreteConverterBlock(Block base, String blockID) {
		super(Properties.from(base));
		this.setRegistryName(CCTConstants.MODID, blockID);
	}

	public AbstractConcreteConverterBlock(Material material, MaterialColor color, ToolType harvestTool,
			int harvestLevel, float hardness, float resistance, SoundType sound, String blockID) {
		super(Properties.create(material, color).harvestTool(harvestTool).harvestLevel(harvestLevel)
				.hardnessAndResistance(hardness, resistance).sound(sound));
		this.setRegistryName(CCTConstants.MODID, blockID);
	}

	public BlockItem createBlockItem() {
		BlockState defaultState = this.getDefaultState();
		BlockItem bi = new BlockItem(this,
				new Item.Properties().addToolType(this.getHarvestTool(defaultState), this.getHarvestLevel(defaultState))
						.group(CONCRETE_CONVERSION_TECH_ITEM_GROUP));
		bi.setRegistryName(this.getRegistryName());
		return bi;
	}

	@Override
	abstract public TileEntity createTileEntity(BlockState state, IBlockReader world);

	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}

	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player,
			Hand handIn, BlockRayTraceResult hit) {
		if (worldIn.isRemote) {
			return ActionResultType.SUCCESS;
		} else {
			this.interactWith(worldIn, pos, player);
			return ActionResultType.CONSUME;
		}
	}

	abstract protected void interactWith(World worldIn, BlockPos pos, PlayerEntity player);
}
