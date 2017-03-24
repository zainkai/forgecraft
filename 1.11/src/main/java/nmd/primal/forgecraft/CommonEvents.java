package nmd.primal.forgecraft;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import nmd.primal.forgecraft.init.ModItems;
import nmd.primal.forgecraft.items.parts.ToolPart;

/**
 * Created by mminaie on 3/15/17.
 */
public class CommonEvents implements ToolNBT{


    @SubscribeEvent(priority= EventPriority.LOWEST, receiveCanceled=true)
    public void onItemCrafted(PlayerEvent.ItemCraftedEvent event) {

        if(!event.player.getEntityWorld().isRemote) {

            if (event.crafting.getItem() == ModItems.ironpickaxe) {
                NBTTagCompound tempTag = new NBTTagCompound();
                for (int i = 0; i < event.craftMatrix.getSizeInventory(); i++) { // Checks all the slots

                    if (event.craftMatrix.getStackInSlot(i) != null) { // If there is an item
                        ItemStack a = event.craftMatrix.getStackInSlot(i); // Gets the item
                        if (a.getItem() instanceof ToolPart) {
                            tempTag = a.getSubCompound("tags").copy();
                            event.crafting.getTagCompound().setTag("tags", tempTag);
                            event.crafting.getItem().updateItemStackNBT(event.crafting.getTagCompound());
                            //if( getDiamondLevel(event.crafting) > 0 ){
                            //    event.crafting.getItem().setHarvestLevel("pickaxe", 3);
                            //}
                        }
                    }
                }
            }
            if (event.crafting.getItem() == ModItems.ironaxe) {
                NBTTagCompound tempTag = new NBTTagCompound();
                for (int i = 0; i < event.craftMatrix.getSizeInventory(); i++) { // Checks all the slots

                    if (event.craftMatrix.getStackInSlot(i) != null) { // If there is an item
                        ItemStack a = event.craftMatrix.getStackInSlot(i); // Gets the item
                        if (a.getItem() instanceof ToolPart) {
                            tempTag = a.getSubCompound("tags").copy();
                            event.crafting.getTagCompound().setTag("tags", tempTag);
                            event.crafting.getItem().updateItemStackNBT(event.crafting.getTagCompound());
                            //if( getDiamondLevel(event.crafting) > 0 ){
                            //    event.crafting.getItem().setHarvestLevel("pickaxe", 3);
                            //}
                        }
                    }
                }
            }
            if (event.crafting.getItem() == ModItems.ironshovel) {
                NBTTagCompound tempTag = new NBTTagCompound();
                for (int i = 0; i < event.craftMatrix.getSizeInventory(); i++) { // Checks all the slots

                    if (event.craftMatrix.getStackInSlot(i) != null) { // If there is an item
                        ItemStack a = event.craftMatrix.getStackInSlot(i); // Gets the item
                        if (a.getItem() instanceof ToolPart) {
                            tempTag = a.getSubCompound("tags").copy();
                            event.crafting.getTagCompound().setTag("tags", tempTag);
                            event.crafting.getItem().updateItemStackNBT(event.crafting.getTagCompound());
                            //if( getDiamondLevel(event.crafting) > 0 ){
                            //    event.crafting.getItem().setHarvestLevel("pickaxe", 3);
                            //}
                        }
                    }
                }
            }
            if (event.crafting.getItem() == ModItems.ironhoe) {
                NBTTagCompound tempTag = new NBTTagCompound();
                for (int i = 0; i < event.craftMatrix.getSizeInventory(); i++) { // Checks all the slots

                    if (event.craftMatrix.getStackInSlot(i) != null) { // If there is an item
                        ItemStack a = event.craftMatrix.getStackInSlot(i); // Gets the item
                        if (a.getItem() instanceof ToolPart) {
                            tempTag = a.getSubCompound("tags").copy();
                            event.crafting.getTagCompound().setTag("tags", tempTag);
                            event.crafting.getItem().updateItemStackNBT(event.crafting.getTagCompound());
                            //if( getDiamondLevel(event.crafting) > 0 ){
                            //    event.crafting.getItem().setHarvestLevel("pickaxe", 3);
                            //}
                        }
                    }
                }
            }
        }
    }


}
