package mrp_v2.concreteconversiontech.blockentity;

import mrp_v2.concreteconversiontech.inventory.container.ConcreteConverterTier4Container;
import mrp_v2.concreteconversiontech.util.ObjectHolder;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class ConcreteConverterTier4BlockEntity extends AbstractConcreteConverterBlockEntity {
    public static final String ID = ID_STEM_PRE + "tier_4";
    public static final int IO_SLOTS = 6;
    public static final int TOTAL_SLOTS = IO_SLOTS * 2;

    public ConcreteConverterTier4BlockEntity(BlockPos pos, BlockState state) {
        super(ObjectHolder.CONCRETE_CONVERTER_TIER_4_BLOCK_ENTITY_TYPE.get(), IO_SLOTS, ID, pos, state);
    }

    public static BlockEntityType<ConcreteConverterTier4BlockEntity> createTileEntityType() {
        return BlockEntityType.Builder
                .of(ConcreteConverterTier4BlockEntity::new, ObjectHolder.CONCRETE_CONVERTER_TIER_4_BLOCK.get())
                .build(null);
    }

    @Override
    public AbstractContainerMenu createMenu(int id, Inventory playerInventoryIn, Player playerIn) {
        return new ConcreteConverterTier4Container(id, playerInventoryIn, this.inventory.parent);
    }
}
