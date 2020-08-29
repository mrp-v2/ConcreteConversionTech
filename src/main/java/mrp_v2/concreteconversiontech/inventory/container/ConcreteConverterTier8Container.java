package mrp_v2.concreteconversiontech.inventory.container;

import mrp_v2.concreteconversiontech.ConcreteConversionTech;
import mrp_v2.concreteconversiontech.client.gui.screen.inventory.ConcreteConverterTier8Screen;
import mrp_v2.concreteconversiontech.inventory.ConcreteConverterItemStackHandler;
import mrp_v2.concreteconversiontech.tileentity.ConcreteConverterTier8TileEntity;
import mrp_v2.concreteconversiontech.util.ObjectHolder;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.ContainerType;

public class ConcreteConverterTier8Container extends AbstractConcreteConverterContainer {

	public static final String ID = ID_STEM_PRE + "tier_8" + ID_STEM_POST;

	public static ContainerType<ConcreteConverterTier8Container> createContainerType() {
		ContainerType<ConcreteConverterTier8Container> containerType = new ContainerType<ConcreteConverterTier8Container>(
				ConcreteConverterTier8Container::new);
		containerType.setRegistryName(ConcreteConversionTech.ID, ID);
		return containerType;
	}

	public ConcreteConverterTier8Container(int id, PlayerInventory playerInventoryIn) {
		this(id, playerInventoryIn,
				new ConcreteConverterItemStackHandler(ConcreteConverterTier8TileEntity.TOTAL_SLOTS, null));
	}

	public ConcreteConverterTier8Container(int id, PlayerInventory playerInventoryIn,
			ConcreteConverterItemStackHandler inventoryIn) {
		super(ObjectHolder.CONCRETE_CONVERTER_TIER_8_CONTAINER_TYPE, id, playerInventoryIn, inventoryIn,
				ConcreteConverterTier8TileEntity.TOTAL_SLOTS, ConcreteConverterTier8Screen.Y_SIZE, 18, 8, 116, 18, 5,
				5);
	}
}
