package com.mygdx.game.sprites.controls;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.InputProcessor;
import com.mygdx.game.SpaceInvaders;

/**
 * Created by moritz2 on 19.06.2018.
 */

public class MyButtonProcessor extends Actor implements InputProcessor {

    private Button leftButton, rightButton;

    public MyButtonProcessor()
    {
        this.leftButton = new Button(new Texture("btn_left.png"), new Vector2(0, 0), "<---");
        this.rightButton  = new Button(new Texture("btn_right.png"), new Vector2(SpaceInvaders.WIDTH / 2, 0), "0");

    }


    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        //Rectangle rect = new Rectangle(this.leftButton.getS)
        //if()
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
