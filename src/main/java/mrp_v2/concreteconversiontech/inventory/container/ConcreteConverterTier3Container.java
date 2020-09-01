package mrp_v2.concreteconversiontech.inventory.container;

import mrp_v2.concreteconversiontech.ConcreteConversionTech;
import mrp_v2.concreteconversiontech.client.gui.screen.inventory.ConcreteConverterTier3Screen;
import mrp_v2.concreteconversiontech.inventory.ConcreteConverterItemStackHandler;
import mrp_v2.concreteconversiontech.tileentity.ConcreteConverterTier3TileEntity;
import mrp_v2.concreteconversiontech.util.ObjectHolder;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.ContainerType;

public class ConcreteConverterTier3Container extends AbstractConcreteConverterContainer
{
    public static final String ID = ID_STEM_PRE + "tier_3" + ID_STEM_POST;

    public static ContainerType<ConcreteConverterTier3Container> createContainerType()
    {
        ContainerType<ConcreteConverterTier3Container> containerType =
                new ContainerType<>(ConcreteConverterTier3Container::new);
        containerType.setRegistryName(ConcreteConversionTech.ID, ID);
        return containerType;
    }

    public ConcreteConverterTier3Container(int id, PlayerInventory playerInventoryIn)
    {
        this(id, playerInventoryIn,
                new ConcreteConverterItemStackHandler(ConcreteConverterTier3TileEntity.TOTAL_SLOTS, null));
    }

    public ConcreteConverterTier3Container(int id, PlayerInventory playerInventoryIn,
            ConcreteConverterItemStackHandler inventoryIn)
    {
        super(ObjectHolder.CONCRETE_CONVERTER_TIER_3_CONTAINER_TYPE, id, playerInventoryIn, inventoryIn,
                ConcreteConverterTier3Screen.Y_SIZE, 0, 35, 107, 18, 2, 2);
    }
}
