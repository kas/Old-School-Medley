package com.kencussionproductions.oldschoolmedley.entity;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.kencussionproductions.oldschoolmedley.OldSchoolMedley;
import com.kencussionproductions.oldschoolmedley.SpriteManager;

public class Enemy extends Entity {
	private final EntityManager entityManager;

	public Enemy(Vector2 pos, Vector2 direction, EntityManager entityManager,
			int sizeX, int sizeY) {
		super(SpriteManager.ENEMY, pos, direction, sizeX, sizeY);
		this.entityManager = entityManager;
	}

	@Override
	public void update() {
		pos.add(direction);

		// Random number generation: Min + (int)(Math.random() * ((Max - Min) +
		// 1))
		int fireChance = 1 + (int) (Math.random() * ((100 - 1) + 1));

//		if (fireChance == 1) {
//			entityManager.addEntity(new Missile(pos.cpy().add(44, 0), true));
//		}

		// if (pos.y <= -SpriteManager.ENEMY.getHeight()) {
		// float x = MathUtils.random(0, OldSchoolMedley.WIDTH -
		// SpriteManager.ENEMY.getWidth());
		// pos.set(x, OldSchoolMedley.HEIGHT);
		// }
	}
}
