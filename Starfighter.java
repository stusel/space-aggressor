package com.mygdx.game.sprites.enemies;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.misc.interfaces.IBehavior;

/**
 * Created by moritz2 on 19.06.2018.
 */

public class Starfighter extends EnemyShip {
    public Starfighter(Texture texture, Vector2 position) {
        super(texture, position);

        /*
        Behaviors.DIAGONAL_LEFT.n = 10;
        Behaviors.DIAGONAL_RIGHT.n = 10;
        Behaviors.FORWARD.n = 10;*/

        this.behavior = Behaviors.getStarfighterSteps();
    }

}
