package com.kencussionproductions.oldschoolmedley.entity;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.kencussionproductions.oldschoolmedley.SpriteManager;

public class Missile extends Entity {
	boolean enemyBullet;

	// Maybe add Sprite sprite and boolean enemyBullet?
	public Missile(Vector2 pos, Sprite sprite, Vector2 direction,
			boolean enemyBullet) {
		super(sprite, pos, direction, 9, 21);
		this.enemyBullet = enemyBullet;
	}

	@Override
	public void update() {
		pos.add(direction);
	}

	public boolean checkEnd() {
		if (enemyBullet)
			return pos.x >= 1920;
		else
			return pos.x <= 0;
	}
}
