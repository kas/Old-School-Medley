package com.kencussionproductions.oldschoolmedley.entity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.kencussionproductions.oldschoolmedley.OldSchoolMedley;
import com.kencussionproductions.oldschoolmedley.SpriteManager;

// Checks collisions, updates current enemies
public class EntityManager {
	private final Array<Entity> entities = new Array<Entity>();
	private final Player player;

	public EntityManager(int amount) {
		player = new Player(new Vector2(470, 15), new Vector2(0, 0));
		for (int i = 0; i < amount; i++) {
			float x = MathUtils.random(0, OldSchoolMedley.WIDTH
					- SpriteManager.ENEMY.getWidth());
			float y = MathUtils.random(OldSchoolMedley.HEIGHT,
					OldSchoolMedley.HEIGHT * 3);
			float speed = MathUtils.random(2, 5);

			addEntity(new Enemy(new Vector2(x, y), new Vector2(0, -speed)));
		}
	}

	public void update() {
		for (Entity e : entities)
			e.update();
		player.update();
	}

	public void render(SpriteBatch sb) {
		for (Entity e : entities)
			e.render(sb);
		player.render(sb);
	}

	// Allows us to add entities at our leisure
	public void addEntity(Entity entity) {
		entities.add(entity);
	}

	private Array<Enemy> getEnemies() {
		Array<Enemy> ret = new Array<Enemy>();
		for (Entity e : entities) {
			// If the class is an Enemy class
			if (e instanceof Enemy)
				// Cast the entity to Enemy
				ret.add((Enemy) e);
		}
		return ret;
	}

	public boolean gameOver() {
		// If 0 or less enemies exist, return true
		return getEnemies().size <= 0;
	}
}
