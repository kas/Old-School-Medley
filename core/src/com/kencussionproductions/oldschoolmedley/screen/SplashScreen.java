package com.kencussionproductions.oldschoolmedley.screen;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.kencussionproductions.oldschoolmedley.SpriteManager;

public class SplashScreen extends Screen {
	private OrthographicCamera camera;
	private long countDown;

	@Override
	public void create() {
		camera = new OrthographicCamera();
		camera.setToOrtho(true, 1080, 1920);
		
		countDown = System.currentTimeMillis();
	}

	@Override
	public void render(SpriteBatch sb) {
		// Combines all the camera matrices into one table (use camera. to see
		// matrices)
		sb.setProjectionMatrix(camera.combined);

		sb.begin();
		sb.draw(SpriteManager.SPLASH, 0, 0);
		sb.end();
	}

	@Override
	public void update() {
		camera.update();

		if (System.currentTimeMillis() - countDown >= 5000) {
			ScreenManager.setScreen(new SpaceInvadersScreen());
			this.dispose();
		}
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void dispose() {

	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}
}
