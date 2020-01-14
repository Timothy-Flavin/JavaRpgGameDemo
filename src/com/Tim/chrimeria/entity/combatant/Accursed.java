package com.Tim.chrimeria.entity.combatant;

import com.Tim.chrimeria.graphics.Sprite;
import com.Tim.chrimeria.graphics.SpriteSheet;

public class Accursed extends Combatant{
	
	public Accursed(int lvl){
		super(lvl);
		name = "accursed";
		animation = new Sprite[]{
				new Sprite(32, 32, 4, 6, SpriteSheet.combatSprites),
				new Sprite(32, 32, 5, 6, SpriteSheet.combatSprites),
				new Sprite(32, 32, 6, 6, SpriteSheet.combatSprites),
				new Sprite(32, 32, 7, 6, SpriteSheet.combatSprites),
				new Sprite(32, 32, 8, 6, SpriteSheet.combatSprites),
				new Sprite(32, 32, 9, 6, SpriteSheet.combatSprites),
				new Sprite(32, 32, 10, 6, SpriteSheet.combatSprites),
				new Sprite(32, 32, 11, 6, SpriteSheet.combatSprites),
				new Sprite(32, 32, 4, 7, SpriteSheet.combatSprites),
				new Sprite(32, 32, 5, 7, SpriteSheet.combatSprites),
				new Sprite(32, 32, 6, 7, SpriteSheet.combatSprites),
				new Sprite(32, 32, 7, 7, SpriteSheet.combatSprites),
				new Sprite(32, 32, 8, 7, SpriteSheet.combatSprites),
				new Sprite(32, 32, 9, 7, SpriteSheet.combatSprites),
				new Sprite(32, 32, 10, 7, SpriteSheet.combatSprites),
				new Sprite(32, 32, 11, 7, SpriteSheet.combatSprites),
		};
		sprite = animation[0];
		animationFrames = 16;
		fps = 20;
		animationLength = animationFrames * (60/fps);
		bhp = 5;
		bad = 2;
		bap = 3;
		bmr = 3;
		bar = 3;
		bsp = 4;
		mhp = bhp*lvl; hp = mhp; ad = bad*lvl; ap = bap*lvl; mr = bmr*lvl; ar = bar*lvl; sp = bsp*lvl;
	}
	public void animate(){
		super.animate();
	}
	public void takeTurn(){
		
	}
	
	public void die(){
		dead = true;
	}
	
	public void levelUp(){
		
	}
}