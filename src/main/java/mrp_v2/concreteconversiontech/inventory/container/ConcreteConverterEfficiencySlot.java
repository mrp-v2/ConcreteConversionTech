package mrp_v2.concreteconversiontech.inventory.container;

import mrp_v2.concreteconversiontech.inventory.ConcreteConverterItemStackHandler;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.items.SlotItemHandler;

import java.util.Map;

public class ConcreteConverterEfficiencySlot extends SlotItemHandler
{
    public ConcreteConverterEfficiencySlot(ConcreteConverterItemStackHandler itemHandler, int index, int xPosition,
            int yPosition)
    {
        super(itemHandler, index, xPosition, yPosition);
    }

    @Override public boolean mayPlace(ItemStack stack)
    {
        if (stack.getItem() == Items.ENCHANTED_BOOK)
        {
            Map<Enchantment, Integer> enchantments = EnchantmentHelper.getEnchantments(stack);
            return enchantments.containsKey(Enchantments.BLOCK_EFFICIENCY);
        }
        return false;
    }
}
