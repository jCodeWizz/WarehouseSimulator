package dev.codewizz.warehouse;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import dev.codewizz.network.Network;
import dev.codewizz.warehouse.pathfinding.NavGraph;

import java.util.ArrayList;
import java.util.List;

public class Warehouse {

    private final List<Robot> robots = new ArrayList<>();
    private final Network network;

    public Warehouse() {
        network = new Network();
    }

    public void render(SpriteBatch batch) {
        for (Robot robot : robots) {
            robot.render(batch);
        }
    }

    public void addRobot(float x, float y) {
        Robot robot = new Robot(this);
        robot.getPosition().set(x, y);
        robots.add(robot);
    }

    public Network getNetwork() {
        return network;
    }
}
