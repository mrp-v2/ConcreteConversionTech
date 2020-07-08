package mrp_v2.concreteconversiontech.common.inventory.container;

import mrp_v2.concreteconversiontech.ConcreteConversionTech;
import mrp_v2.concreteconversiontech.client.gui.screen.inventory.ConcreteConverterTier3Screen;
import mrp_v2.concreteconversiontech.common.inventory.ConcreteConverterItemStackHandler;
import mrp_v2.concreteconversiontech.common.tileentity.ConcreteConverterTier3TileEntity;
import mrp_v2.concreteconversiontech.common.util.CCTObjectHolder;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.ContainerType;

public class ConcreteConverterTier3Container extends AbstractConcreteConverterContainer {

	public static final String ID = ID_STEM_PRE + "tier_3" + ID_STEM_POST;

	public static ContainerType<ConcreteConverterTier3Container> createContainerType() {
		ContainerType<ConcreteConverterTier3Container> containerType = new ContainerType<ConcreteConverterTier3Container>(
				ConcreteConverterTier3Container::new);
		containerType.setRegistryName(ConcreteConversionTech.MODID, ID);
		return containerType;
	}

	public ConcreteConverterTier3Container(int id, PlayerInventory playerInventoryIn) {
		this(id, playerInventoryIn,
				new ConcreteConverterItemStackHandler(ConcreteConverterTier3TileEntity.TOTAL_SLOTS, null));
	}

	public ConcreteConverterTier3Container(int id, PlayerInventory playerInventoryIn,
			ConcreteConverterItemStackHandler inventoryIn) {
		super(CCTObjectHolder.CONCRETE_CONVERTER_TIER_3_CONTAINER_TYPE, id, playerInventoryIn, inventoryIn,
				ConcreteConverterTier3TileEntity.TOTAL_SLOTS, ConcreteConverterTier3Screen.Y_SIZE);
	}

	@Override
	protected void addSlots() {
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				this.addSlot(new ConcreteConverterInputSlot(this.inventory, j + i * 2, 35 + j * 18, 18 + i * 18));
			}
		}
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				this.addSlot(new ConcreteConverterOutputSlot(this.inventory, 4 + j + i * 2, 107 + j * 18, 18 + i * 18));
			}
		}
	}
}
