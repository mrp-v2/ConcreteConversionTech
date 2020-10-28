package mrp_v2.concreteconversiontech.client.gui.screen.inventory;

import mrp_v2.concreteconversiontech.inventory.container.ConcreteConverterTier7Container;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT) public class ConcreteConverterTier7Screen
        extends AbstractConcreteConverterScreen<ConcreteConverterTier7Container>
{
    public static final int Y_SIZE = 225;

    public ConcreteConverterTier7Screen(ConcreteConverterTier7Container screenContainer, PlayerInventory inv,
            ITextComponent titleIn)
    {
        super(screenContainer, inv, titleIn, 7, Y_SIZE);
    }
}
