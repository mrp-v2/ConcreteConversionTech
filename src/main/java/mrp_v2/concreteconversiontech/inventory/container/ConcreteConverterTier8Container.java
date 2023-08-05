package mrp_v2.concreteconversiontech.inventory.container;

import mrp_v2.concreteconversiontech.blockentity.ConcreteConverterTier8BlockEntity;
import mrp_v2.concreteconversiontech.client.gui.screen.inventory.ConcreteConverterTier8Screen;
import mrp_v2.concreteconversiontech.inventory.ConcreteConverterItemStackHandler;
import mrp_v2.concreteconversiontech.util.ObjectHolder;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.MenuType;

public class ConcreteConverterTier8Container extends AbstractConcreteConverterContainer
{
    public ConcreteConverterTier8Container(int id, Inventory playerInventoryIn,
            ConcreteConverterItemStackHandler inventoryIn)
    {
        super(ObjectHolder.CONCRETE_CONVERTER_TIER_8_CONTAINER_TYPE.get(), id, playerInventoryIn, inventoryIn,
                ConcreteConverterTier8Screen.Y_SIZE, 18, 8, 116, 5, 5);
    }

    public ConcreteConverterTier8Container(int id, Inventory playerInventoryIn)
    {
        this(id, playerInventoryIn,
                new ConcreteConverterItemStackHandler(ConcreteConverterTier8BlockEntity.TOTAL_SLOTS, null));
    }

    public static MenuType<ConcreteConverterTier8Container> createContainerType()
    {
        return new MenuType<>(ConcreteConverterTier8Container::new);
    }
}
