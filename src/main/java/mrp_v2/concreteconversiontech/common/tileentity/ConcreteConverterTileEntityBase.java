package mrp_v2.concreteconversiontech.common.tileentity;

import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

abstract public class ConcreteConverterTileEntityBase extends TileEntity {

	protected static final String ID_STEM = "concrete_converter_tile_entity_";

	public ConcreteConverterTileEntityBase(TileEntityType<?> tileEntityTypeIn) {
		super(tileEntityTypeIn);
	}

	@Override
	public void func_230337_a_(BlockState p_230337_1_, CompoundNBT p_230337_2_) {
		// TODO Auto-generated method stub
		super.func_230337_a_(p_230337_1_, p_230337_2_);
	}

	@Override
	public CompoundNBT write(CompoundNBT compound) {
		// TODO Auto-generated method stub
		return super.write(compound);
	}
}
