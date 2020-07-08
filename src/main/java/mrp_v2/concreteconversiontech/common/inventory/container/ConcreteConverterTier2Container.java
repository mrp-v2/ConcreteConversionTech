package mrp_v2.concreteconversiontech.common.inventory.container;

import mrp_v2.concreteconversiontech.ConcreteConversionTech;
import mrp_v2.concreteconversiontech.client.gui.screen.inventory.ConcreteConverterTier2Screen;
import mrp_v2.concreteconversiontech.common.inventory.ConcreteConverterItemStackHandler;
import mrp_v2.concreteconversiontech.common.tileentity.ConcreteConverterTier2TileEntity;
import mrp_v2.concreteconversiontech.common.util.CCTObjectHolder;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.ContainerType;

public class ConcreteConverterTier2Container extends AbstractConcreteConverterContainer {

	public static final String ID = ID_STEM_PRE + "tier_2" + ID_STEM_POST;

	public static ContainerType<ConcreteConverterTier2Container> createContainerType() {
		ContainerType<ConcreteConverterTier2Container> containerType = new ContainerType<ConcreteConverterTier2Container>(
				ConcreteConverterTier2Container::new);
		containerType.setRegistryName(ConcreteConversionTech.MODID, ID);
		return containerType;
	}

	public ConcreteConverterTier2Container(int id, PlayerInventory playerInventoryIn) {
		this(id, playerInventoryIn,
				new ConcreteConverterItemStackHandler(ConcreteConverterTier2TileEntity.TOTAL_SLOTS, null));
	}

	public ConcreteConverterTier2Container(int id, PlayerInventory playerInventoryIn,
			ConcreteConverterItemStackHandler inventoryIn) {
		super(CCTObjectHolder.CONCRETE_CONVERTER_TIER_2_CONTAINER_TYPE, id, playerInventoryIn, inventoryIn,
				ConcreteConverterTier2TileEntity.TOTAL_SLOTS, ConcreteConverterTier2Screen.Y_SIZE, 0, 35, 107, 18, 2,
				1);
	}
}
