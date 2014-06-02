package com.kencussionproductions.oldschoolmedley.screen;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.kencussionproductions.oldschoolmedley.SpriteManager;
import com.kencussionproductions.oldschoolmedley.entity.EntityManager;

public class SpaceInvadersScreen extends Screen {
	// private OrthoCamera camera;
	private OrthographicCamera camera;
	private EntityManager entityManager;
	private SpriteManager spriteManager;
	
	@Override
	public void create() {
		// camera = new OrthoCamera();
		camera = new OrthographicCamera();

		camera.setToOrtho(true, 1080, 1920);
		
		spriteManager = new SpriteManager();
		spriteManager.load();

		entityManager = new EntityManager(10);
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
