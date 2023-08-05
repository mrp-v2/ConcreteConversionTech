package mrp_v2.concreteconversiontech.blockentity;

import mrp_v2.concreteconversiontech.inventory.container.ConcreteConverterTier3Container;
import mrp_v2.concreteconversiontech.util.ObjectHolder;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class ConcreteConverterTier3BlockEntity extends AbstractConcreteConverterBlockEntity {
    public static final String ID = ID_STEM_PRE + "tier_3";
    public static final int IO_SLOTS = 4;
    public static final int TOTAL_SLOTS = IO_SLOTS * 2;

    public ConcreteConverterTier3BlockEntity(BlockPos pos, BlockState state) {
        super(ObjectHolder.CONCRETE_CONVERTER_TIER_3_BLOCK_ENTITY_TYPE.get(), IO_SLOTS, ID, pos, state);
    }

    public static BlockEntityType<ConcreteConverterTier3BlockEntity> createTileEntityType() {
        return BlockEntityType.Builder
                .of(ConcreteConverterTier3BlockEntity::new, ObjectHolder.CONCRETE_CONVERTER_TIER_3_BLOCK.get())
                .build(null);
    }

    @Override
    public AbstractContainerMenu createMenu(int id, Inventory playerInventoryIn, Player playerIn) {
        return new ConcreteConverterTier3Container(id, playerInventoryIn, this.inventory.parent);
    }
}
