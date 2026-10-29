package dev.codewizz.warehouse.pathfinding;

import com.badlogic.gdx.ai.pfa.Connection;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;

public class NavCell {

    public float x, y;
    public Vector2 position = new Vector2();
    public int index, indexX, indexY;

    public float cost;

    public Array<Connection<NavCell>> connections;

    public NavCell(float x, float y, int index, int indexX, int indexY, float cost) {
        this.x = x;
        this.y = y;
        this.position = new Vector2(x, y);
        this.index = index;
        this.indexX = indexX;
        this.indexY = indexY;
        this.cost = cost;

        connections = new Array<>();
    }

    public void addConnection(NavCell navCell) {
        connections.add(new NavConnection<>(this, navCell, (cost + navCell.cost)/2f));
        navCell.connections.add(new NavConnection<>(navCell, this, (cost + navCell.cost)/2f));
    }
}
