package com.nightmare.LD22.States;

import java.awt.Font;
import java.io.InputStream;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.util.ResourceLoader;

import MenuEntities.Text;

import com.nightmare.LD22.FrameWork.Main;

import it.marteEngine.World;

public class CutScence extends World {

	Text t3;
	public static TrueTypeFont font;
	public static TrueTypeFont font2;

	public CutScence(int id, GameContainer container) {
		super(id, container);
		Font awtFont = new Font("Times New Roman", Font.BOLD, 24);
		font = new TrueTypeFont(awtFont, true);

		// load font from a .ttf file
		try {
			InputStream inputStream = ResourceLoader
					.getResourceAsStream("resources/minimal.TTF");

			Font awtFont2 = Font.createFont(Font.TRUETYPE_FONT, inputStream);
			awtFont2 = awtFont2.deriveFont(24f); // set font size
			font2 = new TrueTypeFont(awtFont2, true);

		} catch (Exception e) {
			e.printStackTrace();
		}

		Text t = new Text(25, 600, font, "You're free!");
		add(t);
		Text t1 = new Text(25, 625, font,
				"The world is colorful again... and you're no longer ALONE!");
		add(t1);
		Text t2 = new Text(25, 750, font,
				"This game was made by NightmareApps at NightmareApps.com");
		add(t2);
		Text t4 = new Text(25, 775, font,
				"The game was made in 48 hours for LudumDare 22");
		add(t4);
		Text t5 = new Text(25, 800, font,
				"Make sure to check out my other games for Android and computer...");
		add(t5);
		t3 = new Text(25, 825, font, "Thanks for playing my LD22 entry!");
		add(t3);

	}

	@Override
	public int getID() {
		return Main.CutScence;
	}

	public void render(GameContainer container, StateBasedGame game, Graphics gr)
			throws SlickException {
		super.render(container, game, gr);
	}

	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		super.update(container, game, delta);
		if (t3.y + 25 < 0) {
			System.exit(0);
		}
	}

}
