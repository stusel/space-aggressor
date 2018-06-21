package com.mygdx.game.misc;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.mygdx.game.misc.containers.Delay;

/**
 * Created by moritz2 on 18.06.2018.
 */

public class Animator<T> extends Animation<T>
{
    private float stateTime;

    public Animator(float time, T frames)
    {
        super(time, frames);
    }
}
