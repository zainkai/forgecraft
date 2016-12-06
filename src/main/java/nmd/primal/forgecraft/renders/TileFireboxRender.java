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
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureMap;
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

/**
 * Created by kitsu on 12/4/2016.
 */
public class TileFireboxRender extends TileEntitySpecialRenderer<TileFirebox>
{
    private final RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
    private int rotation;
    private float translateX, translateZ;
    private EntityItem entItem = null;

    @Override
    public void renderTileEntityAt(TileFirebox tile, double x, double y, double z, float partialTicks, int destroyStage) {

        GL11.glPushMatrix();
        GL11.glTranslated(x + 0.5D, y + 0.875D, z + 0.5D);
        GL11.glScalef(0.25F, 0.25F, 0.25F);

        World world = tile.getWorld();
        IBlockState state = world.getBlockState(tile.getPos());

        switch(state.getValue(BlockHorizontal.FACING))
        {
            case NORTH:
                rotation = 0;
                //Left and Right
                translateX = 1.5f;
                //Back and Forth
                translateZ = 1.05f;
                break;
            case EAST:
                rotation = 3;
                translateZ = 1.0f;
                translateX = 1.4f;
                break;
            case SOUTH:
                rotation = 2;
                //Left and Right
                translateX = 1.40f;
                //Back and Forth
                translateZ = -0.5f;
                break;
            case WEST:
                rotation = 1;
                //Back and Forth
                translateX = 2.5f;
                //Left and Right
                translateZ = 0.85f;
                break;
        }

        GL11.glTranslatef(-1.5F, -0.0F, -1.0F);

        Minecraft.getMinecraft().getTextureManager().bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
        float prevLGTX = OpenGlHelper.lastBrightnessX;
        float prevLGTY = OpenGlHelper.lastBrightnessY;
        BlockPos pos = tile.getPos();
        int bright = tile.getWorld().getCombinedLight(pos.up(), 0);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, bright % 65536, bright / 65536);

                ItemStack stack = tile.getStackInSlot(0);
                if (stack != null) {
                    ///
                    //  rotate 90 degrees for blocks but not items?
                    ///
                    boolean is_block = stack.getItem() instanceof ItemBlock;
                    float height = -0.855f;

                    float scale = is_block ? 0.9F : 1.8F;
                    int stackSize = stack.stackSize;

                    if(stackSize < 16){
                        GL11.glPushMatrix();
                        GL11.glTranslatef(translateX, height, translateZ);
                        GL11.glScalef(scale, scale, scale);
                        GL11.glRotatef(90.0F * rotation, 0.0F, 1.0F, 0.0F);
                        renderItem.renderItem(stack, renderItem.getItemModelMesher().getItemModel(stack));
                        GL11.glPopMatrix();
                    }
                    if(stackSize > 15 && stackSize < 32){
                        GL11.glPushMatrix();
                        GL11.glTranslatef(translateX, height, translateZ);
                        GL11.glScalef(scale, scale, scale);
                        GL11.glRotatef(90.0F * rotation, 0.0F, 1.0F, 0.0F);
                        renderItem.renderItem(stack, renderItem.getItemModelMesher().getItemModel(stack));
                        GL11.glPopMatrix();

                        GL11.glPushMatrix();
                        GL11.glTranslatef(translateX, height, translateZ);
                        GL11.glScalef(scale, scale, scale);
                        GL11.glRotatef(90.0F * (rotation + 1), 0.0F, 1.0F, 0.0F);
                        renderItem.renderItem(stack, renderItem.getItemModelMesher().getItemModel(stack));
                        GL11.glPopMatrix();
                    }
                    if(stackSize > 31 && stackSize < 48){
                        GL11.glPushMatrix();
                        GL11.glTranslatef(translateX, height, translateZ);
                        GL11.glScalef(scale, scale, scale);
                        GL11.glRotatef(90.0F * rotation, 0.0F, 1.0F, 0.0F);
                        renderItem.renderItem(stack, renderItem.getItemModelMesher().getItemModel(stack));
                        GL11.glPopMatrix();

                        GL11.glPushMatrix();
                        GL11.glTranslatef(translateX, height, translateZ);
                        GL11.glScalef(scale, scale, scale);
                        GL11.glRotatef(90.0F * (rotation + 1), 0.0F, 1.0F, 0.0F);
                        renderItem.renderItem(stack, renderItem.getItemModelMesher().getItemModel(stack));
                        GL11.glPopMatrix();

                        GL11.glPushMatrix();
                        GL11.glTranslatef(translateX, height, translateZ);
                        GL11.glScalef(scale, scale, scale);
                        GL11.glRotatef(90.0F * (rotation + 2), 0.0F, 1.0F, 0.0F);
                        renderItem.renderItem(stack, renderItem.getItemModelMesher().getItemModel(stack));
                        GL11.glPopMatrix();
                    }
                    if(stackSize > 47){
                        GL11.glPushMatrix();
                        GL11.glTranslatef(translateX, height, translateZ);
                        GL11.glScalef(scale, scale, scale);
                        GL11.glRotatef(90.0F * rotation, 0.0F, 1.0F, 0.0F);
                        renderItem.renderItem(stack, renderItem.getItemModelMesher().getItemModel(stack));
                        GL11.glPopMatrix();

                        GL11.glPushMatrix();
                        GL11.glTranslatef(translateX, height, translateZ);
                        GL11.glScalef(scale, scale, scale);
                        GL11.glRotatef(90.0F * (rotation + 1), 0.0F, 1.0F, 0.0F);
                        renderItem.renderItem(stack, renderItem.getItemModelMesher().getItemModel(stack));
                        GL11.glPopMatrix();

                        GL11.glPushMatrix();
                        GL11.glTranslatef(translateX, height, translateZ);
                        GL11.glScalef(scale, scale, scale);
                        GL11.glRotatef(90.0F * (rotation + 2), 0.0F, 1.0F, 0.0F);
                        renderItem.renderItem(stack, renderItem.getItemModelMesher().getItemModel(stack));
                        GL11.glPopMatrix();

                        GL11.glPushMatrix();
                        GL11.glTranslatef(translateX, height, translateZ);
                        GL11.glScalef(scale, scale, scale);
                        GL11.glRotatef(90.0F * (rotation + 3), 0.0F, 1.0F, 0.0F);
                        renderItem.renderItem(stack, renderItem.getItemModelMesher().getItemModel(stack));
                        GL11.glPopMatrix();
                    }




        }
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, prevLGTX, prevLGTY);

        GL11.glPopMatrix();

    }

}
