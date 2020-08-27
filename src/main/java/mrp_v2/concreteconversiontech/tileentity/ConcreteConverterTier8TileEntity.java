package mrp_v2.concreteconversiontech.tileentity;

import mrp_v2.concreteconversiontech.ConcreteConversionTech;
import mrp_v2.concreteconversiontech.inventory.container.ConcreteConverterTier8Container;
import mrp_v2.concreteconversiontech.util.ObjectHolder;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.tileentity.TileEntityType;

public class ConcreteConverterTier8TileEntity extends AbstractConcreteConverterTileEntity {

	public static final String ID = ID_STEM_PRE + "tier_8" + ID_STEM_POST;

	public static final int IO_SLOTS = 25;
	public static final int TOTAL_SLOTS = IO_SLOTS * 2;

	public ConcreteConverterTier8TileEntity() {
		super(ObjectHolder.CONCRETE_CONVERTER_TIER_8_TILE_ENTITY_TYPE, IO_SLOTS, ID);
	}

	@Override
	public Container createMenu(int id, PlayerInventory playerInventoryIn, PlayerEntity playerIn) {
		return new ConcreteConverterTier8Container(id, playerInventoryIn, this.inventory);
	}

	public static TileEntityType<ConcreteConverterTier8TileEntity> createTileEntityType() {
		TileEntityType<ConcreteConverterTier8TileEntity> tileEntityType = TileEntityType.Builder
				.create(ConcreteConverterTier8TileEntity::new, ObjectHolder.CONCRETE_CONVERTER_TIER_8_BLOCK)
				.build(null);
		tileEntityType.setRegistryName(ConcreteConversionTech.MODID, ID);
		return tileEntityType;
	}
}
