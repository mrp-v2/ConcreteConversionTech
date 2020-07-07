package mrp_v2.concreteconversiontech.client.gui.screen.inventory;

import mrp_v2.concreteconversiontech.common.inventory.container.ConcreteConverterTier2Container;
import mrp_v2.concreteconversiontech.common.util.CCTConstants;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class ConcreteConverterTier2Screen extends AbstractConcreteConverterScreen<ConcreteConverterTier2Container> {

	private static final ResourceLocation GUI_TEXTURE = new ResourceLocation(CCTConstants.MODID,
			"textures/gui/container/concrete_converter_tier_2.png");

	public ConcreteConverterTier2Screen(ConcreteConverterTier2Container screenContainer, PlayerInventory inv,
			ITextComponent titleIn) {
		super(screenContainer, inv, titleIn, GUI_TEXTURE);
	}
}
