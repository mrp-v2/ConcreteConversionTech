package mrp_v2.concreteconversiontech.inventory.container;

import mrp_v2.concreteconversiontech.client.gui.screen.inventory.ConcreteConverterTier2Screen;
import mrp_v2.concreteconversiontech.inventory.ConcreteConverterItemStackHandler;
import mrp_v2.concreteconversiontech.tileentity.ConcreteConverterTier2TileEntity;
import mrp_v2.concreteconversiontech.util.ObjectHolder;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.MenuType;

public class ConcreteConverterTier2Container extends AbstractConcreteConverterContainer
{
    public ConcreteConverterTier2Container(int id, Inventory playerInventoryIn,
            ConcreteConverterItemStackHandler inventoryIn)
    {
        super(ObjectHolder.CONCRETE_CONVERTER_TIER_2_CONTAINER_TYPE.get(), id, playerInventoryIn, inventoryIn,
                ConcreteConverterTier2Screen.Y_SIZE, 0, 35, 107, 2, 1);
    }

    public ConcreteConverterTier2Container(int id, Inventory playerInventoryIn)
    {
        this(id, playerInventoryIn,
                new ConcreteConverterItemStackHandler(ConcreteConverterTier2TileEntity.TOTAL_SLOTS, null));
    }

    public static MenuType<ConcreteConverterTier2Container> createContainerType()
    {
        return new MenuType<>(ConcreteConverterTier2Container::new);
    }
}
