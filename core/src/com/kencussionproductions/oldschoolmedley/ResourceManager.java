package com.kencussionproductions.oldschoolmedley;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;

public class ResourceManager {
	public static Sound enemyDeath = Gdx.audio.newSound(Gdx.files.internal("spaceinvaders/sounds/enemyDeath.wav"));
	public static Sound playerDeath = Gdx.audio.newSound(Gdx.files.internal("spaceinvaders/sounds/playerDeath.wav"));
	public static Sound playerShoot = Gdx.audio.newSound(Gdx.files.internal("spaceinvaders/sounds/playerShoot.wav"));
	
	public static FreeTypeFontGenerator generator;
	private static FreeTypeFontParameter parameter;

	public static BitmapFont font, font2;

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

		generator = new FreeTypeFontGenerator(
				Gdx.files.internal("fonts/font.ttf"));

		parameter = new FreeTypeFontParameter();

		parameter.size = 112;
		parameter.flip = true;

		font = generator.generateFont(parameter);

		font.setColor(Color.WHITE);
		
		parameter.size = 72;
		
		font2 = generator.generateFont(parameter);
	}
}
