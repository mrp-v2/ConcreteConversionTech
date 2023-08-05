package mrp_v2.concreteconversiontech.client.gui.screen.inventory;

import mrp_v2.concreteconversiontech.inventory.container.ConcreteConverterTier5Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT) public class ConcreteConverterTier5Screen
        extends AbstractConcreteConverterScreen<ConcreteConverterTier5Container>
{
    public static final int Y_SIZE = 189;

    public ConcreteConverterTier5Screen(ConcreteConverterTier5Container screenContainer, Inventory inv,
            Component titleIn)
    {
        super(screenContainer, inv, titleIn, 5, Y_SIZE);
    }
}
