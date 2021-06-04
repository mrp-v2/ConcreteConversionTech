package mrp_v2.concreteconversiontech.inventory.container;

import mrp_v2.concreteconversiontech.inventory.ConcreteConverterItemStackHandler;
import mrp_v2.concreteconversiontech.tileentity.AbstractConcreteConverterTileEntity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.SlotItemHandler;

public class ConcreteConverterInputSlot extends SlotItemHandler
{
    public ConcreteConverterInputSlot(ConcreteConverterItemStackHandler inventoryIn, int index, int xPosition,
            int yPosition)
    {
        super(inventoryIn, index, xPosition, yPosition);
    }

    @Override public boolean mayPlace(ItemStack stack)
    {
        return AbstractConcreteConverterTileEntity.isConcretePowder(stack);
    }
}
