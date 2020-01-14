package com.Tim.chrimeria.graphics;

import java.awt.Color;
import java.awt.Graphics;

import com.Tim.chrimeria.BattleScreen;
import com.Tim.chrimeria.Game;
import com.Tim.chrimeria.MenuButton;
import com.Tim.chrimeria.input.Keyboard;
import com.Tim.chrimeria.level.tile.Tile;

//import java.util.Random;

public class Screen {
	
	//private Random random = new Random();
	public int width, height;
	public int[] pixels;
	public final int MAP_SIZE = 64;
	public final int MAP_SIZE_MASK = MAP_SIZE -1;
	public int xOffset, yOffset;
	public int[] tiles = new int[MAP_SIZE * MAP_SIZE];
	public Sprite escapeMenuBg = new Sprite(480/3,288/2,1);
	public MenuButton quitButton;
	public boolean menuOpen = false;
	public boolean canSwitch = true;
	public boolean menuInit = false;
	MenuButton[] activeButtons = new MenuButton[16];
	int menuNum = 0;
	
	public Screen(int width, int height) {
		this.width = width;
		this.height = height;

		pixels = new int[width * height];
	}
	
	public void clear(){
		for(int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
	}	
	
	public boolean canOpenOrClose(Keyboard input){
		if(input.escape == canSwitch){
			canSwitch = !canSwitch;
			return true;
		}
		else return false;
	}
	
	public void renderTile(int xp, int yp, Tile tile){
		xp -= xOffset;
		yp -= yOffset;
		for(int y = 0; y < tile.sprite.h; y++){
			int ya = y + yp;
			for(int x = 0; x < tile.sprite.w; x++){
				int xa = x + xp;
				if(xa < -tile.sprite.w || xa >= width || ya < 0 || ya >= height) break;
				if(xa<0) xa = 0;
				
				if(tile.sprite.pixels[x+ y*tile.sprite.w]!=0)pixels[xa + ya * width] = tile.sprite.pixels[x+ y*tile.sprite.w]; //add numbers here to tint
				//System.out.println(pixels.length);
				//System.out.println(tile.sprite.pixels.length);
			}
		}
	}
	
	public void renderFrontTile(int xp, int yp, Tile tile){
		xp -= xOffset;
		yp -= yOffset;
		for(int y = 0; y < tile.sprite.h; y++){
			int ya = y + yp;
			for(int x = 0; x < tile.sprite.w; x++){
				int xa = x + xp;
				if(xa < -tile.sprite.w || xa >= width || ya < 0 || ya >= height) break;
				if(xa<0) xa = 0;
				
				if(tile.sprite.pixels[x+ y*tile.sprite.w]!=0)pixels[xa + ya * width] = tile.sprite.pixels[x+ y*tile.sprite.w]; //add numbers here to tint
				//System.out.println(pixels.length);
				//System.out.println(tile.sprite.pixels.length);
			}
		}
	}
	
	public void renderPlayer(int xp, int yp, Sprite sprite){
		xp -= xOffset;
		yp -= yOffset + 8;
		for(int y = 0; y < 32; y++){
			int ya = y + yp;
			for(int x = 0; x < 32; x++){
				int xa = x + xp;
				if(xa < -32 || xa >= width || ya < 0 || ya >= height) break;
				if(xa<0) xa = 0;
				int col = sprite.pixels[x+y*32];
				if(col != 0x000000)
					pixels[xa + ya * width] = col;
			}
		}
	}
	
	public void setOffset(int xOffset, int yOffset){
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	public void renderMenu(){
		if(menuOpen){
			if(!menuInit){
				menuInit = true;
				openMenu();
			}
			getClicks();
			renderMenuBg();
			updateButtons();
		}
		else{
			if(menuInit){
				menuInit = false;
				closeMenu();
			}
		}
	}
	public void renderMenuBg(){
		for(int y = 0; y < escapeMenuBg.h; y++){
			int ya = y + 72; 
			for(int x = 0; x < escapeMenuBg.w; x++){
				int xa = x + 160;
				if(xa < -escapeMenuBg.w || xa >= width || ya < 0 || ya >= height) break;
				if(xa<0) xa = 0;
				int col = escapeMenuBg.pixels[x+y*escapeMenuBg.w];
				if(col != 0x000000){	
					int red = 0xFF & ( pixels[xa + ya * width] >> 16);
					int blue = 0xFF & ( pixels[xa + ya * width] >> 0);
					int green = 0xFF & ( pixels[xa + ya * width] >> 8);
					
					int red1 = 0xFF & ( col >> 16);
					int blue1 = 0xFF & ( col >> 0);
					int green1 = 0xFF & ( col >> 8);

					red = red1 + red>>2;
					blue = blue1 + blue>>2;
					green = green1 + green>>2;
					
					pixels[xa + ya * width] =(red<<16) | (green<<8) | blue; 
				}
			}
		}
		
	}
	public void renderProfiles(){
		for(int i = 0; i < BattleScreen.getAllies().length;i++){
			//System.out.println(i);
			if(BattleScreen.getAllies()[i]!= null)
			for(int y = 0; y < BattleScreen.getAllies()[i].profile.h; y++){
				int ya = y + (i<<5)+5; 
				//System.out.println(ya);
				for(int x = 0; x < BattleScreen.getAllies()[i].profile.w; x++){
					int xa = x + 5;
					if(xa < 0 || xa >= width || ya < 0 || ya >= height) break;
						pixels[xa + ya * width] = BattleScreen.getAllies()[i].profile.pixels[x+y*BattleScreen.getAllies()[i].profile.w]; 
				}
			}
		}
	}
	
	public void renderHealthBars(Graphics g){
		for(int i= 0; i < BattleScreen.getAllies().length; i++){
			if(BattleScreen.getAllies()[i] != null){
				for(int y = 0; y < Sprite.healthBar.h; y++){
					int ya = y + ((i+1)<<5); 
					for(int x = 0; x < Sprite.healthBar.w; x++){
						int xa = x + 37;
						if(xa < 0 || xa >= width || ya < 0 || ya >= height) break;
						int col = Sprite.healthBar.pixels[x+y*Sprite.healthBar.w];
						if(col != 0x000000)
							pixels[xa + ya * width] = Sprite.healthBar.pixels[x+ y*Sprite.healthBar.w]; //add numbers here to tint						
					}
				}
			}
		}
		g.setColor(new Color(0x00177a00));
		for(int i = 0; i < BattleScreen.getAllies().length; i++){
			if(BattleScreen.getAllies()[i] != null){
				g.fillRect((39)*Game.scale, (((i+1)<<5)+1)*Game.scale, BattleScreen.getAllies()[i].hp*28/BattleScreen.getAllies()[i].mhp*Game.scale, 3*Game.scale);
			}
		}
	}
	
	public void openMenu(){
		
		MenuButton resume = new MenuButton(Font.makeSprite("resume", false, Font.buttonFont), Font.makeSprite("resume", true, Font.buttonFont), 212, 100);;
		MenuButton settings = new MenuButton(Font.makeSprite("settings", false, Font.buttonFont), Font.makeSprite("settings", true, Font.buttonFont), 205, 130);
		MenuButton quit = new MenuButton(Font.makeSprite("quit", false, Font.buttonFont), Font.makeSprite("quit", true, Font.buttonFont), 219, 190);
		MenuButton inventory = new MenuButton(Font.makeSprite("inventory", false, Font.buttonFont), Font.makeSprite("inventory", true, Font.buttonFont), 201, 160);
		activeButtons[0] = resume;
		activeButtons[1] = settings;
		activeButtons[2] = inventory;
		activeButtons[3] = quit;
	}
	
	public void closeMenu(){
		menuOpen = false;
		for(int i = 0; i < activeButtons.length; i++){
			activeButtons[i]=null;
		}
	}
	
	public void updateButtons(){
		for(int i = 0; i< activeButtons.length; i++){
			if(activeButtons[i] != null){
				activeButtons[i].update();
				renderButton(activeButtons[i]);
			}
		}
	}
	public void renderButton(MenuButton button){
		
		for(int y = 0; y < button.sCurrent.h; y++){
			int ya = y + button.getY(); 
			for(int x = 0; x < button.sCurrent.w; x++){
				int xa = x + button.getX();
				if(xa < -button.sCurrent.w || xa >= width || ya < 0 || ya >= height) break;
				if(xa<0) xa = 0;
				int col = button.sCurrent.pixels[x+y*button.sCurrent.w];
				if(col != 0x000000){	
					pixels[xa + ya * width] = button.sCurrent.pixels[x + y*button.sCurrent.w];
				}
			}
		}
	}
	public void getClicks(){
		if(menuNum == 0){
			if(activeButtons[0].getClicked()){
				closeMenu();
			}
			else if(activeButtons[3].getClicked()){
				Game.quit();
			}
		}
		
		
	}
}
