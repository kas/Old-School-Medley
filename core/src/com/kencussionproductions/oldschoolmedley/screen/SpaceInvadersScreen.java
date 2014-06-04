package com.kencussionproductions.oldschoolmedley.screen;

import java.util.concurrent.TimeUnit;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.kencussionproductions.oldschoolmedley.ResourceManager;
import com.kencussionproductions.oldschoolmedley.entity.EntityManager;

public class SpaceInvadersScreen extends Screen {
	// private OrthoCamera camera;
	private OrthographicCamera camera;
	private EntityManager entityManager;

	public static int enemiesKilled = 0;
	public static int timeSeconds = 0;

	@Override
	public void create() {
		// camera = new OrthoCamera();
		camera = new OrthographicCamera();
		camera.setToOrtho(true, 1080, 1920);

		entityManager = new EntityManager(25);

		timeSeconds = (int) TimeUnit.MILLISECONDS.toSeconds(System
				.currentTimeMillis());
	}

	@Override
	public void render(SpriteBatch sb) {
		// Combines all the camera matrices into one table (use camera. to see
		// matrices)
		sb.setProjectionMatrix(camera.combined);
		sb.begin();
		entityManager.render(sb);
		sb.end();
	}

	@Override
	public void update() {
		// Keeps aspect ratio up to date
		camera.update();
		entityManager.update();
	}

	@Override
	public void resize(int width, int height) {
		// Camera is resized each time screen is resized, keeps aspect ratio up
		// to date
		// camera.resize();
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
