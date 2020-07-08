package mrp_v2.concreteconversiontech.common.inventory.container;

import mrp_v2.concreteconversiontech.ConcreteConversionTech;
import mrp_v2.concreteconversiontech.client.gui.screen.inventory.ConcreteConverterTier5Screen;
import mrp_v2.concreteconversiontech.common.inventory.ConcreteConverterItemStackHandler;
import mrp_v2.concreteconversiontech.common.tileentity.ConcreteConverterTier5TileEntity;
import mrp_v2.concreteconversiontech.common.util.CCTObjectHolder;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.ContainerType;

public class ConcreteConverterTier5Container extends AbstractConcreteConverterContainer {

	public static final String ID = ID_STEM_PRE + "tier_5" + ID_STEM_POST;

	public static ContainerType<ConcreteConverterTier5Container> createContainerType() {
		ContainerType<ConcreteConverterTier5Container> containerType = new ContainerType<ConcreteConverterTier5Container>(
				ConcreteConverterTier5Container::new);
		containerType.setRegistryName(ConcreteConversionTech.MODID, ID);
		return containerType;
	}

	public ConcreteConverterTier5Container(int id, PlayerInventory playerInventoryIn) {
		this(id, playerInventoryIn,
				new ConcreteConverterItemStackHandler(ConcreteConverterTier5TileEntity.TOTAL_SLOTS, null));
	}

	public ConcreteConverterTier5Container(int id, PlayerInventory playerInventoryIn,
			ConcreteConverterItemStackHandler inventoryIn) {
		super(CCTObjectHolder.CONCRETE_CONVERTER_TIER_5_CONTAINER_TYPE, id, playerInventoryIn, inventoryIn,
				ConcreteConverterTier5TileEntity.TOTAL_SLOTS, ConcreteConverterTier5Screen.Y_SIZE, 0, 17, 107, 18, 3,
				3);
	}
}
