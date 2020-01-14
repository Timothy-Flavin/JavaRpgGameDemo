package com.Tim.chrimeria.level;

import com.Tim.chrimeria.Game;

public class TuturialTown extends Level{
	
	public int w, h;

	public TuturialTown(String path, String path2, Game game){
		super(path, path2, game);
		spawnPoints = new Spawns[2];
		spawnDirections = new int[]{-1,0};
		spawnPoints[0] = new Spawns(20, 12);
		spawnPoints[1] = new Spawns(26, 13);
		/*spawnPoints[1] = new Spawns(2, 4);
		spawnPoints[2] = new Spawns(2, 5);
		spawnPoints[3] = new Spawns(2, 6);
		spawnPoints[4] = new Spawns(2, 7);
		*/
		arrivalLevel = new int[]{0,1};//1, 2, 3, 4, 5};
		arrivalSpawn = new int[]{0,0};//0, 0, 0, 0, 0,};

		name = "tuturialTown";
		
		possibleCombatants = new int[]{
			9,10,//0,1,2,3,4,5
		};
	}
	
	
}
