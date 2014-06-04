package com.kencussionproductions.oldschoolmedley;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class SpriteManager {
//	public static FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/font.ttf"));
//	public static BitmapFont font = generator.generateFont(48);
	
	public static Texture splash = new Texture(
			Gdx.files.internal("logo/portrait.png"));
	public static Sprite SPLASH = new Sprite(splash, 1080, 1920);
	
	public static Texture player = new Texture(
			Gdx.files.internal("spaceinvaders/ship.png"));
	public static Sprite PLAYER = new Sprite(player, 100, 190);
	
	public static Texture bullet = new Texture(
			Gdx.files.internal("spaceinvaders/bullet.png"));
	public static Sprite BULLET = new Sprite(bullet, 9, 21);

	public static Texture enemy = new Texture(
			Gdx.files.internal("spaceinvaders/enemy.png"));
	public static Sprite ENEMY = new Sprite(enemy, 11, 8);
	
	public static Texture enemy_bullet = new Texture(
			Gdx.files.internal("spaceinvaders/enemybullet.png"));
	public static Sprite ENEMY_BULLET = new Sprite(enemy_bullet, 9, 21);
	
	public void load() {
		SPLASH.flip(false, true);
		PLAYER.flip(false, true);
		BULLET.flip(false, true);
		ENEMY.flip(false, true);
	}
}
