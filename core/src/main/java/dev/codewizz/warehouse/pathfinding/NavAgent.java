package dev.codewizz.warehouse.pathfinding;

import com.badlogic.gdx.ai.pfa.DefaultGraphPath;
import com.badlogic.gdx.ai.pfa.GraphPath;
import com.badlogic.gdx.ai.pfa.indexed.IndexedAStarPathFinder;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Queue;
import dev.codewizz.warehouse.Robot;

public class NavAgent {

    private final static NavHeuristic heuristic = new NavHeuristic();
    public final static NavGraph graph = new NavGraph();
    private final static IndexedAStarPathFinder<NavCell> pathFinder = new IndexedAStarPathFinder<>(graph);

    private final Queue<NavCell> path;
    private NavCell previous;

    private final Robot robot;

    public NavAgent(Robot robot) {
        path = new Queue<>();
        this.robot = robot;
    }

    public void update(float dt) {
        setSpeedToNextGoal();

        if (path.size > 1) {
            NavCell target = path.first();
            if (Vector2.dst2(robot.getPosition().x, robot.getPosition().y, target.x, target.y) < 0.0004f) {
                reach();
            }
        }
    }

    public boolean navigate(NavCell goal) {
        path.clear();

        GraphPath<NavCell> path = new DefaultGraphPath<>();

        NavCell start = graph.getCell(robot.getPosition());

        boolean success = pathFinder.searchNodePath(graph.getCell(robot.getPosition()), goal, heuristic, path);

        if (success) {
            for (NavCell navCell : path) {
                this.path.addLast(navCell);
            }

            this.path.removeFirst();

            setSpeedToNextGoal();
        }

        return success;
    }

    private void reach() {
        NavCell next = path.first();
        this.robot.getPosition().set(next.x, next.y);

        this.previous = next;
        path.removeFirst();

        if (path.size == 1) {
            finishPath();
        } else {
            setSpeedToNextGoal();
        }
    }

    private void finishPath() {
        robot.getVelocity().setZero();
        path.clear();
    }

    private void setSpeedToNextGoal() {
        if (path.isEmpty()) {
            finishPath();
            return;
        }

        NavCell next = path.first();
        float angle = MathUtils.atan2(next.y - robot.getPosition().y, next.x - robot.getPosition().x);
        robot.getVelocity().set(MathUtils.cos(angle) * 2f, MathUtils.sin(angle) * 2f);
    }

    public Queue<NavCell> getPath() {
        return path;
    }
}
