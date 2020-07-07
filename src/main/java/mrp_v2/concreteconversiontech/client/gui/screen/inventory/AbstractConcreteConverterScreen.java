package mrp_v2.concreteconversiontech.client.gui.screen.inventory;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;

import mrp_v2.concreteconversiontech.common.inventory.container.AbstractConcreteConverterContainer;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public abstract class AbstractConcreteConverterScreen<T extends AbstractConcreteConverterContainer>
		extends ContainerScreen<T> {

	private final ResourceLocation guiTexture;

	public AbstractConcreteConverterScreen(T screenContainer, PlayerInventory inv, ITextComponent titleIn,
			ResourceLocation guiTexture) {
		super(screenContainer, inv, titleIn);
		this.guiTexture = guiTexture;
	}

	@Override
	public void func_230430_a_(MatrixStack p_230430_1_, int p_230430_2_, int p_230430_3_, float p_230430_4_) {
		this.func_230446_a_(p_230430_1_);
		super.func_230430_a_(p_230430_1_, p_230430_2_, p_230430_3_, p_230430_4_);
		this.func_230459_a_(p_230430_1_, p_230430_2_, p_230430_3_);
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void func_230450_a_(MatrixStack p_230450_1_, float p_230450_2_, int p_230450_3_, int p_230450_4_) {
		RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.field_230706_i_.getTextureManager().bindTexture(guiTexture);
		int i = (this.field_230708_k_ - this.xSize) / 2;
		int j = (this.field_230709_l_ - this.ySize) / 2;
		this.func_238474_b_(p_230450_1_, i, j, 0, 0, this.xSize, this.ySize);
	}
}
