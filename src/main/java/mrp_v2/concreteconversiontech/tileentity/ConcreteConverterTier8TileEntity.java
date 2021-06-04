package mrp_v2.concreteconversiontech.tileentity;

import mrp_v2.concreteconversiontech.inventory.container.ConcreteConverterTier8Container;
import mrp_v2.concreteconversiontech.util.ObjectHolder;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.tileentity.TileEntityType;

public class ConcreteConverterTier8TileEntity extends AbstractConcreteConverterTileEntity
{
    public static final String ID = ID_STEM_PRE + "tier_8";
    public static final int IO_SLOTS = 25;
    public static final int TOTAL_SLOTS = IO_SLOTS * 2;

    public static TileEntityType<ConcreteConverterTier8TileEntity> createTileEntityType()
    {
        return TileEntityType.Builder
                .of(ConcreteConverterTier8TileEntity::new, ObjectHolder.CONCRETE_CONVERTER_TIER_8_BLOCK.get())
                .build(null);
    }

    public ConcreteConverterTier8TileEntity()
    {
        super(ObjectHolder.CONCRETE_CONVERTER_TIER_8_TILE_ENTITY_TYPE.get(), IO_SLOTS, ID);
    }

    @Override public Container createMenu(int id, PlayerInventory playerInventoryIn, PlayerEntity playerIn)
    {
        return new ConcreteConverterTier8Container(id, playerInventoryIn, this.inventory.parent);
    }
}
