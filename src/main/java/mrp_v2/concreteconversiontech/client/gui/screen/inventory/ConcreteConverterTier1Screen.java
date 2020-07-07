package mrp_v2.concreteconversiontech.client.gui.screen.inventory;

import mrp_v2.concreteconversiontech.common.inventory.container.ConcreteConverterTier1Container;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ConcreteConverterTier1Screen extends AbstractConcreteConverterScreen<ConcreteConverterTier1Container> {

	private static final ResourceLocation GUI_TEXTURE = new ResourceLocation("concreteconversiontech",
			"textures/gui/container/concrete_converter_tier_1.png");

	public ConcreteConverterTier1Screen(ConcreteConverterTier1Container screenContainer, PlayerInventory inv,
			ITextComponent titleIn) {
		super(screenContainer, inv, titleIn, GUI_TEXTURE);
	}
}
