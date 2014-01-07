package com.nightmare.LD22.States;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import MenuEntities.Logo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.nightmare.LD22.FrameWork.Main;

import it.marteEngine.World;
import it.marteEngine.entity.Entity;

public class Splash extends World {

	public Splash(int id, GameContainer container) throws SlickException {
		super(id, container);
	}

	@Override
	public int getID() {
		return Main.Splash;
	}

	@Override
	public void init(GameContainer container, StateBasedGame sbg)
			throws SlickException {
		super.init(container, sbg);
		new java.util.Timer().schedule(new java.util.TimerTask() {
			@Override
			public void run() {
				if (Main.game.getCurrentStateID() == Main.Splash) {
					Main.game.enterState(Main.Menu, new FadeOutTransition(
							Color.black), new FadeInTransition(Color.white));
					Entity l = find("Logo");
					l.destroy();
				}
			}
		}, 2000);
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics gr)
			throws SlickException {
		super.render(gc, sbg, gr);
		gr.setBackground(Color.white);
		gr.scale(0.5f, 0.5f);
		Logo s = new Logo(Main.gcWidth / 2 - 400, Main.gcHeight / 2 - 226);
		add(s);
		if (Gdx.input.isKeyPressed(Keys.ANY_KEY)
				&& Main.game.getCurrentStateID() == Main.Splash) {
			Main.game.enterState(Main.Menu);
		}
	}
}
