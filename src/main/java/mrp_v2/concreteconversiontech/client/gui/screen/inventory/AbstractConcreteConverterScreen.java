package mrp_v2.concreteconversiontech.client.gui.screen.inventory;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;

import mrp_v2.concreteconversiontech.ConcreteConversionTech;
import mrp_v2.concreteconversiontech.inventory.container.AbstractConcreteConverterContainer;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public abstract class AbstractConcreteConverterScreen<T extends AbstractConcreteConverterContainer>
		extends ContainerScreen<T> {

	private final ResourceLocation guiTexture;

	protected AbstractConcreteConverterScreen(T screenContainer, PlayerInventory inv, ITextComponent titleIn, int tier,
			int ySize) {
		super(screenContainer, inv, titleIn);
		this.guiTexture = new ResourceLocation(ConcreteConversionTech.ID,
				"textures/gui/container/concrete_converter_tier_" + tier + ".png");
		this.passEvents = false;
		this.ySize = ySize;
		this.playerInventoryTitleY = this.ySize - 94;
	}

	protected AbstractConcreteConverterScreen(T screenContainer, PlayerInventory inv, ITextComponent titleIn, int tier,
			int ySize, int playerInventoryXShift) {
		this(screenContainer, inv, titleIn, tier, ySize);
		this.playerInventoryTitleX += playerInventoryXShift;
	}

	@Override
	public void render(MatrixStack p_230430_1_, int p_230430_2_, int p_230430_3_, float p_230430_4_) {
		this.renderBackground(p_230430_1_);
		super.render(p_230430_1_, p_230430_2_, p_230430_3_, p_230430_4_);
		this.func_230459_a_(p_230430_1_, p_230430_2_, p_230430_3_);
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void drawGuiContainerBackgroundLayer(MatrixStack p_230450_1_, float p_230450_2_, int p_230450_3_, int p_230450_4_) {
		RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.minecraft.getTextureManager().bindTexture(guiTexture);
		int i = (this.width - this.xSize) / 2;
		int j = (this.height - this.ySize) / 2;
		this.blit(p_230450_1_, i, j, 0, 0, this.xSize, this.ySize);
	}
}
