package com.kencussionproductions.oldschoolmedley;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class SpriteManager {
	public static Texture player = new Texture(
			Gdx.files.internal("spaceinvaders/ship.png"));
	public static Sprite PLAYER = new Sprite(player, 100, 190);
	
	public static Texture bullet = new Texture(
			Gdx.files.internal("spaceinvaders/bullet.png"));
	public static Sprite BULLET = new Sprite(bullet, 9, 21);

	public static Texture enemy = new Texture(
			Gdx.files.internal("spaceinvaders/enemyResized.png"));
	public static Sprite ENEMY = new Sprite(enemy, 44, 32);
	
	public static Texture enemy_bullet = new Texture(
			Gdx.files.internal("spaceinvaders/enemybullet.png"));
	public static Sprite ENEMY_BULLET = new Sprite(enemy_bullet, 9, 21);
}
