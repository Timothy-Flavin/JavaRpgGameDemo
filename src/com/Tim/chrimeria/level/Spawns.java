package com.Tim.chrimeria.level;

public class Spawns {
	
	int xSpawn;
	int ySpawn;
	
	public Spawns(int xSpawn, int ySpawn){
		this.xSpawn = xSpawn*32;
		this.ySpawn = ySpawn*32;
	}
	
	public int x (){
		return xSpawn;
	}
	public int y (){
		return ySpawn;
	}
	
}
