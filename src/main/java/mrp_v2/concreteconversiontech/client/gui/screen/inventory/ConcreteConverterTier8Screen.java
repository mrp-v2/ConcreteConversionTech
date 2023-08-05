package mrp_v2.concreteconversiontech.client.gui.screen.inventory;

import mrp_v2.concreteconversiontech.inventory.container.ConcreteConverterTier8Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT) public class ConcreteConverterTier8Screen
        extends AbstractConcreteConverterScreen<ConcreteConverterTier8Container>
{
    public static final int Y_SIZE = 225;
    public static final int PLAYER_INVENTORY_X_OFFSET = 18;

    public ConcreteConverterTier8Screen(ConcreteConverterTier8Container screenContainer, Inventory inv,
            Component titleIn)
    {
        super(screenContainer, inv, titleIn, 8, Y_SIZE, PLAYER_INVENTORY_X_OFFSET);
        this.imageWidth += 18 * 2;
    }
}
