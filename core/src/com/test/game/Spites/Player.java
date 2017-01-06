package com.test.game.Spites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.test.game.Animations.AnimationPlayer;
import com.test.game.Controlls.PlayerController;

public class Player {

    private static final int MOVEMENT = 200;

    private Vector3 position;
    private Vector3 velocity;
    private Texture playerImage;
    private Rectangle rectanglePlayer;
    private AnimationPlayer animationPlayer;
    private PlayerController playerController;

    public Player(int x, int y, float velocity, String texture, PlayerController playerController){
        position = new Vector3(x, y, 0);
        this.velocity = new Vector3(velocity, velocity, 0);
        playerImage = new Texture(texture);
        animationPlayer = new AnimationPlayer(new TextureRegion(playerImage), 3, 0.5f);
        rectanglePlayer = new Rectangle(x, y, playerImage.getWidth() / 4, playerImage.getHeight());
        playerController = new PlayerController(this);
    }

    public void update(float dt){
        animationPlayer.update(dt);
        velocity.scl(dt);
        position.add(MOVEMENT * dt, velocity.y, 0);

        if (position.)

    }

    public Rectangle getRectanglePlayer() {
        return rectanglePlayer;
    }

    public Vector3 getPosition() {
        return position;
    }

    public void setPosition(Vector3 position) {
        this.position = position;
    }

    public Vector3 getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector3 velocity) {
        this.velocity = velocity;
    }

    public Texture getTexturePlayer() {
        return playerImage;
    }

    public void setTexturePlayer(Texture texturePlayer) {
        this.playerImage = texturePlayer;
    }

    public void dispose(){
        playerImage.dispose();
    }

}
