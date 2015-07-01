package com.kitsu.medievalcraft.tileents.machine;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityAnvilForge extends TileEntity implements IInventory {

	private String forgeAnvilName;
	public ItemStack[] inv;
	NBTTagCompound tag = new NBTTagCompound();

	public TileEntityAnvilForge(){
		inv = new ItemStack[1];
	}

	public void forgeName(String string){
		this.forgeAnvilName = string;
	}

	@Override
	public int getSizeInventory() {
		return inv.length;
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		return inv[slot];
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int p_70304_1_)
	{
		if (this.inv[p_70304_1_] != null)
		{
			ItemStack itemstack = this.inv[p_70304_1_];
			this.inv[p_70304_1_] = null;
			return itemstack;
		}
		return null;
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack stack)
	{
		this.inv[slot] = stack;

		if (stack != null && stack.stackSize > this.getInventoryStackLimit())
		{
			stack.stackSize = this.getInventoryStackLimit();
		}
		this.markDirty();
	}

	@Override
	public String getInventoryName() {
		return this.hasCustomInventoryName() ? this.forgeAnvilName : "Forge";
	}

	@Override
	public boolean hasCustomInventoryName() {
		return this.forgeAnvilName != null && this.forgeAnvilName.length() > 0;
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
	public boolean isItemValidForSlot(int par1, ItemStack itemstack) {

		return false;
	}
	@Override
	public void readFromNBT(NBTTagCompound tagCompound) {
		super.readFromNBT(tagCompound);

		NBTTagList tagList = tagCompound.getTagList("Inventory", 10);
		for (int i = 0; i < tagList.tagCount(); i++) {
			NBTTagCompound tag = tagList.getCompoundTagAt(i);
			byte slot = tag.getByte("Slot");
			if (slot >= 0 && slot < inv.length) {
				inv[slot] = ItemStack.loadItemStackFromNBT(tag);
			}
		}
		if (tagCompound.hasKey("CustomName", 8)) {
			this.forgeAnvilName = tagCompound.getString("CustomName");
		}
	}

	@Override
	public void writeToNBT(NBTTagCompound tagCompound) {
		super.writeToNBT(tagCompound);

		NBTTagList itemList = new NBTTagList();
		for (int i = 0; i < inv.length; i++) {
			ItemStack stack = inv[i];
			if (stack != null) {
				NBTTagCompound tag = new NBTTagCompound();
				tag.setByte("Slot", (byte) i);
				stack.writeToNBT(tag);
				itemList.appendTag(tag);
			}
		}
		tagCompound.setTag("Inventory", itemList);
	}

	@Override
	public void openInventory() {}

	@Override
	public void closeInventory() {}

	  /**
     * Removes from an inventory slot (first arg) up to a specified number (second arg) of items and returns them in a
     * new stack.
     */
	
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
				return itemstack;
			}
			itemstack = this.inv[p_70298_1_].splitStack(p_70298_2_);

			if (this.inv[p_70298_1_].stackSize == 0)
			{
				this.inv[p_70298_1_] = null;
			}

			return itemstack;
		}
		return null;
	}
	
	@Override
	public Packet getDescriptionPacket() {
		NBTTagCompound tag = new NBTTagCompound();
		writeToNBT(tag);
		return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, -998, tag);
	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
		readFromNBT(pkt.func_148857_g());
		worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
	}
	public void markForUpdate(){
		worldObj.markBlockForUpdate(this.xCoord, this.yCoord, this.zCoord);
	}

}




