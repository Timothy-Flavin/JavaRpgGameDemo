package com.Tim.chrimeria.dialogue;

import com.Tim.chrimeria.Game;
import com.Tim.chrimeria.graphics.Font;
import com.Tim.chrimeria.graphics.Sprite;

public class Dialogue {
	private static int lineLength = 0;
	private static int i=0;
	private static int frame = 0;
	private static int lineNum = 0;
	private static int yLoc = 0;
	public static boolean done = true;
	public static Sprite dialogueBox = new Sprite(300,100,10);
	private static Sprite[] currentWords = new Sprite[2];
	private static String[] lines, subLines;

	public static void playConversation(String[] text){
		lines = text;
		lineLength = text[0].length();
		subLines = splitString(text[0],45);
		frame = 0;
		lineNum = 0;
		i=0;
		lineNum = 0;
		done = false;
		yLoc=175;
		//System.out.println("convo started?" + text[0].length());
	}
	public static void playConversation(String[] text, int y){
		lines = text;
		lineLength = text[0].length();
		subLines = splitString(text[0],45);
		frame = 0;
		lineNum = 0;
		i=0;
		lineNum = 0;
		done = false;
		yLoc=y;
		//System.out.println("convo started?" + text[0].length());
	}
	public static String[] splitString(String txt, int num){
	
		int splitPos = 0, j=0, count=0;
		String subtxt = txt;
		String[] txts=new String[txt.length()];
		
		while(1<=txt.length()){
			splitPos=0;
			count=0;
			if(txt.length()<num){
				txts[j]=txt;
				txt="";
			}
			else{
				while((count+subtxt.indexOf(' ')<num)&&subtxt.indexOf(' ')>=0){
					splitPos=subtxt.indexOf(' ')+1;
					subtxt=subtxt.substring(splitPos);
					count+=splitPos;
				}
				txts[j]=txt.substring(0, count);
				
				txt=txt.substring(count);
				
			}
			j++;
		}
		String[] textArray = new String[j];
		for(int q = 0; q < j; q++){
			textArray[q]=txts[q];
		}
		currentWords = new Sprite[textArray.length];
		return textArray;
		
	}
	public static void renderText(int[] pixels){
		
		if(!done){
				
				lineLength = lines[lineNum].length();
				//System.out.println("not done" + frame);
				for(int i = 0; i < currentWords.length; i++){
					if(frame<accumulate(i+1) && frame > accumulate(i)){
						//System.out.println(frame + " frame" + i + " substring end" + (frame-(i*subLines[i].length())+1));
						currentWords[i] = Font.makeSprite(subLines[i].substring(0,(frame-(accumulate(i))+1)), Font.dialogueFont);//i*subLines[i].length()
					}
				}
				
				makeDialogue(currentWords);
				renderDialogue(pixels);
				
		}
	}
	public static int accumulate(int x){
		int c = 0;
		for(int i = 0; i < x; i++){
			c+=subLines[i].length();
		}
		return c;
	}
	public static void updateText(){
		if(frame < lineLength){
			i++;
			if(i >=2){
				frame++;
				i=0;
			}
		}
	}
	private static void renderDialogue(int[] pixels){
		for(int y = 0; y < dialogueBox.h; y++){
			int ya = y + yLoc; 
			for(int x = 0; x < dialogueBox.w; x++){
				int xa = x + 100;
					pixels[xa + ya * Game.width] = dialogueBox.pixels[x+y*dialogueBox.w];
				
			}
		}
	}
	private static void makeDialogue(Sprite[] sp){
		int ya = 0, xa = 0;
		for(int i = 0; i < sp.length;i++){
			if(sp[i]!=null)
			for(int y = 0; y < sp[i].h; y++){
				ya = 10*(i+1)+y;
				for(int x = 0; x < sp[i].w; x++){
					xa = 10+x;
					dialogueBox.pixels[xa+ya*dialogueBox.w] = sp[i].pixels[x+y*sp[i].w];
				}
			}
		}
	}
	public static void next(){
		frame = 0;
		i=0;
		lineNum++;
		if(lineNum == lines.length){
			done = true;
			lineNum = 0;
		}
		subLines = splitString(lines[lineNum],45);
		dialogueBox = new Sprite(300,100,10);
	}
}

/*if(count!=0){
				txts[j]=txt.substring(0, count+1);
				System.out.println("about to to txt=txt.substring");
				txt=txt.substring(count+1);
			}
			else if(txt.length()>num){
				txts[j]=txt.substring(0, num+1);
				System.out.println("about to to txt=txt.substring");
				txt=txt.substring(num+1);
			}
			else{
				txts[j]=txt;
				txt="";
			}*/
