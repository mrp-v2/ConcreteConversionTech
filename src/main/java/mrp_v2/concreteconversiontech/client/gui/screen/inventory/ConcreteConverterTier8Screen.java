package mrp_v2.concreteconversiontech.client.gui.screen.inventory;

import mrp_v2.concreteconversiontech.common.inventory.container.ConcreteConverterTier8Container;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ConcreteConverterTier8Screen extends AbstractConcreteConverterScreen<ConcreteConverterTier8Container> {

	public static final int Y_SIZE = 203;
	public static final int PLAYER_INVENTORY_X_OFFSET = 18;

	public ConcreteConverterTier8Screen(ConcreteConverterTier8Container screenContainer, PlayerInventory inv,
			ITextComponent titleIn) {
		super(screenContainer, inv, titleIn, 8, Y_SIZE, PLAYER_INVENTORY_X_OFFSET);
	}
}
