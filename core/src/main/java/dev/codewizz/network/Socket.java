package dev.codewizz.network;

public class Socket {

    private static int ID = 0;

    private final int id;
    private final Network network;

    public Socket(Network network) {
        this.network = network;
        this.id = Socket.ID++;
        network.openConnection(this);
    }

    public void receive(Packet packet) {}
    public void send(Packet packet) {
        packet.setFromId(id);
        network.send(packet);
    }

    public int getId() {
        return id;
    }
}
