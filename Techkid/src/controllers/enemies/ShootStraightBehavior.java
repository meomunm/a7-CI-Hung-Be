package controllers.enemies;

import controllers.manangers.ControllerManager;

/**
 * Created by apple on 12/21/16.
 */
public class ShootStraightBehavior implements ShootBehavior {

    @Override
    public void doShot(EnemyController enemyController) {
        int x = enemyController.getModel().getMidX() - 5;
        int y = enemyController.getModel().getY() + 30;
        EnemyBulletController enemyBulletController = EnemyBulletController.create(x,y);
        ControllerManager.enemyBullet.add(enemyBulletController);
    }
}
