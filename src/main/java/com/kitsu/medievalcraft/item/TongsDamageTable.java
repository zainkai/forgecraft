package com.kitsu.medievalcraft.item;

import java.util.Hashtable;

import com.kitsu.medievalcraft.block.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class TongsDamageTable {

public static final Hashtable<Block, Integer> blockToStore = new Hashtable <Block, Integer>(){{
		
		put(ModBlocks.crucibleIronOre, 1);
		put(ModBlocks.crucibleIronIngot, 2);
		put(ModBlocks.crucibleLapis, 3);
		put(ModBlocks.crucibleRedstone, 4);
		put(ModBlocks.crucibleWootz, 5);
		//put(ModBlocks.lapisIngot, 6);
		//put(ModBlocks.redstoneIngot, 7);
		//put(ModBlocks.damascusIngot, 8);
		//put(ModBlocks.myIronIngot, 9);
		//put(ModBlocks.hotIronBlock, 10);
		//put(ModBlocks.hotDamascusIngot, 11);
		//put(ModBlocks.hotIronPlate, 12);
		//put(ModBlocks.hotLapisIngot, 13);
		//put(ModBlocks.hotRedstoneIngot, 14);
	}};
	
public static final Hashtable<Integer, Block> blockToGet = new Hashtable <Integer, Block>(){{
		
		put(1, ModBlocks.crucibleIronOre);
		put(2, ModBlocks.crucibleIronIngot);
		put(3, ModBlocks.crucibleLapis);
		put(4, ModBlocks.crucibleRedstone);
		put(5, ModBlocks.crucibleWootz);
		//put(6, ModBlocks.lapisIngot);
		//put(7, ModBlocks.redstoneIngot);
		//put(8, ModBlocks.damascusIngot);
		//put(9, ModBlocks.myIronIngot);
		//put(10, ModBlocks.hotIronBlock);
		//put(11, ModBlocks.hotDamascusIngot);
		//put(12, ModBlocks.hotIronPlate);
		//put(13, ModBlocks.hotLapisIngot);
		//put(14, ModBlocks.hotRedstoneIngot);
	}};
}
