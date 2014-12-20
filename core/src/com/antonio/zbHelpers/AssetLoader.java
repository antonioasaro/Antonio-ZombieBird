package com.antonio.zbHelpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetLoader {
	public static Texture texture, logoTexture;
	public static TextureRegion logo, zbLogo, bg, grass;
	public static TextureRegion playButtonUp, playButtonDown;
    public static Animation birdAnimation;
    public static TextureRegion bird, birdDown, birdUp;
    public static TextureRegion skullUp, skullDown, bar;
    public static Sound dead, flap, coin;
    public static BitmapFont font, shadow;
    public static Preferences prefs;
    
    public static void load() {
    	
        logoTexture = new Texture(Gdx.files.internal("logo.png"));
        logoTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
        logo = new TextureRegion(logoTexture, 0, 0, 512, 114);

    	texture = new Texture(Gdx.files.internal("texture.png"));
    	texture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        
    	playButtonUp = new TextureRegion(texture, 0, 83, 29, 16);
        playButtonDown = new TextureRegion(texture, 29, 83, 29, 16);
        playButtonUp.flip(false, true);
        playButtonDown.flip(false, true);
        zbLogo = new TextureRegion(texture, 0, 55, 135, 24);
        zbLogo.flip(false, true);

    	
    	bg = new TextureRegion(texture, 0, 0, 136, 43);
    	bg.flip(false, true);
    	grass = new TextureRegion(texture, 0, 43, 143, 11);
    	grass.flip(false, true);
    	birdDown = new TextureRegion(texture, 136, 0, 17, 12);
    	birdDown.flip(false, true);
    	bird = new TextureRegion(texture, 153, 0, 17, 12);
    	bird.flip(false, true);
    	birdUp = new TextureRegion(texture, 170, 0, 17, 12);
    	birdUp.flip(false, true);
    	
    	TextureRegion[] birds = { birdDown, bird, birdUp };
    	birdAnimation = new Animation(0.06f, birds);
    	birdAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
    	
    	skullUp = new TextureRegion(texture, 192, 0, 24, 14);
    	skullDown = new TextureRegion(skullUp);
    	skullDown.flip(false, true);
    	bar = new TextureRegion(texture, 136, 16, 22, 3);
    	bar.flip(false, true);
    	
        dead = Gdx.audio.newSound(Gdx.files.internal("dead.wav"));
        flap = Gdx.audio.newSound(Gdx.files.internal("flap.wav"));
        coin = Gdx.audio.newSound(Gdx.files.internal("coin.wav"));
        
        font = new BitmapFont(Gdx.files.internal("text.fnt"));
        font.setScale(.25f, -.25f);
        shadow = new BitmapFont(Gdx.files.internal("shadow.fnt"));
        shadow.setScale(.25f, -.25f);
        
        prefs = Gdx.app.getPreferences("ZombieBird");
        if (!prefs.contains("highScore")) {
            prefs.putInteger("highScore", 0);
        }

    }

    public static void setHighScore(int val) {
        prefs.putInteger("highScore", val);
        prefs.flush();
    }

    public static int getHighScore() {
        return prefs.getInteger("highScore");
    }

    public static void dispose() {
        texture.dispose();
        dead.dispose();
        flap.dispose();
        coin.dispose();
        font.dispose();
        shadow.dispose();
    }
    
 }