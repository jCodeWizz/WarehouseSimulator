package dev.codewizz.main;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import dev.codewizz.warehouse.Warehouse;

public class Main extends ApplicationAdapter {

    private SpriteBatch batch;
    private Warehouse warehouse;

    @Override
    public void create() {
        Assets.load();

        batch = new SpriteBatch();
        warehouse = new Warehouse();

        warehouse.addRobot(10, 10);
    }

    @Override
    public void render() {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);

        batch.begin();
        warehouse.render(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
