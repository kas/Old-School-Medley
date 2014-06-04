package com.kencussionproductions.oldschoolmedley.screen;

import java.util.concurrent.TimeUnit;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.kencussionproductions.oldschoolmedley.ResourceManager;

public class SpaceInvadersGameOverScreen extends Screen {
	private OrthographicCamera camera;
	private boolean won;

	private String win = "You Win!";
	private String lose = "Game Over";
	private String time = "Seconds : ";
	private String enemiesKilled = "Enemies Killed : ";

	private int currentTimeSeconds;
	private int differenceTimeSeconds;

	public SpaceInvadersGameOverScreen(boolean won) {
		if (won)
			this.won = won;
		else
			this.won = won;

		enemiesKilled = enemiesKilled
				+ Integer.toString(SpaceInvadersScreen.enemiesKilled);

		currentTimeSeconds = (int) TimeUnit.MILLISECONDS.toSeconds(System
				.currentTimeMillis());
		differenceTimeSeconds = currentTimeSeconds
				- SpaceInvadersScreen.timeSeconds;

			time = time + Integer.toString(differenceTimeSeconds);
	}

	@Override
	public void create() {
		camera = new OrthographicCamera();
		camera.setToOrtho(true, 1080, 1920);
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

		if (won) {
			ResourceManager.font
					.draw(sb, win, center('x', win), center('y', win));
		}

		if (!won) {
			ResourceManager.font.draw(sb, lose, center('x', lose),
					center('y', lose));
		}

		ResourceManager.font2.draw(sb, time, center('x', time), center('y', time)
				+ (192 * 2));
		ResourceManager.font2.draw(sb, enemiesKilled, center('x', enemiesKilled),
				center('y', enemiesKilled) + (192 * 4));

		sb.end();
	}

	public int center(char axis, String str) {
		int coordinate = 0;

		if (axis == 'x')
			coordinate = 1080;
		else if (axis == 'y')
			coordinate = 1920;

		int pos = (coordinate / 2)
				- ((int) ResourceManager.font.getBounds(str).width / 2);
		return pos;
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
