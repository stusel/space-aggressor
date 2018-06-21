package com.mygdx.game.misc.containers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pool;
import com.mygdx.game.misc.interfaces.IDisposer;
import com.mygdx.game.sprites.PlayerShip;
import com.mygdx.game.sprites.Sprite;
import com.mygdx.game.states.PlayState;

import java.util.ArrayList;

/**
 * Created by moritz2 on 03.06.2018.
 */

public class MySprites extends Array<Sprite>
{

    public int length;
    private int counter;
    private IDisposer disposer;
    public MySprites(boolean sorted, int len, Class c)
    {
        // use this super constructor!!
        // otherwise it will throw ClasscastExc
        super(sorted, len, c);
        this.length = this.items.length;
    }

    public void checkCollision(MySprites sprites)
    {

        // check for null instead of catching Exception
        for(int i = 0; i < this.length && this.items[i] != null; i++)
        {
            for(int j = 0; j < sprites.length && sprites.items[j] != null; j++)
            {
                if(this.items[i].getRectangle().overlaps(sprites.items[j].getRectangle()))
                {
                    this.items[i].dispose();
                }

            }
        }
    }

    public void move(Vector2 trans)
    {
        //int len = this.items.length;
        for(int i = 0; i < this.length && this.items[i] != null; i++)
        {
            //try {
                this.items[i].move(trans);

        }
    }

    public void render(final SpriteBatch b)
    {
        for(int i = 0; i < this.length && this.items[i] != null; i++)
        {

            this.items[i].render(b);

        }
    }

    public void update(float dt)
    {
        for(int i = 0; i < this.length ; i++)
        {

            if(this.items[i] != null)
            {
                this.items[i].update(dt);
                //checkDispose();
                //this.disposer.checkDispose(this.items[i]);
            }
        }

    }

    public void setDisposer(IDisposer disposer) {
        this.disposer = disposer;
    }

    public void checkDispose()
    {
        for(int i = 0; i < this.length && this.items[i] != null; i++)
        {

            this.disposer.checkDispose(this.items[i]);

        }
    }

    @Override
    public void add(Sprite value) {
        //super.insert(this.counter,value);
        this.items[this.counter] = value;
        this.counter++;
        if(this.counter == this.length) this.counter = 0;

    }

    public void checkFree(Pool<Sprite> p)
    {
        Sprite sprite;
        int len = this.length;
        for(int i = len; --i >=0;)
        {
            sprite = this.get(i);
            if(!sprite.isAlive())
            {
                this.removeIndex(i);
                p.free(sprite);
            }
        }
    }
}
