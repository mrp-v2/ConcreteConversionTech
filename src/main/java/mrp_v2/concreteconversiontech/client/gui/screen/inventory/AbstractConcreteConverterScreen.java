package mrp_v2.concreteconversiontech.client.gui.screen.inventory;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import mrp_v2.concreteconversiontech.ConcreteConversionTech;
import mrp_v2.concreteconversiontech.inventory.container.AbstractConcreteConverterContainer;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public abstract class AbstractConcreteConverterScreen<T extends AbstractConcreteConverterContainer>
        extends AbstractContainerScreen<T> {
    private final ResourceLocation guiTexture;

    protected AbstractConcreteConverterScreen(T screenContainer, Inventory inv, Component titleIn, int tier,
                                              int ySize, int playerInventoryXShift) {
        this(screenContainer, inv, titleIn, tier, ySize);
        this.inventoryLabelX += playerInventoryXShift;
    }

    protected AbstractConcreteConverterScreen(T screenContainer, Inventory inv, Component titleIn, int tier,
                                              int ySize) {
        super(screenContainer, inv, titleIn);
        this.guiTexture = new ResourceLocation(ConcreteConversionTech.ID,
                "textures/gui/container/concrete_converter_tier_" + tier + ".png");
        this.passEvents = false;
        this.imageHeight = ySize;
        this.inventoryLabelY = this.imageHeight - 94;
    }

    @Override
    public void render(PoseStack poseStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(poseStack);
        super.render(poseStack, mouseX, mouseY, partialTicks);
        this.renderTooltip(poseStack, mouseX, mouseY);
    }

    @SuppressWarnings("deprecation")
    @Override
    protected void renderBg(PoseStack poseStack, float partialTicks, int x, int y) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, guiTexture);
        int i = (this.width - this.imageWidth) / 2;
        int j = (this.height - this.imageHeight) / 2;
        this.blit(poseStack, i, j, 0, 0, this.imageWidth, this.imageHeight);
    }
}
