package com.nightmare.LD22.Entitys;
//done
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import com.nightmare.LD22.FrameWork.Main;
import com.nightmare.LD22.FrameWork.Res;

import it.marteEngine.entity.Entity;

public class EnemyBullet extends Entity {

	int speed = 5;

	private double moveX;

	private double moveY;
	public static final String ENEMYBULLET = "EnemyBullet";

	public EnemyBullet(float x, float y, int angle) {
		super(x, y);
		this.angle = angle;
//		centered = true;
		setGraphic(Res.sprites.getSubImage(370, 169, 10, 10));
		setHitBox(0,-10, 10, 10);
//		this.name = "bullet";
		this.depth = 50;
		addType(ENEMYBULLET);
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
		if (collide(PLAYER, x, y) != null) {
			this.destroy();
			Player.health -= 50;
		}
	}

	public void collisionResponse(Entity other) {
	}

	@Override
	public void render(GameContainer gc, Graphics gr) throws SlickException {
		super.render(gc, gr);
		if (collide(LineGuard.COLLIDABLE, x, y) != null) {
			gr.setColor(Color.red);
			gr.drawRect(x, y, 25, 25	);
		}

	}

	public void leftWorldBoundaries() {
		// the player unfortunately left the screen - so we retry
		world.remove(this);
	}

}
