package com.nightmare.LD22.States;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import MenuEntities.Text;

import com.nightmare.LD22.FrameWork.Main;
import com.nightmare.LD22.FrameWork.sc;

import it.marteEngine.World;

public class StoryLine extends World {

	Text t3;
	
	public StoryLine(int id, GameContainer container) {
		super(id, container);
		Text t = new Text(25, 600, Main.font,
				"35 years.. What a long time that is, but have you ever been");
		add(t);
		Text t1 = new Text(25, 625, Main.font,
				"in prison? Yeah me neither. But this guy is, and that's you.");
		add(t1);
		Text t2 = new Text(25, 650, Main.font,
				"You lier! This place is soo lonely, I'm done being ALONE!!!");
		add(t2);
		Text t4 = new Text(25, 675, Main.font,
				"TOO LONG! BLACK AND WHITE... everywhere i look.");
		add(t4);
		t3 = new Text(25, 700, Main.font,
				"Lets get out of here, careful for the security guards.");
		add(t3);
		
	}

	@Override
    public int getID() {
        return Main.StoryLine;
    }
	public void render(GameContainer container, StateBasedGame game, Graphics gr)
			throws SlickException {
		super.render(container, game, gr);
	}
	
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		super.update(container, game, delta);
		sc.print(t3.y);
		if (t3.y + 25 < 0) {
			Main.game.enterState(Main.GameState);
		}
	}
	
}
