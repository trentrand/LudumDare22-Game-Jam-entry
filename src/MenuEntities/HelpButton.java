package MenuEntities;

import it.marteEngine.entity.Entity;

import org.newdawn.slick.geom.Rectangle;

import com.nightmare.LD22.FrameWork.Res;

public class HelpButton extends Entity {
	
	public static Rectangle r;

	public HelpButton(float x, float y, int width, int height) {
		super(x, y);
		setGraphic(Res.sprites.getSubImage(0, 150, width, height));
		name = "HelpButton";
		r = new Rectangle(x, y, width, height);
	}

}
