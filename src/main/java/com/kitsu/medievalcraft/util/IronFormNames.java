package com.kitsu.medievalcraft.util;

import java.util.Hashtable;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.kitsu.medievalcraft.block.ModBlocks;
import com.kitsu.medievalcraft.item.ModItems;

public interface IronFormNames {

	static final Hashtable<Item, ItemStack> forms = new Hashtable <Item, ItemStack>(){{

		put(ModItems.ironAxeForm, new ItemStack(ModItems.ironaxeHead, 1));
		put(ModItems.ironBattleAxeForm, new ItemStack(ModItems.ironbattleaxeHead, 1));
		put(ModItems.ironDaggerForm, new ItemStack(ModItems.irondaggerBlade, 3));
		put(ModItems.ironHandleForm, new ItemStack(ModItems.ironweaponHandle, 2));
		put(ModItems.ironHoeForm, new ItemStack(ModItems.ironhoeHead, 1));
		put(ModItems.ironLongswordForm, new ItemStack(ModItems.ironlongswordBlade, 1));
		put(ModItems.ironMaceHeadForm, new ItemStack(ModItems.ironmaceHead, 1));
		put(ModItems.ironPickaxeForm, new ItemStack(ModItems.ironpickaxeHead, 1));
		put(ModItems.ironRingForm, new ItemStack(ModItems.ironRing, 9));
		put(ModItems.ironSawBladeForm, new ItemStack(ModItems.ironsawBlade, 1));
		put(ModItems.ironSharpTipForm, new ItemStack(ModItems.ironsharpTip, 9));
		put(ModItems.ironShortSwordForm, new ItemStack(ModItems.ironshortswordBlade, 2));
		put(ModItems.ironSpadForm, new ItemStack(ModItems.ironspadeHead, 1));
		put(ModItems.ironSpearTipForm, new ItemStack(ModItems.ironspearTip, 1));
		
	}};
	
	static final Hashtable<Item, ItemStack> formsClay = new Hashtable <Item, ItemStack>(){{

		put(ModItems.cookedaxeHeadClayForm, new ItemStack(ModItems.ironaxeHead, 1));
		put(ModItems.cookedbattleaxeClayForm, new ItemStack(ModItems.ironbattleaxeHead, 1));
		put(ModItems.cookeddaggerClayForm, new ItemStack(ModItems.irondaggerBlade, 3));
		//put(ModItems., new ItemStack(ModItems.ironweaponHandle, 1));
		put(ModItems.cookedhoeHeadClayForm, new ItemStack(ModItems.ironhoeHead, 1));
		put(ModItems.cookedlongswordClayForm, new ItemStack(ModItems.ironlongswordBlade, 1));
		put(ModItems.cookedmaceheadClayForm, new ItemStack(ModItems.ironmaceHead, 1));
		put(ModItems.cookedpickaxeClayForm, new ItemStack(ModItems.ironpickaxeHead, 1));
		put(ModItems.cookedringClayForm, new ItemStack(ModItems.ironRing, 9));
		put(ModItems.cookedsawbladeClayForm, new ItemStack(ModItems.ironsawBlade, 1));
		put(ModItems.cookedsharptipClayForm, new ItemStack(ModItems.ironsharpTip, 9));
		put(ModItems.cookedshortswordClayForm, new ItemStack(ModItems.ironshortswordBlade, 2));
		put(ModItems.cookedspadeHeadClayForm, new ItemStack(ModItems.ironspadeHead, 1));
		put(ModItems.cookedspeartipClayForm, new ItemStack(ModItems.ironspearTip, 1));
		
	}};
	
}
