package com.Tim.chrimeria.level;

import java.util.Random;

import com.Tim.chrimeria.Game;

public class RandomLevel extends Level{

	private static final Random random = new Random();
	
	public RandomLevel(int width, int height, Game game) {
		super(width, height, game);
		spawnPoints = new Spawns[1];
		spawnPoints[0] = new Spawns(width/2, height/2);
		
		arrivalLevel = new int[1];
		arrivalLevel[0] = 0;
		
		arrivalSpawn = new int[]{0};
		name = "randomLevel";
	}
	
	protected void generateLevel(){
		for (int y = 0; y<height; y++){
			for (int x = 0; x < width; x++){
				tilesInt[x+y*width] = random.nextInt(26);
			}
		}
	}
	/*public Tile getTile(int x, int y){
		
		if(x < 0 || y < 0 || x >= width || y >= height){
			return TileList.voidTile;
		}
		//return mapTiles[x+y*width];
		if(tilesInt[x + y * width] < 13){
			//System.out.println(tilesInt[x + y * width]);
			return TileList.grass[tilesInt[x + y * width]];
		}
		if(tilesInt[x + y * width] < 26) return TileList.tallGrass[tilesInt[x + y * width]-13];
		else return TileList.voidTile; 
	}*/
	
}
