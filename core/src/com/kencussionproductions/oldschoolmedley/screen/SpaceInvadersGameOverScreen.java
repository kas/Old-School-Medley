package com.kencussionproductions.oldschoolmedley.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SpaceInvadersGameOverScreen extends Screen {
	private OrthographicCamera camera;
	private Sprite sprite;
	private boolean won;

	public SpaceInvadersGameOverScreen(boolean won) {
		if (won)
			this.won = won;
		else
			this.won = won;
	}

	@Override
	public void create() {
		camera = new OrthographicCamera();
	}

	@Override
	public void update() {
		camera.update();
	}

	@Override
	public void render(SpriteBatch sb) {
		if (won)
			Gdx.gl.glClearColor(0, 0, 1, 1);
		if (!won)
			Gdx.gl.glClearColor(1, 0, 0, 1);
		
		Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
		
		sb.setProjectionMatrix(camera.combined);
		
		sb.begin();
		
		sb.end();
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
