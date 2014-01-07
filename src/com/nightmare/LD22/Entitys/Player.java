package com.nightmare.LD22.Entitys;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.nightmare.LD22.FrameWork.Main;
import com.nightmare.LD22.FrameWork.Res;
import com.nightmare.LD22.FrameWork.sc;

import it.marteEngine.ME;
import it.marteEngine.entity.Entity;

public class Player extends Entity implements InputProcessor {

	public static float mouseX, mouseY;
	public static int keys = 0;
	public static int health = 100;
	public static int bullets = 3;
    public static int mouseAngle;

	public Player(float x, float y) {
		super(x, y);
		Gdx.input.setInputProcessor(this);
		setGraphic(Res.sprites.getSprite(1, 0));
		depth = 100;
		setHitBox(0, 0, 50, 50);
		mouseX = 0;
		mouseY = 0;
		corX = 25;
		corY = 25;
		name = "Player";
		addType(PLAYER);
		centered = true;

		// speed = new Vector2f(4, 4);

	}

	@Override
	public void update(GameContainer container, int delta)
			throws SlickException {
		super.update(container, delta);
		sc.print(mouseX + "  " + mouseY);
		mouseAngle = (int) calculateAngle(x, y,
                Player.mouseX, Player.mouseY);
		
		mouseX = Gdx.input.getX();
		mouseY = Gdx.input.getY();
		Vector2f mouse = new Vector2f(mouseX, mouseY);
		angle = getAngleToPosition(mouse);
		if ((Gdx.input.isKeyPressed(Keys.UP) || (Gdx.input.isKeyPressed(Keys.W)))
				&& collide(SOLID, x, y - 2) == null) {
			y -= 2;
		}
		if ((Gdx.input.isKeyPressed(Keys.DOWN) || (Gdx.input
				.isKeyPressed(Keys.S))) && collide(SOLID, x, y + 2) == null) {
			y += 2;
		}
		if ((Gdx.input.isKeyPressed(Keys.LEFT) || (Gdx.input
				.isKeyPressed(Keys.A))) && collide(SOLID, x - 2, y) == null) {
			x -= 2;
		}
		if ((Gdx.input.isKeyPressed(Keys.RIGHT) || (Gdx.input
				.isKeyPressed(Keys.D))) && collide(SOLID, x + 2, y) == null) {
			x += 2;
		}

	}

	@Override
	public void render(GameContainer gc, Graphics gr) throws SlickException {
		super.render(gc, gr);
	}

	@Override
	public boolean keyDown(int keycode) {
		if (keycode == Keys.BACKSLASH) {
			Main.game.enterState(Main.Menu);
		}
		// if ((keycode == Keys.UP || keycode == Keys.W)
		// && collide(SOLID, x, y - 50) == null) {
		// y -= 50;
		// } else if ((keycode == Keys.DOWN || keycode == Keys.S)
		// && collide(SOLID, x, y + 50) == null) {
		// y += 50;
		// } else if ((keycode == Keys.LEFT || keycode == Keys.A)
		// && collide(SOLID, x - 50, y) == null) {
		// x -= 50;
		// } else if ((keycode == Keys.RIGHT || keycode == Keys.D)
		// && collide(SOLID, x + 50, y) == null) {
		// x += 50;
		// }
		if (keycode == Keys.HOME) {
			ME.debugEnabled = true;
		}
		return false;
	}

	@Override
	public boolean keyTyped(char key) {
		return false;
	}

	@Override
	public boolean keyUp(int arg0) {
		return false;
	}

	@Override
	public boolean scrolled(int arg0) {
		return false;
	}

	@Override
	public boolean touchDown(int x, int y, int pointer, int button) {

		
		// TODO debug to tp
		if (Gdx.input.isKeyPressed(Keys.SPACE)) {
			this.x = ((int) ((x + 25) / 50) * 50);
			this.y = ((int) ((y + 25) / 50) * 50);
		}
		
		return false;
	}

	@Override
	public boolean touchDragged(int arg0, int arg1, int arg2) {
		return false;
	}

	@Override
	public boolean touchMoved(int x, int y) {
		
		return false;
	}

	@Override
	public boolean touchUp(int arg0, int arg1, int arg2, int arg3) {
		return false;
	}

}
