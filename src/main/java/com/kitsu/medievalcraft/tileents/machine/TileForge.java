package com.kitsu.medievalcraft.tileents.machine;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.kitsu.medievalcraft.block.ModBlocks;

public class TileForge extends TileEntity implements IInventory{
	private String tileForgeName;
	private ItemStack[] inv;
	private NBTTagCompound tag = new NBTTagCompound();
	public int heat;
	public boolean isOn;

	public TileForge(){
		this.inv = new ItemStack[2];
	}

	@Override
	public int getSizeInventory() {
		return this.inv.length;
	}
	@Override
	public ItemStack getStackInSlot(int slot) {
		return this.inv[slot];
	}

	@Override
	public ItemStack decrStackSize(int p_70298_1_, int p_70298_2_)
	{
		if (this.inv[p_70298_1_] != null)
		{
			ItemStack itemstack;

			if (this.inv[p_70298_1_].stackSize <= p_70298_2_)
			{
				itemstack = this.inv[p_70298_1_];
				this.inv[p_70298_1_] = null;
				this.markForUpdate();
				this.markDirty();
				return itemstack;
			}
			itemstack = this.inv[p_70298_1_].splitStack(p_70298_2_);

			if (this.inv[p_70298_1_].stackSize == 0)
			{
				this.inv[p_70298_1_] = null;
			}
			this.markForUpdate();
			this.markDirty();
			return itemstack;
		}
		this.markForUpdate();
		this.markDirty();
		return null;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i)
	{
		if (this.inv[i] != null)
		{
			ItemStack itemstack = this.inv[i];
			this.inv[i] = null;
			this.markForUpdate();
			this.markDirty();
			return itemstack;
		}
		else
		{
			this.markForUpdate();
			this.markDirty();
			return null;
		}
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack stack)
	{
		this.inv[slot] = stack;

		if (stack != null && stack.stackSize > this.getInventoryStackLimit())
		{
			stack.stackSize = this.getInventoryStackLimit();
		}
		this.markForUpdate();
		this.markDirty();
	}

	@Override
	public String getInventoryName() {
		return this.hasCustomInventoryName() ? this.tileForgeName : "Forge";
	}

	@Override
	public boolean hasCustomInventoryName() {
		return this.tileForgeName != null && this.tileForgeName.length() > 0;
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : player.getDistanceSq(this.xCoord + 0.5D, this.yCoord + 0.5D, this.zCoord + 0.5D) <= 64.0D;
	}

	@Override
	public void openInventory() {}
	@Override
	public void closeInventory() {}

	@Override
	public boolean isItemValidForSlot(int par1, ItemStack itemstack) {
		return false;
	}

	public void markForUpdate(){
		worldObj.markBlockForUpdate(this.xCoord, this.yCoord, this.zCoord);
	}

	@Override
	public void readFromNBT(NBTTagCompound tagCompound) {
		super.readFromNBT(tagCompound);
		NBTTagList tagList = tagCompound.getTagList("Inventory", 10);
		this.inv = new ItemStack[this.getSizeInventory()];
		for (int i = 0; i < tagList.tagCount(); i++) {
			NBTTagCompound tag = tagList.getCompoundTagAt(i);
			byte slot = tag.getByte("Slot");
			if (slot >= 0 && slot < this.inv.length) {
				this.inv[slot] = ItemStack.loadItemStackFromNBT(tag);
			}
		}
		if (tagCompound.hasKey("CustomName", 8)) {
			this.tileForgeName = tagCompound.getString("CustomName");
		}
		//this.stack0 = tagCompound.getString("stack0");
		this.heat = tag.getInteger("HEAT");
		this.isOn = tag.getBoolean("ISCOAL");

	}

	@Override
	public void writeToNBT(NBTTagCompound tagCompound) {
		super.writeToNBT(tagCompound);

		NBTTagList itemList = new NBTTagList();
		for (int i = 0; i < inv.length; i++) {
			//ItemStack stack = inv[i];
			if (inv[i] != null) {
				NBTTagCompound tag = new NBTTagCompound();
				tag.setByte("Slot", (byte) i);
				this.inv[i].writeToNBT(tag);
				itemList.appendTag(tag);
			}
		}
		tagCompound.setTag("Inventory", itemList);
		tag.setInteger("HEAT", this.heat);
		tag.setBoolean("ISCOAL", this.isOn);
	}
	@Override
	public Packet getDescriptionPacket() {
		NBTTagCompound tag = new NBTTagCompound();
		this.writeToNBT(tag);
		return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 998, tag);
	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
		readFromNBT(pkt.func_148857_g());
		worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
	}

	@Override
	public void updateEntity() {

		World world = getWorldObj();
		int x = this.xCoord;
		int y = this.yCoord;
		int z = this.zCoord;
		if(!world.isRemote){
			if(!world.isRemote){
	
			}
			/*if(world.getBlock(x, y+1, z).equals(Blocks.air)||this.getStackInSlot(0)==null){
				this.isOn = false;
			}
			if((this.getStackInSlot(0)==null)&&(world.getBlock(x, y+1, z).equals(Blocks.fire))){
				world.setBlock(x, y+1, z, Blocks.air, 0, 2);
				this.isOn=false;
			}
			if(this.isOn==true && world.getBlock(x, y+1, z).equals(Blocks.air)){
				world.setBlock(x, y+1, z, Blocks.fire, 0, 2);
			}
			if(world.getBlock(x, y+1, z).equals(Blocks.fire)){
				this.isOn = true;
			}
			 */
			//fireboxFuelDec(world, x, y, z, this.getStackInSlot(0), this.ticks);
			//isFurnace(world, x, y, z);
			//isCrucible(world, x, y, z);
			//isIngot(world, x, y, z);
		}
		if (worldObj.isRemote) return;
	}

}





