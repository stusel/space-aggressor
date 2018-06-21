package com.mygdx.game.sprites.controls;

import com.badlogic.gdx.InputAdapter;
import com.mygdx.game.SpaceInvaders;

/**
 * Created by moritz2 on 28.05.2018.
 */

// prototype without buttons
public class MyInputProcessor extends InputAdapter {

    private ScreenSpot currentSpot;
    public MyInputProcessor()
    {
        super();
        this.currentSpot = ScreenSpot.NONE;
    }


    @Override
    public boolean touchDown(int x, int y, int pointer, int button) {

        if(x > SpaceInvaders.WIDTH / 2)
        {
            this.currentSpot = ScreenSpot.RIGHT;
        }
        else this.currentSpot = ScreenSpot.LEFT;

        return true;
    }

    @Override
    public boolean touchUp(int x, int y, int pointer, int button) {
        this.currentSpot = ScreenSpot.NONE;
        return true;
    }

    public ScreenSpot getCurrentSpot() {
        return currentSpot;
    }
}
