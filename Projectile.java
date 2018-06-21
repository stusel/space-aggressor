package com.mygdx.game.sprites.projectiles;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.SpaceInvaders;
import com.mygdx.game.sprites.Sprite;

/**
 * Created by moritz2 on 02.06.2018.
 */

public abstract class Projectile extends Sprite {

    protected float damage;

    protected float speedY;

    @Override
    public void init(Texture texture, Vector2 position) {
        super.init(texture, position);
        //this.speedY = speed;
        //this.damage = damage;
    }


    public Projectile(Texture texture, Vector2 position) {
        super(texture, position);
    }

    public Projectile(Texture texture, Vector2 position, float speed, float damage) {
        super(texture, position);
        this.speedY = speed;
        this.damage = damage;
    }


    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    public Texture getTexture() {
        return super.getTexture();
    }

    // TODO: should be done in the container MyArray
    public void checkDispose()
    {
        if(this.position.y > SpaceInvaders.HEIGTH) dispose();
    }
}
