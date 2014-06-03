package com.kencussionproductions.oldschoolmedley.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector2;
import com.kencussionproductions.oldschoolmedley.OldSchoolMedley;
import com.kencussionproductions.oldschoolmedley.SpriteManager;

public class Player extends Entity {
	// To add missiles
	private final EntityManager entityManager;

	private long lastFire;

	public Player(Vector2 pos, Vector2 direction, EntityManager entityManager,
			int sizeX, int sizeY) {
		super(SpriteManager.PLAYER, pos, direction, sizeX, sizeY);
		this.entityManager = entityManager;
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

		if (Gdx.input.isKeyPressed(Keys.SPACE)) {
			if (System.currentTimeMillis() - lastFire >= 500) {
				// We add a little to the pos so the missile starts above the
				// ship
				entityManager.addEntity(new Missile(pos.cpy().add(
						SpriteManager.PLAYER.getWidth() / 2, 0), false));
				lastFire = System.currentTimeMillis();
			}
		}
	}
}
