package mrp_v2.concreteconversiontech.inventory.container;

import mrp_v2.concreteconversiontech.ConcreteConversionTech;
import mrp_v2.concreteconversiontech.client.gui.screen.inventory.ConcreteConverterTier7Screen;
import mrp_v2.concreteconversiontech.inventory.ConcreteConverterItemStackHandler;
import mrp_v2.concreteconversiontech.tileentity.ConcreteConverterTier7TileEntity;
import mrp_v2.concreteconversiontech.util.ObjectHolder;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.ContainerType;

public class ConcreteConverterTier7Container extends AbstractConcreteConverterContainer
{
    public static final String ID = ID_STEM_PRE + "tier_7" + ID_STEM_POST;

    public static ContainerType<ConcreteConverterTier7Container> createContainerType()
    {
        ContainerType<ConcreteConverterTier7Container> containerType =
                new ContainerType<>(ConcreteConverterTier7Container::new);
        containerType.setRegistryName(ConcreteConversionTech.ID, ID);
        return containerType;
    }

    public ConcreteConverterTier7Container(int id, PlayerInventory playerInventoryIn)
    {
        this(id, playerInventoryIn,
                new ConcreteConverterItemStackHandler(ConcreteConverterTier7TileEntity.TOTAL_SLOTS));
    }

    public ConcreteConverterTier7Container(int id, PlayerInventory playerInventoryIn,
            ConcreteConverterItemStackHandler inventoryIn)
    {
        super(ObjectHolder.CONCRETE_CONVERTER_TIER_7_CONTAINER_TYPE, id, playerInventoryIn, inventoryIn,
                ConcreteConverterTier7Screen.Y_SIZE, 0, 8, 98, 18, 4, 5);
    }
}
