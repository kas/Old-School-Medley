package com.kencussionproductions.oldschoolmedley.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Input.Peripheral;
import com.badlogic.gdx.math.Vector2;
import com.kencussionproductions.oldschoolmedley.ResourceManager;

public class Player extends Entity {
	// To add missiles
	private final EntityManager entityManager;

	private long lastFire;

	private final int speed = 500;

	public Player(Vector2 pos, Vector2 direction, EntityManager entityManager,
			int sizeX, int sizeY) {
		super(ResourceManager.PLAYER, pos, direction, sizeX, sizeY);
		this.entityManager = entityManager;
	}

	@Override
	public void update() {
		// Delta keeps FPS equal regardless of device
		// Direction equals the scaled value of the current direction
		// Multiplies x and y value by .getDeltaTime()
		pos.add(direction);

		if (Gdx.input.isPeripheralAvailable(Peripheral.Accelerometer)) {
			setDirection((-Gdx.input.getAccelerometerX() * 250), 0);

			if (Gdx.input.isTouched()) {
				fireBullet();
			}
		}

		else {
			if (Gdx.input.isKeyPressed(Keys.A))
				setDirection(-speed, 0);
			else if (Gdx.input.isKeyPressed(Keys.D))
				setDirection(speed, 0);
			else
				setDirection(0, 0);

			if (Gdx.input.isKeyPressed(Keys.SPACE)) {
				fireBullet();
			}
		}

		checkBounds();
	}

	public void checkBounds() {
		if (pos.x <= 0)
			pos.x = 0;
		else if (pos.x >= 1080 - ResourceManager.PLAYER.getWidth())
			pos.x = 1080 - ResourceManager.PLAYER.getWidth();
	}

	public void fireBullet() {
		if (System.currentTimeMillis() - lastFire >= 500) {
			// We add a little to the pos so the missile starts above
			// the
			// ship
			entityManager.addEntity(new Missile(pos.cpy().add(
					ResourceManager.PLAYER.getWidth() / 2, 0),
					ResourceManager.BULLET, new Vector2(0, -10), false));
			ResourceManager.playerShoot.play();
			lastFire = System.currentTimeMillis();
		}
	}
}
