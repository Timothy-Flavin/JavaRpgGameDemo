package com.Tim.chrimeria.graphics;

import java.awt.Color;

public class Font {
	public static Font buttonFont = new Font(new SpriteSheet("/fonts/fivebysevensimple.png", 91,55), 7, 11);
	public static Font dialogueFont = new Font(new SpriteSheet("/fonts/font.png",36,36), 6, 6);
	public  Sprite[] letters;
	private int letterWidth,letterHeight;
	public Font(SpriteSheet sp, int letterWidth, int letterHeight){
		this.letterWidth = letterWidth;
		this.letterHeight = letterHeight;
		letters = Sprite.split(letterWidth, letterHeight, sp);
	}
	//private static SpriteSheet font = new SpriteSheet("/fonts/font.png", 56);
	public static Sprite makeSprite(String words, boolean pressed, Font font){
		Sprite[] word = new Sprite[words.length()+2];
			if(!pressed) words = "["+words+"]";
			else words = "{"+words+"}";
		for(int i = 0; i < words.length(); i++){
			word[i] = font.letters[getLetter(words.charAt(i))];
		}
		
		return wordMaker(word, font.letterWidth, font.letterHeight);
	}
	public static Sprite makeSprite(String words, Font font){
		Sprite[] word = new Sprite[words.length()];
		for(int i = 0; i < words.length(); i++){
			//System.out.println(i);
			word[i] = font.letters[getLetter(words.charAt(i))];
		}
		
		return wordMaker(word, font.letterWidth, font.letterHeight);
	}
	
	private static Sprite wordMaker(Sprite[] wordArray, int width, int height){
		//System.out.println(wordArray[0].pixels.length);
		
		Sprite wordSprite = new Sprite(width*wordArray.length, height);
		
		for(int i = 0; i < wordArray.length; i++){
			for(int y = 0; y < height; y++){
				for(int x = 0; x < width; x++){
					wordSprite.pixels[x+width*i + y*width*wordArray.length] = wordArray[i].pixels[x + y*width];
				}
			}
		}
		
		return wordSprite;
	}
	
	public static int[] renderText(String text, int[] pixels, int xloc, int yloc){
		Sprite ts = makeSprite(text, dialogueFont);
		for(int y = 0; y < ts.h; y++){
			int ya = y +yloc; 
			for(int x = 0; x < ts.w; x++){
				int xa = x + xloc;
				if(xa < -ts.w || xa >= 480 || ya < 0 || ya >= 288) break;
				if(xa<0) xa = 0;
				int col = ts.pixels[x+y*ts.w];
				if(col != 0x000000){	
					pixels[xa + ya * 480] = ts.pixels[x + y*ts.w];
				}
			}
		}
		return pixels;
	}
	public static int[] renderText(String text, int[] pixels, int xloc, int yloc, Color color){
		Sprite ts = makeSprite(text, dialogueFont);
		for(int y = 0; y < ts.h; y++){
			int ya = y +yloc; 
			for(int x = 0; x < ts.w; x++){
				int xa = x + xloc;
				if(xa < -ts.w || xa >= 480 || ya < 0 || ya >= 288) break;
				if(xa<0) xa = 0;
				int col = ts.pixels[x+y*ts.w];
				if(col != 0x000000){	
					pixels[xa + ya * 480] = color.getRGB();
				}
			}
		}
		return pixels;
	}
	
	private static int getLetter(char l){
		if(l == 'a') return 0;
		if(l == 'b') return 1;
		if(l == 'c') return 2;
		if(l == 'd') return 3;
		if(l == 'e') return 4;
		if(l == 'f') return 5;
		if(l == 'g') return 6;
		if(l == 'h') return 7;
		if(l == 'i') return 8;
		if(l == 'j') return 9;
		if(l == 'k') return 10;
		if(l == 'l') return 11;
		if(l == 'm') return 12;
		if(l == 'n') return 13;
		if(l == 'o') return 14;
		if(l == 'p') return 15;
		if(l == 'q') return 16;
		if(l == 'r') return 17;
		if(l == 's') return 18;
		if(l == 't') return 19;
		if(l == 'u') return 20;
		if(l == 'v') return 21;
		if(l == 'w') return 22;
		if(l == 'x') return 23;
		if(l == 'y') return 24;
		if(l == 'z') return 25;
		if(l == ' ') return 30;
		if(l == '[') return 26;
		if(l == ']') return 27;
		if(l == '{') return 28;
		if(l == '}') return 29;
		if(l == '.') return 31;
		if(l == ',') return 32;
		if(l == '!') return 33;
		if(l == '?') return 34;
		if(l == '(') return 26;
		if(l == ')') return 27;
		if(l == '\'')return 35;
		
		return 666;
		
	}
	
}
