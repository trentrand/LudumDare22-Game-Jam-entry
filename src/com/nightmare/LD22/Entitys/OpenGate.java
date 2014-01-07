package com.nightmare.LD22.Entitys;



import com.nightmare.LD22.FrameWork.Res;

import it.marteEngine.entity.Entity;

public class OpenGate extends Entity {

	public OpenGate(float x, float y) {
		super(x, y);
		setGraphic(Res.sprites.getSubImage(300, 350, 200, 58));
//		addType(SOLID);
		name = "Gate";
	}
	
//	public void collisionResponse(Entity other) {
//		if (other.isType(Player.PLAYER)) {
//			if (Player.keys > 0) {
//				Player.keys --;
//				setHitBox(1000, 0, 0, 0);
////				setGraphic(Res.sprites.getSubImage(300, 350, 200, 59));
//			}
//		}
//	}
}
