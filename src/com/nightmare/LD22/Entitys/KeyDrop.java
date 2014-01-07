package com.nightmare.LD22.Entitys;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;

import com.nightmare.LD22.FrameWork.Res;

import it.marteEngine.entity.Entity;

public class KeyDrop extends Entity{

	public KeyDrop(float x, float y) {
		super(x, y);
		corX = 25;
		corY = 25;
		setGraphic(Res.sprites.getSprite(5, 3));
		setHitBox(10, 10, 30, 30);
	}

	@Override
	public void update(GameContainer container, int delta)
			throws SlickException {
		super.update(container, delta);
		if (angle < 360) {
			angle++;
		} else {
			angle = 0;
		}
		if (collide(PLAYER, x, y) != null) {
			this.destroy();
			Player.keys++;
		}
	}
	
	
}
