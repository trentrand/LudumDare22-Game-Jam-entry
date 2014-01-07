package com.nightmare.LD22.Entitys;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

import com.nightmare.LD22.FrameWork.Main;
import com.nightmare.LD22.FrameWork.Res;
import com.nightmare.LD22.States.G2;
import com.nightmare.LD22.States.G3;
import com.nightmare.LD22.States.G4;
import com.nightmare.LD22.States.G5;
import com.nightmare.LD22.States.GameState;

import it.marteEngine.entity.Entity;

public class LineGuard extends Entity {

	public boolean ud;
	public int dir = 0;
	int up = 1;
	int down = 180;
	int right = 90;
	int left = 270;
	public static int health = 100;

	public LineGuard(float x, float y, boolean ud) {
		super(x, y);
		setGraphic(Res.sprites.getSprite(2, 0));
		depth = 100;
		setHitBox(10, 10, 30, 30);
		this.ud = ud;
		corX = 25;
		corY = 25;
		angle = 2;
		addType(COLLIDABLE);
	}

	@Override
	public void update(GameContainer container, int delta)
			throws SlickException {
		super.update(container, delta);
		if (ud == false) {
			if (collide(SOLID, x - 1, y) != null) {
				dir = 1;
			}
			if (collide(SOLID, x + 1, y) != null) {
				dir = 0;
			}
			if (dir == 1) {
				x += 2;
				angle = right;
			} else {
				x -= 2;
				angle = left;
			}
		} else {
			if (collide(SOLID, x, y - 1) != null) {
				dir = 1;
			}
			if (collide(SOLID, x, y + 1) != null) {
				dir = 0;
			}
			if (dir == 1) {
				y += 2;
				angle = down;

			} else {
				y -= 2;
				angle = up;

			}
		}
	}

	@Override
	public void render(GameContainer gc, Graphics gr) throws SlickException {
		super.render(gc, gr);
		Entity player = world.find("Player");

		if (ud) {
			if (dir == 1) {
				for (int i = 0; i < 12; i++) {
					if (this.collide(SOLID, x, y + (50 * i)) != null) {
						break;
					} else if (this.collideWith(player, x, y + (50 * i)) != null) {
						spotted();
						// gr.setColor(Color.red);
						// gr.fillRect(x, y + (50 * i), 50, 50);
					}
				}
			} else if (dir == 0) {
				for (int i = 0; i < 12; i++) {
					if (this.collide(SOLID, x, y - (50 * i)) != null) {
						break;
					} else if (this.collideWith(player, x, y - (50 * i)) != null) {
						spotted();
						// gr.setColor(Color.red);
						// gr.fillRect(x, y - (50 * i), 50, 50);
					}
				}
			}
		} else {
			if (dir == 1) {
				for (int i = 0; i < 12; i++) {
					if (this.collide(SOLID, x + (50 * i), y) != null) {
						break;
					} else if (this.collideWith(player, x + (50 * i), y) != null) {
						spotted();
						// gr.setColor(Color.red);
						// gr.fillRect(x+ (50 * i), y , 50, 50);
					}
				}
			} else if (dir == 0) {
				for (int i = 0; i < 12; i++) {
					if (this.collide(SOLID, x - (50 * i), y) != null) {
						break;
					} else if (this.collideWith(player, x - (50 * i), y) != null) {
						spotted();
						// gr.setColor(Color.red);
						// gr.fillRect(x - (50 * i), y , 50, 50);
					}
				}
			}
		}
	}

	public void spotted() {
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
		// angle = this.getAngleToPosition(new Vector2f(p.x, p.y));
	}
}
