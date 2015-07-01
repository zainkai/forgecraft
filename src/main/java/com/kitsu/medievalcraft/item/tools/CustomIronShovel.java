package com.kitsu.medievalcraft.item.tools;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;

import com.kitsu.medievalcraft.Main;
import com.kitsu.medievalcraft.item.ModItems;
import com.kitsu.medievalcraft.util.CustomTab;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CustomIronShovel extends ItemSpade{
	private String name = "customIronShovel";
	private Item item;
	
	public CustomIronShovel(String name, ToolMaterial mat) {
		super(mat);
		item = this;
		setUnlocalizedName(name);
		setCreativeTab(CustomTab.MedievalCraftTab);
		this.toolMaterial = ModItems.customWoodNormal;
		setTextureName(Main.MODID + ":" + name);
		GameRegistry.registerItem(this, name);
	}
	@Override
	public int getItemEnchantability () {
		return 0;
		
	}

    @Override
    public boolean getIsRepairable(ItemStack item, ItemStack repair) {
        return Items.iron_ingot == repair.getItem() ? true : false;
    }
    
	 @SideOnly(Side.CLIENT)
	    public boolean hasEffect(ItemStack par1ItemStack)
	    {
	        return false;
	    }
	

	/*public void onCreated(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {

		//customWoodNormal = EnumHelper.addToolMaterial("WOODNORMAL", 2, 400, 6.5F, 2, 0);
		//customWoodStrong = EnumHelper.addToolMaterial("WOODSTRONG", 3, 500, 7.0F, 2, 0);
		//customWoodWeak = EnumHelper.addToolMaterial("WOODWEAK", 2, 300, 6.0F, 2, 0);
		//customIronToolStrong = EnumHelper.addToolMaterial("IRONSTRONG", 3, 400, 7.0F, 2, 0);
		//customIronToolRodNormal = EnumHelper.addToolMaterial("IRONNORMAL", 2, 300, 7.0F, 2, 0);
		//customIronToolRodWeak = EnumHelper.addToolMaterial("IRONWEAK", 2, 250, 7.0F, 2, 0);

		switch (CraftingHandle.craftflag){

//SILK TOUCH TOOLS
		case 1: CraftingHandle.craftflag = 1;
		par1ItemStack.addEnchantment(Enchantment.silkTouch, 1);
		this.toolMaterial = ModItems.customWoodWeak;
		break;
			
		case 2: CraftingHandle.craftflag = 2;
		par1ItemStack.addEnchantment(Enchantment.silkTouch, 1);
		par1ItemStack.addEnchantment(Enchantment.unbreaking, 1);
		this.toolMaterial = ModItems.customWoodNormal;
		break;
			
		case 3: CraftingHandle.craftflag = 3;
		par1ItemStack.addEnchantment(Enchantment.silkTouch, 1);
		par1ItemStack.addEnchantment(Enchantment.efficiency, 1);
		this.toolMaterial = ModItems.customWoodWeak;
		break;
		
// FULL IRON PICK			
		case 4: CraftingHandle.craftflag = 4;
		par1ItemStack.addEnchantment(Enchantment.silkTouch, 1);
		this.toolMaterial = ModItems.customIronToolRodWeak;
		break;

//UNBREAKING TOOLS
		case 5: CraftingHandle.craftflag = 5;
		par1ItemStack.addEnchantment(Enchantment.unbreaking, 1);
		this.toolMaterial = ModItems.customWoodNormal;
		break;
		
		case 6: CraftingHandle.craftflag = 6;
		par1ItemStack.addEnchantment(Enchantment.unbreaking, 2);
		this.toolMaterial = ModItems.customWoodNormal;
		break;
		
		case 7: CraftingHandle.craftflag = 7;
		par1ItemStack.addEnchantment(Enchantment.unbreaking, 1);
		par1ItemStack.addEnchantment(Enchantment.fortune, 1);
		this.toolMaterial = ModItems.customWoodNormal;
		break;
		
		case 8: CraftingHandle.craftflag = 8;
		par1ItemStack.addEnchantment(Enchantment.unbreaking, 1);
		this.toolMaterial = ModItems.customIronToolRodNormal;
		break;
		
		case 9: CraftingHandle.craftflag = 9;
		par1ItemStack.addEnchantment(Enchantment.unbreaking, 1);
		par1ItemStack.addEnchantment(Enchantment.efficiency, 1);
		this.toolMaterial = ModItems.customIronToolRodWeak;
		break;
		
		case 10: CraftingHandle.craftflag = 10;
		par1ItemStack.addEnchantment(Enchantment.unbreaking, 1);
		par1ItemStack.addEnchantment(Enchantment.fortune, 1);
		this.toolMaterial = ModItems.customIronToolRodWeak;
		break;

		case 11: CraftingHandle.craftflag = 11;
		par1ItemStack.addEnchantment(Enchantment.unbreaking, 2);
		this.toolMaterial = ModItems.customWoodStrong;
		break;
		
		case 12: CraftingHandle.craftflag = 12;
		par1ItemStack.addEnchantment(Enchantment.unbreaking, 3);
		this.toolMaterial = ModItems.customWoodStrong;
		break;
		
		case 13: CraftingHandle.craftflag = 13;
		par1ItemStack.addEnchantment(Enchantment.unbreaking, 2);
		par1ItemStack.addEnchantment(Enchantment.fortune, 1);
		this.toolMaterial = ModItems.customWoodStrong;

		break;
		
		case 14: CraftingHandle.craftflag = 14;
		par1ItemStack.addEnchantment(Enchantment.unbreaking, 2);
		this.toolMaterial = ModItems.customIronToolStrong;
		break;
		
		case 15: CraftingHandle.craftflag = 15;
		par1ItemStack.addEnchantment(Enchantment.unbreaking, 2);
		par1ItemStack.addEnchantment(Enchantment.efficiency, 1);
		this.toolMaterial = ModItems.customIronToolStrong;
		break;
		
		case 16: CraftingHandle.craftflag = 16;
		par1ItemStack.addEnchantment(Enchantment.unbreaking, 2);
		par1ItemStack.addEnchantment(Enchantment.fortune, 1);
		this.toolMaterial = ModItems.customIronToolStrong;
		break;
		
		
		
		
//FORTUNE TOOLS		
		case 17: CraftingHandle.craftflag = 17;
		par1ItemStack.addEnchantment(Enchantment.fortune, 1);
		this.toolMaterial = ModItems.customWoodWeak;
		break;
		
		case 18: CraftingHandle.craftflag = 18;
		par1ItemStack.addEnchantment(Enchantment.fortune, 1);
		par1ItemStack.addEnchantment(Enchantment.unbreaking, 1);
		this.toolMaterial = ModItems.customWoodNormal;
		break;
		
		case 19: CraftingHandle.craftflag = 19;
		par1ItemStack.addEnchantment(Enchantment.fortune, 2);
		this.toolMaterial = ModItems.customWoodWeak;
	
		break;
		
		case 20: CraftingHandle.craftflag = 20;
		par1ItemStack.addEnchantment(Enchantment.fortune, 1);
		this.toolMaterial = ModItems.customIronToolRodWeak;
		break;
		
		case 21: CraftingHandle.craftflag = 21;
		par1ItemStack.addEnchantment(Enchantment.fortune, 1);
		par1ItemStack.addEnchantment(Enchantment.efficiency, 1);
		this.toolMaterial = ModItems.customIronToolRodWeak;
		break;
		
		case 22: CraftingHandle.craftflag = 22;
		par1ItemStack.addEnchantment(Enchantment.fortune, 2);
		this.toolMaterial = ModItems.customIronToolRodWeak;
		break;

		case 23: CraftingHandle.craftflag = 23;
		this.toolMaterial = ModItems.customWoodWeak;
		break;
		
		case 24: CraftingHandle.craftflag = 24;
		par1ItemStack.addEnchantment(Enchantment.fortune, 2);
		par1ItemStack.addEnchantment(Enchantment.unbreaking, 1);
		this.toolMaterial = ModItems.customWoodWeak;
		break;
		
		case 25: CraftingHandle.craftflag = 25;
		par1ItemStack.addEnchantment(Enchantment.fortune, 3);
		this.toolMaterial = ModItems.customWoodWeak;
		break;
		
		case 26: CraftingHandle.craftflag = 26;
		par1ItemStack.addEnchantment(Enchantment.fortune, 2);
		this.toolMaterial = ModItems.customIronToolRodWeak;
		break;
		
		case 27: CraftingHandle.craftflag = 27;
		par1ItemStack.addEnchantment(Enchantment.fortune, 2);
		par1ItemStack.addEnchantment(Enchantment.efficiency, 1);
		this.toolMaterial = ModItems.customIronToolRodWeak;
		break;
		
		case 28: CraftingHandle.craftflag = 28;
		par1ItemStack.addEnchantment(Enchantment.fortune, 3);
		this.toolMaterial = ModItems.customIronToolRodWeak;
		break;
		
// EFFIC TOOLS
		case 29: CraftingHandle.craftflag = 29;
		par1ItemStack.addEnchantment(Enchantment.efficiency, 1);
		this.toolMaterial = ModItems.customWoodWeak;
		break;
				
		case 30: CraftingHandle.craftflag = 30;
		par1ItemStack.addEnchantment(Enchantment.efficiency, 1);
		par1ItemStack.addEnchantment(Enchantment.unbreaking, 1);
		this.toolMaterial = ModItems.customWoodWeak;
		break;
				
		case 31: CraftingHandle.craftflag = 31;
		par1ItemStack.addEnchantment(Enchantment.efficiency, 1);
		par1ItemStack.addEnchantment(Enchantment.fortune, 1);
		this.toolMaterial = ModItems.customWoodWeak;
		break;
				
		case 32: CraftingHandle.craftflag = 32;
		par1ItemStack.addEnchantment(Enchantment.efficiency, 1);
		this.toolMaterial = ModItems.customIronToolRodWeak;
		break;
				
		case 33: CraftingHandle.craftflag = 33;
		par1ItemStack.addEnchantment(Enchantment.efficiency, 2);
		this.toolMaterial = ModItems.customIronToolRodWeak;
		break;
				
		case 34: CraftingHandle.craftflag = 34;
		par1ItemStack.addEnchantment(Enchantment.efficiency, 1);
		par1ItemStack.addEnchantment(Enchantment.fortune, 1);
		this.toolMaterial = ModItems.customIronToolRodWeak;
		break;

		case 35: CraftingHandle.craftflag = 35;
		par1ItemStack.addEnchantment(Enchantment.efficiency, 2);
		this.toolMaterial = ModItems.customWoodWeak;
		break;
				
		case 36: CraftingHandle.craftflag = 36;
		par1ItemStack.addEnchantment(Enchantment.efficiency, 2);
		par1ItemStack.addEnchantment(Enchantment.unbreaking, 1);
		this.toolMaterial = ModItems.customWoodWeak;
		break;
				
		case 37: CraftingHandle.craftflag = 37;
		par1ItemStack.addEnchantment(Enchantment.efficiency, 2);
		par1ItemStack.addEnchantment(Enchantment.fortune, 1);
		this.toolMaterial = ModItems.customWoodWeak;
		break;
				
		case 38: CraftingHandle.craftflag = 38;
		par1ItemStack.addEnchantment(Enchantment.efficiency, 2);
		this.toolMaterial = ModItems.customIronToolRodWeak;
		break;
				
		case 39: CraftingHandle.craftflag = 39;
		par1ItemStack.addEnchantment(Enchantment.efficiency, 3);
		this.toolMaterial = ModItems.customIronToolRodWeak;
		break;
		
		case 40: CraftingHandle.craftflag = 40;
		par1ItemStack.addEnchantment(Enchantment.efficiency, 2);
		par1ItemStack.addEnchantment(Enchantment.fortune, 1);
		this.toolMaterial = ModItems.customIronToolRodWeak;
		break;
		
// EFFIC & FORTUNE HEAD
		case 41: CraftingHandle.craftflag = 41;
		par1ItemStack.addEnchantment(Enchantment.efficiency, 1);
		par1ItemStack.addEnchantment(Enchantment.fortune, 1);
		this.toolMaterial = ModItems.customWoodWeak;
		break;
				
		case 42: CraftingHandle.craftflag = 42;
		par1ItemStack.addEnchantment(Enchantment.efficiency, 1);
		par1ItemStack.addEnchantment(Enchantment.fortune, 1);
		par1ItemStack.addEnchantment(Enchantment.unbreaking, 1);
		this.toolMaterial = ModItems.customWoodWeak;
		break;
				
		case 43: CraftingHandle.craftflag = 43;
		par1ItemStack.addEnchantment(Enchantment.efficiency, 1);
		par1ItemStack.addEnchantment(Enchantment.fortune, 2);
		this.toolMaterial = ModItems.customWoodWeak;
		break;
				
		case 44: CraftingHandle.craftflag = 44;
		par1ItemStack.addEnchantment(Enchantment.efficiency, 1);
		par1ItemStack.addEnchantment(Enchantment.fortune, 1);
		this.toolMaterial = ModItems.customIronToolRodWeak;
		break;
				
		case 45: CraftingHandle.craftflag = 45;
		par1ItemStack.addEnchantment(Enchantment.efficiency, 2);
		par1ItemStack.addEnchantment(Enchantment.fortune, 1);
		this.toolMaterial = ModItems.customIronToolRodWeak;
		break;
		
		case 46: CraftingHandle.craftflag = 46;
		par1ItemStack.addEnchantment(Enchantment.efficiency, 1);
		par1ItemStack.addEnchantment(Enchantment.fortune, 2);
		this.toolMaterial = ModItems.customIronToolRodWeak;
		break;
		
		
		
//UNBREAKING & EFFIC HEAD
		case 47: CraftingHandle.craftflag = 47;
		par1ItemStack.addEnchantment(Enchantment.unbreaking, 1);
		par1ItemStack.addEnchantment(Enchantment.efficiency, 1);
		this.toolMaterial = ModItems.customWoodNormal;
		break;
					
		case 48: CraftingHandle.craftflag = 48;
		par1ItemStack.addEnchantment(Enchantment.unbreaking, 2);
		par1ItemStack.addEnchantment(Enchantment.efficiency, 1);
		this.toolMaterial = ModItems.customWoodNormal;
		break;
					
		case 49: CraftingHandle.craftflag = 49;
		par1ItemStack.addEnchantment(Enchantment.unbreaking, 1);
		par1ItemStack.addEnchantment(Enchantment.efficiency, 1);
		par1ItemStack.addEnchantment(Enchantment.fortune, 1);
		this.toolMaterial = ModItems.customWoodNormal;
		break;
						
		case 50: CraftingHandle.craftflag = 50;
		par1ItemStack.addEnchantment(Enchantment.unbreaking, 1);
		par1ItemStack.addEnchantment(Enchantment.efficiency, 1);
		this.toolMaterial = ModItems.customIronToolRodNormal;
		break;
						
		case 51: CraftingHandle.craftflag = 51;
		par1ItemStack.addEnchantment(Enchantment.unbreaking, 1);
		par1ItemStack.addEnchantment(Enchantment.efficiency, 2);
		this.toolMaterial = ModItems.customIronToolRodWeak;
		break;
				
		case 52: CraftingHandle.craftflag = 52;
		par1ItemStack.addEnchantment(Enchantment.unbreaking, 1);
		par1ItemStack.addEnchantment(Enchantment.efficiency, 1);
		par1ItemStack.addEnchantment(Enchantment.fortune, 1);
		this.toolMaterial = ModItems.customIronToolRodWeak;
		break;
		
		
//UNBREAKING & FORTUNE HEAD
		case 53: CraftingHandle.craftflag = 53;
		par1ItemStack.addEnchantment(Enchantment.unbreaking, 1);
		par1ItemStack.addEnchantment(Enchantment.fortune, 1);
		this.toolMaterial = ModItems.customWoodNormal;
		break;
					
		case 54: CraftingHandle.craftflag = 54;
		par1ItemStack.addEnchantment(Enchantment.unbreaking, 2);
		par1ItemStack.addEnchantment(Enchantment.fortune, 1);
		this.toolMaterial = ModItems.customWoodNormal;
		break;
					
		case 55: CraftingHandle.craftflag = 55;
		par1ItemStack.addEnchantment(Enchantment.unbreaking, 1);
		par1ItemStack.addEnchantment(Enchantment.fortune, 2);
		this.toolMaterial = ModItems.customWoodNormal;
		break;
						
		case 56: CraftingHandle.craftflag = 56;
		par1ItemStack.addEnchantment(Enchantment.unbreaking, 1);
		par1ItemStack.addEnchantment(Enchantment.fortune, 1);
		this.toolMaterial = ModItems.customIronToolRodNormal;
		break;
						
		case 57: CraftingHandle.craftflag = 57;
		par1ItemStack.addEnchantment(Enchantment.unbreaking, 1);
		par1ItemStack.addEnchantment(Enchantment.efficiency, 1);
		par1ItemStack.addEnchantment(Enchantment.fortune, 1);
		this.toolMaterial = ModItems.customIronToolRodWeak;
		break;
				
		case 58: CraftingHandle.craftflag = 58;
		par1ItemStack.addEnchantment(Enchantment.unbreaking, 1);
		par1ItemStack.addEnchantment(Enchantment.fortune, 2);
		this.toolMaterial = ModItems.customIronToolRodWeak;
		break;
		
		}
    }*/
}
