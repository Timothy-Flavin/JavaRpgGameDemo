package com.Tim.chrimeria.entity.combatant;

import com.Tim.chrimeria.graphics.Sprite;
import com.Tim.chrimeria.graphics.SpriteSheet;

public class MaeveSoldier2 extends Combatant{
	public MaeveSoldier2(int lvl){
		super(lvl);
		name = "player";
		name = "soldier";
		animation = new Sprite[]{
			new Sprite(32, 64, 9, 10, SpriteSheet.combatSprites),
			new Sprite(32, 64, 10, 10, SpriteSheet.combatSprites),
			new Sprite(32, 64, 11, 10, SpriteSheet.combatSprites),
		};
		sprite = animation[0];
		animationFrames = 3;
		fps = 3;
		animationLength = animationFrames * (60/fps);
		bhp = 5;
		bad = 2;
		bap = 3;
		bmr = 3;
		bar = 3;
		bsp = 4;
		mhp = bhp*lvl; hp = mhp; ad = bad*lvl; ap = bap*lvl; mr = bmr*lvl; ar = bar*lvl; sp = bsp*lvl;
		skillIdList = new int[5];
		tempAd=ad;
		for(int i = 0; i < skillIdList.length-1; i++){
			skillIdList[i] = i;
		}
		skillIdList[4]=8;
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
