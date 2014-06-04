package com.kencussionproductions.oldschoolmedley;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.kencussionproductions.oldschoolmedley.screen.Screen;
import com.kencussionproductions.oldschoolmedley.screen.SpaceInvadersScreen;
import com.kencussionproductions.oldschoolmedley.screen.ScreenManager;
import com.kencussionproductions.oldschoolmedley.screen.SplashScreen;

public class OldSchoolMedley implements ApplicationListener {
	public static int WIDTH = 360, HEIGHT = 640;
	// public static int WIDTH = 1080, HEIGHT = 1920;
	SpriteBatch batch;

	private Screen splashScreen;

	private ResourceManager spriteManager;

	@Override
	public void create() {
		batch = new SpriteBatch();

		spriteManager = new ResourceManager();
		spriteManager.load();

		ScreenManager.setScreen(new SplashScreen());
		splashScreen = ScreenManager.getCurrentScreen();
		
		ScreenManager.setScreen(new SpaceInvadersScreen());
	}

	@Override
	public void render() {
		if (ScreenManager.getCurrentScreen() == splashScreen)
			Gdx.gl.glClearColor(1, 1, 1, 1);
		else
			Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);

		if (ScreenManager.getCurrentScreen() != null)
			ScreenManager.getCurrentScreen().update();

		if (ScreenManager.getCurrentScreen() != null)
			ScreenManager.getCurrentScreen().render(batch);
	}

	@Override
	public void resize(int width, int height) {
		if (ScreenManager.getCurrentScreen() != null)
			ScreenManager.getCurrentScreen().resize(width, height);
	}

	@Override
	public void pause() {
		if (ScreenManager.getCurrentScreen() != null)
			ScreenManager.getCurrentScreen().pause();
	}

	@Override
	public void resume() {
		if (ScreenManager.getCurrentScreen() != null)
			ScreenManager.getCurrentScreen().resume();
	}

	@Override
	public void dispose() {
		if (ScreenManager.getCurrentScreen() != null)
			ScreenManager.getCurrentScreen().dispose();
		ResourceManager.generator.dispose();
		
		ResourceManager.enemyDeath.dispose();
		ResourceManager.playerDeath.dispose();
		ResourceManager.playerShoot.dispose();
		
		batch.dispose();
	}
}
