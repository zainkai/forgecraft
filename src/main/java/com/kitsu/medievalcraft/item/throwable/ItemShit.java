package com.kitsu.medievalcraft.item.throwable;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.kitsu.medievalcraft.Main;
import com.kitsu.medievalcraft.entity.EntityShit;
import com.kitsu.medievalcraft.util.CustomTab;

import cpw.mods.fml.common.registry.GameRegistry;

public class ItemShit extends Item {
	
	private String name = "itemShit";
	
	public ItemShit() {
		
		setUnlocalizedName(name);
		setCreativeTab(CustomTab.MedievalCraftTab);
		setTextureName(Main.MODID + ":" + name);
		GameRegistry.registerItem(this, name);
		
	}
	
	   public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	    {

	            --stack.stackSize;


	       world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

	        if (!world.isRemote)
	        {
	            world.spawnEntityInWorld(new EntityShit(world, player));
	        }

	        return stack;
	    }

}
