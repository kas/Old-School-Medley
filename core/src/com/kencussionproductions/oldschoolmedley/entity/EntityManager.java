package com.kencussionproductions.oldschoolmedley.entity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.kencussionproductions.oldschoolmedley.ResourceManager;
import com.kencussionproductions.oldschoolmedley.screen.ScreenManager;
import com.kencussionproductions.oldschoolmedley.screen.SpaceInvadersGameOverScreen;
import com.kencussionproductions.oldschoolmedley.screen.SpaceInvadersScreen;

// Checks collisions, updates current enemies
public class EntityManager {
	private final Array<Entity> entities = new Array<Entity>();
	private final Player player;
	private final int enemyBeginMovingDirection;

	private final int rowPos = 72;
	private final int rowSpacing = 216;

	public EntityManager(int amount) {
		player = new Player(new Vector2(440, 1730), new Vector2(0, 0), this,
				100, 190);

		enemyBeginMovingDirection = (int) (Math.random() * 2 + 1); // Returns
																	// either 1
																	// or 2

		// X is 216 away from ea/o
		int columnCtr = 0;
		int rowCtr = 0;

		// Do not need to subtract enemy width
		// 64, 280, 496, 712, 928
		final int column[] = { 172, 334, 496, 658, 820 };
		final int row[] = { rowPos, (rowPos + rowSpacing),
				rowPos + (rowSpacing * 2), rowPos + (rowSpacing * 3),
				rowPos + (rowSpacing * 4), rowPos + (rowSpacing * 5) };

		if (amount <= 25) {
			// 288 is first Y layer, add 288 after that
			for (int ctr = 0; ctr < amount; ctr++) {
				float x = column[columnCtr];
				float y = row[rowCtr];
				float speed = 0;
				columnCtr++;

				if (columnCtr > 4) {
					columnCtr = 0;
					rowCtr++;
				}

				addEntity(new Enemy(new Vector2(x, y), new Vector2(0, speed),
						this, enemyBeginMovingDirection, 88, 64));
			}
		} else
			System.out.println("More than 25 enemies.");
	}

	public void update() {
		for (Entity e : entities)
			e.update();
		for (Missile m : getMissiles())
			// If missile is off the screen (instead of colliding with another
			// rectangle)
			if (m.checkEnd())
				entities.removeValue(m, false);
		player.update();
		checkCollisions();
	}

	public void render(SpriteBatch sb) {
		for (Entity e : entities)
			e.render(sb);
		player.render(sb);
	}

	private void checkCollisions() {
		for (Enemy e : getEnemies()) {
			for (Missile m : getMissiles()) {
				if (m.getBounds().overlaps(e.getBounds()) && !m.enemyBullet) {
					// False means faster processing (checking the class for the
					// entity)
					entities.removeValue(e, false);
					ResourceManager.enemyDeath.play();
					SpaceInvadersScreen.enemiesKilled++;

					entities.removeValue(m, false);
					if (gameOver())
						// End game, win
						ScreenManager
								.setScreen(new SpaceInvadersGameOverScreen(true));
				}
				if (m.getBounds().overlaps(player.getBounds()) && m.enemyBullet) {
					// End the game, lose
					ResourceManager.playerDeath.play();
					ScreenManager.setScreen(new SpaceInvadersGameOverScreen(
							false));
				}
			}
			if (e.getBounds().overlaps(player.getBounds())) {
				ResourceManager.playerDeath.play();
				ScreenManager.setScreen(new SpaceInvadersGameOverScreen(false));
			}
		}
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

	private Array<Missile> getMissiles() {
		Array<Missile> ret = new Array<Missile>();
		for (Entity e : entities)
			// If the class is an Enemy class
			if (e instanceof Missile)
				// Cast the entity to Enemy
				// (Because Enemy extends Entity)
				ret.add((Missile) e);
		return ret;
	}

	public boolean gameOver() {
		// If 0 or less enemies exist, return true
		return getEnemies().size <= 0;
	}
}
