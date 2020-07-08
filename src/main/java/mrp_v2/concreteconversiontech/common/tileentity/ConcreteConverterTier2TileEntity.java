package mrp_v2.concreteconversiontech.common.tileentity;

import mrp_v2.concreteconversiontech.ConcreteConversionTech;
import mrp_v2.concreteconversiontech.common.inventory.container.ConcreteConverterTier2Container;
import mrp_v2.concreteconversiontech.common.util.CCTObjectHolder;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.tileentity.TileEntityType;

public class ConcreteConverterTier2TileEntity extends AbstractConcreteConverterTileEntity {

	public static final String ID = ID_STEM_PRE + "tier_2" + ID_STEM_POST;

	public static final int IO_SLOTS = 2;
	public static final int TOTAL_SLOTS = IO_SLOTS * 2;

	public ConcreteConverterTier2TileEntity() {
		super(CCTObjectHolder.CONCRETE_CONVERTER_TIER_2_TILE_ENTITY_TYPE, IO_SLOTS, ID);
	}

	@Override
	public Container createMenu(int id, PlayerInventory playerInventoryIn, PlayerEntity playerIn) {
		return new ConcreteConverterTier2Container(id, playerInventoryIn, this.inventory);
	}

	public static TileEntityType<ConcreteConverterTier2TileEntity> createTileEntityType() {
		TileEntityType<ConcreteConverterTier2TileEntity> tileEntityType = TileEntityType.Builder
				.create(ConcreteConverterTier2TileEntity::new, CCTObjectHolder.CONCRETE_CONVERTER_TIER_2_BLOCK)
				.build(null);
		tileEntityType.setRegistryName(ConcreteConversionTech.MODID, ID);
		return tileEntityType;
	}
}
