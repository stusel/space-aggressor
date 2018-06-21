package com.mygdx.game;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.sprites.controls.Button;
import com.mygdx.game.states.GameStateManager;
import com.mygdx.game.states.PlayState;

public class SpaceInvaders extends ApplicationAdapter {
	SpriteBatch batch;
	GameStateManager gsm;

	public static int WIDTH = 1080;
	public static int HEIGTH = 1920;
	public static final String TITLE = "Space Invaders";

	Texture img;



	@Override
	public void create () {
		batch = new SpriteBatch();
		gsm = new GameStateManager();
		img = new Texture("badlogic.jpg");

		// Gdx.graphics.setWindowedMode(WIDTH, HEIGTH);

		//buttonAtlas = new TextureAtlas(Gdx.files.internal("buttons/buttons.pack"));
		//skin.addRegions(buttonAtlas);

		//textButtonStyle.up = skin.getDrawable("up-button");
		//textButtonStyle.down = skin.getDrawable("down-button");
		//textButtonStyle.checked = skin.getDrawable("checked-button");

		gsm.push(new PlayState(gsm));
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(batch);
		Gdx.app.log("FPS",""+Gdx.graphics.getFramesPerSecond());

	}

	public void setup()
	{
		Graphics graphics = Gdx.app.getGraphics();
		graphics.setTitle(TITLE);

		if(Gdx.app.getType().equals(Application.ApplicationType.Android))
		{
			// -- portrait mode set in AndroidManifest --

			WIDTH = graphics.getWidth();
			HEIGTH = graphics.getHeight();

		}

	}

	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}

	public static Texture scale(String path, int width, int height)
	{
		Pixmap pm1, pm2;
		Texture ret;
		pm1 = new Pixmap(Gdx.files.internal(path));
		pm2 = new Pixmap(width, height, pm1.getFormat());
		pm2.drawPixmap(pm1, 0, 0, pm1.getWidth(), pm1.getHeight(), 0, 0,
				pm2.getWidth(), pm2.getHeight());
		ret = new Texture(pm2);
		pm1.dispose();
		pm2.dispose();
		return ret;
	}
}
