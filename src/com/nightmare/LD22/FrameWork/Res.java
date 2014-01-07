package com.nightmare.LD22.FrameWork;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class Res {
	public static SpriteSheet sprites;
	
	public static void load() throws SlickException {
		sprites = new SpriteSheet("resources/spritesheet.png", 50, 50);
	}
}
