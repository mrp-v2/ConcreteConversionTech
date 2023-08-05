package mrp_v2.concreteconversiontech.block;

import mrp_v2.concreteconversiontech.tileentity.AbstractConcreteConverterTileEntity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraftforge.items.CapabilityItemHandler;

import javax.annotation.Nullable;
import java.util.function.Supplier;

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

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

    @Override public BlockEntity createTileEntity(BlockState state, BlockGetter world)
    {
        return tileEntitySupplier.get();
    }

    @SuppressWarnings("deprecation") @Override
    public void onRemove(BlockState state, Level worldIn, BlockPos pos, BlockState newState, boolean isMoving)
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
    public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand handIn,
            BlockHitResult hit)
    {
        if (worldIn.isClientSide)
        {
            return InteractionResult.SUCCESS;
        } else
        {
            BlockEntity tileEntity = worldIn.getBlockEntity(pos);
            if (tileEntity instanceof AbstractConcreteConverterTileEntity)
            {
                player.openMenu((MenuProvider) tileEntity);
            }
            return InteractionResult.CONSUME;
        }
    }

    @Override public int getAnalogOutputSignal(BlockState blockState, Level worldIn, BlockPos pos)
    {
        return super.getAnalogOutputSignal(blockState, worldIn, pos);
    }

    @Override public void setPlacedBy(Level worldIn, BlockPos pos, BlockState state, @Nullable LivingEntity placer,
            ItemStack stack)
    {
        super.setPlacedBy(worldIn, pos, state, placer, stack);
        if (stack.hasCustomHoverName())
        {
            BlockEntity tileEntity = worldIn.getBlockEntity(pos);
            if (tileEntity instanceof AbstractConcreteConverterTileEntity)
            {
                ((AbstractConcreteConverterTileEntity) tileEntity).setCustomName(stack.getHoverName());
            }
        }
    }
}
