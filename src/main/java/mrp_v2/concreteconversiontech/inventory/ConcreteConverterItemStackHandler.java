package mrp_v2.concreteconversiontech.inventory;

import mrp_v2.concreteconversiontech.tileentity.AbstractConcreteConverterTileEntity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.NonNullSupplier;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class ConcreteConverterItemStackHandler extends ItemStackHandler implements NonNullSupplier<IItemHandler>
{
    private final AbstractConcreteConverterTileEntity concreteConverter;

    public ConcreteConverterItemStackHandler(int slots, AbstractConcreteConverterTileEntity concreteConverter)
    {
        super(slots);
        this.concreteConverter = concreteConverter;
    }

    /**
     * Ignores slot limitations
     */
    public ItemStack extractItem(int slot, int amount)
    {
        return super.extractItem(slot, amount, false);
    }

    @Override public IItemHandler get()
    {
        return this;
    }

    /**
     * Ignores slot limitations
     */
    public ItemStack insertItem(int slot, ItemStack stack)
    {
        return super.insertItem(slot, stack, false);
    }

    @Override public ItemStack insertItem(int slot, ItemStack stack, boolean simulate)
    {
        if (slot >= this.stacks.size() / 2 || !AbstractConcreteConverterTileEntity.isConcretePowder(stack))
        {
            return stack;
        }
        return super.insertItem(slot, stack, simulate);
    }

    @Override public ItemStack extractItem(int slot, int amount, boolean simulate)
    {
        if (slot < this.stacks.size() / 2)
        {
            return ItemStack.EMPTY;
        }
        return super.extractItem(slot, amount, simulate);
    }

    @Override protected void onContentsChanged(int slot)
    {
        super.onContentsChanged(slot);
    }

    public boolean isInputEmpty()
    {
        for (int i = 0; i < this.stacks.size() / 2; i++)
        {
            if (!this.stacks.get(i).isEmpty())
            {
                return false;
            }
        }
        return true;
    }
}
