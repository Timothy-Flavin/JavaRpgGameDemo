package com.Tim.chrimeria;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.Tim.chrimeria.Game.STATE;

public class Menu {
	private enum MENUNUM{
		MAIN,
		NEWGAME,
		SETTINGS
	};
	private MENUNUM MenuNum = MENUNUM.MAIN;
	
	int width = Game.width;
	int height = Game.height;
	int scale = Game.scale;
	int[] pixels = new int[width*height];
	int[] bigPixels = new int[width*scale * height*scale];
	BufferedImage bg;
	Image img, title;
	
	
	MenuButton mpb, msb, mqb;
	
	
	Color darkGrey = new Color(200,200,200);
	Color lightGrey = new Color(230,230,230);
	boolean playPressed = false, settingsPressed = false, quitPressed = false;

	public Menu(){
		try{
			bg = ImageIO.read(Menu.class.getResource("/backgrounds/MainMenu.png"));// makes a buffered image
			img = bg.getScaledInstance(width*scale, height*scale, Image.SCALE_SMOOTH);
			title = ImageIO.read(Menu.class.getResource("/backgrounds/Title.png"));// makes a buffered image
			title = title.getScaledInstance(title.getWidth(null)*scale*2, title.getHeight(null)*scale*2, Image.SCALE_SMOOTH);
			mpb = new MenuButton("/backgrounds/PlayButton.png", "/backgrounds/PlayButtonPressed.png", (width/2)*scale, height * scale / 5 + 40*scale);
			msb = new MenuButton("/backgrounds/SettingsButton.png", "/backgrounds/SettingsButtonPressed.png", (width/2)*scale, height * 2 * scale / 5+ 40*scale);
			mqb = new MenuButton("/backgrounds/QuitButton.png", "/backgrounds/QuitButtonPressed.png", (width/2)*scale, height * 3 * scale / 5+ 40*scale);
			
		}catch(IOException e) { //in case the sheet is not there
			e.printStackTrace();
		}
	}
	
	public void updateButtons(){
		mpb.update();
		msb.update();
		mqb.update();
	}
	
	public void render(Graphics g){
		scale = Game.scale;
		updateButtons();
		g.drawImage(img, 0, 0, null);
		g.drawImage(title, width*scale/2 - title.getWidth(null)/2, 3*scale, null);
		if(MenuNum == MENUNUM.MAIN){

			g.drawImage(mpb.getImage(), mpb.getX(), mpb.getY(), null);
			g.drawImage(msb.getImage(), msb.getX(), msb.getY(), null);
			g.drawImage(mqb.getImage(), mqb.getX(), mqb.getY(), null);
			if(mpb.clicked){
				mpb.clicked = false;
				mpb.pressed = false;
				Game.switchState(STATE.OVERWORLD);
				Game.switchMusic("res/music/TuturialTown.wav");
				//Dialogue.playConversation(TextToRender.getDialogueByName("intro").getTextArray());
			}
			if(mqb.clicked){
				Game.quit();
			}
		}
	}
	
}
