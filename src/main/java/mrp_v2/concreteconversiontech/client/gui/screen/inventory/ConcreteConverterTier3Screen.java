package mrp_v2.concreteconversiontech.client.gui.screen.inventory;

import mrp_v2.concreteconversiontech.inventory.container.ConcreteConverterTier3Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT) public class ConcreteConverterTier3Screen
        extends AbstractConcreteConverterScreen<ConcreteConverterTier3Container>
{
    public static final int Y_SIZE = 171;

    public ConcreteConverterTier3Screen(ConcreteConverterTier3Container screenContainer, Inventory inv,
            Component titleIn)
    {
        super(screenContainer, inv, titleIn, 3, Y_SIZE);
    }
}
