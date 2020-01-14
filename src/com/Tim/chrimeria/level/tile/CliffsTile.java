package com.Tim.chrimeria.level.tile;

import com.Tim.chrimeria.graphics.Screen;
import com.Tim.chrimeria.graphics.Sprite;

public class CliffsTile extends Tile{
	
	public CliffsTile(Sprite sprite, boolean up, boolean down, boolean left, boolean right) {
		super(sprite);
		directional = true;
		this.up = up;
		this.down = down;
		this.left = left;
		this.right = right;
		// TODO Auto-generated constructor stub
	}
	
	public boolean encounter(){
		return false;
	}
	
	public void render(int x, int y, Screen screen){
		screen.renderTile(x<<5, y<<5, this);
	}
	
	public boolean solid(int dir){
		if(dir == 0){
			if(down)
				return true;
			else
				return false;
		}
		else if(dir == 1){
			if(left)
				return true;
			else
				return false;
		}
		else if(dir == 2){
			if(up)
				return true;
			else
				return false;
		}
		else if(dir == 3){
			if(right)
				return true;
			else 
				return false;
		}
		
		return true;
	}
}
