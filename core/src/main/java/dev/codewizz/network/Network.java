package dev.codewizz.network;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Network {

    private final Map<Integer, Socket> sockets = new ConcurrentHashMap<>();

    public void openConnection(Socket socket) {
        sockets.put(socket.getId(), socket);
    }

    public void send(Packet packet) {
        if (packet.getToId() == -1) {
            for (Socket socket : sockets.values()) {
                socket.receive(packet);
            }
            return;
        }

        sockets.get(packet.getToId()).receive(packet);
    }
}
