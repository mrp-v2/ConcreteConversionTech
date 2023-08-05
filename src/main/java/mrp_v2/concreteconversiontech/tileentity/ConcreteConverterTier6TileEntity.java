package mrp_v2.concreteconversiontech.tileentity;

import mrp_v2.concreteconversiontech.inventory.container.ConcreteConverterTier6Container;
import mrp_v2.concreteconversiontech.util.ObjectHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class ConcreteConverterTier6TileEntity extends AbstractConcreteConverterTileEntity
{
    public static final String ID = ID_STEM_PRE + "tier_6";
    public static final int IO_SLOTS = 15;
    public static final int TOTAL_SLOTS = IO_SLOTS * 2;

    public static BlockEntityType<ConcreteConverterTier6TileEntity> createTileEntityType()
    {
        return BlockEntityType.Builder
                .of(ConcreteConverterTier6TileEntity::new, ObjectHolder.CONCRETE_CONVERTER_TIER_6_BLOCK.get())
                .build(null);
    }

    public ConcreteConverterTier6TileEntity()
    {
        super(ObjectHolder.CONCRETE_CONVERTER_TIER_6_TILE_ENTITY_TYPE.get(), IO_SLOTS, ID);
    }

    @Override public AbstractContainerMenu createMenu(int id, Inventory playerInventoryIn, Player playerIn)
    {
        return new ConcreteConverterTier6Container(id, playerInventoryIn, this.inventory.parent);
    }
}
