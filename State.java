package com.mygdx.game.states;
//package States

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.sprites.controls.EventType;

/**
 * Created by moritz2 on 31.03.2018.
 */

public abstract class State
{
    protected OrthographicCamera cam;
    protected Vector3 mouse;
    protected GameStateManager gsm;
    public Stage processor;

    protected State(GameStateManager gsm)
    {
        this.gsm = gsm;
        this.cam = new OrthographicCamera();
        setCamera();
        //processor =
        //mouse = new Vector3();
    }

    protected abstract void handleInput(InputEvent event, EventType et);
    public abstract void update(float dt);
    public abstract void render(SpriteBatch b);
    public abstract void dispose();

    protected void setCamera()
    {
        float scrw = Gdx.app.getGraphics().getWidth();
        float scrh = Gdx.app.getGraphics().getHeight();

        this.cam.setToOrtho(false, 500, 888);
        this.cam.update();

    }

}
