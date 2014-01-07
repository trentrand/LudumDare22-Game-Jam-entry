package com.nightmare.LD22.Entitys;

import it.marteEngine.entity.Entity;

public class Bounds extends Entity {

	public Bounds(float x, float y, int width, int height) {
		super(x, y);
		setHitBox(0, 0, width, height);
		addType(SOLID);
	}

}
