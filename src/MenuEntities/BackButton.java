package MenuEntities;

import it.marteEngine.entity.Entity;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

import com.nightmare.LD22.FrameWork.Res;

public class BackButton extends Entity {
	
	public static Rectangle r;

	public BackButton(float x, float y, int width, int height) {
		super(x, y);
		setGraphic(Res.sprites.getSubImage(200, 150, width, height));
		name = "BackButton";
		r = new Rectangle(x, y, width, height);
	}
	
	@Override
	public void render(GameContainer gc, Graphics gr) throws SlickException {
		super.render(gc, gr);
//		gr.draw(r);
	}

}
