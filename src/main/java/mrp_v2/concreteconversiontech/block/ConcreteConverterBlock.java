package mrp_v2.concreteconversiontech.block;

import mrp_v2.concreteconversiontech.blockentity.AbstractConcreteConverterBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.items.CapabilityItemHandler;

import javax.annotation.Nullable;
import java.util.function.BiFunction;
import java.util.function.Supplier;

public class ConcreteConverterBlock extends Block implements EntityBlock {
    protected static final String ID_STEM_PRE = "concrete_converter_tier_";
    public final Block base;
    private final BiFunction<BlockPos, BlockState, AbstractConcreteConverterBlockEntity> blockEntitySupplier;
    private final Supplier<BlockEntityType<? extends AbstractConcreteConverterBlockEntity>> blockEntityTypeSupplier;

    public ConcreteConverterBlock(Block base, BiFunction<BlockPos, BlockState, AbstractConcreteConverterBlockEntity> blockEntitySupplier, Supplier<BlockEntityType<? extends AbstractConcreteConverterBlockEntity>> blockEntityTypeSupplier) {
        super(Properties.copy(base));
        this.base = base;
        this.blockEntitySupplier = blockEntitySupplier;
        this.blockEntityTypeSupplier = blockEntityTypeSupplier;
    }

    @Nullable
    private static <E extends BlockEntity, A extends BlockEntity> BlockEntityTicker<A> createTicker(BlockEntityType<A> a, BlockEntityType<E> b, BlockEntityTicker<? super E> ticker) {
        return b == a ? (BlockEntityTicker<A>) ticker : null;
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onRemove(BlockState state, Level worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
        if (state.hasBlockEntity() && (state.getBlock() != newState.getBlock() || !newState.hasBlockEntity())) {
            worldIn.getBlockEntity(pos).getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
                    .ifPresent(itemHandler ->
                    {
                        for (int i = 0; i < itemHandler.getSlots(); i++) {
                            Block.popResource(worldIn, pos, itemHandler.getStackInSlot(i));
                        }
                    });
        }
        super.onRemove(state, worldIn, pos, newState, isMoving);
    }

    @Override
    public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand handIn,
                                 BlockHitResult hit) {
        if (worldIn.isClientSide) {
            return InteractionResult.SUCCESS;
        } else {
            BlockEntity tileEntity = worldIn.getBlockEntity(pos);
            if (tileEntity instanceof AbstractConcreteConverterBlockEntity) {
                player.openMenu((MenuProvider) tileEntity);
            }
            return InteractionResult.CONSUME;
        }
    }

    @Override
    public int getAnalogOutputSignal(BlockState blockState, Level worldIn, BlockPos pos) {
        return super.getAnalogOutputSignal(blockState, worldIn, pos);
    }

    @Override
    public void setPlacedBy(Level worldIn, BlockPos pos, BlockState state, @Nullable LivingEntity placer,
                            ItemStack stack) {
        super.setPlacedBy(worldIn, pos, state, placer, stack);
        if (stack.hasCustomHoverName()) {
            BlockEntity tileEntity = worldIn.getBlockEntity(pos);
            if (tileEntity instanceof AbstractConcreteConverterBlockEntity) {
                ((AbstractConcreteConverterBlockEntity) tileEntity).setCustomName(stack.getHoverName());
            }
        }
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return blockEntitySupplier.apply(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
        return createTicker(blockEntityType, blockEntityTypeSupplier.get(), AbstractConcreteConverterBlockEntity::tick);
    }
}
