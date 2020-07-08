package mrp_v2.concreteconversiontech.client.gui.screen.inventory;

import mrp_v2.concreteconversiontech.common.inventory.container.ConcreteConverterTier3Container;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.text.ITextComponent;

public class ConcreteConverterTier3Screen extends AbstractConcreteConverterScreen<ConcreteConverterTier3Container> {

	public static final int Y_SIZE = 149;

	protected ConcreteConverterTier3Screen(ConcreteConverterTier3Container screenContainer, PlayerInventory inv,
			ITextComponent titleIn) {
		super(screenContainer, inv, titleIn, 3, Y_SIZE);
	}
}
