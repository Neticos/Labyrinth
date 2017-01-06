package com.test.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.test.game.Constants;

import com.test.game.Spites.Player;

public class GameState extends State {

    private Texture background;
    private Player player;

    public GameState(GameStateManager gsm) {
        super(gsm);
        background = new Texture("background.png");
        player = new Player(Constants.WIDTH, Constants.HEIGHT, 0.5f, "idle_player_top.png");
    }

    @Override
    public void handleInput() {
    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(background, 0, 0);
        sb.draw(player.getTexturePlayer(),
                player.getPosition().x,
                player.getPosition().y);
        sb.end();

        player.update(Gdx.graphics.getDeltaTime());

        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)){
            gsm.push(new MenuState(gsm));
        }
    }

    @Override
    public void dispose() {
        background.dispose();
        player.dispose();
    }
}
