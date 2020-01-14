package com.Tim.chrimeria.level;

import com.Tim.chrimeria.BattleScreen;
import com.Tim.chrimeria.Game;
import com.Tim.chrimeria.GameEvent;
import com.Tim.chrimeria.TextToRender;
import com.Tim.chrimeria.dialogue.Dialogue;
import com.Tim.chrimeria.entity.combatant.Accursed;
import com.Tim.chrimeria.entity.combatant.BlueSlime;
import com.Tim.chrimeria.entity.combatant.Bunny;
import com.Tim.chrimeria.entity.combatant.Combatant;

public class SmallHouse extends Level{
	
	public int w, h, prevx=0, prevy=0;

	public SmallHouse(String path, String path2, Game game){
		super(path, path2, game);
		events = new GameEvent[4];
		for(int i = 0;i<events.length;i++){
			events[i] = new GameEvent(true);
		}
		spawnPoints = new Spawns[1];
		spawnPoints[0] = new Spawns(7, 14);
		spawnDirections = new int[]{2};
		/*spawnPoints[1] = new Spawns(2, 4);
		spawnPoints[2] = new Spawns(2, 5);
		spawnPoints[3] = new Spawns(2, 6);
		spawnPoints[4] = new Spawns(2, 7);
		*/
		arrivalLevel = new int[]{0};//1, 2, 3, 4, 5};
		arrivalSpawn = new int[]{1};//0, 0, 0, 0, 0,};

		name = "SmallHouse";
		
		possibleCombatants = new int[]{
			0,1,2,3,4,5
		};
	}
	public boolean doEvent(int x, int y){
		if(x==416&&y==160||x==416&&y==192){
			boolean heal = false;
			for(int i = 0;i<BattleScreen.getAllies().length;i++){
				if(BattleScreen.getAllies()[i]!=null)
				if(!(BattleScreen.getAllies()[i].hp==BattleScreen.getAllies()[i].mhp))heal=true;
			}
			if(heal){
				prevx=x;
				prevy=y;
				for(int i = 0;i<BattleScreen.getAllies().length;i++){
					if(BattleScreen.getAllies()[i]!=null){
						BattleScreen.getAllies()[i].hp=BattleScreen.getAllies()[i].mhp;
						BattleScreen.getAllies()[i].setDead(false);
					}
				}
				//System.out.println(TextToRender.getDialogueByName("heal").getTextArray()[0]);
				//events[0].set(false);
				Dialogue.playConversation(TextToRender.getDialogueByName("heal").getTextArray());
				return true;
			}
			else if((prevx!=x||prevy!=y)&&Dialogue.done){
				prevx=x;
				prevy=y;
				//System.out.println(TextToRender.getDialogueByName("healAlt").getTextArray()[0]);
				//events[0].set(false);
				Dialogue.playConversation(TextToRender.getDialogueByName("healAlt").getTextArray());
				return true;
			}
			//return true;
		}
		else if(x==160&&y==128&&events[1].getE()){
			Combatant[] cb = new Combatant[3];
			cb[0]=new Accursed(5);
			cb[1]=new Bunny(1);
			cb[2]=new BlueSlime(5);
			Game.enterCombat(cb, events[1]);
			return true;
			//mapTiles[(x>>5)+((y>>5)*width)] = null;
			//events[1]=false;
		}
		else if(Math.abs(x-prevx)>32||Math.abs(y-prevy)>32){
			prevx=x;
			prevy=y;
			//System.out.println(x+", "+y+"   "+prevx+", "+prevy);
		}
		return false;
	}
	
}
