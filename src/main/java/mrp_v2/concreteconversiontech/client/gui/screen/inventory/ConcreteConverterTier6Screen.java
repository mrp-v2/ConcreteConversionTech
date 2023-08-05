package mrp_v2.concreteconversiontech.client.gui.screen.inventory;

import mrp_v2.concreteconversiontech.inventory.container.ConcreteConverterTier6Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT) public class ConcreteConverterTier6Screen
        extends AbstractConcreteConverterScreen<ConcreteConverterTier6Container>
{
    public static final int Y_SIZE = 225;

    public ConcreteConverterTier6Screen(ConcreteConverterTier6Container screenContainer, Inventory inv,
            Component titleIn)
    {
        super(screenContainer, inv, titleIn, 6, Y_SIZE);
    }
}
