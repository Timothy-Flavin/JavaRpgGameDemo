package com.Tim.chrimeria.level.tile;

import com.Tim.chrimeria.graphics.Sprite;

public class TileList {
	public static Tile rock = new RockTile(Sprite.rock);
	public static Tile water = new WaterTile(Sprite.water);
	//public static Tile grass = new GrassTile(Sprite.grass);
	public static Tile voidTile = new voidTile(Sprite.voidSprite);
	public static Tile[] masterList = new Tile[]{
			voidTile,
			//rock,
		new GrassTile(Sprite.grass[0]),
		new GrassTile(Sprite.grass[1]),
		new GrassTile(Sprite.grass[2]),
		new GrassTile(Sprite.grass[3]),
		new GrassTile(Sprite.grass[4]),
		new GrassTile(Sprite.grass[5]),
		new GrassTile(Sprite.grass[6]),
		new GrassTile(Sprite.grass[7]),
		new GrassTile(Sprite.grass[8]),
		
		new GrassTile(Sprite.grass[9]),
		new GrassTile(Sprite.grass[10]),
		new GrassTile(Sprite.grass[11]),
		new GrassTile(Sprite.grass[12]),
		
		new GrassTile(Sprite.grass[13]),
		new GrassTile(Sprite.grass[14]),
		new GrassTile(Sprite.grass[15]),
	//};
	//public static Tile[] tallGrass = new Tile[]{
		new TallGrassTile(Sprite.tallGrass[0]),
		new TallGrassTile(Sprite.tallGrass[1]),
		new TallGrassTile(Sprite.tallGrass[2]),
		new TallGrassTile(Sprite.tallGrass[3]),
		new TallGrassTile(Sprite.tallGrass[4]),
		new TallGrassTile(Sprite.tallGrass[5]),
		new TallGrassTile(Sprite.tallGrass[6]),
		new TallGrassTile(Sprite.tallGrass[7]),
		new TallGrassTile(Sprite.tallGrass[8]),
		
		new TallGrassTile(Sprite.tallGrass[9]),
		new TallGrassTile(Sprite.tallGrass[10]),
		new TallGrassTile(Sprite.tallGrass[11]),
		new TallGrassTile(Sprite.tallGrass[12]),
		new TallGrassTile(Sprite.tallGrass[13]),
	//};

	//public static Tile[] grassToWater = new Tile[]{
		new GrassToWaterTile(Sprite.grassToWater[0], true, false, true, false),
		new GrassToWaterTile(Sprite.grassToWater[1], true, false, false, false),
		new GrassToWaterTile(Sprite.grassToWater[2], true, false, false, true),
		new GrassToWaterTile(Sprite.grassToWater[3], false, false, true, false),
		new GrassToWaterTile(Sprite.grassToWater[4], false, false, false, false),
		new GrassToWaterTile(Sprite.grassToWater[5], false, false, false, true),
		new GrassToWaterTile(Sprite.grassToWater[6], false, true, true, false),
		new GrassToWaterTile(Sprite.grassToWater[7], false, true, false, false),
		new GrassToWaterTile(Sprite.grassToWater[8], false, true, false, true),
		
		new GrassToWaterTile(Sprite.grassToWater[9], false, false, false, false),
		new GrassToWaterTile(Sprite.grassToWater[10], false, false, false, false),
		new GrassToWaterTile(Sprite.grassToWater[11], false, false, false, false),
		new GrassToWaterTile(Sprite.grassToWater[12], false, false, false, false),
	//};
	
	//public static Tile[] cliffs = new Tile[]{
		new CliffsTile(Sprite.cliffs[0], true, true, true, true),
		new CliffsTile(Sprite.cliffs[1], true, true, true, true),
		new CliffsTile(Sprite.cliffs[2], true, true, true, true),
		
		new CliffsTile(Sprite.cliffs[3], true, true, true, true),
		new CliffsTile(Sprite.cliffs[4], true, true, true, true),
		new CliffsTile(Sprite.cliffs[5], true, true, true, true),
		
		new CliffsTile(Sprite.cliffs[6], true, true, true, true),
		new CliffsTile(Sprite.cliffs[7], true, true, true, true),
		new CliffsTile(Sprite.cliffs[8], true, true, true, true),
		
		new CliffsTile(Sprite.cliffs[9], true, false, true, false),
		new CliffsTile(Sprite.cliffs[10], true, false, false, false),
		new CliffsTile(Sprite.cliffs[11], true, false, false, true),
		
		new CliffsTile(Sprite.cliffs[12], false, false, true, false),
		new CliffsTile(Sprite.cliffs[13], false, false, false, true),
		
		new CliffsTile(Sprite.cliffs[14], false, true, true, false),
		new CliffsTile(Sprite.cliffs[15], false, true, false, true),
		
		new CliffsTile(Sprite.cliffs[16], true, false, true, false),
		new CliffsTile(Sprite.cliffs[17], true, false, false, false),
		new CliffsTile(Sprite.cliffs[18], true, false, false, true),
	//};
	
	//public static Tile[] beach = new Tile[]{
		new SandTile(Sprite.beach[0], true, false, true, false),
		new SandTile(Sprite.beach[1], true, false, false, false),
		new SandTile(Sprite.beach[2], true, false, false, true),
		new SandTile(Sprite.beach[3], false, false, true, false),
		new SandTile(Sprite.beach[4], false, false, false, false),
		new SandTile(Sprite.beach[5], false, false, false, true),
		new SandTile(Sprite.beach[6], false, true, true, false),
		new SandTile(Sprite.beach[7], false, true, false, false),
		new SandTile(Sprite.beach[8], false, true, false, true),
		
		new SandTile(Sprite.beach[9], false, false, false, false),
		new SandTile(Sprite.beach[10], false, false, false, false),
		new SandTile(Sprite.beach[11], false, false, false, false),
		new SandTile(Sprite.beach[12], false, false, false, false),
		
		new SandTile(Sprite.beach[13], false, false, false, false),
		new SandTile(Sprite.beach[14], false, false, false, false),
		new SandTile(Sprite.beach[15], false, false, false, false),
	//};
	
	//public static Tile[] stairs = new Tile[]{
		new StairTile(Sprite.stairs[0]),
		new StairTile(Sprite.stairs[1]),
		new StairTile(Sprite.stairs[2]),
		
		new HouseTile(Sprite.house[0],false,false,false,false),
		new HouseTile(Sprite.house[1],false,false,false,false),
		new HouseTile(Sprite.house[2],true,true,true,true),
		new HouseTile(Sprite.house[3],false,false,false,false),
		
		new HouseTile(Sprite.house[4],false,false,false,false),
		new HouseTile(Sprite.house[5],false,false,false,false),
		new HouseTile(Sprite.house[6],false,false,false,false),
		new HouseTile(Sprite.house[7],true,true,true,true),
		new HouseTile(Sprite.house[8],false,false,false,false),
		new HouseTile(Sprite.house[9],false,true,false,false),
		new HouseTile(Sprite.house[10],false,false,false,false),
		
		new HouseTile(Sprite.house[11],false,false,false,false),
		new HouseTile(Sprite.house[12],false,false,false,false),
		new HouseTile(Sprite.house[13],false,false,false,false),
		new HouseTile(Sprite.house[14],false,false,false,false),
		new HouseTile(Sprite.house[15],true,true,true,true),
		new HouseTile(Sprite.house[16],true,true,true,true),
		new HouseTile(Sprite.house[17],true,true,true,true),
		new HouseTile(Sprite.house[18],false,false,false,false),
		
		new HouseTile(Sprite.house[19],true,true,true,true),
		new HouseTile(Sprite.house[20],false,false,false,false),
		new HouseTile(Sprite.house[21],false,false,false,false),
		
		new RockTile(Sprite.rock),
		new WaterTile(Sprite.water),
		
		new RockTile(Sprite.chest)
	};


}
