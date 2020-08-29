package mrp_v2.concreteconversiontech.tileentity;

import mrp_v2.concreteconversiontech.ConcreteConversionTech;
import mrp_v2.concreteconversiontech.inventory.container.ConcreteConverterTier4Container;
import mrp_v2.concreteconversiontech.util.ObjectHolder;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.tileentity.TileEntityType;

public class ConcreteConverterTier4TileEntity extends AbstractConcreteConverterTileEntity {

	public static final String ID = ID_STEM_PRE + "tier_4" + ID_STEM_POST;

	public static final int IO_SLOTS = 6;
	public static final int TOTAL_SLOTS = IO_SLOTS * 2;

	public ConcreteConverterTier4TileEntity() {
		super(ObjectHolder.CONCRETE_CONVERTER_TIER_4_TILE_ENTITY_TYPE, IO_SLOTS, ID);
	}

	@Override
	public Container createMenu(int id, PlayerInventory playerInventoryIn, PlayerEntity playerIn) {
		return new ConcreteConverterTier4Container(id, playerInventoryIn, this.inventory);
	}

	public static TileEntityType<ConcreteConverterTier4TileEntity> createTileEntityType() {
		TileEntityType<ConcreteConverterTier4TileEntity> tileEntityType = TileEntityType.Builder
				.create(ConcreteConverterTier4TileEntity::new, ObjectHolder.CONCRETE_CONVERTER_TIER_4_BLOCK)
				.build(null);
		tileEntityType.setRegistryName(ConcreteConversionTech.ID, ID);
		return tileEntityType;
	}
}
