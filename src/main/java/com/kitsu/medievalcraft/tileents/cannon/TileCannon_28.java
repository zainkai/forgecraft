package com.kitsu.medievalcraft.tileents.cannon;

import com.kitsu.medievalcraft.block.ModBlocks;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileCannon_28 extends TileEntity implements IInventory, ISidedInventory{

	private String tileCannon_28;
	private ItemStack[] inv;
	private NBTTagCompound tag = new NBTTagCompound();
	private int ticks;
	public boolean isOn;

	public TileCannon_28(){
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
		return this.hasCustomInventoryName() ? this.tileCannon_28 : "tileCannon_28";
	}

	@Override
	public boolean hasCustomInventoryName() {
		return this.tileCannon_28 != null && this.tileCannon_28.length() > 0;
	}

	@Override
	public int getInventoryStackLimit() {
		return 9;
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
	public boolean isItemValidForSlot(int slot, ItemStack itemstack) {
		if(slot == 0 && itemstack.getItem() == Items.gunpowder){
			return true;
		}
		if(slot == 1 && itemstack.getItem() == Item.getItemFromBlock(ModBlocks.cannonBall_28)){
			return true;
		}
		return true;
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
			this.tileCannon_28 = tagCompound.getString("CustomName");
		}

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
			if(this.isOn==true){
				ticks++;
			}
			if(ticks>=100){
				this.isOn=false;
				ticks=0;
			}
		}
		if (worldObj.isRemote) return;
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int p_94128_1_) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean canInsertItem(int p_102007_1_, ItemStack p_102007_2_, int p_102007_3_) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canExtractItem(int p_102008_1_, ItemStack p_102008_2_, int p_102008_3_) {
		// TODO Auto-generated method stub
		return false;
	}




}





