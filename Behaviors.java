package com.mygdx.game.sprites.enemies;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.misc.containers.MyBehavior;
import com.mygdx.game.misc.interfaces.IAction;
import com.mygdx.game.misc.interfaces.IBehavior;
import com.mygdx.game.sprites.Sprite;

import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * Created by moritz2 on 19.06.2018.
 */

public class Behaviors
{
    /*public static IBehavior FORWARD = new IBehavior() {
        @Override
        public void execute(Sprite sprite) {
            sprite.move(new Vector2(0, -5));
        }
    };*/

    public static Step FORWARD = new
            Step(new IBehavior() {
        @Override
        public void execute(Sprite sprite) {
            sprite.move(new Vector2(0, -5));
        }
    },
    1);

    public static Step DIAGONAL_LEFT = new Step(new IBehavior() {
        @Override
        public void execute(Sprite sprite) {
            sprite.move(new Vector2(-5, -5));
        }
    }, 1);

    public static Step DIAGONAL_RIGHT = new Step(new IBehavior() {
        @Override
        public void execute(Sprite sprite) {
            sprite.move(new Vector2(5, -5));
        }
    }, 1);

    // array with n steps p
    public static Step[] getMultiple(Step p, int n)
    {
        Step[] tmp = new Step[n];
        for(int i = 0; i < n; i++)
        {
            tmp[i] = p;
        }

        return tmp;
    }

    public static MyBehavior getStarfighterSteps()
    {
        MyBehavior temp = new MyBehavior(80);
        temp.addAll(getMultiple(FORWARD, 20));
        temp.addAll(getMultiple(DIAGONAL_LEFT, 20));
        temp.addAll(getMultiple(FORWARD, 20));
        temp.addAll(getMultiple(DIAGONAL_RIGHT, 20));
        return temp;
    }
}
