package mrp_v2.concreteconversiontech.inventory.container;

import mrp_v2.concreteconversiontech.ConcreteConversionTech;
import mrp_v2.concreteconversiontech.client.gui.screen.inventory.ConcreteConverterTier6Screen;
import mrp_v2.concreteconversiontech.inventory.ConcreteConverterItemStackHandler;
import mrp_v2.concreteconversiontech.tileentity.ConcreteConverterTier6TileEntity;
import mrp_v2.concreteconversiontech.util.ObjectHolder;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.ContainerType;

public class ConcreteConverterTier6Container extends AbstractConcreteConverterContainer
{
    public static final String ID = ID_STEM_PRE + "tier_6" + ID_STEM_POST;

    public static ContainerType<ConcreteConverterTier6Container> createContainerType()
    {
        ContainerType<ConcreteConverterTier6Container> containerType =
                new ContainerType<>(ConcreteConverterTier6Container::new);
        containerType.setRegistryName(ConcreteConversionTech.ID, ID);
        return containerType;
    }

    public ConcreteConverterTier6Container(int id, PlayerInventory playerInventoryIn)
    {
        this(id, playerInventoryIn,
                new ConcreteConverterItemStackHandler(ConcreteConverterTier6TileEntity.TOTAL_SLOTS));
    }

    public ConcreteConverterTier6Container(int id, PlayerInventory playerInventoryIn,
            ConcreteConverterItemStackHandler inventoryIn)
    {
        super(ObjectHolder.CONCRETE_CONVERTER_TIER_6_CONTAINER_TYPE, id, playerInventoryIn, inventoryIn,
                ConcreteConverterTier6Screen.Y_SIZE, 0, 17, 107, 3, 5);
    }
}
