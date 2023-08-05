package mrp_v2.concreteconversiontech.tileentity;

import mrp_v2.concreteconversiontech.inventory.container.ConcreteConverterTier8Container;
import mrp_v2.concreteconversiontech.util.ObjectHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class ConcreteConverterTier8TileEntity extends AbstractConcreteConverterTileEntity
{
    public static final String ID = ID_STEM_PRE + "tier_8";
    public static final int IO_SLOTS = 25;
    public static final int TOTAL_SLOTS = IO_SLOTS * 2;

    public static BlockEntityType<ConcreteConverterTier8TileEntity> createTileEntityType()
    {
        return BlockEntityType.Builder
                .of(ConcreteConverterTier8TileEntity::new, ObjectHolder.CONCRETE_CONVERTER_TIER_8_BLOCK.get())
                .build(null);
    }

    public ConcreteConverterTier8TileEntity()
    {
        super(ObjectHolder.CONCRETE_CONVERTER_TIER_8_TILE_ENTITY_TYPE.get(), IO_SLOTS, ID);
    }

    @Override public AbstractContainerMenu createMenu(int id, Inventory playerInventoryIn, Player playerIn)
    {
        return new ConcreteConverterTier8Container(id, playerInventoryIn, this.inventory.parent);
    }
}
