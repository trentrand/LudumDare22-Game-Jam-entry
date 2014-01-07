package MenuEntities;

import it.marteEngine.entity.Entity;

import org.newdawn.slick.geom.Rectangle;

import com.nightmare.LD22.FrameWork.Res;

public class PlayButton extends Entity {
	
	public static Rectangle r;

	public PlayButton(float x, float y, int width, int height) {
		super(x, y);
		setGraphic(Res.sprites.getSubImage(0, 50, width, height));
		name = "PlayButton";
		r = new Rectangle(x, y, width, height);
	}

}
