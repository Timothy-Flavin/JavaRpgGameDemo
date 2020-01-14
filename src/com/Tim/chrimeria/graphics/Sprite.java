package com.Tim.chrimeria.graphics;

public class Sprite {
	
	public final int w, h; // assumes the sprite is a square
	private int x, y;
	public int[] pixels;
	private SpriteSheet sheet;
	
	//public static Sprite grass = new Sprite(32, 32, 1, 0, SpriteSheet.tiles);
	public static Sprite rock = new Sprite(32, 32, 4, 7, SpriteSheet.tiles);
	public static Sprite chest = new Sprite(32, 32, 7, 8, SpriteSheet.tiles);
	public static Sprite cuchulainProfile = new Sprite(32, 32, 9, 1, SpriteSheet.combatSprites);
	public static Sprite laegProfile = new Sprite(32, 32, 10, 1, SpriteSheet.combatSprites);
	public static Sprite water = new Sprite(32, 32, 3, 6, SpriteSheet.tiles);
	public static Sprite battleScreenBackground = new Sprite(480, 288, 0, 0, SpriteSheet.battleScreen);
	public static Sprite voidSprite = new Sprite(32, 32, 0xff000006);
	public static Sprite healthBar = new Sprite(32, 5, 0, 5, SpriteSheet.combatSprites);
	public static Sprite button = new Sprite(32, 16, 2, 5, SpriteSheet.combatSprites);
	public static Sprite buttonOn = new Sprite(32, 16, 3, 5, SpriteSheet.combatSprites);
	public static Sprite arrow = new Sprite(32, 5, 1, 5, SpriteSheet.combatSprites);
	public static Sprite[] player = new Sprite[]{
		new Sprite(32, 32, 0, 0, SpriteSheet.barbarian),
		new Sprite(32, 32, 1, 0, SpriteSheet.barbarian),
		new Sprite(32, 32, 2, 0, SpriteSheet.barbarian),
		new Sprite(32, 32, 3, 0, SpriteSheet.barbarian),
		new Sprite(32, 32, 4, 0, SpriteSheet.barbarian),
		new Sprite(32, 32, 5, 0, SpriteSheet.barbarian),
		new Sprite(32, 32, 6, 0, SpriteSheet.barbarian),
		new Sprite(32, 32, 7, 0, SpriteSheet.barbarian),
		new Sprite(32, 32, 0, 1, SpriteSheet.barbarian),
		new Sprite(32, 32, 1, 1, SpriteSheet.barbarian),
		new Sprite(32, 32, 2, 1, SpriteSheet.barbarian),
		new Sprite(32, 32, 3, 1, SpriteSheet.barbarian),
		new Sprite(32, 32, 4, 1, SpriteSheet.barbarian),
		new Sprite(32, 32, 5, 1, SpriteSheet.barbarian),
		new Sprite(32, 32, 6, 1, SpriteSheet.barbarian),
		new Sprite(32, 32, 7, 1, SpriteSheet.barbarian)
	};
	
	public static Sprite[] stairs = new Sprite[]{
			new Sprite(32, 32, 3, 8, SpriteSheet.tiles),
			new Sprite(32, 32, 3, 9, SpriteSheet.tiles),
			new Sprite(32, 32, 3, 10, SpriteSheet.tiles)
	};
	
	public static Sprite[] grass = new Sprite[]{
		new Sprite(32, 32, 0, 0, SpriteSheet.tiles),
		new Sprite(32, 32, 1, 0, SpriteSheet.tiles),
		new Sprite(32, 32, 2, 0, SpriteSheet.tiles),
		new Sprite(32, 32, 0, 1, SpriteSheet.tiles),
		new Sprite(32, 32, 1, 1, SpriteSheet.tiles),
		new Sprite(32, 32, 2, 1, SpriteSheet.tiles),
		new Sprite(32, 32, 0, 2, SpriteSheet.tiles),
		new Sprite(32, 32, 1, 2, SpriteSheet.tiles),
		new Sprite(32, 32, 2, 2, SpriteSheet.tiles),
		
		new Sprite(32, 32, 3, 0, SpriteSheet.tiles),
		new Sprite(32, 32, 4, 0, SpriteSheet.tiles),
		new Sprite(32, 32, 3, 1, SpriteSheet.tiles),
		new Sprite(32, 32, 4, 1, SpriteSheet.tiles),
		
		new Sprite(32, 32, 5, 3, SpriteSheet.tiles),
		new Sprite(32, 32, 6, 3, SpriteSheet.tiles),
		new Sprite(32, 32, 7, 3, SpriteSheet.tiles),
	};
	public static Sprite[] tallGrass = new Sprite[]{
		new Sprite(32, 32, 5, 0, SpriteSheet.tiles),
		new Sprite(32, 32, 6, 0, SpriteSheet.tiles),
		new Sprite(32, 32, 7, 0, SpriteSheet.tiles),
		new Sprite(32, 32, 5, 1, SpriteSheet.tiles),
		new Sprite(32, 32, 6, 1, SpriteSheet.tiles),
		new Sprite(32, 32, 7, 1, SpriteSheet.tiles),
		new Sprite(32, 32, 5, 2, SpriteSheet.tiles),
		new Sprite(32, 32, 6, 2, SpriteSheet.tiles),
		new Sprite(32, 32, 7, 2, SpriteSheet.tiles),
		
		new Sprite(32, 32, 3, 2, SpriteSheet.tiles),
		new Sprite(32, 32, 4, 2, SpriteSheet.tiles),
		new Sprite(32, 32, 3, 3, SpriteSheet.tiles),
		new Sprite(32, 32, 4, 3, SpriteSheet.tiles),
		new Sprite(32, 32, 8, 3, SpriteSheet.tiles),
	}; 
	public static Sprite[] grassToWater = new Sprite[]{
		new Sprite(32, 32, 0, 4, SpriteSheet.tiles),
		new Sprite(32, 32, 1, 4, SpriteSheet.tiles),
		new Sprite(32, 32, 2, 4, SpriteSheet.tiles),
		new Sprite(32, 32, 0, 5, SpriteSheet.tiles),
		new Sprite(32, 32, 1, 5, SpriteSheet.tiles),
		new Sprite(32, 32, 2, 5, SpriteSheet.tiles),
		new Sprite(32, 32, 0, 6, SpriteSheet.tiles),
		new Sprite(32, 32, 1, 6, SpriteSheet.tiles),
		new Sprite(32, 32, 2, 6, SpriteSheet.tiles),
		
		new Sprite(32, 32, 3, 4, SpriteSheet.tiles),
		new Sprite(32, 32, 4, 4, SpriteSheet.tiles),
		new Sprite(32, 32, 3, 5, SpriteSheet.tiles),
		new Sprite(32, 32, 4, 5, SpriteSheet.tiles),
	}; 

	public static Sprite[] beach = new Sprite[]{
			
		new Sprite(32, 32, 5, 4, SpriteSheet.tiles),
		new Sprite(32, 32, 6, 4, SpriteSheet.tiles),
		new Sprite(32, 32, 7, 4, SpriteSheet.tiles),
		new Sprite(32, 32, 5, 5, SpriteSheet.tiles),
		new Sprite(32, 32, 6, 5, SpriteSheet.tiles),
		new Sprite(32, 32, 7, 5, SpriteSheet.tiles),
		new Sprite(32, 32, 5, 6, SpriteSheet.tiles),
		new Sprite(32, 32, 6, 6, SpriteSheet.tiles),
		new Sprite(32, 32, 7, 6, SpriteSheet.tiles),
		
		new Sprite(32, 32, 0, 7, SpriteSheet.tiles),
		new Sprite(32, 32, 1, 7, SpriteSheet.tiles),
		new Sprite(32, 32, 2, 7, SpriteSheet.tiles),
		new Sprite(32, 32, 3, 7, SpriteSheet.tiles),
			
		new Sprite(32, 32, 0, 3, SpriteSheet.tiles),
		new Sprite(32, 32, 1, 3, SpriteSheet.tiles),
		new Sprite(32, 32, 2, 3, SpriteSheet.tiles),
	}; 
	
	public static Sprite[] cliffs = new Sprite[]{
			
		new Sprite(32, 32, 4, 8, SpriteSheet.tiles),
		new Sprite(32, 32, 5, 8, SpriteSheet.tiles),
		new Sprite(32, 32, 6, 8, SpriteSheet.tiles),
		
		new Sprite(32, 32, 4, 9, SpriteSheet.tiles),
		new Sprite(32, 32, 5, 9, SpriteSheet.tiles),
		new Sprite(32, 32, 6, 9, SpriteSheet.tiles),
		
		new Sprite(32, 32, 4, 10, SpriteSheet.tiles),
		new Sprite(32, 32, 5, 10, SpriteSheet.tiles),
		new Sprite(32, 32, 6, 10, SpriteSheet.tiles),
		
		new Sprite(32, 32, 0, 8, SpriteSheet.tiles),
		new Sprite(32, 32, 1, 8, SpriteSheet.tiles),
		new Sprite(32, 32, 2, 8, SpriteSheet.tiles),
		
		new Sprite(32, 32, 0, 9, SpriteSheet.tiles),
		new Sprite(32, 32, 2, 9, SpriteSheet.tiles),
		
		new Sprite(32, 32, 0, 10, SpriteSheet.tiles),
		new Sprite(32, 32, 2, 10, SpriteSheet.tiles),
		
		new Sprite(32, 32, 0, 11, SpriteSheet.tiles),
		new Sprite(32, 32, 1, 11, SpriteSheet.tiles),
		new Sprite(32, 32, 2, 11, SpriteSheet.tiles),
	}; 
	
	public static Sprite[] house = new Sprite[]{
			
			new Sprite(32, 32, 8, 0, SpriteSheet.tiles),
			new Sprite(32, 32, 9, 0, SpriteSheet.tiles),
			new Sprite(32, 32, 11, 0, SpriteSheet.tiles),
			new Sprite(32, 32, 13, 0, SpriteSheet.tiles),
			new Sprite(32, 32, 8, 1, SpriteSheet.tiles),
			new Sprite(32, 32, 9, 1, SpriteSheet.tiles),
			new Sprite(32, 32, 10, 1, SpriteSheet.tiles),
			new Sprite(32, 32, 11, 1, SpriteSheet.tiles),
			new Sprite(32, 32, 12, 1, SpriteSheet.tiles),
			new Sprite(32, 32, 13, 1, SpriteSheet.tiles),
			new Sprite(32, 32, 14, 1, SpriteSheet.tiles),
			
			new Sprite(32, 32, 8, 2, SpriteSheet.tiles),
			new Sprite(32, 32, 9, 2, SpriteSheet.tiles),
			new Sprite(32, 32, 10, 2, SpriteSheet.tiles),
			new Sprite(32, 32, 11, 2, SpriteSheet.tiles),
			new Sprite(32, 32, 12, 2, SpriteSheet.tiles),
			new Sprite(32, 32, 13, 2, SpriteSheet.tiles),
			
			new Sprite(32, 32, 14, 2, SpriteSheet.tiles),
			new Sprite(32, 32, 15, 2, SpriteSheet.tiles),
			new Sprite(32, 32, 12, 3, SpriteSheet.tiles),
			new Sprite(32, 32, 13, 3, SpriteSheet.tiles),
			new Sprite(32, 32, 14, 3, SpriteSheet.tiles),
		};
	
	public Sprite(int w, int h, int x, int y, SpriteSheet sheet){
		this.w = w;
		this.h = h;
		pixels = new int[w*h];
		this.x = x * 32; //makes it so we can say a cord like 5, 2 instead of 32, 128
		this.y = y * 32;
		this.sheet = sheet;
		load();
	}
	
	public Sprite(int w, int h){
		this.w = w;
		this.h = h;
		pixels = new int[w*h];
	}
	
	public Sprite(int w, int h, int x, int y, SpriteSheet sheet, boolean fuck){
		this.w = w;
		this.h = h;
		pixels = new int[w*h];
		this.x = x * w; //makes it so we can say a cord like 5, 2 instead of 32, 128
		this.y = y * h;
		this.sheet = sheet;
		load();
	}
	public Sprite(int w, int h, int color){
		this.w = w;
		this.h = h;
		pixels = new int[w*h];
		setColor(color);
	}
	public void setColor(int color){
		for(int i = 0; i < w*h; i++){
			pixels[i] = color;
		}
	}
	private void load(){
		for(int y = 0; y < h; y++){
			for(int x = 0; x < w; x++){
				pixels[x+y*w] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.SIZE];
				//System.out.println(sheet.pixels[(x + this.x) + (y + this.y) * sheet.SIZE]);
			}
		}
	}
	public static Sprite[] split(int w, int h, SpriteSheet sheet){
		Sprite[] sprites = new Sprite[sheet.WIDTH/w * sheet.HEIGHT/h];
		for(int y = 0; y < sheet.HEIGHT/h; y++){
			for(int x = 0; x < sheet.WIDTH/w; x++){
				sprites[x+y*(sheet.WIDTH/w)] = new Sprite(w, h, x, y, sheet, true);
			}
			
		}
		return(sprites);
	}
}
