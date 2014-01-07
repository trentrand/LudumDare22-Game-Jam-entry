package com.nightmare.LD22.Entitys;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import com.nightmare.LD22.FrameWork.Res;

import it.marteEngine.entity.Entity;

public class Wall extends Entity {

	
	public Wall(float x, float y) {
		super(x, y);
		setGraphic(Res.sprites.getSubImage(0, 0, 50, 50));
		addType(SOLID, COLLIDABLE);
		name = "Wall";
		setHitBox(0, 0, 50, 50);
		depth = 50;
		
	}

	@Override
	public void render(GameContainer gc, Graphics gr) throws SlickException {
		super.render(gc, gr);
	}
}
