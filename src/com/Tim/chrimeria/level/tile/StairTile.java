package com.Tim.chrimeria.level.tile;

import com.Tim.chrimeria.graphics.Screen;
import com.Tim.chrimeria.graphics.Sprite;

public class StairTile extends Tile{
	
	public StairTile(Sprite sprite) {
		super(sprite);
		// TODO Auto-generated constructor stub
	}
	
	public boolean encounter(){
		return false;
	}
	
	public void render(int x, int y, Screen screen){
		screen.renderTile(x<<5, y<<5, this);
	}
}
