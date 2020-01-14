package com.Tim.chrimeria.entity.mob;

import com.Tim.chrimeria.Game;
import com.Tim.chrimeria.Game.STATE;
import com.Tim.chrimeria.dialogue.Dialogue;
import com.Tim.chrimeria.entity.combatant.Combatant;
import com.Tim.chrimeria.entity.combatant.Cuchulain;
import com.Tim.chrimeria.graphics.Screen;
import com.Tim.chrimeria.graphics.Sprite;
import com.Tim.chrimeria.input.Keyboard;
import com.Tim.chrimeria.input.Mouse;

public class Player extends Mob{
	
	public boolean moved = false, inEncounter = false, inDialogue = false;
	public static boolean e = false;
	public boolean startGame=true;
	private Keyboard input;
	public Combatant pCombatant;
	private int tempx,tempy;
	//private boolean standingEvent = true;
	//public int animationCounter = 0;
	
	public Player(Keyboard input){
		this.input = input;
		setStats();
	}
	public Player(int x, int y, Keyboard input){
		this.x = x;
		this.y = y;
		this.input = input;
		setStats();
	}
	public int getDir(){
		return dir;
	}
	public void go(int d){
		if(d==0){
			ya=-1;
		}
		else if(d==1){
			xa=1;
		}
		else if(d==2){
			ya=1;
		}
		else if(d==3){
			xa=-1;
		}
		moving = true;
		animationCounter = 0;
		pathing = false;
	}
	public void setStats(){
		pCombatant = new Cuchulain(30);
	}
	
	public void update(Screen screen){
		
		if(input.e){
			
			switch(dir){
				case 0:
					if(Game.getLevel().doEvent(x, y-32))e = true;
					//System.out.println(x+", "+(y-32));
					break;
				case 1:
					if(Game.getLevel().doEvent(x+32, y))e = true;
					break;
				case 2:
					if(Game.getLevel().doEvent(x, y+32))e = true;
					break;
				case 3:
					if(Game.getLevel().doEvent(x-32, y))e = true;
					break;
				
			}
			
			/*if(Dialogue.done && !e){
				String[] s = new String[2];
				s[0] = "great! you pressed e. good job. after wandering around a bit, how about you go see if you can find a weapon?";
				s[1] = "wdhaio waifoiyawofihoaiwhf oiahwofihoahwfoih awoihfohawf";
				Dialogue.playConversation(s);
				inDialogue = true;
				e = true;
			}*/
			if(!Dialogue.done && !e){
				Dialogue.next();
				//inDialogue = !Dialogue.done;
				e = true;
			}
		}
		else if(!input.e){
			e=false;
		}
		if(input.escape&&Dialogue.done){
			if(screen.canOpenOrClose(input))screen.menuOpen = !screen.menuOpen;
		}
		else{
			screen.canOpenOrClose(input);
		}
		if(screen.menuOpen||!Dialogue.done){
		}
		else{
			if(!moving){
				//if(standingEvent){
				Game.getLevel().doEvent(x,y);  //needs to be optimized later
					//standingEvent=false;
				//}
				updateMove(screen);
				if(xa!=0 || ya!=0){
					inEncounter = false;
					move();
				}
				
			}	
			else{
				//standingEvent=true;
				/*if(Mouse.getButton() == 1)
					queuePath(Mouse.getX(), Mouse.getY(), x, y);*/
				tempx=x;
				tempy=y;
				if(input.up || input.down || input.left || input.right)
					pathing = false;
				move();
				if(!(tempx==x&&tempy==y))
					moved = true;
			}
		}
		
	}
	
	public void updateMove(Screen screen){

			//System.out.println(Game.State);
	
		if(Mouse.getButton() == 1){
			int xAr = x + (Mouse.getX()/Game.scale - 224);
			xAr -= xAr%32;
				
			int yAr = y + (Mouse.getY()/Game.scale - 128);
			yAr -= yAr%32;
			path(xAr, yAr);
		}
		
		if(input.up || input.down || input.left || input.right || input.escape || inEncounter){
			xa = 0;
			ya = 0;
			pathing = false;
		}
		if(inEncounter){
			
			Game.State = STATE.COMBAT;
			inEncounter = false;
			Game.enterCombat();
			//System.out.println(Game.State);
		}
		
		if(input.shift) speed = 2;
		else speed = 1;
		if(input.up) ya-=1;
		if(input.down) ya += 1;
		if(ya == 0){
			if(input.left) xa -= 1;
			if(input.right) xa += 1;
		}
	}
		
	
	
	public void render(Screen screen){
		if(!moving)
			screen.renderPlayer(x, y, Sprite.player[dir*4]);
		else{
			if(animationCounter > 24)
				screen.renderPlayer(x, y, Sprite.player[dir*4+3]);
			else if(animationCounter > 16)
				screen.renderPlayer(x, y, Sprite.player[dir*4+2]);
			else if(animationCounter > 8)
				screen.renderPlayer(x, y, Sprite.player[dir*4+1]);
			else
				screen.renderPlayer(x, y, Sprite.player[dir*4]);
		}
		screen.renderMenu();
	}
	protected void encounter(){
		//System.out.println("easy and in the right place?");
		if(level.getTile((x)/32, (y)/32).encounter()){
			xa = 0;
			ya = 0;
			Game.State = STATE.COMBAT;
			pathing = false;
			Game.enterCombat();
		}
	}
	public void setPathing(boolean t){
		pathing = t;
	}
}
