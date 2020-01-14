package com.Tim.chrimeria.level.tile;

import com.Tim.chrimeria.graphics.Screen;
import com.Tim.chrimeria.graphics.Sprite;

public class RockTile extends Tile{
	
	public RockTile(Sprite sprite) {
		super(sprite);
		// TODO Auto-generated constructor stub
	}
	
	public void render(int x, int y, Screen screen){
		screen.renderTile(x<<5, y<<5, this);
	}
	public boolean solid(int dir){
		return true;
	}
}