package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Pool;
import com.mygdx.game.SpaceInvaders;


/**
 * Created by moritz2 on 22.05.2018.
 */

public abstract class Sprite implements Pool.Poolable
{
    public boolean isAlive() {
        return alive;
    }

    protected boolean  alive;
    protected Texture texture;
    protected Vector2 position, speed;

    public Sprite(Texture texture, Vector2 position)
    {
        this.alive = false;
        this.texture = texture;
        this.position = position;
    }

    public void update(float dt)
    {
        if (this.isOutOfScreen()) this.alive = false;
    }

    public void init(Texture texture, Vector2 position) {
        this.position.set(position);
        this.texture = texture;
        this.alive = true;
    }

    public void render(SpriteBatch batch)
    {
        batch.begin();
        batch.draw(this.texture, this.position.x, this.position.y);
        batch.end();
    }
    public void dispose()
    {

        this.texture.dispose();
        //this.position = null;
    }
    public void move(Vector2 translation)
    {
        this.position.add(translation);
    }


    public Texture getTexture()
    {
        return this.texture;
    }

    public Vector2 getPosition() {
        return position;
    }

    public Rectangle getRectangle()
    {
        return new Rectangle(this.position.x, this.position.y, this.texture.getWidth(), this.texture.getHeight());
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    @Override
    public void reset()
    {
        this.position.set(0, 0);
        this.alive = false;

    }

    public boolean isOutOfScreen()
    {
        if(this.getPosition().x > SpaceInvaders.WIDTH || this.getPosition().y > SpaceInvaders.HEIGTH)
        {
            return true;
        }
        else return false;
    }
}
