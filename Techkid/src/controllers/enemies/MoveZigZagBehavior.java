package controllers.enemies;

import controllers.GameVector;

/**
 * Created by apple on 12/24/16.
 */
public class MoveZigZagBehavior implements MoveBehavior {

    private static final int DIRECTION_DURATION = 100;
    private GameVector moveVector;
    private int counter;

    public MoveZigZagBehavior() {
        moveVector = new GameVector(2, 2);
    }

    @Override
    public void doMove(EnemyController enemyController) {
        counter++;
        if (counter >= DIRECTION_DURATION) {
            counter = 0;
            moveVector.dx = -moveVector.dx;
        }
        enemyController.move(this.moveVector);
    }
}
