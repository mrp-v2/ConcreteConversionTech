package mrp_v2.concreteconversiontech.common.tileentity;

import mrp_v2.concreteconversiontech.common.inventory.container.ConcreteConverterTier1Container;
import mrp_v2.concreteconversiontech.common.util.CCTConstants;
import mrp_v2.concreteconversiontech.common.util.CCTObjectHolder;
import mrp_v2.concreteconversiontech.common.util.MessageHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.text.ITextComponent;

public class ConcreteConverterTier1TileEntity extends AbstractConcreteConverterTileEntity {

	public static final String ID = ID_STEM_PRE + "tier_1" + ID_STEM_POST;

	public static final int IO_SLOTS = 1;
	public static final int TOTAL_SLOTS = IO_SLOTS * 2;

	public ConcreteConverterTier1TileEntity() {
		super(CCTObjectHolder.CONCRETE_CONVERTER_TIER_1_TILE_ENTITY_TYPE, IO_SLOTS, 16);
	}

	@Override
	public ITextComponent getDisplayName() {
		return MessageHelper.makeTranslation(ID, "display_name");
	}

	@Override
	public Container createMenu(int id, PlayerInventory playerInventoryIn, PlayerEntity playerIn) {
		return new ConcreteConverterTier1Container(id, playerInventoryIn, this.inventory);
	}

	public static TileEntityType<ConcreteConverterTier1TileEntity> createTileEntityType() {
		TileEntityType<ConcreteConverterTier1TileEntity> tileEntityType = TileEntityType.Builder
				.create(ConcreteConverterTier1TileEntity::new, CCTObjectHolder.CONCRETE_CONVERTER_TIER_1_BLOCK)
				.build(null);
		tileEntityType.setRegistryName(CCTConstants.MODID, ID);
		return tileEntityType;
	}
}
