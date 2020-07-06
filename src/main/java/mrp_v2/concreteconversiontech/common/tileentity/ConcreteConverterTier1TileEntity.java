package mrp_v2.concreteconversiontech.common.tileentity;

import mrp_v2.concreteconversiontech.common.util.CCTObjectHolder;
import mrp_v2.concreteconversiontech.common.util.MessageHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.util.text.ITextComponent;

public class ConcreteConverterTier1TileEntity extends AbstractConcreteConverterTileEntity {

	public static final String ID = ID_STEM + "tier_1";

	public ConcreteConverterTier1TileEntity() {
		super(CCTObjectHolder.CONCRETE_CONVERTER_TIER_1_TILE_ENTITY_TYPE, 1, 16);
	}

	@Override
	public ITextComponent getDisplayName() {
		return MessageHelper.makeTranslation(ID, "displayName");
	}

	@Override
	public Container createMenu(int p_createMenu_1_, PlayerInventory p_createMenu_2_, PlayerEntity p_createMenu_3_) {
		// TODO Auto-generated method stub
		return null;
	}
}
