package com.mygdx.game.sprites.projectiles;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by moritz2 on 02.06.2018.
 */

public class Bullet extends Projectile
{

    public Bullet(Texture texture, Vector2 position, float speed, float damage) {
        super(texture, position, speed, damage);
    }

    @Override
    public void update(float dt)
    {
        super.update(dt);
        checkDispose();
        move(new Vector2(0, this.speedY));
    }

    @Override
    public void render(SpriteBatch batch) {
        super.render(batch);

    }
}
