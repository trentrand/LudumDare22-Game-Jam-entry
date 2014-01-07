package MenuEntities;

import it.marteEngine.entity.Entity;

import org.newdawn.slick.geom.Rectangle;

import com.nightmare.LD22.FrameWork.Res;

public class InfoButton extends Entity {
	
	public static Rectangle r;

	public InfoButton(float x, float y, int width, int height) {
		super(x, y);
		setGraphic(Res.sprites.getSubImage(0, 250, width, height));
		name = "InfoButton";
		r = new Rectangle(x, y, width, height);
	}

}
