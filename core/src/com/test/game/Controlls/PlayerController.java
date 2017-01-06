package com.test.game.Controlls;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;
import com.test.game.Constants;
import com.test.game.Spites.Player;

public class PlayerController {

    private static final int MOVEMENT = 200;

    private Player player;

    public PlayerController (Player pPlayer){
        player = pPlayer;
    }

    public void setAdvanceController(float dt) {

        if (Gdx.input.isKeyPressed(Keys.A)) {
           player.getPosition().x -= MOVEMENT * dt * player.getVelocity();
        }
        if (Gdx.input.isKeyPressed(Keys.D)) {
            player.getPosition().x += MOVEMENT * dt * player.getVelocity();
        }
        if (Gdx.input.isKeyPressed(Keys.S)) {
            player.getPosition().y -= MOVEMENT * dt * player.getVelocity();
        }
        if (Gdx.input.isKeyPressed(Keys.W)) {
            player.getPosition().y += MOVEMENT * dt * player.getVelocity();
        }

        if (player.getPosition().x < 0) player.getPosition().x = 0;
        else if (player.getPosition().x > Constants.WIDTH - player.getTexturePlayer().getWidth())
            player.getPosition().x = Constants.WIDTH - player.getTexturePlayer().getWidth();
        if (player.getPosition().y < 0) player.getPosition().y = 0;
        else if (player.getPosition().y > Constants.HEIGHT - player.getTexturePlayer().getHeight())
            player.getPosition().y = Constants.HEIGHT - player.getTexturePlayer().getHeight();
    }

}
