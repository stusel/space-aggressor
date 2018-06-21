package com.mygdx.game.sprites.enemies;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.misc.containers.MyBehavior;
import com.mygdx.game.misc.interfaces.IBehavior;

/**
 * Created by moritz2 on 19.06.2018.
 */

public class Meteor extends EnemyShip {
    public Meteor(Texture texture, Vector2 position) {
        super(texture, position);
        this.behavior = new MyBehavior(1);
        this.behavior.addAll(Behaviors.getMultiple(Behaviors.FORWARD, 1));
    }



}
