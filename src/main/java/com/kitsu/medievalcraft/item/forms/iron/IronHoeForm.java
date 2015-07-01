package com.kitsu.medievalcraft.item.forms.iron;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.kitsu.medievalcraft.Main;
import com.kitsu.medievalcraft.util.CustomTab;

import cpw.mods.fml.common.registry.GameRegistry;

public class IronHoeForm extends Item {
	private String name = "ironHoeForm";
	private Item item;
	
public IronHoeForm() {
		
		setMaxStackSize(1);
		setUnlocalizedName(name);
		setCreativeTab(CustomTab.MedievalCraftTab);
		setTextureName(Main.MODID + ":" + name);
		setMaxDamage(64);
		setNoRepair();
		
		item = this;
		
		GameRegistry.registerItem(this, name);
		
		
	}
	
    @Override
    public boolean doesContainerItemLeaveCraftingGrid(ItemStack itemstack) {

        return false;

    }
    
    @Override
    public Item getContainerItem()
    {
        item.setDamage(new ItemStack(item), +1);
        //itemStack.setItemDamage(itemStack.getItemDamage() + 1);
        return item;
    }

    public boolean getIsRepairable(ItemStack p_82789_1_, ItemStack p_82789_2_)
    {
        return false;
    }

	
}
