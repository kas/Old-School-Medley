package com.kencussionproductions.oldschoolmedley.entity;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.kencussionproductions.oldschoolmedley.OldSchoolMedley;
import com.kencussionproductions.oldschoolmedley.SpriteManager;

public class Enemy extends Entity {

	public Enemy(Vector2 pos, Vector2 direction) {
		super(SpriteManager.ENEMY, pos, direction);

	}

	@Override
	public void update() {
		pos.add(direction);
		if (pos.y <= -SpriteManager.ENEMY.getHeight()) {
			float x = MathUtils.random(0, OldSchoolMedley.WIDTH - SpriteManager.ENEMY.getWidth());
			pos.set(x, OldSchoolMedley.HEIGHT);
		}
	}
}
