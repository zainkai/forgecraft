package nmd.primal.forgecraft.renders.blocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import nmd.primal.forgecraft.blocks.Breaker;
import nmd.primal.forgecraft.init.ModBlocks;
import nmd.primal.forgecraft.init.ModItems;
import nmd.primal.forgecraft.tiles.TileBreaker;
import nmd.primal.forgecraft.tiles.TileForge;
import org.lwjgl.opengl.GL11;

/**
 * Created by mminaie on 4/9/17.
 */
public class TileBreakerRender extends TileEntitySpecialRenderer<TileBreaker>
{
    private RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();

    @Override
    public void renderTileEntityAt(TileBreaker tile, double x, double y, double z, float partialTicks, int destroyStage)
    {
        GL11.glPushMatrix();
        GL11.glTranslated(x + 0.5D, y + 0.95D, z + 0.5D);
        GL11.glScalef(1.0f,1.0f,1.0f);
        Minecraft.getMinecraft().getTextureManager().bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
        float prevLGTX = OpenGlHelper.lastBrightnessX;
        float prevLGTY = OpenGlHelper.lastBrightnessY;
        BlockPos pos = tile.getPos();
        IBlockState state = this.getWorld().getBlockState(pos);
        int bright = tile.getWorld().getCombinedLight(pos.up(), 0);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, bright % 65536, bright / 65536);

        //ItemStack stack0 = tile.getSlotStack(0);

        if(state.getValue(Breaker.FACING) == EnumFacing.NORTH) {
            GL11.glPushMatrix();
            GL11.glRotated(90, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(tile.charge, 0.0f, 0.0f, 1.0f);
            renderItem.renderItem(tile.getSlotStack(0), ItemCameraTransforms.TransformType.FIXED);
            GL11.glPopMatrix();
        }
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, prevLGTX, prevLGTY);
        GL11.glPopMatrix();
    }
}