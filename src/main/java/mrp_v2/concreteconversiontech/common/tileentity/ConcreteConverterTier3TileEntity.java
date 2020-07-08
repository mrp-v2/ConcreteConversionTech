package mrp_v2.concreteconversiontech.common.tileentity;

import mrp_v2.concreteconversiontech.ConcreteConversionTech;
import mrp_v2.concreteconversiontech.common.inventory.container.ConcreteConverterTier3Container;
import mrp_v2.concreteconversiontech.common.util.CCTObjectHolder;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.tileentity.TileEntityType;

public class ConcreteConverterTier3TileEntity extends AbstractConcreteConverterTileEntity {

	public static final String ID = ID_STEM_PRE + "tier_3" + ID_STEM_POST;

	public static final int IO_SLOTS = 4;
	public static final int TOTAL_SLOTS = IO_SLOTS * 2;

	public ConcreteConverterTier3TileEntity() {
		super(CCTObjectHolder.CONCRETE_CONVERTER_TIER_3_TILE_ENTITY_TYPE, IO_SLOTS, ID);
	}

	@Override
	public Container createMenu(int id, PlayerInventory playerInventoryIn, PlayerEntity playerIn) {
		return new ConcreteConverterTier3Container(id, playerInventoryIn, this.inventory);
	}

	public static TileEntityType<ConcreteConverterTier3TileEntity> createTileEntityType() {
		TileEntityType<ConcreteConverterTier3TileEntity> tileEntityType = TileEntityType.Builder
				.create(ConcreteConverterTier3TileEntity::new, CCTObjectHolder.CONCRETE_CONVERTER_TIER_3_BLOCK)
				.build(null);
		tileEntityType.setRegistryName(ConcreteConversionTech.MODID, ID);
		return tileEntityType;
	}
}
