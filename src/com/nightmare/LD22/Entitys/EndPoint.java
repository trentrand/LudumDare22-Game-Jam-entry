package com.nightmare.LD22.Entitys;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;

import com.nightmare.LD22.FrameWork.Main;
import com.nightmare.LD22.FrameWork.Res;
import it.marteEngine.entity.Entity;

public class EndPoint extends Entity {

	public EndPoint(float x, float y) {
		super(x, y);
		setGraphic(Res.sprites.getSubImage(250, 0, 100, 50));
		setHitBox(0, 0, 100, 15);
		addType(Main.END);
	}

	@Override
	public void update(GameContainer container, int delta)
			throws SlickException {
		super.update(container, delta);
		if (collide(Player.PLAYER, x, y) != null) {
			if (Main.game.getCurrentStateID() == Main.GameState) {
				Main.game.enterState(Main.G2);
//				Main.pStartX = world.find("Player").x;
//				Main.pStartY = world.find("Player").y;
			} else if (Main.game.getCurrentStateID() == Main.G2) {
				Main.game.enterState(Main.G3);
//				Main.pStartX = world.find("Player").x;
//				Main.pStartY = world.find("Player").y;
			} else if (Main.game.getCurrentStateID() == Main.G3) {
				Main.game.enterState(Main.G4);
//				Main.pStartX = world.find("Player").x;
//				Main.pStartY = world.find("Player").y;
			} else if (Main.game.getCurrentStateID() == Main.G4) {
				Main.game.enterState(Main.G5);
//				Main.pStartX = world.find("Player").x;
//				Main.pStartY = world.find("Player").y;
			} else if (Main.game.getCurrentStateID() == Main.G5) {
				Main.game.enterState(Main.CutScence);
//				Main.pStartX = world.find("Player").x;
//				Main.pStartY = world.find("Player").y;
			}
		}
	}
}
