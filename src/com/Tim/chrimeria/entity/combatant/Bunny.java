package com.Tim.chrimeria.entity.combatant;

import com.Tim.chrimeria.graphics.Sprite;
import com.Tim.chrimeria.graphics.SpriteSheet;

public class Bunny extends Combatant{
	public Bunny(int lvl){
		super(lvl);
		name = "bunny";
		animation = new Sprite[]{
				new Sprite(32, 32, 0, 0, SpriteSheet.combatSprites),
				new Sprite(32, 32, 1, 0, SpriteSheet.combatSprites),
				new Sprite(32, 32, 2, 0, SpriteSheet.combatSprites),
				new Sprite(32, 32, 3, 0, SpriteSheet.combatSprites),
				new Sprite(32, 32, 4, 0, SpriteSheet.combatSprites),
				new Sprite(32, 32, 5, 0, SpriteSheet.combatSprites),
				new Sprite(32, 32, 6, 0, SpriteSheet.combatSprites),
				new Sprite(32, 32, 7, 0, SpriteSheet.combatSprites),
				new Sprite(32, 32, 8, 0, SpriteSheet.combatSprites),
				new Sprite(32, 32, 9, 0, SpriteSheet.combatSprites),
				new Sprite(32, 32, 10, 0, SpriteSheet.combatSprites),
				new Sprite(32, 32, 11, 0, SpriteSheet.combatSprites)
		};
		sprite = animation[0];
		animationFrames = 12;
		fps = 10;
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
	public void animate(){
		super.animate();
	}
}
