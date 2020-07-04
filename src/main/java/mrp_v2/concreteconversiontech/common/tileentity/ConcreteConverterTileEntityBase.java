package mrp_v2.concreteconversiontech.common.tileentity;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

abstract public class ConcreteConverterTileEntityBase extends TileEntity
		implements ITickableTileEntity, ISidedInventory {

	protected static final String ID_STEM = "concrete_converter_tile_entity_";

	public ConcreteConverterTileEntityBase(TileEntityType<?> tileEntityTypeIn) {
		super(tileEntityTypeIn);
	}

	protected static final Map<Item, Item> POWDER_TO_CONCRETE;
	static {
		HashMap<Item, Item> temp = new HashMap<Item, Item>();
		temp.put(Items.BLACK_CONCRETE_POWDER, Items.BLACK_CONCRETE);
		temp.put(Items.BLUE_CONCRETE_POWDER, Items.BLUE_CONCRETE);
		temp.put(Items.BROWN_CONCRETE_POWDER, Items.BROWN_CONCRETE);
		temp.put(Items.CYAN_CONCRETE_POWDER, Items.CYAN_CONCRETE);
		temp.put(Items.GRAY_CONCRETE_POWDER, Items.GRAY_CONCRETE);
		temp.put(Items.GREEN_CONCRETE_POWDER, Items.GREEN_CONCRETE);
		temp.put(Items.LIGHT_BLUE_CONCRETE_POWDER, Items.LIGHT_BLUE_CONCRETE);
		temp.put(Items.LIGHT_GRAY_CONCRETE_POWDER, Items.LIGHT_GRAY_CONCRETE);
		temp.put(Items.LIME_CONCRETE_POWDER, Items.LIME_CONCRETE);
		temp.put(Items.MAGENTA_CONCRETE_POWDER, Items.MAGENTA_CONCRETE);
		temp.put(Items.ORANGE_CONCRETE_POWDER, Items.ORANGE_CONCRETE);
		temp.put(Items.PINK_CONCRETE_POWDER, Items.PINK_CONCRETE);
		temp.put(Items.PURPLE_CONCRETE_POWDER, Items.PURPLE_CONCRETE);
		temp.put(Items.RED_CONCRETE_POWDER, Items.RED_CONCRETE);
		temp.put(Items.WHITE_CONCRETE_POWDER, Items.WHITE_CONCRETE);
		temp.put(Items.YELLOW_CONCRETE_POWDER, Items.YELLOW_CONCRETE);
		POWDER_TO_CONCRETE = Collections.unmodifiableMap(temp);
	}
}
