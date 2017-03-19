package nmd.primal.forgecraft;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import nmd.primal.core.api.PrimalBlocks;
import nmd.primal.core.api.PrimalItems;
import nmd.primal.core.api.PrimalRegistries;
import nmd.primal.core.common.init.ModConfig;
import nmd.primal.forgecraft.init.ModItems;
import nmd.primal.forgecraft.items.toolparts.ToolPart;
import nmd.primal.forgecraft.items.tools.CustomPickaxe;

import javax.annotation.Nonnull;

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
                            if( getDiamondLevel(event.crafting) > 0 ){
                                event.crafting.getItem().setHarvestLevel("Iron", 3);
                            }
                        }
                    }
                }
            }
        }
    }


}
