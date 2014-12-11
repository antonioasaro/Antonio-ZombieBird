package com.antonio.screens;

import com.antonio.gameworld.GameRenderer;
import com.antonio.gameworld.GameWorld;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;

public class GameScreen implements Screen {

	private GameWorld world;
	private GameRenderer renderer;
	
	public GameScreen () {
		Gdx.app.log("GameScreen", "Attached");
		world = new GameWorld();
		renderer = new GameRenderer(world);
	}
	
	@Override
	public void render(float delta) {
		world.update(delta);
		renderer.render();
	}

	@Override
	public void resize(int width, int height) {
		Gdx.app.log("GameScreen", "Resizing");
	}

	@Override
	public void show() {
		Gdx.app.log("GameScreen", "Show called");
	}

	@Override
	public void hide() {
		Gdx.app.log("GameScreen", "Hide called");
	}

	@Override
	public void pause() {
		Gdx.app.log("GameScreen", "Pause called");
	}

	@Override
	public void resume() {
		Gdx.app.log("GameScreen", "Resume called");
	}

	@Override
	public void dispose() {
	}

}
