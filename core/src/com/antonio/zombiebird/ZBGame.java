package com.antonio.zombiebird;

import com.antonio.screens.GameScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

public class ZBGame extends Game {

	@Override
	public void create() {
		Gdx.app.log("ZBGame", "created");
		setScreen(new GameScreen());
	}

}
