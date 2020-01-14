package com.Tim.chrimeria;

import java.awt.Color;
import java.awt.Graphics;

import com.Tim.chrimeria.Game.STATE;
import com.Tim.chrimeria.combat.Skill;
import com.Tim.chrimeria.combat.SkillList;
import com.Tim.chrimeria.dialogue.Dialogue;
import com.Tim.chrimeria.entity.combatant.Combatant;
import com.Tim.chrimeria.entity.combatant.Combatants;
import com.Tim.chrimeria.entity.combatant.Laeg;
import com.Tim.chrimeria.entity.mob.Player;
import com.Tim.chrimeria.graphics.Font;
import com.Tim.chrimeria.graphics.Sprite;
import com.Tim.chrimeria.graphics.SpriteSheet;
import com.Tim.chrimeria.level.Level;

public class BattleScreen {
	
	public static enum BSTATE{
		INCOMBAT,
		WIN,
		LOSS
	};
	public static BSTATE State = BSTATE.INCOMBAT;
	int menuNum = -1, attackNum = 0, frameCounter=0, attackStep=0;
	boolean alliesTurn, init = false;
	Skill chosenAttack;
	Combatant targets;
	Combatant[] enemies = new Combatant[3];
	private static Combatant[] allies = new Combatant[3];
	Combatant activeCombatant;
	Combatant[] attackOrder;
	Sprite battleMenuBg = new Sprite(192, 96, 0, 9, SpriteSheet.combatSprites);
	MenuButton[] activeButtons = new MenuButton[16];
	MenuButton[] mainCombatButtons = new MenuButton[16];
	MenuButton[] targetList = new MenuButton[3];
	MenuButton fightButton = new MenuButton(Font.makeSprite("fight", false, Font.buttonFont), Font.makeSprite("fight", true, Font.buttonFont), 214, 200);
	MenuButton runButton = new MenuButton(Font.makeSprite("run", false, Font.buttonFont), Font.makeSprite("run", true, Font.buttonFont), 222, 230);
	MenuButton itemButton = new MenuButton(Font.makeSprite("item", false, Font.buttonFont), Font.makeSprite("item", true, Font.buttonFont), 218, 215);
	GameEvent e;
	int[] enemyOptions;
	int[] xEnemies = new int[]{
		30,
		70,
		30
	};
	int[] yEnemies = new int[]{
		160,
		200,
		250
	};
	int[] xAllies = new int[]{
		420,
		380,
		420
	};
	int[] yAllies = new int[]{
		160,
		200,
		250
	};

	int width, height, aNum = 0, turn = 0;
	int[] pixels;
	public Sprite background = Sprite.battleScreenBackground;
	
	public BattleScreen(int width, int height, Player player){
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
		clear();
		
		mainCombatButtons[0] = fightButton;
		mainCombatButtons[1] = runButton;
		mainCombatButtons[2] = itemButton;
		
		activeButtons = mainCombatButtons;
		allies[0] = new Laeg(10);
		//allies[0].hp = allies[0].mhp/2;
		allies[1] = player.pCombatant;
		allies[2] = null;//new BlueSlime(4);
	}
	
	public static Combatant[] getAllies(){
		return allies;
	}
	
	public void swapPartyMember(Combatant cb, int pos){
		allies[pos]=cb;
	}
	
	public void initBattle(Level level){
		State = BSTATE.INCOMBAT;
		Game.switchMusic("res/music/battleMusic.wav");
		
		enemies[0] = Combatants.getCombatant(level.possibleCombatants[(int)(Math.random()*level.getPossibleCombatants().length)], level.getEnemyLevel());
		enemies[1] = Combatants.getCombatant(level.possibleCombatants[(int)(Math.random()*level.getPossibleCombatants().length)], level.getEnemyLevel());
		enemies[2] = Combatants.getCombatant(level.possibleCombatants[(int)(Math.random()*level.getPossibleCombatants().length)], level.getEnemyLevel());
		for(int i = 0; i < enemies.length;i++){
			if(enemies[i]!=null) enemies[i].ai=true;
		}
		resetPos();
		this.e=null;
		setOrder();
		activeCombatant = attackOrder[0];
		getEnemieOptions();
		turn=0;
		menuNum=-1;
		attackStep=0;
	}
	
	public void initBattle(Level level, Combatant[] enemies, GameEvent e){
		State = BSTATE.INCOMBAT;
		Game.switchMusic("res/music/battleMusic.wav");
		this.enemies[0] = enemies[0];
		this.enemies[1] = enemies[1];
		this.enemies[2] = enemies[2];
		resetPos();
		setOrder();
		this.e=e;
		activeCombatant = attackOrder[0];
		getEnemieOptions();
		turn=0;
		menuNum=-1;
		attackStep=0;
	}
	
	public void getEnemieOptions(){
		int enemyO=0;
		for(int i = 0; i < allies.length;i++){
			if(allies[i]!=null){
				enemyO++;
			}
		}
		enemyOptions = new int[enemyO];
		enemyO=0;
		for(int i = 0; i < allies.length;i++){
			if(allies[i]!=null){
				enemyOptions[enemyO]=i;
				enemyO++;
			}
		}
	}
	
	public void animate(){
		frameCounter++;
		for(int i= 0; i < allies.length; i++){
			if(allies[i] != null){
				allies[i].animate();
			}
		}
		for(int i= 0; i < enemies.length; i++){
			if(enemies[i] != null){
				enemies[i].animate();
			}
		}
		if(frameCounter == 60)frameCounter = 0;
	}
	
	public void resetPos(){
		yEnemies[0] = 160;
		yEnemies[1] = 200;
		yEnemies[2] = 250;
		
		yAllies[0] = 160;
		yAllies[1] = 200;
		yAllies[2] = 250;
		for(int i = 0; i < allies.length; i++){
			if(allies[i] != null)
			yAllies[i]-=allies[i].animation[0].h;
		}
		for(int i = 0; i < enemies.length; i++){
			if(enemies[i] != null)
			yEnemies[i]-=enemies[i].animation[0].h;
		}
		for(int i = 0; i < allies.length; i++){
			if(allies[i] != null){
				allies[i].x = xAllies[i];
				allies[i].y = yAllies[i];
			}
		}
		for(int i = 0; i < enemies.length; i++){
			if(enemies[i] != null){
				enemies[i].x = xEnemies[i];
				enemies[i].y = yEnemies[i];
			}
		}
	}
	public void setOrder(){
		int numCombatants = 0;
		for(int i = 0; i < enemies.length; i++){
			if(enemies[i] != null){
				if(!enemies[i].getDead()){
					numCombatants++;
				}
			}
		}
		for(int i = 0; i < allies.length; i++){
			if(allies[i] != null){
				if(!allies[i].getDead()){
					numCombatants++;
				}
			}
		}
		attackOrder = new Combatant[numCombatants];
		
		int j = 0;
		for(int i = 0; i < enemies.length; i++){
			if(enemies[i] != null){
				if(!enemies[i].getDead()){
					attackOrder[j] = enemies[i];
					j++;
				}
			}
		}
		for(int i = 0; i < allies.length; i++){
			if(allies[i] != null){
				if(!allies[i].getDead()){
					attackOrder[j] = allies[i];
					j++;
				}
			}
		}
		//System.out.println(numCombatants);
		sortSpeeds();
		//System.out.println(numCombatants);
	}
	
	private void sortSpeeds(){
		int n = attackOrder.length;  
		Combatant temp;  
		for(int i=0; i < n; i++){  
			for(int j=1; j < (n-i); j++){  
				if(attackOrder[j-1].sp < attackOrder[j].sp){  
				                //swap elements  
					temp = attackOrder[j-1];  
					attackOrder[j-1] = attackOrder[j];  
					attackOrder[j] = temp;  
				}         
			}  
		}
	}
	
	public void render(Graphics g){
		
		renderBackground();
		renderCombatants();
		renderHealthBars(g);
		renderArrow();
		renderMenu();
		updateButtons();
		getClicks();
		//System.out.println(runButton.getClicked());
		//for(int i = 0;i<attackOrder.length)
		//Font.renderText("hi", pixels, 50, 50, new Color(200,200,200));
	}
	
	public void getClicks(){
		if(menuNum == -1){
			if(runButton.getClicked()){
				Game.switchMusic("res/music/TuturialTown.wav");
				Game.switchState(STATE.OVERWORLD);
				runButton.setPressed(false);
				runButton.setClicked(false);
			}
			if(fightButton.getClicked()){
				fightButton.setClicked(false);
				fightButton.setPressed(false);
				menuNum = 0;
				attackStep=0;
				setUpFight();
			}
		}
		else if(menuNum<attackOrder.length && menuNum>-1){
			if(attackOrder[menuNum].ai){
				attackOrder[menuNum].chooseAttack();
				attackOrder[menuNum].takeTurn(getTargets());
				
				if(menuNum<attackOrder.length-1){
					attackStep = 0;
					menuNum++;
					setUpFight();
				}
				else{
					switchToSix();
				}
			}
			else if(attackStep==0){
				if(activeButtons[activeButtons.length-1].getClicked()){
					activeButtons[activeButtons.length-1].setClicked(false);
					activeButtons[activeButtons.length-1].setPressed(false);
					while(menuNum-1>-1&&attackOrder[menuNum-1].ai){
						menuNum--;
						
					}
					if(menuNum==-1){
						activeButtons = mainCombatButtons;
					}
					else{
						setUpFight();
					}
				}
				else{
					for(int i = 0; i < activeButtons.length-1; i++){
						if(activeButtons[i]!=null){
							if(activeButtons[i].getClicked()){
								System.out.println("attackStep: "+attackStep + ", menuNum:"+menuNum);
								attackOrder[menuNum].move = SkillList.getMove(attackOrder[menuNum].skillIdList[i]);
								activeButtons[i].setClicked(false);
								activeButtons[i].setPressed(false);
								attackStep=1;
								chooseTarget();
								break;
							}
						}
					}
				}
			}
			else if(attackStep == 1){
				if(activeButtons[activeButtons.length-1].getClicked()){
					activeButtons[activeButtons.length-1].setClicked(false);
					activeButtons[activeButtons.length-1].setPressed(false);
					attackStep = 0;
					setUpFight();			
				}
				else{
					for(int i = 0; i < activeButtons.length-1; i++){
						if(activeButtons[i]!=null){
							if(activeButtons[i].getClicked()){
								activeButtons[i].setClicked(false);
								activeButtons[i].setPressed(false);
								if(i<3)
									attackOrder[menuNum].target = enemies[i];
								else if(i<6)
									attackOrder[menuNum].target = allies[i-3];
								if(menuNum<attackOrder.length-1){
									attackStep = 0;
									menuNum++;
									setUpFight();
								}
								else{
									switchToSix();
								}
								//break;
							}
						}
					}
				}
			}
		}
		else if(menuNum==6){
			if(!Dialogue.done){
				if(activeButtons[0].getClicked()){
					activeButtons[0].setClicked(false);
					activeButtons[0].setPressed(false);
					takeTurn();
					
				}
			}else{
				menuNum=-1;
				activeButtons=mainCombatButtons;
				checkWin();
			}
		}
		else if(menuNum==7){
			if(activeButtons[0].getClicked()){
				activeButtons[0].setClicked(false);
				activeButtons[0].setPressed(false);
				Game.switchMusic("res/music/TuturialTown.wav");
				Game.State = Game.STATE.OVERWORLD;
				State = BSTATE.INCOMBAT;
				menuNum = -1;
				activeButtons = mainCombatButtons;	
			}
			
		}
	}
	
	public Combatant[] getTargets(){
		Combatant targets[];
		int numTargets = 0;
		
		if(alliesTurn()){
			for(int i = 0;i<attackOrder.length;i++){
				for(int x=0;x<enemies.length;x++){
					if(attackOrder[i]==enemies[x]&&!enemies[x].getDead()){
						numTargets++;
					}
				}
			}
			targets = new Combatant[numTargets];
			numTargets=0;
			for(int x=0;x<enemies.length;x++){
				if(enemies[x]!=null&&!enemies[x].getDead()){
					targets[numTargets]=enemies[x];
					numTargets++;
				}
			}
		}
		else{
			for(int i = 0;i<attackOrder.length;i++){
				for(int x=0;x<allies.length;x++){
					if(attackOrder[i]==allies[x]&&!allies[x].getDead()){
						numTargets++;
					}
				}
			}
			targets = new Combatant[numTargets];
			numTargets=0;
			for(int x=0;x<allies.length;x++){
				if(allies[x]!=null&&!allies[x].getDead()){
					targets[numTargets]=allies[x];
					numTargets++;
				}
			}
		}
		return targets;
	}
	
	public void switchToSix(){
		String[] moves = new String[attackOrder.length];
		for(int q = 0; q < attackOrder.length;q++){
			System.out.println("got here");
			
			moves[q]=attackOrder[q].name+" used "+attackOrder[q].move.name+" on "+attackOrder[q].target.name;
		}
		activeButtons=new MenuButton[1];
		activeButtons[0]=new MenuButton(Font.makeSprite("next", false, Font.buttonFont), Font.makeSprite("next", true, Font.buttonFont), 222, 250);
		Dialogue.playConversation(moves, 50);
		menuNum=6;
	}
	
	public void takeTurn(){
		
		//if(Dialogue.done)
		
		if(!attackOrder[turn].getDead())
			attackOrder[turn].move.go(attackOrder[turn],attackOrder[turn].target);
		
		for(int i = 0; i < enemies.length;i++){
			if(enemies[i]!=null&&enemies[i].hp<=0){
				enemies[i].hp=0;
				enemies[i].die();
			}
		}
		for(int i = 0; i < allies.length;i++){
			if(allies[i]!=null&&allies[i].hp<=0){
				allies[i].hp=0;
				allies[i].die();
			}
		}
		
		/*for(int j = 0; j<attackOrder.length; j++){
			if(attackOrder[j].hp <= 0){
				attackOrder[j].hp = 0;
				attackOrder[j].die();
			}
		}
		
		/*turn++;
		if(turn == attackOrder.length){
			turn = 0;
			setOrder();
		}*/
		turn++;
		Dialogue.next();
		if(turn==attackOrder.length)turn=0;
		while(attackOrder[turn].getDead()){
			turn++;
			Dialogue.next();
			if(turn == attackOrder.length){
				turn = 0;
				setOrder();
			}
		}
		
		//}
	}
	public void checkWin(){
		for(int j = 0; j<attackOrder.length; j++){
			if(attackOrder[j].hp <= 0){
				attackOrder[j].hp = 0;
				attackOrder[j].die();
			}
		}
		//turn=0;
		boolean enemiesAlive = false;
		boolean alliesAlive = false;
		for(int j = 0; j < enemies.length; j++){
			if(enemies[j] != null){
				if(!enemies[j].getDead()){
					enemiesAlive = true;
				}
			}
		}
		for(int k = 0; k < allies.length; k++){
			if(allies[k] != null){
				if(!allies[k].getDead()){
					alliesAlive = true;
				}
			}
				
		}
		if(!enemiesAlive){
			win();
		}
		else if(!alliesAlive){
			lose();
		}
	}
	public void win(){
		//set new button, grant xp, display stuff
		menuNum = 7;
		activeButtons = new MenuButton[1];
		activeButtons[0] =  new MenuButton(Font.makeSprite("done", false, Font.buttonFont), Font.makeSprite("done", true, Font.buttonFont), 214, 200);
		if(e!=null){
			e.set(false);
		}
		for(int i = 0;i<allies.length;i++){
			if(allies[i]!=null)
				allies[i].tempAd=allies[i].ad;
		}
		State = BSTATE.WIN;
	}
	
	public void lose(){
		State = BSTATE.LOSS;
	}
	
	public void exit(){
		init = false;
		Game.switchMusic("res/music/TuturialTown.wav");
		Game.State = Game.STATE.OVERWORLD;
	}
	
	public boolean alliesTurn(){
		for(int i = 0; i < allies.length;i++){
			if(attackOrder[menuNum]==allies[i]){
				return true;
			}
		}
		for(int i = 0; i < enemies.length;i++){
			if(attackOrder[menuNum]==enemies[i]){
				return false;
			}
		}
		System.out.println("oh boy attack order turn is not an enemy or allie wtf boom");
		return false;
	}
	
	public void chooseTarget(){
		if(Dialogue.done){
			activeButtons = new MenuButton[7];
			Sprite off1 = Font.makeSprite("back", false, Font.buttonFont);
	 		Sprite on1 = Font.makeSprite("back", true, Font.buttonFont);
			activeButtons[6] = new MenuButton(off1, on1, 145 + (192-off1.w)/2, 267);
			
			
				for(int j = 0; j < enemies.length; j++){
					if(enemies[j] != null && !enemies[j].getDead()){
						
						Sprite off = Font.makeSprite(enemies[j].name, false, Font.buttonFont);
				 		Sprite on = Font.makeSprite(enemies[j].name, true, Font.buttonFont);
						activeButtons[j] = new MenuButton(off, on, 145 + (96-off.w)/2, 197+20*j);
						
					}
				}
			
				for(int j = 0; j < allies.length; j++){
					if(allies[j] != null && !allies[j].getDead()){
						
						Sprite off = Font.makeSprite(allies[j].name, false, Font.buttonFont);
				 		Sprite on = Font.makeSprite(allies[j].name, true, Font.buttonFont);
						activeButtons[j+3] = new MenuButton(off, on, 240 + (96-off.w)/2, 197+20*j);
						
					}
				}
			
		}
	}
	
	public void setUpFight(){
		
			activeButtons = new MenuButton[attackOrder[menuNum].skillIdList.length+1];
			//System.out.println(activeButtons.length);
			//System.out.println(attackOrder[turn].skillIdList.length);
			for(int i = 0; i<activeButtons.length; i++){
				if(i == activeButtons.length -1)
			 		activeButtons[i] = new MenuButton(Font.makeSprite("back", false, Font.buttonFont), Font.makeSprite("back", true, Font.buttonFont), 218, 275);
				else if(i<4){
					Sprite off = Font.makeSprite(SkillList.getAttackName(attackOrder[menuNum].skillIdList[i]), false, Font.buttonFont);
			 		Sprite on = Font.makeSprite(SkillList.getAttackName(attackOrder[menuNum].skillIdList[i]), true, Font.buttonFont);
					activeButtons[i] = new AttackButton(off, on, 145 + (96-off.w)/2, 197+20*i, SkillList.getAttackName(i), i);
				}
			 	else if(i<8){
			 		Sprite off = Font.makeSprite(SkillList.getAttackName(attackOrder[menuNum].skillIdList[i]), false, Font.buttonFont);
			 		Sprite on = Font.makeSprite(SkillList.getAttackName(attackOrder[menuNum].skillIdList[i]), true, Font.buttonFont);
					activeButtons[i] = new AttackButton(off, on, 240+(96-off.w)/2, 197+20*(i-4), SkillList.getAttackName(i), i);
			 	}
			 	
			}
	}

	
	public void renderMenu(){
		if(State == BSTATE.INCOMBAT){
			for(int y = 0; y < battleMenuBg.h; y++){
				int ya = y + 192; 
				for(int x = 0; x < battleMenuBg.w; x++){
					int xa = x + 144;
					if(xa < -battleMenuBg.w || xa >= width || ya < 0 || ya >= height) break;
					if(xa<0) xa = 0;
					int col = battleMenuBg.pixels[x+y*battleMenuBg.w];
					if(col != 0x000000){	
						int red = 0xFF & ( pixels[xa + ya * width] >> 16);
						int blue = 0xFF & ( pixels[xa + ya * width] >> 0);
						int green = 0xFF & ( pixels[xa + ya * width] >> 8);
						
						int red1 = 0xFF & ( col >> 16);
						int blue1 = 0xFF & ( col >> 0);
						int green1 = 0xFF & ( col >> 8);
	
						red = red1 + red>>2;
						blue = blue1 + blue>>2;
						green = green1 + green>>2;
						
						pixels[xa + ya * width] =(red<<16) | (green<<8) | blue; 
					}
				}
			}
		}
		else if (State == BSTATE.WIN){
			//SSystem.out.println("I am being called");
			
			for(int y = 0; y < height; y++){
				for(int x = 0; x < width; x++){
					
						int red = 0xFF & ( pixels[x + y * width] >> 16);
						int blue = 0xFF & ( pixels[x + y * width] >> 0);
						int green = 0xFF & ( pixels[x + y * width] >> 8);
	
						red = red>>2;
						blue = blue>>2;
						green = green>>2;
						
						pixels[x + y * width] =(red<<16) | (green<<8) | blue; 
					
				}
			}
			pixels = Font.renderText("you won good job", pixels, 50, 50);
		}
	}
	public void renderButton(MenuButton button){
		for(int y = 0; y < button.sCurrent.h; y++){
			int ya = y + button.getY(); 
			for(int x = 0; x < button.sCurrent.w; x++){
				int xa = x + button.getX();
				if(xa < -button.sCurrent.w || xa >= width || ya < 0 || ya >= height) break;
				if(xa<0) xa = 0;
				int col = button.sCurrent.pixels[x+y*button.sCurrent.w];
				if(col != 0x000000){	
					pixels[xa + ya * width] = button.sCurrent.pixels[x + y*button.sCurrent.w];
				}
			}
		}
	}
	public void renderArrow(){
		for(int y = 0; y < Sprite.arrow.h; y++){
			int ya;
			if(menuNum>-1&&menuNum<attackOrder.length)
				ya = y + attackOrder[menuNum].y - 8+frameCounter/30;
			else{
				ya = y + attackOrder[0].y - 8+frameCounter/30;	
			}
			for(int x = 0; x < Sprite.arrow.w; x++){
				int xa;
				if(menuNum>-1&&menuNum<attackOrder.length)xa = x + attackOrder[menuNum].x;
				else xa = x + attackOrder[0].x;
				if(xa < -Sprite.arrow.w || xa >= width || ya < 0 || ya >= height) break;
				if(xa<0) xa = 0;
				int col = Sprite.arrow.pixels[x+y*Sprite.arrow.w];
				if(col != 0x000000)
					pixels[xa + ya * width] = Sprite.arrow.pixels[x+ y*Sprite.arrow.w]; //add numbers here to tint						
			}
		}
	}
	public void renderBackground(){
		for(int y = 0; y < background.pixels.length; y++){
			pixels[y] = background.pixels[y];
		}//add numbers here to tint	
	}
	public void renderCombatants(){
		for(int i= 0; i < allies.length; i++){
			if(allies[i] != null){
				for(int y = 0; y < allies[i].sprite.h; y++){
					int ya = y + yAllies[i]; 
					for(int x = 0; x < allies[i].sprite.w; x++){
						int xa = x + xAllies[i];
						if(xa < -allies[i].sprite.w || xa >= width || ya < 0 || ya >= height) break;
						if(xa<0) xa = 0;
						int col = allies[i].sprite.pixels[x+y*allies[i].sprite.w];
						if(col != 0x000000){	
							pixels[xa + ya * width] = allies[i].sprite.pixels[x+ y*allies[i].sprite.w]; 
						}//add numbers here to tint
					}
				}
			}
		}
		
		for(int i= 0; i < enemies.length; i++){
			if(enemies[i] != null){
				for(int y = 0; y < enemies[i].sprite.h; y++){
					int ya = y + yEnemies[i]; 
					for(int x = enemies[i].sprite.w -1; x >= 0; x--){
						int xa = enemies[i].sprite.w -1- x + xEnemies[i];
						if(xa < -enemies[i].sprite.w || xa >= width || ya < 0 || ya >= height) break;
						if(xa<0) xa = 0;
						int col = enemies[i].sprite.pixels[x+y*enemies[i].sprite.w];
						if(col != 0x000000)
							pixels[xa + ya * width] = enemies[i].sprite.pixels[x+ y*enemies[i].sprite.w]; //replace sprite with animation[0] maybe
					}
				}
			}
		}
	}
	
	public void renderHealthBars(Graphics g){
		for(int i= 0; i < allies.length; i++){
			if(allies[i] != null){
				for(int y = 0; y < Sprite.healthBar.h; y++){
					int ya = y + yAllies[i] + allies[i].animation[0].h; 
					for(int x = 0; x < Sprite.healthBar.w; x++){
						int xa = x + xAllies[i];
						if(xa < -Sprite.healthBar.w || xa >= width || ya < 0 || ya >= height) break;
						if(xa<0) xa = 0;
						int col = Sprite.healthBar.pixels[x+y*Sprite.healthBar.w];
						if(col != 0x000000)
							pixels[xa + ya * width] = Sprite.healthBar.pixels[x+ y*Sprite.healthBar.w]; //add numbers here to tint						
					}
				}
			}
		}
		for(int i= 0; i < enemies.length; i++){
			if(enemies[i] != null){
				for(int y = 0; y < Sprite.healthBar.h; y++){
					int ya = y + yEnemies[i] + enemies[i].animation[0].h; 
					for(int x = 0; x < Sprite.healthBar.w; x++){
						int xa = x + xEnemies[i];
						if(xa < -Sprite.healthBar.w || xa >= width || ya < 0 || ya >= height) break;
						if(xa<0) xa = 0;
						int col = Sprite.healthBar.pixels[x+y*Sprite.healthBar.w];
						if(col != 0x000000)
							pixels[xa + ya * width] = Sprite.healthBar.pixels[x+ y*Sprite.healthBar.w]; //add numbers here to tint						
					}
				}
			}
		}
		g.setColor(new Color(0x00177a00));
		for(int i = 0; i < allies.length; i++){
			if(allies[i] != null){
				g.fillRect((xAllies[i] +2)*Game.scale, (yAllies[i] + allies[i].animation[0].h + 1)*Game.scale, allies[i].hp*28/allies[i].mhp*Game.scale, 3*Game.scale);
			}
		}
		for(int i = 0; i < enemies.length; i++){
			if(enemies[i] != null){
				g.fillRect((xEnemies[i] +2)*Game.scale, (yEnemies[i] + enemies[i].animation[0].h + 1)*Game.scale, enemies[i].hp*28/enemies[i].mhp*Game.scale, 3*Game.scale);
			}
		}
	}
	
	public void clear(){
		for(int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
	}
	public void updateButtons(){
		for(int i = 0; i< activeButtons.length; i++){
			if(activeButtons[i] != null){
				activeButtons[i].update();
				renderButton(activeButtons[i]);
			}
		}
	}
}
