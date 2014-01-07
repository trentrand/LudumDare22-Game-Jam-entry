package MenuEntities;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import it.marteEngine.entity.Entity;

public class Logo extends Entity {

public static Image logo;
	
	public Logo(float x, float y) throws SlickException {
		super(x, y);
		
		logo = new Image("resources/logo.png");
			setGraphic(logo);
		this.depth = -1;
		this.scale = 1;
		name = "Logo";
	}

}
