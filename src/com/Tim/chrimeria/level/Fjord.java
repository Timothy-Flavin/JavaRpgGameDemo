package com.Tim.chrimeria.level;

import com.Tim.chrimeria.BattleScreen;
import com.Tim.chrimeria.Game;
import com.Tim.chrimeria.GameEvent;
import com.Tim.chrimeria.TextToRender;
import com.Tim.chrimeria.dialogue.Dialogue;
import com.Tim.chrimeria.entity.combatant.Combatant;
import com.Tim.chrimeria.entity.combatant.Ferdia;
import com.Tim.chrimeria.entity.combatant.MaeveSoldier;
import com.Tim.chrimeria.entity.combatant.MaeveSoldier2;
import com.Tim.chrimeria.entity.mob.Player;

public class Fjord extends Level{
	
	public int w, h;

	public Fjord(String path, String path2, Game game){
		super(path, path2, game);
		events = new GameEvent[10];
		for(int i = 0;i<events.length;i++){
			events[i] = new GameEvent(true);
		}
		spawnPoints = new Spawns[3];
		spawnDirections = new int[]{-1,0,0};
		spawnPoints[0] = new Spawns(28, 8);
		spawnPoints[1] = new Spawns(38, 11);
		spawnPoints[2] = new Spawns(55, 34);
		/*spawnPoints[1] = new Spawns(2, 4);
		spawnPoints[2] = new Spawns(2, 5);
		spawnPoints[3] = new Spawns(2, 6);
		spawnPoints[4] = new Spawns(2, 7);
		*/
		arrivalLevel = new int[]{0,1,2};//1, 2, 3, 4, 5};
		arrivalSpawn = new int[]{0,0,0};//0, 0, 0, 0, 0,};

		name = "fjord";
		
		possibleCombatants = new int[]{
			9,10,//0,1,2,3,4,5
		};
	}
	
	public boolean doEvent(int x, int y){
		if(x==416&&events[0].getE()){
			events[0].set(false);
			System.out.println("should be doing it");
			Dialogue.playConversation(TextToRender.getDialogueByName("news").getTextArray());
			return true;
		}
		else if(x==1600&&y==160&&events[1].getE()){
			events[1].set(false);
			Player.e=true;
			Dialogue.playConversation(TextToRender.getDialogueByName("item1").getTextArray());
			BattleScreen.getAllies()[1].skillIdList = new int[5];
			for(int i = 0; i < 4; i++){
				BattleScreen.getAllies()[1].skillIdList[i] = i;
			}
			BattleScreen.getAllies()[1].skillIdList[4]=9;
			return true;
		}
		else if(x==1248&&y==576&&events[2].getE()){
			events[2].set(false);
			Player.e=true;
			Dialogue.playConversation(TextToRender.getDialogueByName("item2").getTextArray());
			BattleScreen.getAllies()[1].mhp += 30;
			return true;
		}
		else if(y==576&&events[7].getE()){
			events[7].set(false);
			Player.e=true;
			Dialogue.playConversation(TextToRender.getDialogueByName("exposition").getTextArray());
			return true;
		}
		else if(x==1024&&y==544&&events[3].getE()){
			events[3].set(false);
			Player.e=true;
			BattleScreen.getAllies()[0].ap += 20;
			Dialogue.playConversation(TextToRender.getDialogueByName("item3").getTextArray());
			return true;
		}
		else if(x==1280&&y==864&&events[4].getE()){
			events[4].set(false);
			Player.e=true;
			Dialogue.playConversation(TextToRender.getDialogueByName("item4").getTextArray());
			BattleScreen.getAllies()[0].hp = BattleScreen.getAllies()[0].mhp;
			BattleScreen.getAllies()[1].hp = BattleScreen.getAllies()[1].mhp;
			return true;
		}
		else if(x==544&&y==928&&events[5].getE()){
			events[5].set(false);
			Player.e=true;
			int[] newIds= new int[BattleScreen.getAllies()[1].skillIdList.length+1];
			for(int i = 0; i < BattleScreen.getAllies()[1].skillIdList.length; i++){
				newIds[i]=BattleScreen.getAllies()[1].skillIdList[i];
			}
			newIds[BattleScreen.getAllies()[1].skillIdList.length]=10;
			BattleScreen.getAllies()[1].skillIdList=newIds;
			Dialogue.playConversation(TextToRender.getDialogueByName("item5").getTextArray());
			return true;
		}
		else if(x==1728&&y==1280&&events[6].getE()){
			events[6].set(false);
			Player.e=true;
			Dialogue.playConversation(TextToRender.getDialogueByName("item6").getTextArray());
			BattleScreen.getAllies()[1].ad+=30;
			return true;
		}
		else if(y==1408&&events[8].getE()){
			Combatant[] cb = new Combatant[3];
			cb[0]=new MaeveSoldier(5);
			cb[1]=new Ferdia(1);
			cb[2]=new MaeveSoldier2(5);
			for(int i = 0; i < 3;i++){
				cb[i].ai=true;
			}
			Game.enterCombat(cb, events[8]);
			return true;
		}
		else if(!events[8].getE()&&events[9].getE()){
			events[9].set(false);
			Dialogue.playConversation(TextToRender.getDialogueByName("end").getTextArray());
			if(Dialogue.done){
				Game.quit();
			}
		}
		return false;
	}
}
