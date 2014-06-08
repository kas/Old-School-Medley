package com.kencussionproductions.oldschoolmedley.entity;

import com.badlogic.gdx.math.Vector2;
import com.kencussionproductions.oldschoolmedley.ResourceManager;

public class Enemy extends Entity {
	private final EntityManager entityManager;

	private final int speed = 2;
	private final int speedY = 3;

	private int moveDirection; // 1 == left, 2 == right, 3 == down
	private int previousMoveDirection;

	private int originX;
	private int originY;
	private final int beginningOriginX;
	private boolean hitBeginningOriginX = false;
	private final int originalDistanceX = 175;
	private final int distanceX = 350;
	private final int distanceY = 150;
	private boolean firstMove = true;
	private boolean secondMove = false;

	private long lastFire;

	private boolean savedFire = false;

	public Enemy(Vector2 pos, Vector2 direction, EntityManager entityManager,
			int enemyBeginMovingDirection, int sizeX, int sizeY) {
		super(ResourceManager.ENEMY, pos, direction, sizeX, sizeY);
		this.entityManager = entityManager;
		this.originX = (int) pos.x;
		this.beginningOriginX = (int) pos.x;
		this.originY = (int) pos.y;
		this.moveDirection = enemyBeginMovingDirection;
	}

	@Override
	public void update() {
		pos.add(direction);

		// if (pos.x == originX) {
		// if (moveDirection == 1)
		// moveDirection = 2;
		// else if (moveDirection == 2)
		// moveDirection = 1;
		// }

		if (moveDirection == 1 && firstMove) {
			direction.x = -speed;

		}
		if (firstMove && pos.x <= originX - originalDistanceX) {
			direction.x = 0;
			direction.y = 0;
			previousMoveDirection = moveDirection;
			originX = (int) pos.x;
			originY = (int) pos.y;
			moveDirection = 3;
			firstMove = false;
			secondMove = true;
		}
		if (moveDirection == 2 && firstMove) {
			direction.x = speed;
		}
		if (firstMove && pos.x >= originX + originalDistanceX) {
			direction.x = 0;
			direction.y = 0;
			previousMoveDirection = moveDirection;
			originX = (int) pos.x;
			originY = (int) pos.y;
			moveDirection = 3;
			firstMove = false;
			secondMove = true;
		}

		// After first move

		if (moveDirection == 3 && !firstMove) {
			direction.x = 0;
			direction.y = speedY;
		}
		if (moveDirection == 3 && pos.y >= originY + distanceY) {
			direction.x = 0;
			direction.y = 0;
			originX = (int) pos.x;
			originY = (int) pos.y;
			if (previousMoveDirection == 2) {
				moveDirection = 1;
			} else if (previousMoveDirection == 1) {
				moveDirection = 2;
			}
		}

		// other moves

		else if (moveDirection == 1 && secondMove && !firstMove) {
			direction.x = -speed;
			if (pos.x == beginningOriginX) {
				hitBeginningOriginX = true;
			}
			if (hitBeginningOriginX
					&& pos.x <= beginningOriginX - originalDistanceX) {
				secondMove = false;
				previousMoveDirection = moveDirection;
				moveDirection = 3;
			}
		} else if (moveDirection == 1 && !firstMove && !secondMove) {
			direction.x = -speed;

			if (pos.x <= originX - distanceX) {
				direction.x = 0;
				direction.y = 0;
				previousMoveDirection = moveDirection;
				originX = (int) pos.x;
				originY = (int) pos.y;
				moveDirection = 3;
			}

		} else if (moveDirection == 2 && secondMove && !firstMove) {
			direction.x = speed;
			if (pos.x == beginningOriginX) {
				hitBeginningOriginX = true;
			}
			if (hitBeginningOriginX
					&& pos.x >= beginningOriginX + originalDistanceX) {
				secondMove = false;
				previousMoveDirection = moveDirection;
				moveDirection = 3;
			}
		} else if (moveDirection == 2 && !firstMove && !secondMove) {
			direction.x = speed;

			if (pos.x >= originX + distanceX) {
				direction.x = 0;
				direction.y = 0;
				previousMoveDirection = moveDirection;
				originX = (int) pos.x;
				originY = (int) pos.y;
				moveDirection = 3;
			}
		}

		// Random number generation: Min + (int)(Math.random() * ((Max -
		// Min) +
		// 1))
		int fireChance = 1 + (int) (Math.random() * ((750 - 1) + 1));

		if (moveDirection != 3 && fireChance == 1 && System.currentTimeMillis() - lastFire >= 1000
				|| savedFire) {
			entityManager.addEntity(new Missile(pos.cpy().add(44, 0),
					ResourceManager.ENEMY_BULLET, new Vector2(0, 10), true));
			if (savedFire)
				savedFire = false;
			lastFire = System.currentTimeMillis();
		} else if (fireChance == 1
				&& System.currentTimeMillis() - lastFire < 1000) {
			savedFire = true;
		}
	}
}
