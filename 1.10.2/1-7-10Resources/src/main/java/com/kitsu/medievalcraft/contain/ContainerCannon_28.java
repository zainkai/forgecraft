package com.kitsu.medievalcraft.contain;

import com.kitsu.medievalcraft.tileents.cannon.TileCannon_28;
import com.kitsu.medievalcraft.tileents.machine.TileForge;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerCannon_28 extends Container {

	protected TileCannon_28 tileEnt;

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return tileEnt.isUseableByPlayer(player);
	}

	public ContainerCannon_28 (InventoryPlayer inventoryPlayer, TileCannon_28 te){
		tileEnt = te;

		//the Slot constructor takes the IInventory and the slot number in that it binds to
		//and the x-y coordinates it resides on-screen
		/* for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                        addSlotToContainer(new Slot(tileEnt, j + i * 3, 62 + j * 18, 17 + i * 18));
               }
        }*/
		addSlotToContainer(new Slot(tileEnt, 0, 30, 34));
		addSlotToContainer(new Slot(tileEnt, 1, 48, 34));
		//commonly used vanilla code that adds the player's inventory
		bindPlayerInventory(inventoryPlayer);
	}

	protected void bindPlayerInventory(InventoryPlayer inventoryPlayer) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 9; j++) {
				addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9,
						8 + j * 18, 84 + i * 18));
			}
		}

		for (int i = 0; i < 9; i++) {
			addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 142));
		}
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int slot) {
		ItemStack stack = null;
		Slot slotObject = (Slot) inventorySlots.get(slot);

		//null checks and checks if the item can be stacked (maxStackSize > 1)
		/*if (slotObject != null && slotObject.getHasStack()) {
			ItemStack stackInSlot = slotObject.getStack();
			stack = stackInSlot.copy();

			//merges the item into player inventory since its in the tileEntity
			if (slot < 9) {
				if (!this.mergeItemStack(stackInSlot, 9, this.inventorySlots.size(), true)) {
					return null;
				}
			}
			//places it into the tileEntity is possible since its in the player inventory
			else if (!this.mergeItemStack(stackInSlot, 0, 9, false)) {
				return null;
			}

			if (stackInSlot.stackSize == 0) {
				slotObject.putStack((ItemStack)null);
			} else {
				slotObject.onSlotChanged();
			}

		}*/
		return stack;
	}

}