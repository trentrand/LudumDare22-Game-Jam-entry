package com.nightmare.LD22.States;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import MenuEntities.HelpButton;
import MenuEntities.InfoButton;
import MenuEntities.PlayButton;

import com.badlogic.gdx.Gdx;
import com.nightmare.LD22.Entitys.Player;
import com.nightmare.LD22.FrameWork.Main;
import com.nightmare.LD22.FrameWork.Res;

import it.marteEngine.World;

public class Menu extends World {

	PlayButton pb;
	HelpButton hb;
	InfoButton ib;

	public Menu(int id, GameContainer container) {
		super(id, container);
		pb = new PlayButton(Main.gcWidth / 2 - 100, Main.gcHeight / 3 - 50 + 100,
				200, 100);
		add(pb);
		Player p = new Player(-9999, -9999);
		add(p);
		hb = new HelpButton(Main.gcWidth / 3 - 100, Main.gcHeight / 2 + 100,
				200, 100);
		add(hb);
		ib = new InfoButton(Main.gcWidth  - 400, Main.gcHeight / 2 + 100,
				200, 100);
		add(ib);
	}

	public void render(GameContainer container, StateBasedGame game, Graphics gr)
			throws SlickException {
		super.render(container, game, gr);
		gr.setBackground(Color.darkGray);
		gr.scale(2, 2);
		gr.setColor(Color.gray);
		gr.drawImage(Res.sprites.getSubImage(200, 200, 300, 50), 50, 50	);
	}

	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		super.update(container, game, delta);
		if (Gdx.input.isTouched()) {
			if (PlayButton.r.contains(Player.mouseX, Player.mouseY)) {
				Main.lastState = Main.game.getCurrentStateID();
				Main.game.enterState(Main.StoryLine);
//				this.clear();
			}
			else if (HelpButton.r.contains(Player.mouseX, Player.mouseY)) {
				Main.lastState = Main.game.getCurrentStateID();
				Main.game.enterState(Main.Help);
//				this.clear();
			} else if (InfoButton.r.contains(Player.mouseX, Player.mouseY)) {
				Main.lastState = Main.game.getCurrentStateID();
				Main.game.enterState(Main.Info);
//				this.clear();
			}
		}
	}

	@Override
	public int getID() {
		return Main.Menu;
	}
}
