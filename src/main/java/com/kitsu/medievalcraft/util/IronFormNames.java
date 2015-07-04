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
		put(ModItems.ironDaggerForm, new ItemStack(ModItems.irondaggerBlade, 1));
		put(ModItems.ironHandleForm, new ItemStack(ModItems.ironweaponHandle, 1));
		put(ModItems.ironHoeForm, new ItemStack(ModItems.ironhoeHead, 1));
		put(ModItems.ironLongswordForm, new ItemStack(ModItems.ironlongswordBlade, 1));
		put(ModItems.ironMaceHeadForm, new ItemStack(ModItems.ironmaceHead, 1));
		put(ModItems.ironPickaxeForm, new ItemStack(ModItems.ironpickaxeHead, 1));
		put(ModItems.ironRingForm, new ItemStack(ModItems.ironRing, 1));
		put(ModItems.ironSawBladeForm, new ItemStack(ModItems.ironsawBlade, 1));
		put(ModItems.ironSharpTipForm, new ItemStack(ModItems.ironsharpTip, 1));
		put(ModItems.ironShortSwordForm, new ItemStack(ModItems.ironshortswordBlade, 1));
		put(ModItems.ironSpadForm, new ItemStack(ModItems.ironspadeHead, 1));
		put(ModItems.ironSpearTipForm, new ItemStack(ModItems.ironspearTip, 1));
		
	}};
	
}
