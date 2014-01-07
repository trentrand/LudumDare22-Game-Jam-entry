package com.nightmare.LD22.FrameWork;

import java.awt.Font;
import java.io.InputStream;

import it.marteEngine.ME;
import it.marteEngine.World;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.util.ResourceLoader;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Input.Keys;
import com.nightmare.LD22.States.*;

/**
 * LD22 Demo working on Android and OS
 * 
 */
public class Main extends StateBasedGame implements ApplicationListener {

	public static final int GameState = 0;
	public static final int Help = 1;
	public static final int Menu = 2;
	public static final int Splash = 3;
	public static final int Info = 4;
	public static final int StoryLine = 5;
	public static final int G2 = 6;
	public static final int G3 = 7;
	public static final int G4 = 8;
	public static final int G5 = 9;
	public static final int CutScence = 10;


	public static int gcWidth, gcHeight;
	public static Main game = null;
    public static World w;
	public static final String GATE = "GATE";
	public static final String WALL = "Wall";
	public static final String END = "End";
	public static final String ENEMY = "Enemy";
public static float pStartX;
public static float pStartY;
	
	public static int lastState;

	/** volume for SFX and music */
	public static float musicVolume = 1.0f;
	public static float sfxVolume = 1.0f;
	
	public static TrueTypeFont font;
	public static TrueTypeFont font2;
	public static GameState world;

	public Main() {
		super("No Longer Alone");
		game = this;
	}

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		gcWidth = getContainer().getWidth();
		gcHeight = getContainer().getHeight();
		Res.load();
		
		 
		// load a default java font
		Font awtFont = new Font("Times New Roman", Font.BOLD, 24);
		font = new TrueTypeFont(awtFont, true);
		 
		// load font from a .ttf file
		try {
		InputStream inputStream = ResourceLoader.getResourceAsStream("resources/minimal.TTF");
		 
		Font awtFont2 = Font.createFont(Font.TRUETYPE_FONT, inputStream);
		awtFont2 = awtFont2.deriveFont(24f); // set font size
		font2 = new TrueTypeFont(awtFont2, true);
		 
		} catch (Exception e) {
		e.printStackTrace();
		}  
		gc.setMaximumLogicUpdateInterval(50);
		 gc.setIcon("resources/icon.png");

		addState(new GameState(GameState, gc));
		addState(new Help(Help, gc));
		addState(new Menu(Menu, gc));
		addState(new Splash(Splash, gc));
		addState(new StoryLine(StoryLine, gc));
		addState(new Info(Info, gc));
		addState(new G2(G2, gc));
		addState(new G3(G3, gc));
		addState(new G4(G4, gc));
		addState(new G5(G5, gc));
		addState(new CutScence(CutScence, gc));

		ME.keyFullScreen = Keys.DEL;

		enterState(Splash);
//		 enterState(Help);
	}

	@Override
	public void create() {
	}

	@Override
	public void dispose() {
	}

	@Override
	public void pause() {
	}

	@Override
	public void render() {
	}

	@Override
	public void resize(int arg0, int arg1) {
	}

	@Override
	public void resume() {
	}

}
