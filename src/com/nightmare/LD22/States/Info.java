package com.nightmare.LD22.States;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import MenuEntities.BackButton;

import com.badlogic.gdx.Gdx;
import com.nightmare.LD22.Entitys.Player;
import com.nightmare.LD22.FrameWork.Main;

import it.marteEngine.World;

public class Info extends World {

	BackButton bb;
	String infoText = 
		"This game was created for LD22, a game competition in";
	String it2 = "which you are given 48 hours to complete a game to the";
	String it3 = "______________________given theme__________________" ;
	String it4 = "All game code and assets were created by NightmareApps.";
	String it5 = "NightmareApps has more games for computer and Android";
	String it6 = "which can be found at NightmareApps.com! Enjoy.";
	

	public Info(int id, GameContainer container) {
		super(id, container);
		bb = new BackButton(10, 10, 50, 50);
		add(bb);
		Player p = new Player(-9999, -9999);
		add(p);
	}

	public void render(GameContainer container, StateBasedGame game, Graphics gr)
			throws SlickException {
		super.render(container, game, gr);
		gr.setBackground(Color.darkGray);
		gr.setFont(Main.font);
		gr.drawString(infoText, 25, 175);
		gr.drawString(it2, 25, 200);
		gr.drawString(it3, 25, 225);
		gr.drawString(it4, 25, 300);
		gr.drawString(it5, 25, 325);
		gr.drawString(it6, 25, 350);


	}

	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		super.update(container, game, delta);
		if (Gdx.input.isTouched()) {
			if (BackButton.r.contains(Player.mouseX, Player.mouseY)) {
				// ithink Dont need to remember the back button cause we're
				// using it
				// Main.lastState = Main.game.getCurrentStateID();
				Main.game.enterState(Main.lastState);
			}
		}
	}

	@Override
	public int getID() {
		return Main.Info;
	}
}
