package com.Tim.chrimeria.entity.combatant;

import com.Tim.chrimeria.graphics.Sprite;
import com.Tim.chrimeria.graphics.SpriteSheet;

public class PlayerCombatant extends Combatant{
	
	public PlayerCombatant(int lvl){
		super(lvl);
		name = "Player";
		name = "necromancer";
		animation = new Sprite[]{
			new Sprite(32, 64, 0, 1, SpriteSheet.combatSprites),
			new Sprite(32, 64, 1, 1, SpriteSheet.combatSprites),
			new Sprite(32, 64, 2, 1, SpriteSheet.combatSprites),
			new Sprite(32, 64, 3, 1, SpriteSheet.combatSprites),
			new Sprite(32, 64, 4, 1, SpriteSheet.combatSprites),
			new Sprite(32, 64, 5, 1, SpriteSheet.combatSprites),
			new Sprite(32, 64, 6, 1, SpriteSheet.combatSprites),
			new Sprite(32, 64, 7, 1, SpriteSheet.combatSprites),
		};
		sprite = animation[0];
		animationFrames = 8;
		fps = 8;
		animationLength = animationFrames * (60/fps);
		bhp = 5;
		bad = 2;
		bap = 3;
		bmr = 3;
		bar = 3;
		bsp = 4;
		mhp = bhp*lvl; hp = mhp; ad = bad*lvl; ap = bap*lvl; mr = bmr*lvl; ar = bar*lvl; sp = bsp*lvl;
		
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
