package com.Tim.chrimeria.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class SpriteSheet {
	
	private String path;
	public final int SIZE, WIDTH, HEIGHT;
	public int[] pixels;
	
	public static SpriteSheet tiles = new SpriteSheet("/textures/coastTiles.png", 512);
	public static SpriteSheet barbarian = new SpriteSheet("/textures/cuchulain.png", 256);
	public static SpriteSheet battleScreen = new SpriteSheet("/backgrounds/BattleScreen2.png", 480);
	public static SpriteSheet combatSprites = new SpriteSheet("/textures/CombatSprites.png", 480);
	
	public SpriteSheet(String path, int size){
		this.path = path;
		this.SIZE = size;
		this.WIDTH = size;
		this.HEIGHT = size;
		pixels = new int[SIZE * SIZE];	// would be length * width if the sheet was not a square	
		load();
	}
	public SpriteSheet(String path, int width, int height){
		this.path = path;
		this.SIZE = width;
		this.WIDTH = width;
		this.HEIGHT = height;
		pixels = new int[WIDTH * HEIGHT];	// would be length * width if the sheet was not a square	
		load();
	}
	
	private void load(){
		try{
			BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(path));// makes a buffered image
			int w = image.getWidth();
			int h = image.getHeight();
			image.getRGB(0, 0, w, h, pixels, 0, w); // puts the pixels on the sheet into the pixels int array
		}catch(IOException e) { //in case the sheet is not there
			//System.out.println("FUCK YOU");
			e.printStackTrace();
		}
		
	}
	
}
