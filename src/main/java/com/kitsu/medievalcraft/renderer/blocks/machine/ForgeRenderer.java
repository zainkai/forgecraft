package com.kitsu.medievalcraft.renderer.blocks.machine;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

import com.kitsu.medievalcraft.block.ModBlocks;
import com.kitsu.medievalcraft.tileents.machine.TileEntityFirebox;
import com.kitsu.medievalcraft.tileents.machine.TileForge;

import cpw.mods.fml.client.FMLClientHandler;

public class ForgeRenderer extends TileEntitySpecialRenderer {

	private final Random rand = new Random();
	private double r = rand.nextDouble();
	//public ModelFirebox model;
	EntityItem entItem = null;
	EntityItem entCoal = null;
	//boolean slotStatus;
	public static final ResourceLocation MODEL = new ResourceLocation("kitsumedievalcraft:models/Forge.obj");
	public static final ResourceLocation TEXTURE = new ResourceLocation("kitsumedievalcraft:models/Forge.png");

	IModelCustom model = AdvancedModelLoader.loadModel(MODEL);

	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float scale) {
		TileForge tileEntity = (TileForge)tile;
		GL11.glPushMatrix();

		GL11.glTranslatef((float) x, (float) y, (float) z);

		renderBlock(tileEntity, tile.getWorldObj(), tile.xCoord,tile.yCoord, tile.zCoord, ModBlocks.forge);
		//System.out.println(tileEntity.isCoal);
		//if(tileEntity.isCoal==true){
			//System.out.println("Renderer me plz");
			ItemStack c = new ItemStack(Items.coal, 1 , 1);
			entCoal = new EntityItem(tileEntity.getWorldObj(), x, y, z, c);
			GL11.glPushMatrix();
			this.entCoal.hoverStart = 0.0F;
			RenderItem.renderInFrame = true;
			GL11.glScalef(0.5f, 0.5f, 0.5f);
			GL11.glRotatef(90, 1, 0, 0);
			RenderManager.instance.renderEntityWithPosYaw(entCoal, 1.55D, 1.3D, -0.79D, 0.0F, 0.0F);
			RenderManager.instance.renderEntityWithPosYaw(entCoal, 1.15D, 1.3D, -0.79D, 0.0F, 0.0F);
			RenderManager.instance.renderEntityWithPosYaw(entCoal, 0.75D, 1.3D, -0.79D, 0.0F, 0.0F);
			RenderManager.instance.renderEntityWithPosYaw(entCoal, 0.35D, 1.3D, -0.79D, 0.0F, 0.0F);
			
			RenderManager.instance.renderEntityWithPosYaw(entCoal, 1.35D, 1.0D, -0.79D, 0.0F, 0.0F);
			RenderManager.instance.renderEntityWithPosYaw(entCoal, 0.95D, 1.0D, -0.79D, 0.0F, 0.0F);
			RenderManager.instance.renderEntityWithPosYaw(entCoal, 0.55D, 1.0D, -0.79D, 0.0F, 0.0F);
			
			RenderManager.instance.renderEntityWithPosYaw(entCoal, 1.55D, 0.7D, -0.79D, 0.0F, 0.0F);
			RenderManager.instance.renderEntityWithPosYaw(entCoal, 1.15D, 0.7D, -0.79D, 0.0F, 0.0F);
			RenderManager.instance.renderEntityWithPosYaw(entCoal, 0.75D, 0.7D, -0.79D, 0.0F, 0.0F);
			RenderManager.instance.renderEntityWithPosYaw(entCoal, 0.35D, 0.7D, -0.79D, 0.0F, 0.0F);
			
			RenderManager.instance.renderEntityWithPosYaw(entCoal, 1.35D, 0.4D, -0.79D, 0.0F, 0.0F);
			RenderManager.instance.renderEntityWithPosYaw(entCoal, 0.95D, 0.4D, -0.79D, 0.0F, 0.0F);
			RenderManager.instance.renderEntityWithPosYaw(entCoal, 0.55D, 0.4D, -0.79D, 0.0F, 0.0F);
			
			RenderItem.renderInFrame = false;
			GL11.glPopMatrix();

		//}

		if(tileEntity.getStackInSlot(0) != null){
			entItem = new EntityItem(tileEntity.getWorldObj(), x, y, z, tileEntity.getStackInSlot(0));
			GL11.glPushMatrix();
			this.entItem.hoverStart = 0.0F;
			RenderItem.renderInFrame = true;
			GL11.glScalef(1.0f, 1.0f, 1.0f);
			GL11.glRotatef(10, 0, 1, 0);
			RenderManager.instance.renderEntityWithPosYaw(entItem, 0.4D, 0.325D, 0.6D, 0.0F, 0.0F);
			RenderItem.renderInFrame = false;
			GL11.glPopMatrix();
		}

		tileEntity.markForUpdate();
		tileEntity.markDirty();

		GL11.glPopMatrix();

	}

	public void renderBlock(TileForge tl, World world, int i, int j,int k, Block block) {
		GL11.glPushMatrix();
		//GL11.glRotatef(15F, 0F, 1F, 0F);
		float scale = 0.50f;
		GL11.glScalef(scale, scale, scale);
		GL11.glTranslatef(1.0F, 0.2F, 1.0F);
		int dir = world.getBlockMetadata(i, j, k);
		if(dir == 1){
			//GL11.glTranslatef(-1F, 0F, 1F);
			GL11.glRotated(-90F, 0.0, 1.0F, 0.0F);
		}
		if(dir == 2){
			//GL11.glTranslatef(-2F, 0F, 0F);
			GL11.glRotated(-180F, 0.0, 1.0F, 0.0F);
		}
		if(dir == 3){
			//GL11.glTranslatef(-1F, 0F, -1F);
			GL11.glRotated(90F, 0.0, 1.0F, 0.0F);
		}
		//
		FMLClientHandler.instance().getClient().renderEngine.bindTexture(TEXTURE);

		this.model.renderAll();
		GL11.glPopMatrix();
	}

}