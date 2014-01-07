package com.nightmare.LD22.Entitys;
//done
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import com.nightmare.LD22.FrameWork.Main;
import com.nightmare.LD22.FrameWork.Res;

import it.marteEngine.entity.Entity;

public class Bullet extends Entity {

	public static final String BULLET = "bullet";

	int speed = 5;

	private double moveX;

	private double moveY;

	public Bullet(float x, float y, int angle) {
		super(x, y);
		this.angle = angle;
//		centered = true;
		setGraphic(Res.sprites.getSubImage(370, 169, 10, 10));
		setHitBox(0,-10, 10, 10);
		this.name = "bullet";
		this.depth = 50;
		addType(BULLET, COLLIDABLE);
	}

	@Override
	public void update(GameContainer container, int delta)
			throws SlickException {
		super.update(container, delta);
		moveX = Math.sin(Math.toRadians(angle));
		moveY = Math.cos(Math.toRadians(angle));
		this.x += moveX * speed;
		this.y -= moveY * speed;
		if (collide(COLLIDABLE, x, y) != null) {
			this.destroy();
		}
		if (collide(Main.ENEMY, x, y) != null) {
			this.destroy();
		}
	}

	public void collisionResponse(Entity other) {
	}

	@Override
	public void render(GameContainer gc, Graphics gr) throws SlickException {
		super.render(gc, gr);

	}

	public void leftWorldBoundaries() {
		// the player unfortunately left the screen - so we retry
		world.remove(this);
	}

}
