package com.Tim.chrimeria.entity.mob;

import com.Tim.chrimeria.Game;
import com.Tim.chrimeria.entity.Entity;
import com.Tim.chrimeria.graphics.Sprite;

public abstract class Mob extends Entity{
	
	protected Sprite sprite;
	protected int dir = 0;
	protected int speed = 1;
	protected boolean moving = false, atArrival = false, pathing = false;
	protected int animationCounter = 0;
	protected int xa = 0, ya = 0, xArrival, yArrival, txArrival, tyArrival;
	
	
	public void move(){
		updateDir();
		if(moving){
			x += xa * speed;
			y += ya * speed;
			animationCounter += speed;

			if(animationCounter == 32){
				animationCounter = 0;
				moving = false;
				encounter();
				if(!pathing){
					xa = 0;
					ya = 0;
					///if(encounter(x,y))
						//System.out.println("got an encounter with wasd");
				}
				/*else if(encounter()){
					//System.out.println("got an encounter");
					xa = 0;
					ya = 0;
					pathing = false;
				}*/
				else if(txArrival != 0 && tyArrival != 0){
					xArrival = txArrival;
					yArrival = tyArrival;
					txArrival = 0;
					tyArrival = 0;
					setPathStep();
				}
				else{
					setPathStep();
				}
			}
		}
		if(!moving){
			
			if(xa != 0 || ya != 0) {
				if(!collision(xa, ya))
					moving = true;
				else{
					moving = true;
					if(pathing){
						
					}
					else{
						xa = 0;
						ya = 0;
					}
				}
			}
			
		}
		
	}
	
	protected void encounter(){

	}
	
	public void setPathStep(){
		
		int xLength = (xArrival - x);
		int yLength = (yArrival - y);
		if((xLength == 0 || yLength == 0) && !collision(xa, ya)){
			if(Math.abs(xLength) >= Math.abs(yLength) && xLength != 0){
				if(xLength > 0){
					xa = 1;
					ya = 0;
				}
				else{
					xa = -1;
					ya = 0;
				}
			}
			else if(Math.abs(yLength) >= Math.abs(xLength) && yLength != 0){
				if(yLength > 0){
					ya = 1;
					xa = 0;
				}
				else{
					ya = -1;
					xa = 0;
				}
			}
			else{
				pathing = false;
				xa = 0;
				ya = 0;
			}
			if(collision(xa, ya)){
				updateDir();
				setPathStep();
			}
		}
		else if(collision(xa, ya)){
			xa = 0;
			ya = 0;
		}
			
	}
	
	public void update(){
		
	}
	
	public void updateDir(){
		if(ya < 0) dir = 0;
		if(xa > 0) dir = 1;
		if(xa < 0) dir = 3;
		if(ya > 0) dir = 2;
	}
	
	protected boolean collision(int xa, int ya){
		boolean solid = false;
		if(level.getTile((x+xa*32)/32, (y+ya*32)/32).solid(dir)){
			solid = true;
		}
		else if(dir == 0){
			if(level.getTile((x)/32, (y)/32).solid(2)){
				solid = true;
			}
		}
		else if(dir == 1){
			if(level.getTile((x)/32, (y)/32).solid(3)){
				solid = true;
			}
		}
		else if(dir == 2){
			if(level.getTile((x)/32, (y)/32).solid(0)){
				solid = true;
			}
		}
		else if(dir == 3){
			if(level.getTile((x)/32, (y)/32).solid(1)){
				solid = true;
			}
		}
		if(level.getFrontTile((x+xa*32)/32, (y+ya*32)/32)!=null&&level.getFrontTile((x+xa*32)/32, (y+ya*32)/32).solid(dir)){
			solid = true;
		}
		else if(dir == 0){
			if(level.getFrontTile((x)/32, (y)/32)!=null&&level.getFrontTile((x)/32, (y)/32).solid(2)){
				solid = true;
			}
		}
		else if(dir == 1){
			if(level.getFrontTile((x)/32, (y)/32)!=null&&level.getFrontTile((x)/32, (y)/32).solid(3)){
				solid = true;
			}
		}
		else if(dir == 2){
			if(level.getFrontTile((x)/32, (y)/32)!=null&&level.getFrontTile((x)/32, (y)/32).solid(0)){
				solid = true;
			}
		}
		else if(dir == 3){
			if(level.getFrontTile((x)/32, (y)/32)!=null&&level.getFrontTile((x)/32, (y)/32).solid(1)){
				solid = true;
			}
		}
		return solid;
	}
	
	public void render(){
		
	}
	public boolean getMoving(){
		return moving;
	}
	public void path(int xAr, int yAr){
		
		pathing = true;
		xArrival = xAr;
		yArrival = yAr;
		
		int xLength = (xArrival - x);
		int yLength = (yArrival - y);
		
		if(Math.abs(xLength) >= Math.abs(yLength) && xLength != 0){
			if(xLength > 0){
				xa = 1;
				ya = 0;
			}
			else{
				xa = -1;
				ya = 0;
			}
		}
		else if(Math.abs(yLength) >= Math.abs(xLength) && yLength != 0){
			if(yLength > 0){
				ya = 1;
				xa = 0;
			}
			else{
				ya = -1;
				xa = 0;
			}
		}
		setPathStep();
	}
	public void queuePath(int mx, int my, int px, int py){
		
		pathing = true;
		txArrival = px + (mx/Game.scale - 224);
		txArrival -= txArrival%32;
			
		tyArrival = py + (my/Game.scale - 128);
		tyArrival -= tyArrival%32;
		
	}
	
	
}
