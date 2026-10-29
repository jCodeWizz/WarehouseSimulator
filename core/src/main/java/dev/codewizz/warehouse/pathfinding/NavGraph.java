package dev.codewizz.warehouse.pathfinding;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ai.pfa.Connection;
import com.badlogic.gdx.ai.pfa.indexed.IndexedGraph;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class NavGraph implements IndexedGraph<NavCell> {

    public static final int SIZE = 64;

    private final NavCell[][] grid;

    public NavGraph() {

        final int width = Gdx.graphics.getWidth() / SIZE;
        final int height = Gdx.graphics.getHeight() / SIZE;

        grid = new NavCell[width][height];

        for (int i = 0; i < width * height; i++) {

            int indexX = i % width;
            int indexY = i / width;

            grid[indexX][indexY] = new NavCell(indexX * SIZE, indexY * SIZE, i, indexX, indexY, 1f);

            if (indexX > 0) { grid[indexX][indexY].addConnection(grid[indexX-1][indexY]); }
            if (indexY > 0) { grid[indexX][indexY].addConnection(grid[indexX][indexY-1]); }
        }
    }

    @Override
    public int getIndex(NavCell node) {
        return node.index;
    }

    @Override
    public int getNodeCount() {
        return grid.length * grid[0].length;
    }

    @Override
    public Array<Connection<NavCell>> getConnections(NavCell from) {
        return from.connections;
    }

    public NavCell getCell(int indexX, int indexY) {
        return grid[indexX][indexY];
    }

    public NavCell getCell(Vector2 pos) {
        int indexX = MathUtils.floor(pos.x / SIZE);
        int indexY = MathUtils.floor(pos.y / SIZE);

        indexX = MathUtils.clamp(indexX, 0, grid.length - 1);
        indexY = MathUtils.clamp(indexY, 0, grid[0].length - 1);

        return getCell(indexX, indexY);
    }
}
