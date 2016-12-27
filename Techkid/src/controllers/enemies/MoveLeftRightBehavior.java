package controllers.enemies;

/**
 * Created by apple on 12/21/16.
 */
public class MoveLeftRightBehavior implements MoveBehavior {

    @Override
    public void doMove(EnemyController enemyController) {
            enemyController.getModel().move(2,2);
    }
}
