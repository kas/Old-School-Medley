package com.kencussionproductions.oldschoolmedley.entity;

import com.badlogic.gdx.math.Vector2;
import com.kencussionproductions.oldschoolmedley.SpriteManager;

public class Enemy extends Entity {
	private final EntityManager entityManager;

	private final int speed = 1;

	private int moveDirection; // 1 == left, 2 == right

	private final int origin;
	private final int distance = 25;
	
	private long lastFire;
	
	private boolean savedFire = false;

	public Enemy(Vector2 pos, Vector2 direction, EntityManager entityManager,
			int enemyBeginMovingDirection, int sizeX, int sizeY) {
		super(SpriteManager.ENEMY, pos, direction, sizeX, sizeY);
		this.entityManager = entityManager;
		this.origin = (int) pos.x;
		this.moveDirection = enemyBeginMovingDirection;
	}

	@Override
	public void update() {
		pos.add(direction);

		// if (pos.x == origin) {
		// if (moveDirection == 1)
		// moveDirection = 2;
		// else if (moveDirection == 2)
		// moveDirection = 1;
		// }

		if (moveDirection == 1) {
			direction.x = -speed;
			if (pos.x <= origin - distance) {
				moveDirection = 2;
			}
		} else if (moveDirection == 2) {
			direction.x = speed;

			if (pos.x >= origin + distance) {
				moveDirection = 1;
			}
		}

		// Random number generation: Min + (int)(Math.random() * ((Max - Min) +
		// 1))
		int fireChance = 1 + (int) (Math.random() * ((750 - 1) + 1));

		if (fireChance == 1 && System.currentTimeMillis() - lastFire >= 1000 || savedFire) {
			entityManager.addEntity(new Missile(pos.cpy().add(44, 0),
					SpriteManager.ENEMY_BULLET, new Vector2(0, 10), true));
			if (savedFire)
				savedFire = false;
			lastFire = System.currentTimeMillis();
		}
		else if (fireChance == 1 && System.currentTimeMillis() - lastFire < 1000) {
			savedFire = true;
		}
	}
}
