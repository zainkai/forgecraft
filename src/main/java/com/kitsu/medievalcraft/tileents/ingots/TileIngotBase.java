package com.kitsu.medievalcraft.tileents.ingots;

import com.kitsu.medievalcraft.block.ModBlocks;

import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileIngotBase extends TileEntity {
	
	private String specName;
	public int hits = 0;
	public int coolTicks = 100;
	public int heatTicks = 100;
	public boolean hot;

	public TileIngotBase(String name){
		specName = name;
	}
	
	public void markForUpdate(){
		worldObj.markBlockForUpdate(this.xCoord, this.yCoord, this.zCoord);
	}
	
	@Override
	public void updateEntity() {
		World world = this.getWorldObj();
		int x = this.xCoord;
		int y = this.yCoord;
		int z = this.zCoord;
		if(!world.isRemote){
			if(this.heatTicks<=0){
				world.setBlockMetadataWithNotify(x, y, z, 1, 2);
			}
			if(this.coolTicks<=0){
				world.setBlockMetadataWithNotify(x, y, z, 0, 2);
			}
			coolDown(world, x, y, z);
			//System.out.println(this.hot);
		}

	}
	
	private void coolDown(World world, int x, int y, int z){
		if(!world.isRemote){
			if((world.getBlock(x, y-1, z)!=ModBlocks.firebox)&&(this.hot==true)){
				coolTicks--;
				if(coolTicks <= 0){
					this.hot=false;
					this.coolTicks=100;
					this.heatTicks=100;
					this.markForUpdate();
					this.markDirty();
				}
			}
		}
	}

	@Override
	public void readFromNBT(NBTTagCompound tagCompound)
	{
		super.readFromNBT(tagCompound);
		this.hits = tagCompound.getInteger("HITS");
		this.coolTicks = tagCompound.getInteger("COOLTICK");
		this.heatTicks = tagCompound.getInteger("HEATTICKS");
		this.hot = tagCompound.getBoolean("HOT");
	}

	@Override
	public void writeToNBT(NBTTagCompound tagCompound)
	{
		super.writeToNBT(tagCompound);
		tagCompound.setInteger("HITS", this.hits);
		tagCompound.setInteger("COOLTICK", this.coolTicks);
		tagCompound.setInteger("HEATTICKS", this.heatTicks);
		tagCompound.setBoolean("HOT", this.hot);
	}

	@Override
	public Packet getDescriptionPacket() {
		NBTTagCompound nbt = new NBTTagCompound();
		writeToNBT(nbt);
		return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, -998, nbt);
	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
		readFromNBT(pkt.func_148857_g());
		worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
	}

}