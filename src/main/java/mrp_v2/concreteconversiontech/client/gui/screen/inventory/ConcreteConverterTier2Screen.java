package mrp_v2.concreteconversiontech.client.gui.screen.inventory;

import mrp_v2.concreteconversiontech.inventory.container.ConcreteConverterTier2Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT) public class ConcreteConverterTier2Screen
        extends AbstractConcreteConverterScreen<ConcreteConverterTier2Container>
{
    public static final int Y_SIZE = 153;
	
    public ConcreteConverterTier2Screen(ConcreteConverterTier2Container screenContainer, Inventory inv,
            Component titleIn)
    {
        super(screenContainer, inv, titleIn, 2, Y_SIZE);
    }
}
