package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Pool;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.SpaceInvaders;
import com.mygdx.game.misc.containers.Delay;
import com.mygdx.game.misc.containers.MySprites;
import com.mygdx.game.misc.interfaces.IAction;
import com.mygdx.game.misc.interfaces.IDisposer;
import com.mygdx.game.sprites.Sprite;
import com.mygdx.game.sprites.controls.Button;
import com.mygdx.game.sprites.PlayerShip;
import com.mygdx.game.sprites.controls.EventType;
import com.mygdx.game.sprites.controls.MyInputProcessor;
import com.mygdx.game.sprites.enemies.EnemyShip;
import com.mygdx.game.sprites.enemies.Meteor;
import com.mygdx.game.sprites.enemies.Starfighter;
import com.mygdx.game.sprites.projectiles.Bullet;
import com.mygdx.game.sprites.projectiles.Projectile;
//import com.sun.xml.internal.bind.v2.model.core.ID;

/**
 * Created by moritz2 on 08.04.2018.
 */

public class PlayState extends State
{
    private IDisposer bulletDisposer, enemieDisposer;

    public final Pool<Bullet> bulletPool = new Pool<Bullet>() {
        @Override
        protected Bullet newObject() {
            return new Bullet(new Texture("bullet.png"), new Vector2(player.getPosition().x, 500), 8, 1);
        }
    };

    public final Pool<Meteor> meteorPool = new Pool<Meteor>() {
        @Override
        protected Meteor newObject() {
            return new Meteor(new Texture("meteor.png"), new Vector2());
        }
    };

    public Texture[] meteorSizes;

    // -- Game Objects --

    // Player
    private PlayerShip player;
    // Buttons
    private Button buttonLeft, buttonRight;

    // Containers
    private MySprites bullets;
    private MySprites enemies;
    // Delays
    private Delay bulletDelay, meteorSpawnDelay, starfighterSpawnDelay;

    public Texture test;

    // -- Input Flags --
    private boolean leftPressed, rightPressed;

    // Table for Buttons
    private Table table;

    private MyInputProcessor withoutButtons;

    public PlayState(GameStateManager gsm)
    {
        super(gsm);             // call superclass constructor

        // Set input Flags
        leftPressed = rightPressed = false;
        withoutButtons = new MyInputProcessor();

        meteorSizes = new Texture[]{
                SpaceInvaders.scale("meteor.png", 30,30),
                SpaceInvaders.scale("meteor.png", 50, 50),
                SpaceInvaders.scale("meteor.png", 100, 100),
        };

        this.enemieDisposer = new IDisposer() {
            @Override
            public void checkDispose(Sprite sprite) {
                if(sprite.getPosition().y < 0) sprite.dispose();
            }
        };

        this.bulletDisposer = new IDisposer() {
            @Override
            public void checkDispose(Sprite sprite) {

            }
        };

        // Initialize Game Objects
        player = new PlayerShip(new Texture("player.png"), new Vector2(200, 300));
        bullets = new MySprites(false, 50, Projectile.class);
        enemies = new MySprites(false, 50, EnemyShip.class);
        enemies.setDisposer(this.enemieDisposer);
        bullets.setDisposer(this.bulletDisposer);

        // -- Setup Delays --
        // Player bullets
        bulletDelay = new Delay(0.1f, 0.5f);
        bulletDelay.setAction(new IAction() {
            @Override
            public void execute()
            {
                Bullet b;
                b = bulletPool.obtain();
                Vector2 pos = player.getPosition();

                b.init(new Texture("bullet.png"), new Vector2(pos.x, 500));

                bullets.add(b);

            }
        });

        // enemy meteor
        meteorSpawnDelay = new Delay(1f, 1.2f);
        meteorSpawnDelay.setAction(new IAction() {
            @Override
            public void execute() {

                int random = Math.round((float) Math.random() * (meteorSizes.length - 1));

                Meteor meteor;
                meteor = meteorPool.obtain();
                meteor.init(meteorSizes[random], new Vector2((float) Math.random() *
                        SpaceInvaders.WIDTH, SpaceInvaders.HEIGTH));

                enemies.add(meteor);
            }
        });

        starfighterSpawnDelay = new Delay(3f, 3f);
        starfighterSpawnDelay.setAction(new IAction() {
            @Override
            public void execute() {

                //enemies.add(new Starfighter(new Texture("player.png"), new Vector2((float) Math.random() *
                  //      SpaceInvaders.WIDTH, SpaceInvaders.HEIGTH)));

            }
        });

        // Buttons
        buttonLeft = new Button(new Texture("btn_left.png"), new Vector2(0, 0), "<---");
        buttonRight = new Button(new Texture("btn_right.png"), new Vector2(SpaceInvaders.WIDTH / 2, 0), "0");

        // Add Buttons to table
        setUpUI();

        //final Button[] buttons = {buttonLeft, buttonRight};

        // Stage
        this.processor = new Stage(new ScreenViewport());

        // Add Buttons to the stage
        this.processor.addActor(this.table);

        //Gdx.input.setInputProcessor(this.processor);

        Gdx.input.setInputProcessor(withoutButtons);

        //this.cam.setToOrtho(false, SpaceInvaders.WIDTH / 5, SpaceInvaders.HEIGTH / 5);
        this.cam.setToOrtho(false);


    }

    @Override
    protected void handleInput(InputEvent e, EventType eventType)
    {
        /*Actor target = e.getTarget();
        if(target == null)
        {
            Gdx.app.log("Warning", "Target is null");
            return;
        }

        if(target.getName() == null) return;
        Gdx.app.log("Target", target.getName());
        Gdx.app.log("EventType", eventType.name());
        // Target is left Button
        if(target.equals(this.buttonLeft.getImageButton()))
        {
            switch (eventType)
            {
                case touchDown: leftPressed = true; rightPressed = false; break;
                case touchUp: leftPressed = false;
            }

        }else if(target.equals(this.buttonRight.getImageButton()))
        {
            switch (eventType)
            {
                case touchDown: rightPressed = true; leftPressed = false;break;
                case touchUp: rightPressed = false;
            }
        }
*/
    }

    private void handleInput()
    {

        if(buttonLeft.isPressed())
        {
            leftPressed = true;
            rightPressed = false;
        }
        else leftPressed = false;
        if (buttonRight.isPressed())
        {
            leftPressed = false;
            rightPressed = true;
        }else rightPressed = false;
    }

    @Override
    public void update(float dt)
    {
        player.update(dt);
        enemies.checkCollision(bullets);
        handleInput();

        switch (this.withoutButtons.getCurrentSpot())
        {
            case LEFT: this.player.move(new Vector2(-5, 0)); break;
            case RIGHT: this.player.move(new Vector2(5, 0));
        }

        bullets.update(dt);
        bulletDelay.update(dt);
        meteorSpawnDelay.update(dt);
        starfighterSpawnDelay.update(dt);
        enemies.update(dt);

        this.checkFree();


    }

    @Override
    public void render(SpriteBatch b)
    {
        // Matrix stuff
        this.cam.update();
        b.setProjectionMatrix(this.cam.combined);


        enemies.render(b);
        player.render(b);
        bullets.render(b);

        //buttonLeft.render(b);
        b.begin();
        table.draw(b, 1);
        b.end();
        this.processor.draw();
        this.processor.act();

    }

    @Override
    public void dispose() {


    }
    private void setUpUI()
    {
        // Set up table
        this.table = new Table();
        this.table.setSize(SpaceInvaders.WIDTH, SpaceInvaders.HEIGTH);

        // Add Buttons to Table
        table.add(buttonLeft.getImageButton()).bottom();
        table.add(buttonRight.getImageButton()).bottom();
        table.bottom();

    }
    public void setLeftPressed(boolean leftPressed) {
        this.leftPressed = leftPressed;
    }

    public void setRightPressed(boolean rightPressed) {
        this.rightPressed = rightPressed;
    }

    public boolean isLeftPressed() {
        return leftPressed;
    }

    public boolean isRightPressed() {
        return rightPressed;
    }

    public void checkFree()
    {
        Sprite sprite;
        int len = this.length;
        for(int i = len; --i >=0;)
        {
            sprite = this.get(i);
            if(!sprite.isAlive())
            {
                this.removeIndex(i);
                p.free(sprite);
            }
        }
    }

}
