package MenuEntities;

import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

import it.marteEngine.entity.TextEntity;

public class Text extends TextEntity {

	float speed = 0.25f;
	
	public Text(float x, float y, Font font, String text) {
		super(x, y, font, text);
		name = "text";
	}

	@Override
	public void update(GameContainer container, int delta)
			throws SlickException {
		super.update(container, delta);
		y -= speed;
		if (Gdx.input.isTouched() || Gdx.input.isKeyPressed(Keys.ANY_KEY)) {
			speed = 4;
		} else {
			speed = 0.5f;
		}
	}
}
