package mrp_v2.concreteconversiontech.inventory.container;

import mrp_v2.concreteconversiontech.blockentity.ConcreteConverterTier3BlockEntity;
import mrp_v2.concreteconversiontech.client.gui.screen.inventory.ConcreteConverterTier3Screen;
import mrp_v2.concreteconversiontech.inventory.ConcreteConverterItemStackHandler;
import mrp_v2.concreteconversiontech.util.ObjectHolder;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;

public class ConcreteConverterTier3Container extends AbstractConcreteConverterContainer
{
    public ConcreteConverterTier3Container(int id, Inventory playerInventoryIn,
            ConcreteConverterItemStackHandler inventoryIn)
    {
        super(ObjectHolder.CONCRETE_CONVERTER_TIER_3_CONTAINER_TYPE.get(), id, playerInventoryIn, inventoryIn,
                ConcreteConverterTier3Screen.Y_SIZE, 0, 35, 107, 2, 2);
    }

    public ConcreteConverterTier3Container(int id, Inventory playerInventoryIn)
    {
        this(id, playerInventoryIn,
                new ConcreteConverterItemStackHandler(ConcreteConverterTier3BlockEntity.TOTAL_SLOTS, null));
    }

    public static MenuType<ConcreteConverterTier3Container> createContainerType()
    {
        return new MenuType<>(ConcreteConverterTier3Container::new, FeatureFlags.DEFAULT_FLAGS);
    }
}
