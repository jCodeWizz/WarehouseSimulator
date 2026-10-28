package dev.codewizz.warehouse;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import dev.codewizz.main.Assets;

public class Robot {

    private final static Texture TEXTURES = Assets.getTexture("robot");

    private final Vector2 position;

    public Robot() {
        this.position = new Vector2();

    }

    public void render(SpriteBatch batch) {
        batch.draw(TEXTURES, position.x, position.y);
    }

    public Vector2 getPosition() {
        return position;
    }

}
