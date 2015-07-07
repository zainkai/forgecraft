package com.kitsu.medievalcraft.tileents.ingots;

public class TileMyIronIngot extends TileIngotBase{

	private static String nameCustom = "tileMyIronIngot";
	
	public TileMyIronIngot() {
		super(nameCustom);
		this.hits = 0;
		this.hot = false;
		this.heatBase = 50;
		this.heatTicks = 50;
		this.coolBase = 50;
	}

}
