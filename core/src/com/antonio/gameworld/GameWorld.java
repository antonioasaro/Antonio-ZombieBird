package com.antonio.gameworld;

import com.antonio.gameobjects.Bird;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;

public class GameWorld {

    private Bird bird;

    public GameWorld(int midPointY) {
    	bird = new Bird(33, midPointY - 5, 17, 12);    	
    }
    
    public void update(float delta) {
    	bird.update(delta);
    }

    public Bird getBird() {
    	return bird;
    }
}
