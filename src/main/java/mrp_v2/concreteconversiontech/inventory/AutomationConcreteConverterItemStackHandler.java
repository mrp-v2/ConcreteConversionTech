package mrp_v2.concreteconversiontech.inventory;

import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;

public class AutomationConcreteConverterItemStackHandler implements IItemHandler, IItemHandlerModifiable
{
    public final ConcreteConverterItemStackHandler parent;

    public AutomationConcreteConverterItemStackHandler(ConcreteConverterItemStackHandler parent)
    {
        this.parent = parent;
    }

    @Override public void setStackInSlot(int slot, ItemStack stack)
    {
        parent.setStackInSlot(slot, stack);
    }

    @Override public int getSlots()
    {
        return parent.getSlots();
    }

    @Override public ItemStack getStackInSlot(int slot)
    {
        return parent.getStackInSlot(slot);
    }

    @Override public ItemStack insertItem(int slot, ItemStack stack, boolean simulate)
    {
        if (!(slot < (this.getSlots() - 3) / 2))
        {
            return stack;
        }
        return parent.insertItem(slot, stack, simulate);
    }

    @Override public ItemStack extractItem(int slot, int amount, boolean simulate)
    {
        if (slot < (this.getSlots() - 3) / 2 || slot >= this.getSlots() - 3)
        {
            return ItemStack.EMPTY;
        }
        return parent.extractItem(slot, amount, simulate);
    }

    @Override public int getSlotLimit(int slot)
    {
        return parent.getSlotLimit(slot);
    }

    @Override public boolean isItemValid(int slot, ItemStack stack)
    {
        return parent.isItemValid(slot, stack);
    }
}
