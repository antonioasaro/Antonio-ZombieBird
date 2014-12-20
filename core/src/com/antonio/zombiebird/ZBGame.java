package com.antonio.zombiebird;

import com.antonio.screens.GameScreen;
import com.antonio.screens.SplashScreen;
import com.antonio.zbHelpers.AssetLoader;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

public class ZBGame extends Game {

	@Override
	public void create() {
		Gdx.app.log("ZBGame", "created");
		AssetLoader.load();
		setScreen(new SplashScreen(this));
	}

	@Override
	public void dispose() {
	    super.dispose();
	    AssetLoader.dispose();
	}
	
}
