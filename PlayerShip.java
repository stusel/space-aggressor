package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.SpaceInvaders;

/**
 * Created by moritz2 on 22.05.2018.
 */

public class PlayerShip extends Sprite
{


    public PlayerShip(Texture txt, Vector2 position)
    {
        super(txt, position);
        //this.texture = txt;
        //this.position = new Vector2(SpaceInvaders.WIDTH / 2, SpaceInvaders.HEIGTH / 2);
        //this.position = new Vector2(50, 50);

    }

    @Override
    public void update(float dt)
    {
        //move(new Vector2(3, 0));

    }

    @Override
    public void render(SpriteBatch batch)
    {
        /*batch.begin();
        batch.draw(this.texture, this.position.x, this.position.y);
        batch.end();*/
        super.render(batch);


    }

    public void fire()
    {}

}
