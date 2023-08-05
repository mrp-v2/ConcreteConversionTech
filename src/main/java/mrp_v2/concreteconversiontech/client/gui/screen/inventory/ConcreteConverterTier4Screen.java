package mrp_v2.concreteconversiontech.client.gui.screen.inventory;

import mrp_v2.concreteconversiontech.inventory.container.ConcreteConverterTier4Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT) public class ConcreteConverterTier4Screen
        extends AbstractConcreteConverterScreen<ConcreteConverterTier4Container>
{
    public static final int Y_SIZE = 189;

    public ConcreteConverterTier4Screen(ConcreteConverterTier4Container screenContainer, Inventory inv,
            Component titleIn)
    {
        super(screenContainer, inv, titleIn, 4, Y_SIZE);
    }
}
