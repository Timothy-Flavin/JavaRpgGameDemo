package com.Tim.chrimeria.level.tile;

import com.Tim.chrimeria.graphics.Screen;
import com.Tim.chrimeria.graphics.Sprite;

public class WaterTile extends Tile{
	
	public WaterTile(Sprite sprite) {
		super(sprite);
		this.down = true;
		// TODO Auto-generated constructor stub
	}
	
	public void render(int x, int y, Screen screen){
		screen.renderTile(x<<5, y<<5, this);
	}
	public boolean solid(int dir){
		return true;
	}
}