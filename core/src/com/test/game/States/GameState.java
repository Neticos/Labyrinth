package com.test.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.test.game.Constants;
import com.test.game.Controlls.PlayerController;
import com.test.game.Spites.Player;

public class GameState extends State {

    private Texture background;
    private Player player;
    private PlayerController playerController;

    public GameState(GameStateManager gsm) {
        super(gsm);
        background = new Texture("background.png");
        player = new Player(0.5f, "player.png");
        player.createRectangle(Constants.WIDTH / 2 - 64 / 2, Constants.HEIGHT / 2 - 64 / 2);
        playerController = new PlayerController(player);
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
                player.getRectanglePlayer().x,
                player.getRectanglePlayer().y);
        sb.end();

        playerController.setController();
        playerController.startAnim(sb);

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
