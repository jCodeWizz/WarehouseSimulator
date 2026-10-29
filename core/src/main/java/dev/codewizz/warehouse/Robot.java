package dev.codewizz.warehouse;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import dev.codewizz.main.Assets;
import dev.codewizz.network.Network;
import dev.codewizz.network.Packet;
import dev.codewizz.network.Socket;
import dev.codewizz.warehouse.pathfinding.NavAgent;

import java.util.ArrayList;
import java.util.List;

public class Robot {

    private final static Texture TEXTURES = Assets.getTexture("robot");

    private final Vector2 position;
    private final Vector2 velocity;
    private final Socket socket;
    private final NavAgent agent;

    private final List<Robot> knownNeighbours = new ArrayList<>();

    private Package carryingPackage;

    public Robot(Warehouse warehouse) {
        this.position = new Vector2();
        this.velocity = new Vector2();
        this.agent = new NavAgent(this);

        socket = new Socket(warehouse.getNetwork()) {
            @Override
            public void receive(Packet packet) {
                receivePacket(packet);
            }
        };

        System.out.println(this.agent.navigate(NavAgent.graph.getCell(5, 5)));
    }

    public void receivePacket(Packet packet) {

    }

    public void render(SpriteBatch batch) {
        batch.draw(TEXTURES, position.x, position.y);
    }

    public Vector2 getPosition() {
        return position;
    }

    public Vector2 getVelocity() {
        return velocity;
    }
}
