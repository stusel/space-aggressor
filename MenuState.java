package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.sprites.controls.EventType;
import com.badlogic.gdx.scenes.scene2d.InputEvent;


/**
 * Created by moritz2 on 05.04.2018.
 */

public class MenuState extends State
{
    private Texture background, playBtn;
    private Sprite play;

    public MenuState(GameStateManager gsm)
    {
        super(gsm);
        background = new Texture("bg_mobile.png");
        playBtn = new Texture("playbtn.png");
        //play = new Sprite(playBtn, (FlabbyTurdGame.WIDTH / 2) - (playBtn.getWidth() / 2), FlabbyTurdGame.HEIGTH / 2,
          //      playBtn.getWidth(), playBtn.getHeight());

    }

    @Override
    public void handleInput(InputEvent e, EventType eventType)
    {
        if(Gdx.input.justTouched())
        {
            //Gdx.input.get

            //if(Intersector.overlaps(play.getBoundingRectangle(),new Rectangle(Gdx.input.getX(), Gdx.input.getY(), 1, 1)))
            {
                gsm.set(new PlayState(gsm));
                dispose();
            }

            //dispose();
        }

    }

    @Override
    public void update(float dt)
    {


    }

    @Override
    public void render(SpriteBatch b)
    {
        b.begin();
        b.draw(background, 0, 0, 1080, 1920);
        //b.draw(background,0,0, FlabbyTurdGame.WIDTH, FlabbyTurdGame.HEIGTH);
        //b.draw(play.getTexture(), (FlabbyTurdGame.WIDTH_MOBILE / 2) - (playBtn.getWidth() / 2), FlabbyTurdGame.HEIGTH_MOBILE / 2);
        b.end();

    }

    @Override
    public void dispose() {
        background.dispose();
        playBtn.dispose();
    }
}
