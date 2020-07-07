package mrp_v2.concreteconversiontech.common.inventory.container;

import mrp_v2.concreteconversiontech.common.inventory.ConcreteConverterItemStackHandler;
import mrp_v2.concreteconversiontech.common.util.CCTObjectHolder;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;

public class ConcreteConverterTier1Container extends Container {

	public static String ID = "concrete_converter_tier_1_container";

	private final ConcreteConverterItemStackHandler inventory;

	public ConcreteConverterTier1Container(int id, PlayerInventory playerInventoryIn) {
		this(id, playerInventoryIn, new ConcreteConverterItemStackHandler(2, null));
	}

	public ConcreteConverterTier1Container(int id, PlayerInventory playerInventoryIn,
			ConcreteConverterItemStackHandler inventoryIn) {
		super(CCTObjectHolder.CONCRETE_CONVERTER_TIER_1_CONTAINER_TYPE, id);
		Container.assertInventorySize(inventoryIn, 2);
		this.inventory = inventoryIn;
		this.addSlot(new ConcreteConverterInputSlot(inventoryIn, 0, 56, 35));
		this.addSlot(new ConcreteConverterOutputSlot(inventoryIn, 1, 116, 35));

		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 9; ++j) {
				this.addSlot(new Slot(playerInventoryIn, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}
		for (int k = 0; k < 9; ++k) {
			this.addSlot(new Slot(playerInventoryIn, k, 8 + k * 18, 142));
		}
	}

	@Override
	public boolean canInteractWith(PlayerEntity playerIn) {
		return this.inventory.isUsableByPlayer(playerIn);
	}

}
