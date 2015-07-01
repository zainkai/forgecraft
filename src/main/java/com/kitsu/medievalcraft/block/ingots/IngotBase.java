package com.kitsu.medievalcraft.block.ingots;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.kitsu.medievalcraft.Main;
import com.kitsu.medievalcraft.util.CustomTab;

public abstract class IngotBase extends BlockContainer {

	public IngotBase(String unlocalizedName, Material material) {
		super(material);
		this.setBlockName(unlocalizedName);
		this.setBlockTextureName(Main.MODID + ":" + unlocalizedName);
		this.setCreativeTab(CustomTab.MedievalCraftTab);
		this.setHardness(1.0F);
		this.setResistance(1.0F);
		this.setHarvestLevel(null, 0);
		this.setStepSound(soundTypeMetal);
		//xmin, ymin, zmin, 
		//xmax, ymax, zmax
		this.setBlockBounds(0.17F, 0.0F,  0.315F, 
				0.8F,  0.15F, 0.725F);
	}
	
	@Override
	public Item getItemDropped(int metadata, Random random, int fortune) {
		return Item.getItemFromBlock(this);
	}
	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
    public int quantityDropped(Random p_149745_1_)
    {
        return 1;
    }

	private void makeParts(World world, int x, int y, int z){

		world.spawnParticle("lava", x+0.5D, y+0.5D, z+0.5D, 0, 0, 0);
		world.spawnParticle("lava", x+0.5D, y+0.5D, z+0.5D, 0, 0, 0);
		world.spawnParticle("lava", x+0.5D, y+0.5D, z+0.5D, 0, 0, 0);
		world.spawnParticle("lava", x+0.5D, y+0.5D, z+0.5D, 0, 0, 0);
		world.spawnParticle("lava", x+0.5D, y+0.5D, z+0.5D, 0, 0, 0);
		world.spawnParticle("lava", x+0.5D, y+0.5D, z+0.5D, 0, 0, 0);
		world.spawnParticle("lava", x+0.5D, y+0.5D, z+0.5D, 0, 0, 0);
		world.spawnParticle("lava", x+0.5D, y+0.5D, z+0.5D, 0, 0, 0);
		world.spawnParticle("lava", x+0.5D, y+0.5D, z+0.5D, 0, 0, 0);

	}
	
	@Override
	public int getRenderType() {
		return 0;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}
}