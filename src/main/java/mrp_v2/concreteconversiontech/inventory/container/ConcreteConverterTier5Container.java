package mrp_v2.concreteconversiontech.inventory.container;

import mrp_v2.concreteconversiontech.blockentity.ConcreteConverterTier5BlockEntity;
import mrp_v2.concreteconversiontech.client.gui.screen.inventory.ConcreteConverterTier5Screen;
import mrp_v2.concreteconversiontech.inventory.ConcreteConverterItemStackHandler;
import mrp_v2.concreteconversiontech.util.ObjectHolder;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.MenuType;

public class ConcreteConverterTier5Container extends AbstractConcreteConverterContainer
{
    public ConcreteConverterTier5Container(int id, Inventory playerInventoryIn,
            ConcreteConverterItemStackHandler inventoryIn)
    {
        super(ObjectHolder.CONCRETE_CONVERTER_TIER_5_CONTAINER_TYPE.get(), id, playerInventoryIn, inventoryIn,
                ConcreteConverterTier5Screen.Y_SIZE, 0, 17, 107, 3, 3);
    }

    public ConcreteConverterTier5Container(int id, Inventory playerInventoryIn)
    {
        this(id, playerInventoryIn,
                new ConcreteConverterItemStackHandler(ConcreteConverterTier5BlockEntity.TOTAL_SLOTS, null));
    }

    public static MenuType<ConcreteConverterTier5Container> createContainerType()
    {
        return new MenuType<>(ConcreteConverterTier5Container::new);
    }
}
