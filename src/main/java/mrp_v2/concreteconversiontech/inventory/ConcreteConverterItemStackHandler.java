package mrp_v2.concreteconversiontech.inventory;

import mrp_v2.concreteconversiontech.blockentity.AbstractConcreteConverterBlockEntity;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nullable;

public class ConcreteConverterItemStackHandler extends ItemStackHandler
{
    @Nullable
    private final AbstractConcreteConverterBlockEntity concreteConverter;

    public ConcreteConverterItemStackHandler(int slots, @Nullable AbstractConcreteConverterBlockEntity concreteConverter)
    {
        super(slots + 3);
        this.concreteConverter = concreteConverter;
    }

    @Override protected void onContentsChanged(int slot)
    {
        super.onContentsChanged(slot);
        if (concreteConverter != null)
        {
            concreteConverter.setChanged();
        }
    }

    public boolean isInputEmpty()
    {
        for (int i = 0; i < (this.stacks.size() - 3) / 2; i++)
        {
            if (!this.stacks.get(i).isEmpty())
            {
                return false;
            }
        }
        return true;
    }
}
