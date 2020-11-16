package mrp_v2.concreteconversiontech.block;

import mrp_v2.concreteconversiontech.tileentity.AbstractConcreteConverterTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;

import javax.annotation.Nullable;
import java.util.function.Supplier;

public class ConcreteConverterBlock extends Block
{
    protected static final String ID_STEM_PRE = "concrete_converter_tier_";
    public final Block base;
    private final Supplier<AbstractConcreteConverterTileEntity> tileEntitySupplier;

    public ConcreteConverterBlock(Block base, Supplier<AbstractConcreteConverterTileEntity> tileEntitySupplier)
    {
        super(Properties.from(base));
        this.base = base;
        this.tileEntitySupplier = tileEntitySupplier;
    }

    @Override public boolean hasTileEntity(BlockState state)
    {
        return true;
    }

    @Override public TileEntity createTileEntity(BlockState state, IBlockReader world)
    {
        return tileEntitySupplier.get();
    }

    @SuppressWarnings("deprecation") @Override
    public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving)
    {
        if (state.hasTileEntity() && (state.getBlock() != newState.getBlock() || !newState.hasTileEntity()))
        {
            worldIn.getTileEntity(pos)
                    .getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
                    .ifPresent(itemHandler ->
                    {
                        for (int i = 0; i < itemHandler.getSlots(); i++)
                        {
                            Block.spawnAsEntity(worldIn, pos, itemHandler.getStackInSlot(i));
                        }
                    });
        }
        super.onReplaced(state, worldIn, pos, newState, isMoving);
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player,
            Hand handIn, BlockRayTraceResult hit)
    {
        if (worldIn.isRemote)
        {
            return ActionResultType.SUCCESS;
        } else
        {
            TileEntity tileEntity = worldIn.getTileEntity(pos);
            if (tileEntity instanceof AbstractConcreteConverterTileEntity)
            {
                player.openContainer((INamedContainerProvider) tileEntity);
            }
            return ActionResultType.CONSUME;
        }
    }

    @Override public int getComparatorInputOverride(BlockState blockState, World worldIn, BlockPos pos)
    {
        return super.getComparatorInputOverride(blockState, worldIn, pos);
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, @Nullable LivingEntity placer,
            ItemStack stack)
    {
        super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
        if (stack.hasDisplayName())
        {
            TileEntity tileEntity = worldIn.getTileEntity(pos);
            if (tileEntity instanceof AbstractConcreteConverterTileEntity)
            {
                ((AbstractConcreteConverterTileEntity) tileEntity).setCustomName(stack.getDisplayName());
            }
        }
    }
}
