package com.kencussionproductions.oldschoolmedley.entity;

import com.badlogic.gdx.math.Vector2;
import com.kencussionproductions.oldschoolmedley.SpriteManager;

public class Missile extends Entity {

	// Maybe add Sprite sprite and boolean enemyBullet?
	public Missile(Vector2 pos, boolean enemyBullet) {
			super(SpriteManager.BULLET, pos, new Vector2(0, -5), 9, 21);
	}

	@Override
	public void update() {
		pos.add(direction);
	}
	
	public boolean checkEnd() {
		return pos.x <= 0;
	}
}
