package com.nightmare.LD22.Entitys;


import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

import com.badlogic.gdx.Gdx;
import com.nightmare.LD22.FrameWork.Main;
import com.nightmare.LD22.FrameWork.Res;
import com.nightmare.LD22.FrameWork.sc;
import com.nightmare.LD22.States.GameState;

import it.marteEngine.entity.Entity;

public class Gate extends Entity {

	public int locksLeft = 1;
	
	public Gate(float x, float y, int locks) {
		super(x, y);
		locksLeft = locks;
		setGraphic(Res.sprites.getSubImage(350, 0, 100, 50));
		setHitBox(0, 0, 100, 50);
		addType(Main.GATE, SOLID);
		name = "gate";
		
	}
	
	@Override
	public void render(GameContainer gc, Graphics gr) throws SlickException {
		super.render(gc, gr);
		gr.drawString("" + locksLeft, x, y);
	}
	
	@Override
	public void update(GameContainer container, int delta)
			throws SlickException {
		super.update(container, delta);
		if (Gdx.input.isTouched()) {
			if (collide(Player.PLAYER, Player.mouseX, Player.mouseY) != null) {
				if (this.getDistance(new Vector2f(Player.mouseX, Player.mouseY)) < 55) {
					if (Player.keys > 0 && locksLeft > 0) {
						Player.keys --;
						locksLeft--;
					}
				}
			}
		}
		if (locksLeft <= 0) {
		this.destroy();
		OpenGate og = new OpenGate(x - 50, y);
		world.add(og);
		}
	}
	
	public void collisionResponse(Entity other) {
//		if (other.isType(Player.PLAYER)) {
//			
//		}
	}
}
