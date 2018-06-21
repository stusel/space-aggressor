package com.mygdx.game.sprites.controls;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

/**
 * Created by moritz2 on 27.05.2018.
 */

public class Button extends Control
{
    private boolean pressed;

    public boolean isPressed() {
        return pressed;
    }

    public Button(Texture texture, final Vector2 position, String text)
    {
        super(texture, position, text);
        this.pressed = false;

        this.imageButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(this.texture)));

  /*      this.imageButton.addListener(new EventListener()
        {
            @Override
            public boolean handle(Event event)
                {
                    if(event.getTarget().equals(imageButton))
                    {
                        pressed = !pressed;
                        System.out.println("lul x= "+ position.x + " y= " + position.y);
                        return true;
                    }


                //System.out.println("lul x= "+ x + " y= " + y);
                return false;
            }
        });*/
/*
        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean touchDown (int x, int y, int pointer, int button) {
                // your touch down code here
                System.out.println("touchDown");
                pressed = true;
                return true; // return true to indicate the event was handled
            }

            @Override
            public boolean touchUp (int x, int y, int pointer, int button) {
                // your touch up code here
                System.out.println("touchUp");
                pressed = false;
                return true; // return true to indicate the event was handled
            }
        });
*/

        this.imageButton.addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("touchDown");
                pressed = true;
                return true;
            }
        });

        this.imageButton.addListener(new ClickListener(){
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("touchUp");
                System.out.println(pointer);
                pressed = false;
            }
        });
    }


    @Override
    public void update(float dx)
    {

    }

    @Override
    public void render(SpriteBatch batch)
    {
        batch.begin();
        //this.stage.draw();
        batch.end();

    }

    public void handleInput(InputEvent event)
    {
        if(event.getTarget().equals(this.imageButton)) {

            switch (event.getType()) {
                case touchDown:
                    Gdx.app.log("touchDown", "touchDown");
                    break;
                case touchUp:
                    Gdx.app.log("touchUp", "touchUp");
                    break;
            }
        }
    }

    public static Button Get(Button[] bs, Actor a)
    {
        for (Button b : bs)
        {
            if(b.imageButton == a) return b;

        }
        return null;

    }
}
