package mrp_v2.concreteconversiontech.inventory.container;

import mrp_v2.concreteconversiontech.client.gui.screen.inventory.ConcreteConverterTier5Screen;
import mrp_v2.concreteconversiontech.inventory.ConcreteConverterItemStackHandler;
import mrp_v2.concreteconversiontech.tileentity.ConcreteConverterTier5TileEntity;
import mrp_v2.concreteconversiontech.util.ObjectHolder;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.ContainerType;

public class ConcreteConverterTier5Container extends AbstractConcreteConverterContainer
{
    public ConcreteConverterTier5Container(int id, PlayerInventory playerInventoryIn,
            ConcreteConverterItemStackHandler inventoryIn)
    {
        super(ObjectHolder.CONCRETE_CONVERTER_TIER_5_CONTAINER_TYPE.get(), id, playerInventoryIn, inventoryIn,
                ConcreteConverterTier5Screen.Y_SIZE, 0, 17, 107, 3, 3);
    }

    public ConcreteConverterTier5Container(int id, PlayerInventory playerInventoryIn)
    {
        this(id, playerInventoryIn,
                new ConcreteConverterItemStackHandler(ConcreteConverterTier5TileEntity.TOTAL_SLOTS));
    }

    public static ContainerType<ConcreteConverterTier5Container> createContainerType()
    {
        return new ContainerType<>(ConcreteConverterTier5Container::new);
    }
}
