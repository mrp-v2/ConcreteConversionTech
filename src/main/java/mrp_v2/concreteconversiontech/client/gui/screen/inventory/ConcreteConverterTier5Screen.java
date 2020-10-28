package mrp_v2.concreteconversiontech.client.gui.screen.inventory;

import mrp_v2.concreteconversiontech.inventory.container.ConcreteConverterTier5Container;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT) public class ConcreteConverterTier5Screen
        extends AbstractConcreteConverterScreen<ConcreteConverterTier5Container>
{
    public static final int Y_SIZE = 189;

    public ConcreteConverterTier5Screen(ConcreteConverterTier5Container screenContainer, PlayerInventory inv,
            ITextComponent titleIn)
    {
        super(screenContainer, inv, titleIn, 5, Y_SIZE);
    }
}
