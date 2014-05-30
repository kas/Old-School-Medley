package com.kencussionproductions.oldschoolmedley;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.kencussionproductions.oldschoolmedley.screen.MenuScreen;
import com.kencussionproductions.oldschoolmedley.screen.ScreenManager;

public class OldSchoolMedley implements ApplicationListener {
	public static int WIDTH = 360, HEIGHT = 640;
	SpriteBatch batch;

	@Override
	public void create() {
		batch = new SpriteBatch();

		ScreenManager.setScreen(new MenuScreen());
	}

	@Override
	public void render() {
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
		batch.dispose();
	}
}
