package mrp_v2.concreteconversiontech.common.block;

import mrp_v2.concreteconversiontech.common.tileentity.AbstractConcreteConverterTileEntity;
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
import net.minecraftforge.items.CapabilityItemHandler;

abstract public class AbstractConcreteConverterBlock extends Block {

	protected static final String ID_STEM_PRE = "concrete_converter_";
	protected static final String ID_STEM_POST = "_block";

	public static final ItemGroup CONCRETE_CONVERSION_TECH_ITEM_GROUP = new ItemGroup(
			CCTConstants.MODID + ".main_item_group") {
		@OnlyIn(Dist.CLIENT)
		public ItemStack createIcon() {
			return new ItemStack(CCTObjectHolder.CONCRETE_CONVERTER_TIER_1_BLOCK);
		}
	};

	public AbstractConcreteConverterBlock(Block base, String id) {
		super(Properties.from(base));
		this.setRegistryName(CCTConstants.MODID, id);
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
			TileEntity tileEntity = worldIn.getTileEntity(pos);
			if (tileEntity instanceof AbstractConcreteConverterTileEntity) {
				// player.openContainer((INamedContainerProvider)tileEntity);
			}
			return ActionResultType.CONSUME;
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
		if (state.hasTileEntity() && (state.getBlock() != newState.getBlock() || !newState.hasTileEntity())) {
			worldIn.getTileEntity(pos).getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
					.ifPresent(itemHandler -> {
						for (int i = 0; i < itemHandler.getSlots(); i++) {
							Block.spawnAsEntity(worldIn, pos, itemHandler.getStackInSlot(i));
						}
					});
		}
		super.onReplaced(state, worldIn, pos, newState, isMoving);
	}
}
