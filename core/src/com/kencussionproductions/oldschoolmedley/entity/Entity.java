package com.kencussionproductions.oldschoolmedley.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

// All enemies or whatever moves will implement this class
public abstract class Entity {
	// Allows classes to gain access if they extend this
	protected Sprite sprite;
	protected Vector2 pos, direction;
	protected int sizeX, sizeY;
	
	public Entity(Sprite sprite, Vector2 pos, Vector2 direction, int sizeX, int sizeY) {
		this.sprite = sprite;
		this.pos = pos;
		this.direction = direction;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
	}
	
	public abstract void update();
	
	public void render(SpriteBatch sb) {
		sb.draw(sprite, pos.x, pos.y, sizeX, sizeY);
	}
	
	public Vector2 getPosition() {
		return pos;
	}
	
	public void setDirection(float x, float y) {
		direction.set(x, y);
		direction.scl(Gdx.graphics.getDeltaTime());
	}
}
