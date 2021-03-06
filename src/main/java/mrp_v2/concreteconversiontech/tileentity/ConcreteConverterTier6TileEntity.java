package mrp_v2.concreteconversiontech.tileentity;

import mrp_v2.concreteconversiontech.inventory.container.ConcreteConverterTier6Container;
import mrp_v2.concreteconversiontech.util.ObjectHolder;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.tileentity.TileEntityType;

public class ConcreteConverterTier6TileEntity extends AbstractConcreteConverterTileEntity
{
    public static final String ID = ID_STEM_PRE + "tier_6";
    public static final int IO_SLOTS = 15;
    public static final int TOTAL_SLOTS = IO_SLOTS * 2;

    public static TileEntityType<ConcreteConverterTier6TileEntity> createTileEntityType()
    {
        return TileEntityType.Builder.create(ConcreteConverterTier6TileEntity::new,
                ObjectHolder.CONCRETE_CONVERTER_TIER_6_BLOCK.get()).build(null);
    }

    public ConcreteConverterTier6TileEntity()
    {
        super(ObjectHolder.CONCRETE_CONVERTER_TIER_6_TILE_ENTITY_TYPE.get(), IO_SLOTS, ID);
    }

    @Override public Container createMenu(int id, PlayerInventory playerInventoryIn, PlayerEntity playerIn)
    {
        return new ConcreteConverterTier6Container(id, playerInventoryIn, this.inventory.parent);
    }
}
