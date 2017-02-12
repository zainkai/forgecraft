package nmd.primal.forgecraft.renders;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import nmd.primal.forgecraft.tiles.TileForge;
import org.lwjgl.opengl.GL11;

/**
 * Created by kitsu on 12/4/2016.
 */
public class TileForgeRender extends TileEntitySpecialRenderer<TileForge>
{
    private RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();

    @Override
    public void renderTileEntityAt(TileForge tile, double x, double y, double z, float partialTicks, int destroyStage)
    {
        GL11.glPushMatrix();
        GL11.glTranslated(x + 0.5D, y + 0.95D, z + 0.5D);
        //GL11.glRotatef(90.0F, 0.0F, 0.0F, 1.0F);
        Minecraft.getMinecraft().getTextureManager().bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
        float prevLGTX = OpenGlHelper.lastBrightnessX;
        float prevLGTY = OpenGlHelper.lastBrightnessY;
        BlockPos pos = tile.getPos();
        int bright = tile.getWorld().getCombinedLight(pos.up(), 0);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, bright % 65536, bright / 65536);

        ItemStack stack1 = tile.getSlotStack(0);

        boolean is_block = stack1.getItem() instanceof ItemBlock;
        float scale = is_block ? 0.1725F : 0.3F;
        double xTrans = is_block ? -1.6D : -0.45D;
        double yTrans = is_block ? -1.26D : 0.75D;

        if (!stack1.isEmpty()) {
            int stackRotation = stack1.getCount();
            GL11.glPushMatrix();
            GL11.glScalef(scale, scale, scale);
            GL11.glRotated(90.0F, 1.0F, 0.0F, 0.0F);
            renderItem.renderItem(stack1, renderItem.getItemModelMesher().getItemModel(stack1));
            GL11.glPopMatrix();
            for(int i = 0; i < Math.ceil(stackRotation/8) + 1; i++){
                GL11.glPushMatrix();
                GL11.glScalef(scale, scale, scale);
                GL11.glRotated(45.0F * i, 0.0F, 1.0F, 0.0F);
                GL11.glRotated(90.0F, 1.0F, 0.0F, 0.0F);
                GL11.glTranslated(xTrans, yTrans, 0.0D);
                renderItem.renderItem(stack1, renderItem.getItemModelMesher().getItemModel(stack1));
                GL11.glPopMatrix();
            }
        }

        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, prevLGTX, prevLGTY);
        GL11.glPopMatrix();
    }
}