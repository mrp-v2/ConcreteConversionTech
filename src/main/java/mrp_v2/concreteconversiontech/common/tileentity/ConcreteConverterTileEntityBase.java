package mrp_v2.concreteconversiontech.common.tileentity;

import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

abstract public class ConcreteConverterTileEntityBase extends TileEntity implements ITickableTileEntity {

	protected static final String ID_STEM = "concrete_converter_tile_entity_";

	private final int ticksPerItem;

	private int tickProgress = 0;

	public ConcreteConverterTileEntityBase(TileEntityType<?> tileEntityTypeIn, int ticksPerItem) {
		super(tileEntityTypeIn);
		this.ticksPerItem = ticksPerItem;
	}

	private void convertItem() {

	}

	@Override
	public void func_230337_a_(BlockState p_230337_1_, CompoundNBT p_230337_2_) {
		// TODO read data from NBT
		super.func_230337_a_(p_230337_1_, p_230337_2_);
	}

	@SuppressWarnings("unused")
	@Override
	public void tick() {
		if (true) { // TODO has items
			if (ticksPerItem <= 0) {
				convertItem(); // TODO convert all
				return;
			}
			tickProgress++;
			if (tickProgress >= ticksPerItem) {
				while (tickProgress >= ticksPerItem) {
					convertItem();
					tickProgress -= ticksPerItem;
				}
			} else {
				this.markDirty();
			}
		} else if (tickProgress > 0) {
			tickProgress = 0;
			this.markDirty();
		}
	}

	@Override
	public CompoundNBT write(CompoundNBT compound) {
		// TODO save data to NBT
		return super.write(compound);
	}
}
