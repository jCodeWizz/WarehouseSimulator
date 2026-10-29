package dev.codewizz.warehouse;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import dev.codewizz.network.Network;

import java.util.ArrayList;
import java.util.List;

public class Warehouse {

    private List<Robot> robots = new ArrayList<>();
    private Network network;

    public Warehouse() {

    }

    public void render(SpriteBatch batch) {
        for (Robot robot : robots) {
            robot.render(batch);
        }
    }

    public void addRobot(float x, float y) {
        Robot robot = new Robot(network);
        robot.getPosition().set(x, y);
        robots.add(robot);
    }
}
