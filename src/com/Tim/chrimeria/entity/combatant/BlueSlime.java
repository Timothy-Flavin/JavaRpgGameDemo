package com.Tim.chrimeria.entity.combatant;

import com.Tim.chrimeria.graphics.Sprite;
import com.Tim.chrimeria.graphics.SpriteSheet;

public class BlueSlime extends Slime{
	public BlueSlime(int lvl){
		super(lvl);
		name = "blue slime";
		animation = new Sprite[]{
				new Sprite(32, 32, 0, 7, SpriteSheet.combatSprites),
				new Sprite(32, 32, 1, 7, SpriteSheet.combatSprites),
				new Sprite(32, 32, 2, 7, SpriteSheet.combatSprites),
				new Sprite(32, 32, 3, 7, SpriteSheet.combatSprites)
		};
		sprite = animation[0];
		bhp = 6;
		bad = 2;
		bap = 3;
		bmr = 4;
		bar = 4;
		bsp = 4;
		mhp = bhp*lvl; hp = mhp; ad = bad*lvl; ap = bap*lvl; mr = bmr*lvl; ar = bar*lvl; sp = bsp*lvl;
		skillIdList = new int[5];
		for(int i = 0; i < skillIdList.length-1; i++){
			skillIdList[i] = i;
		}
		skillIdList[4]=8;
	}
	
	public void takeTurn(){
		
	}
	
	public void die(){
		dead = true;
	}
	
	public void levelUp(){
	
	}
	public void animate(){
		super.animate();
	}
}
