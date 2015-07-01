package com.kitsu.medievalcraft.compat;

import net.minecraft.item.ItemStack;

import com.kitsu.medievalcraft.block.ModBlocks;
import com.kitsu.medievalcraft.item.ModItems;

import cpw.mods.fml.common.IFuelHandler;

public class FuelHandler implements IFuelHandler
{
    @Override
    public int getBurnTime(ItemStack fuel)
    {
        ItemStack stack = fuel;
        //MagnumOpus.logger.info("fuel handler: " + fuel);

        /** Mod Real Fuel Items **/
        if      ( stack.isItemEqual(new ItemStack(ModItems.itemShit)) ) { return 600; }
        else if ( stack.isItemEqual(new ItemStack(ModBlocks.shitblock)) ) { return 3200; }
        

        /** that is all **/
        else { return 0; }

    }
}