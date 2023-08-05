package mrp_v2.concreteconversiontech.client.gui.screen.inventory;

import mrp_v2.concreteconversiontech.inventory.container.ConcreteConverterTier1Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT) public class ConcreteConverterTier1Screen
        extends AbstractConcreteConverterScreen<ConcreteConverterTier1Container>
{
    public static final int Y_SIZE = 153;

    public ConcreteConverterTier1Screen(ConcreteConverterTier1Container screenContainer, Inventory inv,
            Component titleIn)
    {
        super(screenContainer, inv, titleIn, 1, Y_SIZE);
    }
}
