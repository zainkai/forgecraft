package com.kitsu.medievalcraft.tileents.crucible.empty;

import com.kitsu.medievalcraft.block.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntityFilledWaterCrucible extends TileEntity {

	private String filledWaterCrucibleName;
	private int cticks;
	NBTTagCompound nbt = new NBTTagCompound();

	public void forgeName(String string){
		this.filledWaterCrucibleName = string;
	}
	private void heat(World world, int x, int y, int z){
		Block testBlock = this.worldObj.getBlock(x, y - 1, z);
		Block fire = this.worldObj.getBlock(x, y-2, z);

		if((!world.isRemote) && (testBlock == Blocks.iron_bars) && (fire == Blocks.fire)){
			cticks++;
			if(cticks >= 500 + world.rand.nextInt(50)){
				world.setBlock(x, y, z, ModBlocks.boilingWaterCrucible, 0, 2);
				//System.out.println("Boiled");
			}
		}
	}

	@Override
	public void readFromNBT(NBTTagCompound tagCompound) {
		super.readFromNBT(tagCompound);
		this.cticks = tagCompound.getInteger("CTICKS");
		if (tagCompound.hasKey("CustomName", 8)) {
			this.filledWaterCrucibleName = tagCompound.getString("CustomName");
		}
	}

	@Override
	public void writeToNBT(NBTTagCompound tagCompound) {
		super.writeToNBT(tagCompound);
		tagCompound.setInteger("CTICKS", cticks);
	}

	@Override
	public void updateEntity() {
		World world = this.getWorldObj();
		int x = this.xCoord;
		int y = this.yCoord;
		int z = this.zCoord;
		if(!world.isRemote){
			heat(world, x, y, z);
		}
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


