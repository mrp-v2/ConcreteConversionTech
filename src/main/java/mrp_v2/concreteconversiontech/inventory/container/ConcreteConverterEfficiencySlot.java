package mrp_v2.concreteconversiontech.inventory.container;

import mrp_v2.concreteconversiontech.inventory.ConcreteConverterItemStackHandler;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
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
