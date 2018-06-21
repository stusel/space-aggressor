package com.mygdx.game.misc.containers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.sprites.enemies.Step;

/**
 * Created by moritz2 on 21.06.2018.
 */

public class MyBehavior extends Array<Step>
{
    private int length;
    public MyBehavior(int len)
    {
        super(true, len, Step.class);
        length = len;
    }

    public int getLength()
    {
        return this.length;
    }

    public void dispose()
    {
        try{
            this.finalize();
        }
        catch (Throwable e)
        {
            Gdx.app.log("", "finalizing");
        }
    }
}
