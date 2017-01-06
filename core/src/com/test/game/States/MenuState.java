package com.test.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.model.Animation;
import com.badlogic.gdx.math.Rectangle;
import com.test.game.Constants;

public class MenuState extends State {

    private Texture backgroundImage;
    private Texture playBtnImage;
    private Rectangle playBrnRect;

    private boolean playBtn = false;

    public MenuState(GameStateManager gsm) {
        super(gsm);
        backgroundImage = new Texture("menu_background.png");
        playBtnImage = new Texture("play_default.png");
        playBrnRect = new Rectangle(Constants.WIDTH / 2 - playBtnImage.getWidth() / 2,
                                    Constants.HEIGHT / 2 - playBtnImage.getHeight() / 2,
                                    playBtnImage.getWidth(),
                                    playBtnImage.getHeight());
    }

    public void setPlayBtnImage(Texture playBtnImage) {
        this.playBtnImage = playBtnImage;
    }

    public Rectangle getPlayBrnRect() {
        return playBrnRect;
    }

    @Override
    public void handleInput() {
        Gdx.input.setInputProcessor(new InputAdapter(){
            public boolean touchDown(int x,int y,int pointer,int button){
                if (playBrnRect.contains(x,y)) {
                    playBtnImage = new Texture("play_pressed.png");
                    playBtn = true;
                }
                return true;
            }

            public boolean touchUp(int x,int y,int pointer,int button){
                if (playBtn) {
                    playBtnImage = new Texture("play_default.png");
                    gsm.set(new GameState(gsm));
                    playBtn = false;
                }
                return true;
            }
        });
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(backgroundImage, 0 , 0);
        sb.draw(playBtnImage, Constants.WIDTH / 2 - playBtnImage.getWidth() / 2,
                Constants.HEIGHT / 2 - playBtnImage.getHeight() / 2);
        sb.end();

    }

    @Override
    public void dispose() {
        backgroundImage.dispose();
        playBtnImage.dispose();
    }
}
