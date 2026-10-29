package dev.codewizz.network;

public class Packet {

    private int fromId;
    // -1 for broadcast
    private final int toId;

    private final PacketType type;
    private final int[] data;

    public Packet(int fromId, int toId, PacketType type, int... data) {
        this.fromId = fromId;
        this.toId = toId;
        this.type = type;
        this.data = data;
    }

    public void setFromId(int fromId) {
        this.fromId = fromId;
    }

    public int getFromId() {
        return fromId;
    }

    public int getToId() {
        return toId;
    }

    public PacketType getType() {
        return type;
    }

    public int[] getData() {
        return data;
    }
}
