package mrp_v2.concreteconversiontech.inventory.container;

import mrp_v2.concreteconversiontech.inventory.ConcreteConverterItemStackHandler;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public abstract class AbstractConcreteConverterContainer extends AbstractContainerMenu
{
    protected static final String ID_STEM_PRE = "concrete_converter_";
    protected final ConcreteConverterItemStackHandler inventory;

    protected AbstractConcreteConverterContainer(MenuType<?> type, int id, Inventory playerInventoryIn,
            ConcreteConverterItemStackHandler inventoryIn, int ySize, int playerInventoryXOffset, int inputSlotsXStart,
            int outputSlotsXStart, int slotsWidth, int slotsHeight)
    {
        super(type, id);
        this.inventory = inventoryIn;
        addSlots(inputSlotsXStart, outputSlotsXStart, slotsWidth, slotsHeight, playerInventoryIn,
                playerInventoryXOffset, ySize);
    }

    protected void addSlots(int inputSlotsXStart, int outputSlotsXStart, int width, int height,
            Inventory playerInventory, int playerInventoryXOffset, int ySize)
    {
        int slotsYStart = 40;
        // converter input slots
        for (int i = 0; i < height; i++)
        {
            for (int j = 0; j < width; j++)
            {
                this.addSlot(new ConcreteConverterInputSlot(this.inventory, j + i * width, inputSlotsXStart + j * 18,
                        slotsYStart + i * 18));
            }
        }
        // converter outputs slots
        for (int i = 0; i < height; i++)
        {
            for (int j = 0; j < width; j++)
            {
                this.addSlot(new ConcreteConverterOutputSlot(this.inventory, width * height + j + i * width,
                        outputSlotsXStart + j * 18, slotsYStart + i * 18));
            }
        }
        // converter efficiency slots
        for (int i = 0; i < 3; i++)
        {
            this.addSlot(new ConcreteConverterEfficiencySlot(this.inventory, width * height * 2 + i,
                    62 + i * 18 + playerInventoryXOffset, 18));
        }
        // player inventory slots
        for (int i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 9; ++j)
            {
                this.addSlot(new Slot(playerInventory, j + i * 9 + 9, playerInventoryXOffset + 8 + j * 18,
                        ySize - 82 + i * 18));
            }
        }
        for (int i = 0; i < 9; ++i)
        {
            this.addSlot(new Slot(playerInventory, i, playerInventoryXOffset + 8 + i * 18, ySize - 24));
        }
    }

    @Override public ItemStack quickMoveStack(Player playerIn, int index)
    {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot != null && slot.hasItem())
        {
            ItemStack itemStack1 = slot.getItem();
            itemStack = itemStack1.copy();
            if (index < this.inventory.getSlots())
            {
                if (!this.moveItemStackTo(itemStack1, this.inventory.getSlots(), this.slots.size(), true))
                {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(itemStack1, 0, this.inventory.getSlots() / 2, false))
            {
                if (!this.moveItemStackTo(itemStack1, this.inventory.getSlots() - 3, this.inventory.getSlots(), false))
                {
                    return ItemStack.EMPTY;
                }
            }
            if (itemStack1.isEmpty())
            {
                slot.set(ItemStack.EMPTY);
            } else
            {
                slot.setChanged();
            }
        }
        return itemStack;
    }

    @Override public boolean stillValid(Player playerIn)
    {
        return true;
    }
}
