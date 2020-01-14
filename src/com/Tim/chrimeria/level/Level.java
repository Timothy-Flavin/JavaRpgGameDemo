package com.Tim.chrimeria.level;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import com.Tim.chrimeria.Game;
import com.Tim.chrimeria.GameEvent;
import com.Tim.chrimeria.graphics.Screen;
import com.Tim.chrimeria.level.tile.Tile;
import com.Tim.chrimeria.level.tile.TileList;

public class Level{
	
	public String name;
	protected GameEvent[] events;
	protected int width, height;
	protected int[] tilesInt;
	protected int[] tiles;
	protected Tile[] mapTiles, frontTiles;
	public Spawns[] spawnPoints;
	public int[] arrivalLevel;
	public int[] arrivalSpawn;
	public int[] spawnDirections;
	public int[] possibleCombatants;
	private int w,h;
	
	public Level(int width, int height, Game game){
		this.width = width;
		this.height = height;
		tilesInt = new int[width*height];
		generateLevel();
	}
	
	public Level(String path, String path2, Game game){
		loadLevel(path,path2);
		//generateLevel();
	}
	
	protected void loadLevel(String path, String path2){
		//System.out.println(path);
		try{
			
			File fl = new File(path);
			File f2 = new File(path2);
			Scanner reader = new Scanner(fl);

			//BufferedImage image = ImageIO.read(TuturialTown.class.getResource(path));
			//w = width = image.getWidth();
			//h = height = image.getHeight();
			w = reader.nextInt();
			h = reader.nextInt();
			
			width = w;
			height = h;
			System.out.println("reader width and height yo" + w + " " + h);
			tiles = new int[w*h];
			mapTiles = new Tile[w*h];
			frontTiles = new Tile[w*h];
			for(int i = 0; i < tiles.length;i++){
				tiles[i] = reader.nextInt();
				//System.out.println(tiles[i]);
			}
			generateLevel(mapTiles);
			reader.close();
			reader = new Scanner(f2);
			w = reader.nextInt();
			h = reader.nextInt();
			for(int i = 0; i < tiles.length;i++){
				tiles[i] = reader.nextInt();
				//System.out.println(tiles[i]);
				//System.out.println(tiles[i]);
			}
			generateLevel(frontTiles);
			reader.close();
			//image.getRGB(0, 0, w, h, tiles, 0, w);
		}catch(IOException e){
			e.printStackTrace();
			System.out.println("level file not loaded bro");
		}
	}

	protected void generateLevel(Tile[] theTiles){
		for(int i = 0; i < tiles.length; i++){
			//System.out.println(i);
			//System.out.println(tiles[i]);
			if(tiles[i]==-1){
				theTiles[i] = null;
			}
			else{ 
				theTiles[i] = TileList.masterList[tiles[i]];
			
			}
			//if(mapTiles[i] == null) mapTiles[i] = TileList.voidTile;
		}
	}
	protected void generateLevel(){
		
	}
	public void update(){
		
	}
	
	public void checkSpawn(int dir){
		
	}
	//private void time(){
	//}
	public boolean doEvent(int eventX, int eventY){
		return false;
	}
	public void render(int xScroll, int yScroll, Screen screen){
		screen.setOffset(xScroll, yScroll);
		int x0 = xScroll >> 5;
		int x1 = (xScroll + screen.width + 32) >> 5;
		int y0 = yScroll >> 5;
		int y1 = (yScroll + screen.height + 32) >> 5;
		for(int y = y0; y < y1; y++){
			for(int x = x0; x < x1; x++){
				getTile(x, y).render(x, y, screen);
				//System.out.println(x + " " + y + " width:" + width + " height: "+height);
				//if (x+y*32 < 0 || x+y*32 >= 1024) Tile.voidTile.render(x, y, screen);
				//else tiles[x+y*32].render(x, y, screen);
			}
		}
	}
	public void renderFront(int xScroll, int yScroll, Screen screen){
		screen.setOffset(xScroll, yScroll);
		int x0 = xScroll >> 5;
		int x1 = (xScroll + screen.width + 32) >> 5;
		int y0 = yScroll >> 5;
		int y1 = (yScroll + screen.height + 32) >> 5;
		for(int y = y0; y < y1; y++){
			for(int x = x0; x < x1; x++){
				if(getFrontTile(x,y)!=null) getFrontTile(x, y).render(x, y, screen);
				//System.out.println(x + " " + y + " width:" + width + " height: "+height);
				//if (x+y*32 < 0 || x+y*32 >= 1024) Tile.voidTile.render(x, y, screen);
				//else tiles[x+y*32].render(x, y, screen);
			}
		}
	}
	public Tile getTile(int x, int y){
		if(x < 0 || y < 0 || x >= width || y >= height){
			return TileList.voidTile;
		}
		else if(mapTiles[x+y*width] == null){
			return TileList.masterList[0];
		}
		return mapTiles[x+y*width];
		/*if(tiles[x + y * width] == 0xff00ff00) return Tile.grasses[1];
		if(tiles[x + y * width] == 0xff010000) return Tile.paths[1];
		else return Tile.voidTile; */
	}
	public Tile getFrontTile(int x, int y){
		if(x < 0 || y < 0 || x >= width || y >= height){
			return TileList.voidTile;
		}
		return frontTiles[x+y*width];
		/*if(tiles[x + y * width] == 0xff00ff00) return Tile.grasses[1];
		if(tiles[x + y * width] == 0xff010000) return Tile.paths[1];
		else return Tile.voidTile; */
	}
	public int[] getPossibleCombatants() {
		// TODO Auto-generated method stub
		return possibleCombatants;
	}

	public int getEnemyLevel() {
		return (int)(Math.random()*10)+1;
	}
}
