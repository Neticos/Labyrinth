package com.test.game.Spites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.test.game.Animations.AnimationPlayer;
import com.test.game.Controlls.PlayerController;

public class Player {

    private Vector3 position;
    private float velocity;
    private Texture playerImage;
    private Rectangle boundsPlayer;
    private AnimationPlayer animationPlayer;
    private PlayerController playerController;

    public Player(int x, int y, float velocity, String texture){
        this.velocity = velocity;
        this.playerImage = new Texture(texture);
        this.animationPlayer = new AnimationPlayer(new TextureRegion(playerImage), 4, 0.5f);
        this.boundsPlayer = new Rectangle(x / 2 - playerImage.getWidth() / 2,
                                     y / 2 - playerImage.getHeight() / 2,
                                     playerImage.getWidth() / 4,
                                     playerImage.getHeight());
        this.position = new Vector3(boundsPlayer.x, boundsPlayer.y, 0);
        this.playerController = new PlayerController(this);
    }

    public void update(float dt){
        animationPlayer.update(dt);

        playerController.setAdvanceController(dt);

    }

    public Rectangle getBoundsPlayer() {
        return boundsPlayer;
    }

    public Vector3 getPosition() {
        return position;
    }

    public void setPosition(Vector3 position) {
        this.position = position;
    }

    public float getVelocity() {
        return velocity;
    }

    public void setVelocity(float velocity) {
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
