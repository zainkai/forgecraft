package com.kitsu.medievalcraft.tileents.ingots;

public class TileMyIronIngot extends TileIngotBase{

	private static String nameCustom = "tileMyIronIngot";
	
	public TileMyIronIngot() {
		super(nameCustom);
		this.hits = 0;
		this.hot = false;
		this.coolTicks = 100;
		this.heatTicks = 100;
	}

}
