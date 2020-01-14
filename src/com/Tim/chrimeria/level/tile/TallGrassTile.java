package com.Tim.chrimeria.level.tile;

import com.Tim.chrimeria.graphics.Screen;
import com.Tim.chrimeria.graphics.Sprite;

public class TallGrassTile extends Tile{
	
	public TallGrassTile(Sprite sprite) {
		super(sprite);
		// TODO Auto-generated constructor stub
	}
	
	public boolean encounter(){
		if(Math.random() * 100 > 70) return true;
		else return false;
	}
	
	public void render(int x, int y, Screen screen){
		screen.renderTile(x<<5, y<<5, this);
	}
}