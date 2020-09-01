package mrp_v2.concreteconversiontech.client.gui.screen.inventory;

import mrp_v2.concreteconversiontech.inventory.container.ConcreteConverterTier2Container;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT) public class ConcreteConverterTier2Screen
        extends AbstractConcreteConverterScreen<ConcreteConverterTier2Container>
{
    public static final int Y_SIZE = 131;
	
    public ConcreteConverterTier2Screen(ConcreteConverterTier2Container screenContainer, PlayerInventory inv,
            ITextComponent titleIn)
    {
        super(screenContainer, inv, titleIn, 2, Y_SIZE);
    }
}
