package mrp_v2.concreteconversiontech.blockentity;

import mrp_v2.concreteconversiontech.inventory.container.ConcreteConverterTier2Container;
import mrp_v2.concreteconversiontech.util.ObjectHolder;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class ConcreteConverterTier2BlockEntity extends AbstractConcreteConverterBlockEntity {
    public static final String ID = ID_STEM_PRE + "tier_2";
    public static final int IO_SLOTS = 2;
    public static final int TOTAL_SLOTS = IO_SLOTS * 2;

    public ConcreteConverterTier2BlockEntity(BlockPos pos, BlockState state) {
        super(ObjectHolder.CONCRETE_CONVERTER_TIER_2_BLOCK_ENTITY_TYPE.get(), IO_SLOTS, ID, pos, state);
    }

    public static BlockEntityType<ConcreteConverterTier2BlockEntity> createTileEntityType() {
        return BlockEntityType.Builder
                .of(ConcreteConverterTier2BlockEntity::new, ObjectHolder.CONCRETE_CONVERTER_TIER_2_BLOCK.get())
                .build(null);
    }

    @Override
    public AbstractContainerMenu createMenu(int id, Inventory playerInventoryIn, Player playerIn) {
        return new ConcreteConverterTier2Container(id, playerInventoryIn, this.inventory.parent);
    }
}
