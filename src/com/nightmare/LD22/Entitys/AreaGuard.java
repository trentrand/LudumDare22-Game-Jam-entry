package com.nightmare.LD22.Entitys;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import com.nightmare.LD22.FrameWork.Main;
import com.nightmare.LD22.FrameWork.Res;
import com.nightmare.LD22.States.G2;
import com.nightmare.LD22.States.G3;
import com.nightmare.LD22.States.G4;
import com.nightmare.LD22.States.G5;
import com.nightmare.LD22.States.GameState;

import it.marteEngine.entity.Entity;

public class AreaGuard extends Entity {

	public boolean cw;
	public int dir = 3;
	int up = 1;
	int down = 180;
	int right = 90;
	int left = 270;

	public AreaGuard(float x, float y, boolean cw) {
		super(x, y);
		setGraphic(Res.sprites.getSprite(2, 0));
		depth = 100;
		setHitBox(10, 0, 30, 50);
		this.cw = cw;
		corX = 25;
		corY = 25;
		addType(COLLIDABLE, Main.ENEMY);

	}

	@Override
	public void update(GameContainer container, int delta)
			throws SlickException {
		super.update(container, delta);
		if (cw == false) {
			if (collide(SOLID, x + 2, y) != null) {
				dir = 1;
				setHitBox(10, 0, 30, 50);
			}
			if (collide(SOLID, x, y - 2) != null) {
				dir = 4;
				setHitBox(0, 10, 50, 30);
			}
			if (collide(SOLID, x - 2, y) != null) {
				dir = 3;
				setHitBox(10, 0, 30, 50);
			}
			if (collide(SOLID, x, y + 2) != null) {
				dir = 2;
				setHitBox(0, 10, 50, 30);
			}
			if (dir == 1) {
				y -= 2;
				angle = up;
			} else if (dir == 2){
				x += 2;
				angle = right;
			} else if (dir == 3){
				y += 2;
				angle = down;
			} else if (dir == 4){
				x -= 2;
				angle = left;
			}
		}
		if (cw) {
			if (collide(SOLID, x + 2, y) != null) {
				dir = 3;
				setHitBox(10, 0, 30, 50);
			}
			if (collide(SOLID, x, y - 2) != null) {
				dir = 2;
				setHitBox(0, 10, 50, 30);
			}
			if (collide(SOLID, x - 2, y) != null) {
				dir = 1;
				setHitBox(10, 0, 30, 50);
			}
			if (collide(SOLID, x, y + 2) != null) {
				dir = 4;
				setHitBox(0, 10, 50, 30);
			}
			if (dir == 1) {
				y -= 2;
			} else if (dir == 2){
				x += 2;
			} else if (dir == 3){
				y += 2;
			} else if (dir == 4){
				x -= 2;
			}
		}
	}

	@Override
	public void render(GameContainer gc, Graphics gr) throws SlickException {
		super.render(gc, gr);
		Entity player = world.find("Player");

		if (!cw) {
			if (dir == 3) {
				for (int i = 0; i < 12; i++) {
					if (this.collide(SOLID, x, y + (50 * i)) != null) {
						break;
					} else if (this.collideWith(player, x, y + (50 * i)) != null) {
						spotted();
//						gr.setColor(Color.red);
//						gr.fillRect(x, y + (50 * i), 50, 50);
					}
				}
			} else if (dir == 1) {
				for (int i = 0; i < 12; i++) {
					if (this.collide(SOLID, x, y - (50 * i)) != null) {
						break;
					} else if (this.collideWith(player, x, y - (50 * i)) != null) {
						spotted();
//						gr.setColor(Color.red);
//						gr.fillRect(x, y - (50 * i), 50, 50);
					}
				}
			} else if (dir == 2) {
				for (int i = 0; i < 12; i++) {
					if (this.collide(SOLID, x + (50 * i), y ) != null) {
						break;
					} else if (this.collideWith(player, x + (50 * i), y) != null) {
						spotted();
//						gr.setColor(Color.red);
//						gr.fillRect(x + (50 * i), y, 50, 50);
					}
				}
			} else if (dir == 4) {
				for (int i = 0; i < 12; i++) {
					if (this.collide(SOLID, x - (50 * i), y ) != null) {
						break;
					} else if (this.collideWith(player, x - (50 * i), y) != null) {
						spotted();
//						gr.setColor(Color.red);
//						gr.fillRect(x - (50 * i), y, 50, 50);
					}
				}
			}
//		} else {
//			if (dir == 1) {
//				for (int i = 0; i < 12; i++) {
//					if (this.collide(SOLID, x + (50 * i), y) != null) {
//						break;
//					} else if (this.collideWith(player, x+ (50 * i), y ) != null) {
//						spotted();
//						gr.setColor(Color.red);
//						gr.fillRect(x+ (50 * i), y , 50, 50);
//					}
//				}
//			} else if (dir == 0) {
//				for (int i = 0; i < 12; i++) {
//					if (this.collide(SOLID, x - (50 * i), y) != null) {
//						break;
//					} else if (this.collideWith(player, x - (50 * i), y ) != null) {
//						spotted();
//						gr.setColor(Color.red);
//						gr.fillRect(x - (50 * i), y , 50, 50);
//					}
//				}
//			}
		}
	}

	private void spotted() {
		Entity p = world.find("Player");
		if (Main.game.getCurrentStateID() == Main.GameState) {
			p.x = GameState.pStartX;
			p.y = GameState.pStartY;
		} else if (Main.game.getCurrentStateID() == Main.G2) {
			p.x = G2.pStartX;
			p.y = G2.pStartY;
		} else if (Main.game.getCurrentStateID() == Main.G3) {
			p.x = G3.pStartX;
			p.y = G3.pStartY;
		} else if (Main.game.getCurrentStateID() == Main.G4) {
			p.x = G4.pStartX;
			p.y = G4.pStartY;
		} else if (Main.game.getCurrentStateID() == Main.G5) {
			p.x = G5.pStartX;
			p.y = G5.pStartY;
		} 
	}
}
