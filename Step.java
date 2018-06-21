package com.mygdx.game.sprites.enemies;

import com.mygdx.game.misc.interfaces.IBehavior;

/**
 * Created by moritz2 on 19.06.2018.
 */

public class Step
{
    public IBehavior behavior;
    public int n;

    public Step(IBehavior behavior, int n) {
        this.behavior = behavior;
        this.n = n;
    }
}
