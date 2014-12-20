package com.antonio.gameworld;

import com.antonio.gameobjects.Bird;
import com.antonio.gameobjects.ScrollHandler;
import com.antonio.zbHelpers.AssetLoader;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;

public class GameWorld {

    private Bird bird;
    private ScrollHandler scroller;
    private Rectangle ground;
    private int score = 0;

    public GameWorld(int midPointY) {
    	bird = new Bird(33, midPointY - 5, 17, 12);   
        scroller = new ScrollHandler(this, midPointY + 66);
        ground = new Rectangle(0, midPointY + 66, 136, 11);
    }
    
    public void update(float delta) {
    	bird.update(delta);
    	scroller.update(delta);
    	
        if (scroller.collides(bird) && bird.isAlive()) {
            // Clean up on game over
            scroller.stop();
            bird.die();
            AssetLoader.dead.play();
        }
        
        if (Intersector.overlaps(bird.getBoundingCircle(), ground)) {
            scroller.stop();
            bird.die();
            bird.decelerate();
        }
 
    }

    public Bird getBird() {
    	return bird;
    }
    
    public ScrollHandler getScroller() {
        return scroller;
    }
    
    public int getScore() {
        return score;
    }

    public void addScore(int increment) {
        score += increment;
    }
    
}
