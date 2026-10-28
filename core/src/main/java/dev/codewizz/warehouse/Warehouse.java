package dev.codewizz.warehouse;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.List;

public class Warehouse {

    private List<Robot> robots = new ArrayList<>();

    public Warehouse() {

    }

    public void render(SpriteBatch batch) {
        for (Robot robot : robots) {
            robot.render(batch);
        }
    }

    public void addRobot(float x, float y) {
        Robot robot = new Robot();
        robot.getPosition().set(x, y);
        robots.add(robot);
    }
}
