package mrp_v2.concreteconversiontech.inventory.container;

import mrp_v2.concreteconversiontech.client.gui.screen.inventory.ConcreteConverterTier1Screen;
import mrp_v2.concreteconversiontech.inventory.ConcreteConverterItemStackHandler;
import mrp_v2.concreteconversiontech.tileentity.ConcreteConverterTier1TileEntity;
import mrp_v2.concreteconversiontech.util.ObjectHolder;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.MenuType;

public class ConcreteConverterTier1Container extends AbstractConcreteConverterContainer
{
    public ConcreteConverterTier1Container(int id, Inventory playerInventoryIn,
            ConcreteConverterItemStackHandler inventoryIn)
    {
        super(ObjectHolder.CONCRETE_CONVERTER_TIER_1_CONTAINER_TYPE.get(), id, playerInventoryIn, inventoryIn,
                ConcreteConverterTier1Screen.Y_SIZE, 0, 53, 107, 1, 1);
    }

    public ConcreteConverterTier1Container(int id, Inventory playerInventoryIn)
    {
        this(id, playerInventoryIn,
                new ConcreteConverterItemStackHandler(ConcreteConverterTier1TileEntity.TOTAL_SLOTS, null));
    }

    public static MenuType<ConcreteConverterTier1Container> createContainerType()
    {
        return new MenuType<>(ConcreteConverterTier1Container::new);
    }
}
