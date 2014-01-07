package com.nightmare.LD22.States;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import com.badlogic.gdx.ApplicationListener;
import com.nightmare.LD22.Entitys.Bounds;
import com.nightmare.LD22.Entitys.Player;
import com.nightmare.LD22.FrameWork.Level;
import com.nightmare.LD22.FrameWork.Main;
import com.nightmare.LD22.FrameWork.Res;
import com.nightmare.LD22.FrameWork.sc;

import it.marteEngine.World;

public class G3 extends World implements ApplicationListener {
	public static int levelNum = 3;
	public static Level level;
	public static float pStartX = 650;
	public static float pStartY = 500;
	public G3(int id, GameContainer gc) throws SlickException {
		super(id, gc);
		gc.setShowFPS(true);
		Main.w = this;
		loadLevel();

	}

	@Override
	public int getID() {
		return Main.G3;
	}

	public void render(GameContainer container, StateBasedGame game, Graphics gr)
			throws SlickException {
		super.render(container, game, gr);
		gr.setBackground(Color.darkGray);
		for (int i = 0; i < Player.keys; i++) {
			gr.drawImage(Res.sprites.getSubImage(267, 161, 13, 25),
					10 + (i * 16), 10);
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
