package com.nightmare.LD22.States;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.nightmare.LD22.Entitys.Bounds;
import com.nightmare.LD22.Entitys.Bullet;
import com.nightmare.LD22.Entitys.Player;
import com.nightmare.LD22.FrameWork.Level;
import com.nightmare.LD22.FrameWork.Main;
import com.nightmare.LD22.FrameWork.Res;
import com.nightmare.LD22.FrameWork.sc;

import it.marteEngine.World;
import it.marteEngine.entity.Entity;

public class GameState extends World implements ApplicationListener {
	public static int levelNum = 1;
	public static Level level;
	public static float pStartX = 650;
	public static float pStartY = 550;
	 private int gunFrame = 0;
	    private int gunTimer = 0;
	    private int gunInterval = 250;

	public GameState(int id, GameContainer gc) throws SlickException {
		super(id, gc);
		gc.setShowFPS(true);
		Main.w = this;
		loadLevel();

	}

	@Override
	public int getID() {
		return Main.GameState;
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		super.update(container, game, delta);
		if (Player.bullets > 0) {
			if (Gdx.input.isButtonPressed(0)) {
				gunInterval = 100;
                gunTimer -= delta;
                while (gunTimer <= 0) {
                    gunFrame++;
                    gunTimer += gunInterval;
                    if (gunFrame > 1) {
                    	Entity p = find("Player");
        				Bullet b = new Bullet(p.x + 25, p.y + 25, Player.mouseAngle);
        				add(b);
        				Player.bullets --;
                        gunFrame = 0;
                    }
                }
				
			}
		}
	}
	
	public void render(GameContainer container, StateBasedGame game, Graphics gr)
			throws SlickException {
		super.render(container, game, gr);
		gr.setBackground(Color.darkGray);
		for (int i = 0; i < Player.keys; i++) {
			gr.drawImage(Res.sprites.getSubImage(267, 161, 13, 25),
					10 + (i * 16), 10);
		}
		for (int i = 0; i < Player.bullets; i++) {
			gr.drawImage(Res.sprites.getSubImage(319, 165, 17, 14),
					10 + (i * 20), 40);
		}
	}

	public void enter(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		super.enter(gc, sbg);

		// gr.setColor(Color.white);
		// gr.fillRect(0, 0, 300, 300);
	}

	public void loadLevel() throws SlickException {
		// levelNum++;
		if (Level.levelExists(levelNum)) {
			level = Level.load(levelNum, this);
		} else {
			sc.print("Level doesnt exist");
		}
//		pStartX = find("Player").x;
//		pStartY = find("Player").y;
		sc.print(pStartX + " " + pStartY);
		Bounds north = new Bounds(0, -1, 800, 1);
		add(north);
		Bounds east = new Bounds(800, 0, 1, 600);
		add(east);
		Bounds south = new Bounds(0, 600, 800, 1);
		add(south);
		Bounds west = new Bounds(-1, 0, 1, 600);
		add(west);

	}

	@Override
	public void create() {
	}

	@Override
	public void dispose() {
	}

	@Override
	public void pause() {
	}

	@Override
	public void render() {
	}

	@Override
	public void resize(int arg0, int arg1) {
	}

	@Override
	public void resume() {
	}

}
