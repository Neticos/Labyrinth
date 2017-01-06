package com.test.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.test.game.States.GameStateManager;
import com.test.game.States.MenuState;

public class GameMain extends ApplicationAdapter {

	private SpriteBatch batch;

	private GameStateManager gsm;
	
	@Override
	public void create () {
		Gdx.gl.glClearColor(1, 0, 0, 1);

		gsm = new GameStateManager();

		batch = new SpriteBatch();

		gsm.push(new MenuState(gsm));
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(batch);

	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
