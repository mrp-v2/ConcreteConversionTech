package mrp_v2.concreteconversiontech.inventory.container;

import mrp_v2.concreteconversiontech.ConcreteConversionTech;
import mrp_v2.concreteconversiontech.client.gui.screen.inventory.ConcreteConverterTier1Screen;
import mrp_v2.concreteconversiontech.inventory.ConcreteConverterItemStackHandler;
import mrp_v2.concreteconversiontech.tileentity.ConcreteConverterTier1TileEntity;
import mrp_v2.concreteconversiontech.util.ObjectHolder;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.ContainerType;

public class ConcreteConverterTier1Container extends AbstractConcreteConverterContainer {

	public static final String ID = ID_STEM_PRE + "tier_1" + ID_STEM_POST;

	public static ContainerType<ConcreteConverterTier1Container> createContainerType() {
		ContainerType<ConcreteConverterTier1Container> containerType = new ContainerType<ConcreteConverterTier1Container>(
				ConcreteConverterTier1Container::new);
		containerType.setRegistryName(ConcreteConversionTech.ID, ID);
		return containerType;
	}

	public ConcreteConverterTier1Container(int id, PlayerInventory playerInventoryIn) {
		this(id, playerInventoryIn,
				new ConcreteConverterItemStackHandler(ConcreteConverterTier1TileEntity.TOTAL_SLOTS, null));
	}

	public ConcreteConverterTier1Container(int id, PlayerInventory playerInventoryIn,
			ConcreteConverterItemStackHandler inventoryIn) {
		super(ObjectHolder.CONCRETE_CONVERTER_TIER_1_CONTAINER_TYPE, id, playerInventoryIn, inventoryIn,
				ConcreteConverterTier1TileEntity.TOTAL_SLOTS, ConcreteConverterTier1Screen.Y_SIZE, 0, 53, 107, 18, 1,
				1);
	}
}
