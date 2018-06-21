package com.mygdx.game.sprites.enemies;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.misc.containers.MyBehavior;
import com.mygdx.game.sprites.Sprite;

/**
 * Created by moritz2 on 15.06.2018.
 */

public class EnemyShip extends Sprite
{
    protected MyBehavior behavior;
    protected int stepCounter;
    protected Step step;

    public EnemyShip(Texture texture, Vector2 position)
    {
        super(texture, position);
        this.stepCounter = 0;
    }

    @Override
    public void update(float dt) {

        super.update(dt);
        // execute action at stepCounter
        this.behavior.get(this.stepCounter).behavior.execute(this);

        this.stepCounter++;

        // --------- ERROR ZONE --------------
        // leave try-catch block to make it work
        // TODO: solve exception problem
        //try {

            if (this.stepCounter == this.behavior.getLength()) this.stepCounter = 0;
        //}
        //catch (ClassCastException e){
            //Gdx.app.log("debug", e.getMessage());
            //this.stepCounter = 0;
        //}

        // check dispose
        //this.execute();
    }

    @Override
    public void init(Texture texture, Vector2 position) {
        super.init(texture, position);

    }

    /*

    @Override
    public void dispose() {
        //Gdx.app.log("Disposed", "enemy");

        super.dispose();
        this.behavior.dispose();
    }


    @Override
    public boolean checkDispose() {
        if(this.position.y < 0){ Gdx.app.log("Disposer", this.toString());return true; }
        else return false;
    }

    @Override
    public void execute() {
        if (this.checkDispose()) this.dispose();


    }*/
}
