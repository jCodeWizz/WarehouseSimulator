package dev.codewizz.warehouse;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import dev.codewizz.main.Assets;
import dev.codewizz.network.Network;
import dev.codewizz.network.Packet;
import dev.codewizz.network.Socket;

public class Robot {

    private final static Texture TEXTURES = Assets.getTexture("robot");

    private final Vector2 position;
    private final Socket socket;

    public Robot(Network network) {
        this.position = new Vector2();
        socket = new Socket(network) {
            @Override
            public void receive(Packet packet) {
                receivePacket(packet);
            }
        };
    }

    public void receivePacket(Packet packet) {

    }

    public void render(SpriteBatch batch) {
        batch.draw(TEXTURES, position.x, position.y);
    }

    public Vector2 getPosition() {
        return position;
    }

}
