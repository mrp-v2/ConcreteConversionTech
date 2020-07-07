package mrp_v2.concreteconversiontech.common.inventory.container;

import mrp_v2.concreteconversiontech.common.inventory.ConcreteConverterItemStackHandler;
import mrp_v2.concreteconversiontech.common.tileentity.ConcreteConverterTier1TileEntity;
import mrp_v2.concreteconversiontech.common.util.CCTConstants;
import mrp_v2.concreteconversiontech.common.util.CCTObjectHolder;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.Slot;

public class ConcreteConverterTier1Container extends AbstractConcreteConverterContainer {

	public static final String ID = ID_STEM_PRE + "tier_1" + ID_STEM_POST;

	public ConcreteConverterTier1Container(int id, PlayerInventory playerInventoryIn) {
		this(id, playerInventoryIn,
				new ConcreteConverterItemStackHandler(ConcreteConverterTier1TileEntity.TOTAL_SLOTS, null));
	}

	public ConcreteConverterTier1Container(int id, PlayerInventory playerInventoryIn,
			ConcreteConverterItemStackHandler inventoryIn) {
		super(CCTObjectHolder.CONCRETE_CONVERTER_TIER_1_CONTAINER_TYPE, id, inventoryIn);
		Container.assertInventorySize(this.inventory, 2);
		this.addSlot(new ConcreteConverterInputSlot(this.inventory, 0, 53, 35));
		this.addSlot(new ConcreteConverterOutputSlot(this.inventory, 1, 107, 35));
		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 9; ++j) {
				this.addSlot(new Slot(playerInventoryIn, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}
		for (int k = 0; k < 9; ++k) {
			this.addSlot(new Slot(playerInventoryIn, k, 8 + k * 18, 142));
		}
	}

	public static ContainerType<ConcreteConverterTier1Container> createContainerType() {
		ContainerType<ConcreteConverterTier1Container> containerType = new ContainerType<ConcreteConverterTier1Container>(
				ConcreteConverterTier1Container::new);
		containerType.setRegistryName(CCTConstants.MODID, ID);
		return containerType;
	}
}
