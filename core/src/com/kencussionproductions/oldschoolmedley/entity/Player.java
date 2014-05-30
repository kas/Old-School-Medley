package com.kencussionproductions.oldschoolmedley.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector2;
import com.kencussionproductions.oldschoolmedley.SpriteManager;

public class Player extends Entity {

	public Player(Vector2 pos, Vector2 direction) {
		super(SpriteManager.PLAYER, pos, direction);
	}

	@Override
	public void update() {
		// Delta keeps FPS equal regardless of device
		// Direction equals the scaled value of the current direction
		// Multiplies x and y value by .getDeltaTime()
		pos.add(direction);

		if (Gdx.input.isKeyPressed(Keys.A))
			setDirection(-300, 0);
		else if (Gdx.input.isKeyPressed(Keys.D))
			setDirection(300, 0);
		else
			setDirection(0, 0);
	}
}
