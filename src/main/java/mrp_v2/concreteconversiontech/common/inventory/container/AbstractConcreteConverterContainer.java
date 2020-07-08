package mrp_v2.concreteconversiontech.common.inventory.container;

import mrp_v2.concreteconversiontech.common.inventory.ConcreteConverterItemStackHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;

public abstract class AbstractConcreteConverterContainer extends Container {

	protected static final String ID_STEM_PRE = "concrete_converter_";
	protected static final String ID_STEM_POST = "_container";

	protected final ConcreteConverterItemStackHandler inventory;

	protected AbstractConcreteConverterContainer(ContainerType<?> type, int id, PlayerInventory playerInventoryIn,
			ConcreteConverterItemStackHandler inventoryIn, int expectedSlots, int ySize, int playerInventoryXOffset,
			int inputSlotsXStart, int outputSlotsXStart, int slotsYStart, int slotsWidth, int slotsHeight) {
		super(type, id);
		Container.assertInventorySize(inventoryIn, expectedSlots);
		this.inventory = inventoryIn;
		addSlots(inputSlotsXStart, outputSlotsXStart, slotsYStart, slotsWidth, slotsHeight, playerInventoryIn,
				playerInventoryXOffset, ySize);
	}

	protected void addSlots(int inputSlotsXStart, int outputSlotsXStart, int slotsYStart, int width, int height,
			PlayerInventory playerInventory, int playerInventoryXOffset, int ySize) {
		// converter input slots
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				this.addSlot(new ConcreteConverterInputSlot(this.inventory, j + i * 2, inputSlotsXStart + j * 18,
						slotsYStart + i * 18));
			}
		}
		// converter outputs slots
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				this.addSlot(new ConcreteConverterOutputSlot(this.inventory, width * height + j + i * 2,
						outputSlotsXStart + j * 18, slotsYStart + i * 18));
			}
		}
		// player inventory slots
		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 9; ++j) {
				this.addSlot(new Slot(playerInventory, j + i * 9 + 9, playerInventoryXOffset + 8 + j * 18,
						ySize - 82 + i * 18));
			}
		}
		for (int i = 0; i < 9; ++i) {
			this.addSlot(new Slot(playerInventory, i, playerInventoryXOffset + 8 + i * 18, ySize - 24));
		}
	}

	@Override
	public boolean canInteractWith(PlayerEntity playerIn) {
		return this.inventory.isUsableByPlayer(playerIn);
	}

	@Override
	public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
		ItemStack itemStack = ItemStack.EMPTY;
		Slot slot = this.inventorySlots.get(index);
		if (slot != null && slot.getHasStack()) {
			ItemStack itemStack1 = slot.getStack();
			itemStack = itemStack1.copy();
			if (index < this.inventory.getSlots()) {
				if (!this.mergeItemStack(itemStack1, this.inventory.getSlots(), this.inventorySlots.size(), true)) {
					return ItemStack.EMPTY;
				}
			} else if (!this.mergeItemStack(itemStack1, 0, this.inventory.getSlots() / 2, false)) {
				return ItemStack.EMPTY;
			}
			if (itemStack1.isEmpty()) {
				slot.putStack(ItemStack.EMPTY);
			} else {
				slot.onSlotChanged();
			}
		}
		return itemStack;
	}
}
