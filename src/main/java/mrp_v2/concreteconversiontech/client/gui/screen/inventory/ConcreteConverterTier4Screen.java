package mrp_v2.concreteconversiontech.client.gui.screen.inventory;

import mrp_v2.concreteconversiontech.common.inventory.container.ConcreteConverterTier4Container;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.text.ITextComponent;

public class ConcreteConverterTier4Screen extends AbstractConcreteConverterScreen<ConcreteConverterTier4Container> {

	public static final int Y_SIZE = 167;

	protected ConcreteConverterTier4Screen(ConcreteConverterTier4Container screenContainer, PlayerInventory inv,
			ITextComponent titleIn) {
		super(screenContainer, inv, titleIn, 4, Y_SIZE);
	}
}
