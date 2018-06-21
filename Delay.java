package com.mygdx.game.misc.containers;

import com.mygdx.game.misc.interfaces.IAction;

/**
 * Created by moritz2 on 17.06.2018.
 */
// A Delay waits a certain time and then executes a action
public class Delay
{
    private float value;
    private float defaultReset;
    private IAction action;

    public Delay(float start, float reset)
    {
        this.value = start;
        this.defaultReset = reset;
    }

    // Set an IAction interface
    public void setAction(IAction ia)
    {
        this.action = ia;
    }

    public void update(float dt)
    {
        if (isEllapsed(dt)) executeAction();
    }

    // true if value is ellapsed
    public boolean isEllapsed(float dt)
    {
        this.value -= dt;
        if(this.value <= 0)
        {
            this.value += this.defaultReset;
            return true;
        }
        return false;
    }

    public void executeAction()
    {
        this.action.execute();
    }



}
