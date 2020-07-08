package mrp_v2.concreteconversiontech.common.block;

import java.util.function.Supplier;

import mrp_v2.concreteconversiontech.ConcreteConversionTech;
import mrp_v2.concreteconversiontech.common.tileentity.AbstractConcreteConverterTileEntity;
import mrp_v2.concreteconversiontech.common.util.CCTObjectHolder;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.INamedContainerProvider;
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
import net.minecraftforge.items.CapabilityItemHandler;

public class ConcreteConverterBlock extends Block {

	protected static final String ID_STEM_PRE = "concrete_converter_tier_";
	protected static final String ID_STEM_POST = "_block";

	public static final ItemGroup CONCRETE_CONVERSION_TECH_ITEM_GROUP = new ItemGroup(
			ConcreteConversionTech.MODID + ".main_item_group") {
		@OnlyIn(Dist.CLIENT)
		public ItemStack createIcon() {
			return new ItemStack(CCTObjectHolder.CONCRETE_CONVERTER_TIER_1_BLOCK);
		}
	};

	private final Supplier<AbstractConcreteConverterTileEntity> tileEntitySupplier;

	public ConcreteConverterBlock(Block base, int tier,
			Supplier<AbstractConcreteConverterTileEntity> tileEntitySupplier) {
		super(Properties.from(base));
		this.setRegistryName(ConcreteConversionTech.MODID, ID_STEM_PRE + tier + ID_STEM_POST);
		this.tileEntitySupplier = tileEntitySupplier;
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
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return tileEntitySupplier.get();
	}

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
				player.openContainer((INamedContainerProvider) tileEntity);
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
