package nmd.primal.forgecraft.renders;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderEntityItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.RenderItemFrame;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import nmd.primal.forgecraft.blocks.Firebox;
import nmd.primal.forgecraft.tiles.TileFirebox;
import org.lwjgl.opengl.GL11;
import scala.collection.parallel.ParIterableLike;

/**
 * Created by kitsu on 12/4/2016.
 */
public class TileFireboxRender extends TileEntitySpecialRenderer<TileFirebox>
{
    private RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
    //private EntityItem entItem = null;

    @Override
    public void renderTileEntityAt(TileFirebox tile, double x, double y, double z, float partialTicks, int destroyStage)
    {
        GL11.glPushMatrix();
        GL11.glTranslated(x + 0.5D, y + 0.825D, z + 0.5D);

        Minecraft.getMinecraft().getTextureManager().bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
        float prevLGTX = OpenGlHelper.lastBrightnessX;
        float prevLGTY = OpenGlHelper.lastBrightnessY;
        BlockPos pos = tile.getPos();
        int bright = tile.getWorld().getCombinedLight(pos.up(), 0);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, bright % 65536, bright / 65536);

        ItemStack stack1 = tile.getSlotStack(0);

        boolean is_block = stack1.getItem() instanceof ItemBlock;
        float scale = is_block ? 0.1725F : 0.5F;
        double xTrans = is_block ? -1.6D : -0.45D;
        double yTrans = is_block ? -1.26D : -0.25D;

        if (!stack1.isEmpty()) {
            int stackRotation = stack1.getCount();
            for(int i = 0; i < Math.ceil(stackRotation/8) + 1; i++){
                GL11.glPushMatrix();
                GL11.glScalef(scale, scale, scale);
                GL11.glRotated(45.0F * i, 0.0F, 1.0F, 0.0F);
                GL11.glTranslated(xTrans, yTrans, 0.0D);
                renderItem.renderItem(stack1, renderItem.getItemModelMesher().getItemModel(stack1));
                GL11.glPopMatrix();
            }
        }

        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, prevLGTX, prevLGTY);
        GL11.glPopMatrix();
    }
}