package com.kitsu.medievalcraft.tileents.ingots;

public class TileDamascus extends TileIngotBase{

	private static String nameCustom = "tileDamascus";
	
	public TileDamascus() {
		super(nameCustom);
		this.hits = 0;
		this.hot = false;
		this.coolTicks = 100;
		this.heatTicks = 100;
	}

}
