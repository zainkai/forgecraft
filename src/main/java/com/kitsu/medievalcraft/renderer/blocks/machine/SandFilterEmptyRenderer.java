/*
package com.kitsu.medievalcraft.renderer.blocks.machine;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import com.kitsu.medievalcraft.block.ModBlocks;
import com.kitsu.medievalcraft.tileents.machine.ModelSandFilter;
import com.kitsu.medievalcraft.tileents.machine.TileEntitySandFilterEmpty;

import cpw.mods.fml.client.FMLClientHandler;

public class SandFilterEmptyRenderer extends TileEntitySpecialRenderer {
	
	private ModelSandFilter model;
	public static boolean render;
	
	public SandFilterEmptyRenderer () {
		model = new ModelSandFilter();
	}

	@Override
	public void renderTileEntityAt(TileEntity tileEnt, double x, double y, double z, float scale) {
		World world = tileEnt.getWorldObj();
		GL11.glPushMatrix();

		GL11.glTranslatef((float) x, (float) y, (float) z);
		TileEntitySandFilterEmpty tileEntityBlock = (TileEntitySandFilterEmpty) world.getTileEntity((int) x, (int) y, (int) z);
		FMLClientHandler.instance().getClient().renderEngine.bindTexture(ModelSandFilter.TEXTUREEMPTY);
		//FMLClientHandler.instance().getClient().renderEngine.bindTexture(SandFilterTexture.filterText.get(renderInt));
		
		renderBlock(tileEntityBlock, tileEnt.getWorldObj(), tileEnt.xCoord, tileEnt.yCoord, tileEnt.zCoord, ModBlocks.sandFilterEmpty);
		GL11.glPopMatrix();
	}
	
	@SuppressWarnings({"cast"})
	public void renderBlock(TileEntitySandFilterEmpty tileSand, World world, int x, int y,int z, Block block) {
		tileSand = (TileEntitySandFilterEmpty) world.getTileEntity(x, y, z);
		Tessellator tessellator = Tessellator.instance;

		float f = block.getLightOpacity(world, x, y, z);
		int l = world.getLightBrightnessForSkyBlocks(x, y, z, 0);
		int l1 = l % 65536;
		int l2 = l / 65536;
		tessellator.setColorOpaque_F(f, f, f);
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit,(float) l1, (float) l2);
		
		GL11.glPushMatrix();

		float scale = 0.8F;
		GL11.glScalef(scale, scale-0.05F, scale);
		GL11.glTranslatef(0.62F,0.58F,0.62F);
		
		//ResourceLocation TEXTUREGET = new ResourceLocation(tileSand.getTexture(world, x, y, z));
		//ResourceLocation TEXTURE = new ResourceLocation("kitsumedievalcraft:models/SandFilter.png");
		//ResourceLocation TEXTUREEMPTY = new ResourceLocation("kitsumedievalcraft:models/SandFilterEmpty.png");
		
		//if (render == false){
			//FMLClientHandler.instance().getClient().renderEngine.bindTexture(TEXTUREGET);
		//}
		//if (render == true){
		FMLClientHandler.instance().getClient().renderEngine.bindTexture(ModelSandFilter.TEXTUREEMPTY);
		//}
		//FMLClientHandler.instance().getClient().renderEngine.bindTexture(ModelSandFilter.TEXTURE);
		//FMLClientHandler.instance().getClient().renderEngine.bindTexture(tileSand.getTexture(world, x, y, z));
		
		this.model.render();
		GL11.glPopMatrix();
	}

}
*/