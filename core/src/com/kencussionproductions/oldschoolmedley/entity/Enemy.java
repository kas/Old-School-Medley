package com.kencussionproductions.oldschoolmedley.entity;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.kencussionproductions.oldschoolmedley.OldSchoolMedley;
import com.kencussionproductions.oldschoolmedley.SpriteManager;

public class Enemy extends Entity {

	public Enemy(Vector2 pos, Vector2 direction, int sizeX, int sizeY) {
		super(SpriteManager.ENEMY, pos, direction, sizeX, sizeY);
//		SpriteManager.ENEMY.setSize(88, 64);
//		SpriteManager.ENEMY.flip(false, true);
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
