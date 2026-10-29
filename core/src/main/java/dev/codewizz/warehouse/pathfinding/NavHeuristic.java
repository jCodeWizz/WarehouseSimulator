package dev.codewizz.warehouse.pathfinding;

import com.badlogic.gdx.ai.pfa.Heuristic;

public class NavHeuristic implements Heuristic<NavCell> {

    @Override
    public float estimate(NavCell node, NavCell endNode) {
        return Math.abs(node.indexX - endNode.indexX)
            + Math.abs(node.indexY - endNode.indexY);
    }
}
