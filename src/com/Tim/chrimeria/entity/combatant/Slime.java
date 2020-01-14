package com.Tim.chrimeria.entity.combatant;

public class Slime extends Combatant{
	public Slime(int lvl){
		super(lvl);
		animationFrames = 4;
		fps = 3;
		animationLength = animationFrames * (60/fps);
		bhp = 5;
		bad = 2;
		bap = 3;
		bmr = 3;
		bar = 3;
		bsp = 4;
		mhp = bhp*lvl; hp = mhp; ad = bad*lvl; ap = bap*lvl; mr = bmr*lvl; ar = bar*lvl; sp = bsp*lvl;
	}
	
	public void takeTurn(){
		
	}
	
	public void die(){
		dead = true;
	}
	
	public void levelUp(){
		
	}
}
