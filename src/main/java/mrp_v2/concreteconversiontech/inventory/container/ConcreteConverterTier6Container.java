package mrp_v2.concreteconversiontech.inventory.container;

import mrp_v2.concreteconversiontech.blockentity.ConcreteConverterTier6BlockEntity;
import mrp_v2.concreteconversiontech.client.gui.screen.inventory.ConcreteConverterTier6Screen;
import mrp_v2.concreteconversiontech.inventory.ConcreteConverterItemStackHandler;
import mrp_v2.concreteconversiontech.util.ObjectHolder;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.MenuType;

public class ConcreteConverterTier6Container extends AbstractConcreteConverterContainer
{
    public ConcreteConverterTier6Container(int id, Inventory playerInventoryIn,
            ConcreteConverterItemStackHandler inventoryIn)
    {
        super(ObjectHolder.CONCRETE_CONVERTER_TIER_6_CONTAINER_TYPE.get(), id, playerInventoryIn, inventoryIn,
                ConcreteConverterTier6Screen.Y_SIZE, 0, 17, 107, 3, 5);
    }

    public ConcreteConverterTier6Container(int id, Inventory playerInventoryIn)
    {
        this(id, playerInventoryIn,
                new ConcreteConverterItemStackHandler(ConcreteConverterTier6BlockEntity.TOTAL_SLOTS, null));
    }

    public static MenuType<ConcreteConverterTier6Container> createContainerType()
    {
        return new MenuType<>(ConcreteConverterTier6Container::new);
    }
}
