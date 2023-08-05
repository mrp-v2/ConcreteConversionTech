package mrp_v2.concreteconversiontech.inventory.container;

import mrp_v2.concreteconversiontech.blockentity.AbstractConcreteConverterBlockEntity;
import mrp_v2.concreteconversiontech.inventory.ConcreteConverterItemStackHandler;
import net.minecraft.world.item.ItemStack;
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
        return AbstractConcreteConverterBlockEntity.isConcretePowder(stack);
    }
}
