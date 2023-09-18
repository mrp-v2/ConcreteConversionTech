package mrp_v2.concreteconversiontech.inventory.container;

import mrp_v2.concreteconversiontech.blockentity.ConcreteConverterTier4BlockEntity;
import mrp_v2.concreteconversiontech.client.gui.screen.inventory.ConcreteConverterTier4Screen;
import mrp_v2.concreteconversiontech.inventory.ConcreteConverterItemStackHandler;
import mrp_v2.concreteconversiontech.util.ObjectHolder;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;

public class ConcreteConverterTier4Container extends AbstractConcreteConverterContainer
{
    public ConcreteConverterTier4Container(int id, Inventory playerInventoryIn,
            ConcreteConverterItemStackHandler inventoryIn)
    {
        super(ObjectHolder.CONCRETE_CONVERTER_TIER_4_CONTAINER_TYPE.get(), id, playerInventoryIn, inventoryIn,
                ConcreteConverterTier4Screen.Y_SIZE, 0, 35, 107, 2, 3);
    }

    public ConcreteConverterTier4Container(int id, Inventory playerInventoryIn)
    {
        this(id, playerInventoryIn,
                new ConcreteConverterItemStackHandler(ConcreteConverterTier4BlockEntity.TOTAL_SLOTS, null));
    }

    public static MenuType<ConcreteConverterTier4Container> createContainerType()
    {
        return new MenuType<>(ConcreteConverterTier4Container::new, FeatureFlags.DEFAULT_FLAGS);
    }
}
