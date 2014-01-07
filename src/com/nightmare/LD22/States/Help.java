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
import it.marteEngine.entity.TextEntity;

public class Help extends World {
	BackButton bb;

	public Help(int id, GameContainer container) {
		super(id, container);
		
		bb = new BackButton(10, 10, 50, 50);
		add(bb);
		Player p = new Player(-9999, -9999);
		add(p);
	
		TextEntity te = new TextEntity(50, 75, Main.font,
				"To play, control your character with WASD or Arrow");
		add(te);
		TextEntity te2 = new TextEntity(50, 100, Main.font,
				"Keys. Don't let the guards see you!");
		add(te2);
		TextEntity te3 = new TextEntity(50, 125, Main.font,
				"Your keys and bullets are displayed in the top left corner.");
		add(te3);
		TextEntity te4 = new TextEntity(50, 150, Main.font,
				"Get to the stair case you can escape!");
		add(te4);
		TextEntity te5 = new TextEntity(50, 175, Main.font,
				"The gate blocking the fence requires keys.");
		add(te5);
		TextEntity te6 = new TextEntity(50, 200, Main.font,
				"Click it when you get enough.");
		add(te6);
		TextEntity te7 = new TextEntity(50, 225, Main.font,
				"Push left click to shoot, but dont waste all your bullets!");
		add(te7);
	}

	public void render(GameContainer container, StateBasedGame game, Graphics gr)
			throws SlickException {
		super.render(container, game, gr);
		gr.setBackground(Color.darkGray);
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
		return Main.Help;
	}
}
