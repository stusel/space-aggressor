package com.mygdx.game.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

/**
 * Created by moritz2 on 01.04.2018.
 */

public class GameStateManager
{
    public Stack<State> states;

    public GameStateManager()
    {
        states = new Stack<State>();
    }

    public void push(State s)
    {
        states.push(s);
    }

    public void pop()
    {
        states.pop();
    }

    public void set(State s)
    {
        states.pop();
        states.push(s);
    }

    public void update(float dt)
    {
        states.peek().update(dt);
    }

    public void render(SpriteBatch sb)
    {
        states.peek().render(sb);
    }
}
