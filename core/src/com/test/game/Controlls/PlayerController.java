package com.test.game.Controlls;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;
import com.test.game.Spites.Player;

public class PlayerController {

    private Player player;

    public PlayerController (Player pPlayer){
        player = pPlayer;
    }

    public void setAdvanceController(Vector3 position, Vector3 velocity, ) {
        if (Gdx.input.isKeyPressed(Keys.A)) {
            player.getRectanglePlayer().x -= 200 * Gdx.graphics.getDeltaTime();
        }
        if (Gdx.input.isKeyPressed(Keys.D)) {
            player.getRectanglePlayer().x += 200 * Gdx.graphics.getDeltaTime();
        }
        if (Gdx.input.isKeyPressed(Keys.S)) {
            player.getRectanglePlayer().y -= 200 * Gdx.graphics.getDeltaTime();
        }
        if (Gdx.input.isKeyPressed(Keys.W)) {
            player.getRectanglePlayer().y += 200 * Gdx.graphics.getDeltaTime();
        }

        if (player.getRectanglePlayer().x < 0) player.getRectanglePlayer().x = 0;
        else if (player.getRectanglePlayer().x > 720 - 64) player.getRectanglePlayer().x = 720 - 64;
        if (player.getRectanglePlayer().y < 0) player.getRectanglePlayer().y = 0;
        else if (player.getRectanglePlayer().y > 480 - 64) player.getRectanglePlayer().y = 480 - 64;
    }

}
