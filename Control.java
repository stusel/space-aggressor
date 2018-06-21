package com.mygdx.game.sprites.controls;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
//import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.sprites.Sprite;

/**
 * Created by moritz2 on 22.05.2018.
 */

public abstract class Control extends Sprite
{
    public ImageButton getImageButton() {
        return imageButton;
    }

    public Vector2 getSize() {
        return size;
    }

    protected Vector2 size;

    protected InputAdapter processor;

    protected Stage stage;
    //protected com.badlogic.gdx.scenes.scene2d.ui.TextButton button;
    protected ImageButton imageButton;

    protected TextButton.TextButtonStyle textButtonStyle;
    protected BitmapFont font;
    protected Skin skin;

    public Control(Texture texture, final Vector2 position, String text)
    {
        super(texture, position);
        this.size = new Vector2(texture.getWidth(), texture.getHeight());

        this.imageButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(this.texture)));

    }


}
