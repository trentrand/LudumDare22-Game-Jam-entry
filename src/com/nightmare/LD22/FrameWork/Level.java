package com.nightmare.LD22.FrameWork;

import it.marteEngine.World;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.util.ResourceLoader;

import com.nightmare.LD22.Entitys.*;
import com.nightmare.LD22.Entitys.Player;

public class Level {
	public final static char WALL = '-';
	public final static char PLAYER = 'P';
	public final static char LRGUARD = '@';
	public final static char UDGUARD = '^';
	public final static char CCWGUARD = '[';
	public final static char CWGUARD = ']';
	public final static char STAIR = 'M';
	public final static char GATE = 'H';
	public final static char GATE2 = '2';
	public final static char GATE3 = '3';
	public final static char GATE4 = '4';
	public final static char GATE5 = '5';
	public final static char KEY = 'K';
	public final static char BULLET = 'B';


	private ArrayList<String> lines = null;
	public int levelNum;
	private static String startingXCoord = null;
	private static String startingYCoord = null;

	public static boolean levelExists(int levelNum) {
		String level = "resources/level" + levelNum + ".dat";
		try {
			ResourceLoader.getResourceAsStream(level);
		} catch (RuntimeException e) {
			return false;
		}
		return true;
	}

	public static Level load(int levelNum, World GameState)
			throws SlickException {
		String level = "resources/level" + levelNum + ".dat";

		Level levelLoaded = null;
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				ResourceLoader.getResourceAsStream(level)));
		levelLoaded = new Level();
		levelLoaded.lines = new ArrayList<String>();
		levelLoaded.levelNum = levelNum;
		int width = 0;
		int height = 0;

		try {
			int count = 0;
			while (reader.ready()) {
				String line = reader.readLine();
				count++;
				if (count == 1) {
					startingXCoord = line;
				}
				if (count == 2) {
					startingYCoord = line;
				}
				if (line == null) {
					break;
				}
				if (count > 2) {
					width = Math.max(line.length(), width);
					levelLoaded.lines.add(line);
				}
			}
		} catch (IOException ex) {
			sc.print("Failed to load level");
		}
		height = levelLoaded.lines.size();
		levelLoaded.createEntites(levelLoaded, width - 1, height - 1, GameState);
//		sc.print("level loaded succesfullly");
		return levelLoaded;
	}

	private void createEntites(Level levelLoaded, int width, int height,
			World world) throws SlickException {
		int a = Integer.parseInt(startingXCoord);
		int b = Integer.parseInt(startingYCoord);
		for (int i = width; i >= 0; i--) {
			for (int j = height; j >= 0; j--) {
				char c = lines.get(j).charAt(i);

				float x = (i * 50) + a;
				float y = (j * 50) + b;
				switch (c) {
				case WALL:
					world.add(new Wall(x, y));
					break;
				case LRGUARD:
					world.add(new LineGuard(x, y, false));
					break;
				case UDGUARD:
					world.add(new LineGuard(x, y, true));
					break;
				case CCWGUARD:
					world.add(new AreaGuard(x, y, false));
					break;
				case CWGUARD:
					world.add(new AreaGuard(x, y, true));
					break;
				case PLAYER:
					world.add(new Player(x, y));
					break;
				case STAIR:
					world.add(new EndPoint(x, y));
					break;
				case GATE:
					world.add(new Gate(x, y, 1));
					break;
				case GATE2:
					world.add(new Gate(x, y, 2));
					break;
				case GATE3:
					world.add(new Gate(x, y, 3));
					break;
				case GATE4:
					world.add(new Gate(x, y, 4));
					break;
				case GATE5:
					world.add(new Gate(x, y, 5));
					break;
				case KEY:
					world.add(new KeyDrop(x, y));
					break;
				case BULLET:
					world.add(new BulletDrop(x, y));
					break;
				}
			}
		}
	}
}
