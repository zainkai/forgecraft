package com.kitsu.medievalcraft.block.ingots;

import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.kitsu.medievalcraft.Main;
import com.kitsu.medievalcraft.renderer.RenderId;
import com.kitsu.medievalcraft.tileents.ingots.TileMyIronIngot;
import com.kitsu.medievalcraft.util.CustomTab;

public class RefinedIron extends IngotBase {

	public RefinedIron(String unlocalizedName, Material material) {
		super(unlocalizedName, material);
		this.setBlockTextureName(Main.MODID + ":" + unlocalizedName);
		this.setCreativeTab(CustomTab.MedievalCraftTab);
		this.setHardness(1.0F);
		this.setResistance(1.0F);
		this.setHarvestLevel("pickaxe", 0);
		this.setStepSound(soundTypeMetal);
		//xmin, ymin, zmin, 
		//xmax, ymax, zmax
		this.setBlockBounds(0.17F, 0.0F,  0.315F, 
				            0.8F, 0.15F, 0.725F);
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		
		return new TileMyIronIngot();
	}
	
	@Override
	public int getRenderType() {
		return RenderId.myironingotID;
	}

}
