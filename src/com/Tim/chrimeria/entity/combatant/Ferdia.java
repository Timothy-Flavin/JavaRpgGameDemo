package com.Tim.chrimeria.entity.combatant;

import com.Tim.chrimeria.graphics.Sprite;
import com.Tim.chrimeria.graphics.SpriteSheet;

public class Ferdia extends Combatant{
	public Ferdia(int lvl){
		super(lvl);
		name = "ferdia";
		animation = new Sprite[]{
			new Sprite(32, 64, 6, 10, SpriteSheet.combatSprites),
			new Sprite(32, 64, 7, 10, SpriteSheet.combatSprites),
			new Sprite(32, 64, 8, 10, SpriteSheet.combatSprites),
		};
		sprite = animation[0];
		animationFrames = 3;
		fps = 3;
		animationLength = animationFrames * (60/fps);
		bhp = 500;
		bad = 25;
		bap = 3;
		bmr = 3;
		bar = 3;
		bsp = 40;
		mhp = bhp*lvl; hp = mhp; ad = bad*lvl; ap = bap*lvl; mr = bmr*lvl; ar = bar*lvl; sp = bsp*lvl;
		tempAd=ad;
		skillIdList = new int[4];
		for(int i = 0; i < skillIdList.length; i++){
			skillIdList[i] = i;
		}
	}
	
	public void takeTurn(){
		
	}
	public void animate(){
		super.animate();
	}
	public void die(){
		dead = true;
	}
	
	public void levelUp(){
		super.levelUp();
	}
}
