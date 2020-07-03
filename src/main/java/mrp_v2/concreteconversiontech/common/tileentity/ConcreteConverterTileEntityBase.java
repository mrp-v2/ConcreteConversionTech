package mrp_v2.concreteconversiontech.common.tileentity;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

abstract public class ConcreteConverterTileEntityBase extends TileEntity {
	
	protected static final String ID_STEM = "concrete_converter_tile_entity_";

	public ConcreteConverterTileEntityBase(TileEntityType<?> tileEntityTypeIn) {
		super(tileEntityTypeIn);
	}
}
