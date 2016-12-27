package controllers.enemies;

/**
 * Created by apple on 12/21/16.
 */
public class ShootZiczacBehavior implements ShootBehavior {
    @Override
    public void doShot(EnemyController enemyController) {
        int x = enemyController.getModel().getMidX() - 5;
        int y = enemyController.getModel().getY() + 30;
    }
}
