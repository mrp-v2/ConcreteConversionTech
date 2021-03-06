package mrp_v2.concreteconversiontech.tileentity;

import mrp_v2.concreteconversiontech.inventory.container.ConcreteConverterTier5Container;
import mrp_v2.concreteconversiontech.util.ObjectHolder;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.tileentity.TileEntityType;

public class ConcreteConverterTier5TileEntity extends AbstractConcreteConverterTileEntity
{
    public static final String ID = ID_STEM_PRE + "tier_5";
    public static final int IO_SLOTS = 9;
    public static final int TOTAL_SLOTS = IO_SLOTS * 2;

    public static TileEntityType<ConcreteConverterTier5TileEntity> createTileEntityType()
    {
        return TileEntityType.Builder.create(ConcreteConverterTier5TileEntity::new,
                ObjectHolder.CONCRETE_CONVERTER_TIER_5_BLOCK.get()).build(null);
    }

    public ConcreteConverterTier5TileEntity()
    {
        super(ObjectHolder.CONCRETE_CONVERTER_TIER_5_TILE_ENTITY_TYPE.get(), IO_SLOTS, ID);
    }

    @Override public Container createMenu(int id, PlayerInventory playerInventoryIn, PlayerEntity playerIn)
    {
        return new ConcreteConverterTier5Container(id, playerInventoryIn, this.inventory.parent);
    }
}
