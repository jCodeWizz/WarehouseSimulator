package dev.codewizz.network;

import java.util.HashMap;

public class Network {

    private final HashMap<Integer, Socket> sockets = new HashMap<>();

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
