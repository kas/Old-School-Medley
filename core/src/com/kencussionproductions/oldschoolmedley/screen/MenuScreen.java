package com.kencussionproductions.oldschoolmedley.screen;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.kencussionproductions.oldschoolmedley.camera.OrthoCamera;
import com.kencussionproductions.oldschoolmedley.entity.Player;

public class MenuScreen extends Screen {
	private OrthoCamera camera;
	private Player player;
	
	@Override
	public void create() {
		camera = new OrthoCamera();
		player = new Player(new Vector2(470, 15), new Vector2(0, 0));
	}

	@Override
	public void render(SpriteBatch sb) {
		// Combines all the camera matrices into one table (use camera. to see matrices)
		sb.setProjectionMatrix(camera.combined);
		sb.begin();
		player.render(sb);
		sb.end();
	}
	
	@Override
	public void update() {
		// Keeps aspect ratio up to date
		camera.update();
		player.update();
	}

	@Override
	public void resize(int width, int height) {
		// Camera is resized each time screen is resized, keeps aspect ratio up to date
		camera.resize();
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
