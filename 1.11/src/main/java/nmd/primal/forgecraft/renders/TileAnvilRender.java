package nmd.primal.forgecraft.renders;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import nmd.primal.core.api.PrimalItems;
import nmd.primal.forgecraft.blocks.Anvil;
import nmd.primal.forgecraft.init.ModBlocks;
import nmd.primal.forgecraft.init.ModItems;
import nmd.primal.forgecraft.tiles.TileAnvil;
import nmd.primal.forgecraft.tiles.TileBloomery;
import org.lwjgl.opengl.GL11;

/**
 * Created by mminaie on 3/5/17.
 */



public class TileAnvilRender extends TileEntitySpecialRenderer<TileAnvil>
{


    private RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();

    ;

    @Override
    public void renderTileEntityAt(TileAnvil tile, double x, double y, double z, float partialTicks, int destroyStage)
    {
        GL11.glPushMatrix();
        GL11.glTranslated(x, y + 1.5D, z);
        //GL11.glRotatef(90.0F, 0.0F, 0.0F, 1.0F);
        Minecraft.getMinecraft().getTextureManager().bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
        float prevLGTX = OpenGlHelper.lastBrightnessX;
        float prevLGTY = OpenGlHelper.lastBrightnessY;
        BlockPos pos = tile.getPos();
        IBlockState state = this.getWorld().getBlockState(pos);
        int bright = tile.getWorld().getCombinedLight(pos.up(), 0);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, bright % 65536, bright / 65536);

        /*
        NORTH
        SLOT |   X   |  Y
        0    | 2/16  | 2/16
        1    | 5/16  | 2/16
        2    | 8/16  | 2/16
        3    | 11/16 | 2/16
        4    | 14/16 | 2/16
        --------------------
        5    | 2/16  | 5/16
        6    | 5/16  | 5/16
        7    | 8/16  | 5/16
        8    | 11/16 | 5/16
        9    | 14/16 | 5/16
        --------------------
        10   | 2/16  | 8/16
        11   | 5/16  | 8/16
        12   | 8/16  | 8/16
        13   | 11/16 | 8/16
        14   | 14/16 | 8/16
        --------------------
        15   | 2/16  | 11/16
        16   | 5/16  | 11/16
        17   | 8/16  | 11/16
        18   | 11/16 | 11/16
        19   | 14/16 | 11/16
        --------------------
        20   | 2/16  | 14/16
        21   | 5/16  | 14/16
        22   | 8/16  | 14/16
        23   | 11/16 | 14/16
        24   | 14/16 | 14/16
         */

        if(state.getValue(Anvil.FACING) == EnumFacing.NORTH){
            int counter = 0;
            for(int i=0; i < 5; i++){
                for(int a=0; a<5; a++){
                    if(!tile.getSlotStack(counter).isEmpty()){

                        if(tile.getSlotStack(counter).getItem().equals(Items.REDSTONE) ||
                                (tile.getSlotStack(counter).getItem().equals(Items.DYE) && tile.getSlotStack(counter).getItemDamage() == EnumDyeColor.BLUE.getDyeDamage()) ||
                                tile.getSlotStack(counter).getItem().equals(PrimalItems.EMERALD_KNAPP) ||
                                tile.getSlotStack(counter).getItem().equals(PrimalItems.DIAMOND_KNAPP)
                                ){
                            GL11.glPushMatrix();

                            GL11.glTranslated( tile.getNormalX(a), -0.49D, tile.getNormalZ(i) );
                            GL11.glRotated(-90.0F, 1.0F, -0.0F, 0.0F);
                            GL11.glScaled(0.25D, 0.25D, 0.25D);
                            renderItem.renderItem(tile.getSlotStack(counter), ItemCameraTransforms.TransformType.FIXED);
                            GL11.glPopMatrix();
                        }
                        if(tile.getSlotStack(counter).getItem().equals(ModItems.pickaxehead)){
                            GL11.glPushMatrix();
                            double scale = 1.0D;
                            GL11.glScaled(scale, scale, scale);
                            GL11.glTranslated(tile.getNormalX(a), -0.435D, tile.getNormalZ(i));
                            renderItem.renderItem(tile.getSlotStack(counter), ItemCameraTransforms.TransformType.FIXED);
                            GL11.glPopMatrix();
                        }
                        if(tile.getSlotStack(counter).getItem().equals(ModItems.ironaxehead)){
                            GL11.glPushMatrix();
                            double scale = 1.0D;
                            GL11.glScaled(scale, scale, scale);
                            GL11.glTranslated(tile.getNormalX(a), -0.435D, tile.getNormalZ(i));
                            GL11.glRotated(90.0F, 1.0F, 0.0F, 0.0F);
                            renderItem.renderItem(tile.getSlotStack(counter), ItemCameraTransforms.TransformType.FIXED);
                            GL11.glPopMatrix();
                        }
                        if(tile.getSlotStack(counter).getItem().equals(ModItems.ironshovelhead)){
                            GL11.glPushMatrix();
                            double scale = 1.0D;
                            GL11.glScaled(scale, scale, scale);
                            GL11.glTranslated(tile.getNormalX(a), -0.435D, tile.getNormalZ(i));
                            GL11.glRotated(90.0F, 1.0F, 0.0F, 0.0F);
                            renderItem.renderItem(tile.getSlotStack(counter), ItemCameraTransforms.TransformType.FIXED);
                            GL11.glPopMatrix();
                        }
                        if(tile.getSlotStack(counter).getItem().equals(ModItems.ironhoehead)){
                            GL11.glPushMatrix();
                            double scale = 1.0D;
                            GL11.glScaled(scale, scale, scale);
                            GL11.glTranslated(tile.getNormalX(a), -0.435D, tile.getNormalZ(i));
                            GL11.glRotated(180.0F, 1.0F, 0.0F, 0.0F);
                            renderItem.renderItem(tile.getSlotStack(counter), ItemCameraTransforms.TransformType.FIXED);
                            GL11.glPopMatrix();
                        }
                        if(tile.getSlotStack(counter).getItem() == ModItems.ironingotballhot ){
                            GL11.glPushMatrix();
                            double scale = 1.0D;
                            GL11.glScaled(scale, scale, scale);
                            GL11.glTranslated(tile.getNormalX(a), -0.44D, tile.getNormalZ(i));
                            renderItem.renderItem(tile.getSlotStack(counter), ItemCameraTransforms.TransformType.FIXED);
                            GL11.glPopMatrix();
                        }
                        if(tile.getSlotStack(counter).getItem() == ModItems.ironchunkhot){
                            GL11.glPushMatrix();
                            double scale = 1.0D;
                            GL11.glScaled(scale, scale, scale);
                            GL11.glTranslated(tile.getNormalX(a), -0.455D, tile.getNormalZ(i));
                            renderItem.renderItem(tile.getSlotStack(counter), ItemCameraTransforms.TransformType.FIXED);
                            GL11.glPopMatrix();
                        }

                    }
                    counter++;
                }
            }
        }
        if(state.getValue(Anvil.FACING) == EnumFacing.SOUTH){
            int counter = 0;
            for(int i=0; i < 5; i++){
                for(int a=0; a<5; a++){
                    if(!tile.getSlotStack(counter).isEmpty()){

                        if(tile.getSlotStack(counter).getItem().equals(Items.REDSTONE) ||
                                (tile.getSlotStack(counter).getItem().equals(Items.DYE) && tile.getSlotStack(counter).getItemDamage() == EnumDyeColor.BLUE.getDyeDamage()) ||
                                tile.getSlotStack(counter).getItem().equals(PrimalItems.EMERALD_KNAPP) ||
                                tile.getSlotStack(counter).getItem().equals(PrimalItems.DIAMOND_KNAPP)
                                ){
                            GL11.glPushMatrix();
                            GL11.glTranslated( tile.getReverseX(a), -0.49D, tile.getReverseZ(i) );
                            GL11.glRotated(-90.0F, 1.0F, -0.0F, 0.0F);
                            GL11.glScaled(0.25D, 0.25D, 0.25D);
                            renderItem.renderItem(tile.getSlotStack(counter), ItemCameraTransforms.TransformType.FIXED);
                            GL11.glPopMatrix();
                        }
                        if(tile.getSlotStack(counter).getItem().equals(ModItems.pickaxehead)){
                            GL11.glPushMatrix();
                            double scale = 1.0D;
                            GL11.glScaled(scale, scale, scale);
                            GL11.glTranslated( tile.getReverseX(a), -0.435D, tile.getReverseZ(i) );
                            renderItem.renderItem(tile.getSlotStack(counter), ItemCameraTransforms.TransformType.FIXED);
                            GL11.glPopMatrix();
                        }
                        if(tile.getSlotStack(counter).getItem().equals(ModItems.ironaxehead)){
                            GL11.glPushMatrix();
                            double scale = 1.0D;
                            GL11.glScaled(scale, scale, scale);
                            GL11.glTranslated( tile.getReverseX(a), -0.435D, tile.getReverseZ(i) );
                            GL11.glRotated(90.0F, 1.0F, 0.0F, 0.0F);
                            renderItem.renderItem(tile.getSlotStack(counter), ItemCameraTransforms.TransformType.FIXED);
                            GL11.glPopMatrix();
                        }
                        if(tile.getSlotStack(counter).getItem().equals(ModItems.ironshovelhead)){
                            GL11.glPushMatrix();
                            double scale = 1.0D;
                            GL11.glScaled(scale, scale, scale);
                            GL11.glTranslated( tile.getReverseX(a), -0.435D, tile.getReverseZ(i) );
                            GL11.glRotated(90.0F, 1.0F, 0.0F, 0.0F);
                            renderItem.renderItem(tile.getSlotStack(counter), ItemCameraTransforms.TransformType.FIXED);
                            GL11.glPopMatrix();
                        }
                        if(tile.getSlotStack(counter).getItem().equals(ModItems.ironhoehead)){
                            GL11.glPushMatrix();
                            double scale = 1.0D;
                            GL11.glScaled(scale, scale, scale);
                            GL11.glTranslated( tile.getReverseX(a), -0.435D, tile.getReverseZ(i) );
                            GL11.glRotated(180.0F, 1.0F, 0.0F, 0.0F);
                            renderItem.renderItem(tile.getSlotStack(counter), ItemCameraTransforms.TransformType.FIXED);
                            GL11.glPopMatrix();
                        }
                        if(tile.getSlotStack(counter).getItem() == ModItems.ironingotballhot ){
                            GL11.glPushMatrix();
                            double scale = 1.0D;
                            GL11.glScaled(scale, scale, scale);
                            GL11.glTranslated( tile.getReverseX(a), -0.44D, tile.getReverseZ(i) );
                            renderItem.renderItem(tile.getSlotStack(counter), ItemCameraTransforms.TransformType.FIXED);
                            GL11.glPopMatrix();
                        }
                        if(tile.getSlotStack(counter).getItem() == ModItems.ironchunkhot){
                            GL11.glPushMatrix();
                            double scale = 1.0D;
                            GL11.glScaled(scale, scale, scale);
                            GL11.glTranslated( tile.getReverseX(a), -0.455D, tile.getReverseZ(i) );
                            renderItem.renderItem(tile.getSlotStack(counter), ItemCameraTransforms.TransformType.FIXED);
                            GL11.glPopMatrix();
                        }

                    }
                    counter++;
                }
            }
        }
        if(state.getValue(Anvil.FACING) == EnumFacing.WEST){
            int counter = 0;
            for(int a=0; a < 5; a++){
                for(int i=0; i<5; i++){
                    if(!tile.getSlotStack(counter).isEmpty()){

                        if(tile.getSlotStack(counter).getItem().equals(Items.REDSTONE) ||
                                (tile.getSlotStack(counter).getItem().equals(Items.DYE) && tile.getSlotStack(counter).getItemDamage() == EnumDyeColor.BLUE.getDyeDamage()) ||
                                tile.getSlotStack(counter).getItem().equals(PrimalItems.EMERALD_KNAPP) ||
                                tile.getSlotStack(counter).getItem().equals(PrimalItems.DIAMOND_KNAPP)
                                ){
                            GL11.glPushMatrix();
                            GL11.glTranslated( tile.getNormalX(a), -0.49D, tile.getReverseZ(i) );
                            GL11.glRotated(-90.0F, 1.0F, -0.0F, 0.0F);
                            GL11.glScaled(0.25D, 0.25D, 0.25D);
                            GL11.glRotated(-90.0F, 0.0F, 0.0F, 1.0F);
                            renderItem.renderItem(tile.getSlotStack(counter), ItemCameraTransforms.TransformType.FIXED);
                            GL11.glPopMatrix();
                        }
                        if(tile.getSlotStack(counter).getItem().equals(ModItems.pickaxehead)){
                            GL11.glPushMatrix();
                            double scale = 1.0D;
                            GL11.glScaled(scale, scale, scale);
                            GL11.glTranslated( tile.getNormalX(a), -0.435D, tile.getReverseZ(i) );
                            GL11.glRotated(-90.0F, 0.0F, 1.0F, 0.0F);
                            renderItem.renderItem(tile.getSlotStack(counter), ItemCameraTransforms.TransformType.FIXED);
                            GL11.glPopMatrix();
                        }
                        if(tile.getSlotStack(counter).getItem().equals(ModItems.ironaxehead)){
                            GL11.glPushMatrix();
                            double scale = 1.0D;
                            GL11.glScaled(scale, scale, scale);
                            GL11.glTranslated( tile.getNormalX(a), -0.435D, tile.getReverseZ(i) );
                            GL11.glRotated(90.0F, 1.0F, 0.0F, 0.0F);
                            renderItem.renderItem(tile.getSlotStack(counter), ItemCameraTransforms.TransformType.FIXED);
                            GL11.glPopMatrix();
                        }
                        if(tile.getSlotStack(counter).getItem().equals(ModItems.ironshovelhead)){
                            GL11.glPushMatrix();
                            double scale = 1.0D;
                            GL11.glScaled(scale, scale, scale);
                            GL11.glTranslated( tile.getNormalX(a), -0.435D, tile.getReverseZ(i) );
                            GL11.glRotated(90.0F, 1.0F, 0.0F, 0.0F);
                            renderItem.renderItem(tile.getSlotStack(counter), ItemCameraTransforms.TransformType.FIXED);
                            GL11.glPopMatrix();
                        }
                        if(tile.getSlotStack(counter).getItem().equals(ModItems.ironhoehead)){
                            GL11.glPushMatrix();
                            double scale = 1.0D;
                            GL11.glScaled(scale, scale, scale);
                            GL11.glTranslated( tile.getNormalX(a), -0.435D, tile.getReverseZ(i) );
                            GL11.glRotated(180.0F, 1.0F, 0.0F, 0.0F);
                            renderItem.renderItem(tile.getSlotStack(counter), ItemCameraTransforms.TransformType.FIXED);
                            GL11.glPopMatrix();
                        }
                        if(tile.getSlotStack(counter).getItem() == ModItems.ironingotballhot ){
                            GL11.glPushMatrix();
                            double scale = 1.0D;
                            GL11.glScaled(scale, scale, scale);
                            GL11.glTranslated( tile.getNormalX(a), -0.44D, tile.getReverseZ(i) );
                            renderItem.renderItem(tile.getSlotStack(counter), ItemCameraTransforms.TransformType.FIXED);
                            GL11.glPopMatrix();
                        }
                        if(tile.getSlotStack(counter).getItem() == ModItems.ironchunkhot){
                            GL11.glPushMatrix();
                            double scale = 1.0D;
                            GL11.glScaled(scale, scale, scale);
                            GL11.glTranslated( tile.getNormalX(a), -0.455D, tile.getReverseZ(i) );
                            renderItem.renderItem(tile.getSlotStack(counter), ItemCameraTransforms.TransformType.FIXED);
                            GL11.glPopMatrix();
                        }

                    }
                    counter++;
                }
            }
        }
        if(state.getValue(Anvil.FACING) == EnumFacing.EAST){
            int counter = 0;
            for(int a=0; a < 5; a++){
                for(int i=0; i<5; i++){
                    if(!tile.getSlotStack(counter).isEmpty()){

                        //GL11.glTranslated( tile.getReverseX(a), 0.0D, tile.getNormalZ(i) );
                        if(tile.getSlotStack(counter).getItem().equals(Items.REDSTONE) ||
                                (tile.getSlotStack(counter).getItem().equals(Items.DYE) && tile.getSlotStack(counter).getItemDamage() == EnumDyeColor.BLUE.getDyeDamage()) ||
                                tile.getSlotStack(counter).getItem().equals(PrimalItems.EMERALD_KNAPP) ||
                                tile.getSlotStack(counter).getItem().equals(PrimalItems.DIAMOND_KNAPP)
                                ){
                            GL11.glPushMatrix();
                            GL11.glTranslated( tile.getReverseX(a), -0.49D, tile.getNormalZ(i) );
                            GL11.glRotated(-90.0F, 1.0F, 0.0F, 0.0F);
                            GL11.glScaled(0.25D, 0.25D, 0.25D);
                            GL11.glRotated(-90.0F, 0.0F, 0.0F, 1.0F);
                            //GL11.glRotated(-90.0F, 1.0F, 0.0F, 0.0F);
                            renderItem.renderItem(tile.getSlotStack(counter), ItemCameraTransforms.TransformType.FIXED);
                            GL11.glPopMatrix();
                        }
                        if(tile.getSlotStack(counter).getItem().equals(ModItems.pickaxehead)){
                            GL11.glPushMatrix();
                            double scale = 1.0D;
                            GL11.glScaled(scale, scale, scale);
                            GL11.glTranslated( tile.getReverseX(a), -0.435D, tile.getNormalZ(i) );
                            GL11.glRotated(-90.0F, 0.0F, 1.0F, 0.0F);
                            renderItem.renderItem(tile.getSlotStack(counter), ItemCameraTransforms.TransformType.FIXED);
                            GL11.glPopMatrix();
                        }
                        if(tile.getSlotStack(counter).getItem().equals(ModItems.ironaxehead)){
                            GL11.glPushMatrix();
                            double scale = 1.0D;
                            GL11.glScaled(scale, scale, scale);
                            GL11.glTranslated( tile.getReverseX(a), -0.435D, tile.getNormalZ(i) );
                            GL11.glRotated(90.0F, 1.0F, 0.0F, 0.0F);
                            renderItem.renderItem(tile.getSlotStack(counter), ItemCameraTransforms.TransformType.FIXED);
                            GL11.glPopMatrix();
                        }
                        if(tile.getSlotStack(counter).getItem().equals(ModItems.ironshovelhead)){
                            GL11.glPushMatrix();
                            double scale = 1.0D;
                            GL11.glScaled(scale, scale, scale);
                            GL11.glTranslated( tile.getReverseX(a), -0.435D, tile.getNormalZ(i) );
                            GL11.glRotated(90.0F, 1.0F, 0.0F, 0.0F);
                            renderItem.renderItem(tile.getSlotStack(counter), ItemCameraTransforms.TransformType.FIXED);
                            GL11.glPopMatrix();
                        }
                        if(tile.getSlotStack(counter).getItem().equals(ModItems.ironhoehead)){
                            GL11.glPushMatrix();
                            double scale = 1.0D;
                            GL11.glScaled(scale, scale, scale);
                            GL11.glTranslated( tile.getReverseX(a), -0.435D, tile.getNormalZ(i) );
                            GL11.glRotated(180.0F, 1.0F, 0.0F, 0.0F);
                            renderItem.renderItem(tile.getSlotStack(counter), ItemCameraTransforms.TransformType.FIXED);
                            GL11.glPopMatrix();
                        }
                        if(tile.getSlotStack(counter).getItem() == ModItems.ironingotballhot ){
                            GL11.glPushMatrix();
                            double scale = 1.0D;
                            GL11.glScaled(scale, scale, scale);
                            GL11.glTranslated( tile.getReverseX(a), -0.44D, tile.getNormalZ(i) );
                            renderItem.renderItem(tile.getSlotStack(counter), ItemCameraTransforms.TransformType.FIXED);
                            GL11.glPopMatrix();
                        }
                        if(tile.getSlotStack(counter).getItem() == ModItems.ironchunkhot){
                            GL11.glPushMatrix();
                            double scale = 1.0D;
                            GL11.glScaled(scale, scale, scale);
                            GL11.glTranslated( tile.getReverseX(a), -0.455D, tile.getNormalZ(i) );
                            renderItem.renderItem(tile.getSlotStack(counter), ItemCameraTransforms.TransformType.FIXED);
                            GL11.glPopMatrix();
                        }

                    }
                    counter++;
                }
            }
        }

        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, prevLGTX, prevLGTY);
        GL11.glPopMatrix();
    }

    private void doRendering(TileAnvil tile, Integer counter, Integer i, Integer a){
        if(tile.getSlotStack(counter).getItem().equals(Items.REDSTONE) ||
                (tile.getSlotStack(counter).getItem().equals(Items.DYE) && tile.getSlotStack(counter).getItemDamage() == EnumDyeColor.BLUE.getDyeDamage()) ||
                tile.getSlotStack(counter).getItem().equals(PrimalItems.EMERALD_KNAPP) ||
                tile.getSlotStack(counter).getItem().equals(PrimalItems.DIAMOND_KNAPP)
                ){
            GL11.glPushMatrix();

            GL11.glTranslated( tile.getNormalX(a), -0.49D, tile.getNormalZ(i) );
            GL11.glRotated(-90.0F, 1.0F, -0.0F, 0.0F);
            GL11.glScaled(0.25D, 0.25D, 0.25D);
            renderItem.renderItem(tile.getSlotStack(counter), ItemCameraTransforms.TransformType.FIXED);
            GL11.glPopMatrix();
        }
        if(tile.getSlotStack(counter).getItem().equals(ModItems.pickaxehead)){
            GL11.glPushMatrix();
            double scale = 1.0D;
            GL11.glScaled(scale, scale, scale);
            GL11.glTranslated(tile.getNormalX(a), -0.435D, tile.getNormalZ(i));
            renderItem.renderItem(tile.getSlotStack(counter), ItemCameraTransforms.TransformType.FIXED);
            GL11.glPopMatrix();
        }
        if(tile.getSlotStack(counter).getItem().equals(ModItems.ironaxehead)){
            GL11.glPushMatrix();
            double scale = 1.0D;
            GL11.glScaled(scale, scale, scale);
            GL11.glTranslated(tile.getNormalX(a), -0.435D, tile.getNormalZ(i));
            GL11.glRotated(90.0F, 1.0F, 0.0F, 0.0F);
            renderItem.renderItem(tile.getSlotStack(counter), ItemCameraTransforms.TransformType.FIXED);
            GL11.glPopMatrix();
        }
        if(tile.getSlotStack(counter).getItem().equals(ModItems.ironshovelhead)){
            GL11.glPushMatrix();
            double scale = 1.0D;
            GL11.glScaled(scale, scale, scale);
            GL11.glTranslated(tile.getNormalX(a), -0.435D, tile.getNormalZ(i));
            GL11.glRotated(90.0F, 1.0F, 0.0F, 0.0F);
            renderItem.renderItem(tile.getSlotStack(counter), ItemCameraTransforms.TransformType.FIXED);
            GL11.glPopMatrix();
        }
        if(tile.getSlotStack(counter).getItem().equals(ModItems.ironhoehead)){
            GL11.glPushMatrix();
            double scale = 1.0D;
            GL11.glScaled(scale, scale, scale);
            GL11.glTranslated(tile.getNormalX(a), -0.435D, tile.getNormalZ(i));
            GL11.glRotated(180.0F, 1.0F, 0.0F, 0.0F);
            renderItem.renderItem(tile.getSlotStack(counter), ItemCameraTransforms.TransformType.FIXED);
            GL11.glPopMatrix();
        }
        if(tile.getSlotStack(counter).getItem() == ModItems.ironingotballhot ){
            GL11.glPushMatrix();
            double scale = 1.0D;
            GL11.glScaled(scale, scale, scale);
            GL11.glTranslated(tile.getNormalX(a), -0.44D, tile.getNormalZ(i));
            renderItem.renderItem(tile.getSlotStack(counter), ItemCameraTransforms.TransformType.FIXED);
            GL11.glPopMatrix();
        }
        if(tile.getSlotStack(counter).getItem() == ModItems.ironchunkhot){
            GL11.glPushMatrix();
            double scale = 1.0D;
            GL11.glScaled(scale, scale, scale);
            GL11.glTranslated(tile.getNormalX(a), -0.455D, tile.getNormalZ(i));
            renderItem.renderItem(tile.getSlotStack(counter), ItemCameraTransforms.TransformType.FIXED);
            GL11.glPopMatrix();
        }
    }

}