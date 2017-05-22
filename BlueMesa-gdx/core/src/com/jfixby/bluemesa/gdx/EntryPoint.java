
package com.jfixby.bluemesa.gdx;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jfixby.bluemesa.sqs.MessagesConsumer;
import com.jfixby.scarabei.api.collections.List;
import com.jfixby.scarabei.api.util.JUtils;

public class EntryPoint extends ApplicationAdapter implements MessagesConsumer {
	SpriteBatch batch;
	private BitmapFont font;
// Texture img;
	private List<String> stack;

	@Override
	public void create () {
		this.batch = new SpriteBatch();
		this.font = new BitmapFont();
		this.font.setColor(Color.WHITE);
// this.img = new Texture("badlogic.jpg");

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0.01f, 0.3f, 0f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		this.batch.begin();

		final float H = this.font.getLineHeight();
		if (this.stack != null) {
			for (int i = 0; i < this.stack.size(); i++) {
				this.font.draw(this.batch, this.stack.getElementAt(i), 10, 50 + i * H);
			}
		}
// this.batch.draw(this.img, 0, 0);
		this.batch.end();
	}

	@Override
	public void dispose () {
		this.batch.dispose();
		this.font.dispose();
// this.img.dispose();
	}

	@Override
	public void append (final String messageText) {

		this.stack = JUtils.split(messageText, "\n");
		this.stack.reverse();
	}
}
