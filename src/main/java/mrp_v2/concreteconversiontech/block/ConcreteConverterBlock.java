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
        super(Properties.copy(base));
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
    public void onRemove(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving)
    {
        if (state.hasTileEntity() && (state.getBlock() != newState.getBlock() || !newState.hasTileEntity()))
        {
            worldIn.getBlockEntity(pos).getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
                    .ifPresent(itemHandler ->
                    {
                        for (int i = 0; i < itemHandler.getSlots(); i++)
                        {
                            Block.popResource(worldIn, pos, itemHandler.getStackInSlot(i));
                        }
                    });
        }
        super.onRemove(state, worldIn, pos, newState, isMoving);
    }

    @Override
    public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn,
            BlockRayTraceResult hit)
    {
        if (worldIn.isClientSide)
        {
            return ActionResultType.SUCCESS;
        } else
        {
            TileEntity tileEntity = worldIn.getBlockEntity(pos);
            if (tileEntity instanceof AbstractConcreteConverterTileEntity)
            {
                player.openMenu((INamedContainerProvider) tileEntity);
            }
            return ActionResultType.CONSUME;
        }
    }

    @Override public int getAnalogOutputSignal(BlockState blockState, World worldIn, BlockPos pos)
    {
        return super.getAnalogOutputSignal(blockState, worldIn, pos);
    }

    @Override public void setPlacedBy(World worldIn, BlockPos pos, BlockState state, @Nullable LivingEntity placer,
            ItemStack stack)
    {
        super.setPlacedBy(worldIn, pos, state, placer, stack);
        if (stack.hasCustomHoverName())
        {
            TileEntity tileEntity = worldIn.getBlockEntity(pos);
            if (tileEntity instanceof AbstractConcreteConverterTileEntity)
            {
                ((AbstractConcreteConverterTileEntity) tileEntity).setCustomName(stack.getHoverName());
            }
        }
    }
}
