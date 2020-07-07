package mrp_v2.concreteconversiontech.common.inventory.container;

import mrp_v2.concreteconversiontech.common.inventory.ConcreteConverterItemStackHandler;
import mrp_v2.concreteconversiontech.common.tileentity.ConcreteConverterTier2TileEntity;
import mrp_v2.concreteconversiontech.common.util.CCTConstants;
import mrp_v2.concreteconversiontech.common.util.CCTObjectHolder;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.Slot;

public class ConcreteConverterTier2Container extends AbstractConcreteConverterContainer {

	public static final String ID = ID_STEM_PRE + "tier_2" + ID_STEM_POST;

	public ConcreteConverterTier2Container(int id, PlayerInventory playerInventoryIn) {
		this(id, playerInventoryIn,
				new ConcreteConverterItemStackHandler(ConcreteConverterTier2TileEntity.TOTAL_SLOTS, null));
	}

	public ConcreteConverterTier2Container(int id, PlayerInventory playerInventoryIn,
			ConcreteConverterItemStackHandler inventoryIn) {
		super(CCTObjectHolder.CONCRETE_CONVERTER_TIER_2_CONTAINER_TYPE, id, inventoryIn);
		Container.assertInventorySize(this.inventory, 4);
		this.addSlot(new ConcreteConverterInputSlot(this.inventory, 0, 35, 35));
		this.addSlot(new ConcreteConverterInputSlot(this.inventory, 1, 53, 35));
		this.addSlot(new ConcreteConverterOutputSlot(this.inventory, 2, 107, 35));
		this.addSlot(new ConcreteConverterOutputSlot(this.inventory, 3, 125, 35));
		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 9; ++j) {
				this.addSlot(new Slot(playerInventoryIn, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}
		for (int k = 0; k < 9; ++k) {
			this.addSlot(new Slot(playerInventoryIn, k, 8 + k * 18, 142));
		}
	}

	public static ContainerType<ConcreteConverterTier2Container> createContainerType() {
		ContainerType<ConcreteConverterTier2Container> containerType = new ContainerType<ConcreteConverterTier2Container>(
				ConcreteConverterTier2Container::new);
		containerType.setRegistryName(CCTConstants.MODID, ID);
		return containerType;
	}
}
