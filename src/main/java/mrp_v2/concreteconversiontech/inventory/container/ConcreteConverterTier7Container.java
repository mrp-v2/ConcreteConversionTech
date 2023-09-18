package mrp_v2.concreteconversiontech.inventory.container;

import mrp_v2.concreteconversiontech.blockentity.ConcreteConverterTier7BlockEntity;
import mrp_v2.concreteconversiontech.client.gui.screen.inventory.ConcreteConverterTier7Screen;
import mrp_v2.concreteconversiontech.inventory.ConcreteConverterItemStackHandler;
import mrp_v2.concreteconversiontech.util.ObjectHolder;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;

public class ConcreteConverterTier7Container extends AbstractConcreteConverterContainer
{
    public ConcreteConverterTier7Container(int id, Inventory playerInventoryIn,
            ConcreteConverterItemStackHandler inventoryIn)
    {
        super(ObjectHolder.CONCRETE_CONVERTER_TIER_7_CONTAINER_TYPE.get(), id, playerInventoryIn, inventoryIn,
                ConcreteConverterTier7Screen.Y_SIZE, 0, 8, 98, 4, 5);
    }

    public ConcreteConverterTier7Container(int id, Inventory playerInventoryIn)
    {
        this(id, playerInventoryIn,
                new ConcreteConverterItemStackHandler(ConcreteConverterTier7BlockEntity.TOTAL_SLOTS, null));
    }

    public static MenuType<ConcreteConverterTier7Container> createContainerType()
    {
        return new MenuType<>(ConcreteConverterTier7Container::new, FeatureFlags.DEFAULT_FLAGS);
    }
}
