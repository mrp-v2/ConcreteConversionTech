package mrp_v2.concreteconversiontech.inventory.container;

import mrp_v2.concreteconversiontech.ConcreteConversionTech;
import mrp_v2.concreteconversiontech.client.gui.screen.inventory.ConcreteConverterTier4Screen;
import mrp_v2.concreteconversiontech.inventory.ConcreteConverterItemStackHandler;
import mrp_v2.concreteconversiontech.tileentity.ConcreteConverterTier4TileEntity;
import mrp_v2.concreteconversiontech.util.ObjectHolder;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.ContainerType;

public class ConcreteConverterTier4Container extends AbstractConcreteConverterContainer
{
    public static final String ID = ID_STEM_PRE + "tier_4" + ID_STEM_POST;

    public static ContainerType<ConcreteConverterTier4Container> createContainerType()
    {
        ContainerType<ConcreteConverterTier4Container> containerType =
                new ContainerType<>(ConcreteConverterTier4Container::new);
        containerType.setRegistryName(ConcreteConversionTech.ID, ID);
        return containerType;
    }

    public ConcreteConverterTier4Container(int id, PlayerInventory playerInventoryIn)
    {
        this(id, playerInventoryIn,
                new ConcreteConverterItemStackHandler(ConcreteConverterTier4TileEntity.TOTAL_SLOTS));
    }

    public ConcreteConverterTier4Container(int id, PlayerInventory playerInventoryIn,
            ConcreteConverterItemStackHandler inventoryIn)
    {
        super(ObjectHolder.CONCRETE_CONVERTER_TIER_4_CONTAINER_TYPE, id, playerInventoryIn, inventoryIn,
                ConcreteConverterTier4Screen.Y_SIZE, 0, 35, 107, 18, 2, 3);
    }
}
