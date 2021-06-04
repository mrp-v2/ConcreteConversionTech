package mrp_v2.concreteconversiontech.tileentity;

import mrp_v2.concreteconversiontech.inventory.container.ConcreteConverterTier7Container;
import mrp_v2.concreteconversiontech.util.ObjectHolder;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.tileentity.TileEntityType;

public class ConcreteConverterTier7TileEntity extends AbstractConcreteConverterTileEntity
{
    public static final String ID = ID_STEM_PRE + "tier_7";
    public static final int IO_SLOTS = 20;
    public static final int TOTAL_SLOTS = IO_SLOTS * 2;

    public static TileEntityType<ConcreteConverterTier7TileEntity> createTileEntityType()
    {
        return TileEntityType.Builder
                .of(ConcreteConverterTier7TileEntity::new, ObjectHolder.CONCRETE_CONVERTER_TIER_7_BLOCK.get())
                .build(null);
    }

    public ConcreteConverterTier7TileEntity()
    {
        super(ObjectHolder.CONCRETE_CONVERTER_TIER_7_TILE_ENTITY_TYPE.get(), IO_SLOTS, ID);
    }

    @Override public Container createMenu(int id, PlayerInventory playerInventoryIn, PlayerEntity playerIn)
    {
        return new ConcreteConverterTier7Container(id, playerInventoryIn, this.inventory.parent);
    }
}
