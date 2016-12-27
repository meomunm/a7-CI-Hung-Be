package controllers.enemies;

import controllers.GameVector;
import controllers.PlaneController;
import controllers.manangers.ControllerManager;

import java.util.DoubleSummaryStatistics;

/**
 * Created by apple on 12/24/16.
 */
public class ShootOnTargetBehavior implements ShootBehavior {

    private final int SPEED = 4;

    @Override
    public void doShot(EnemyController enemyController) {
        int x = enemyController.getModel().getMidX();
        int y = enemyController.getModel().getBottom();

        PlaneController planeController = PlaneController.instance;

        GameVector dVector = planeController.getModel().subtract(enemyController.getModel());
        double length = dVector.getLength();

        double steps = length / (double)SPEED;
        GameVector bulletMoveVector = new GameVector((int)(dVector.dx / steps), (int)(dVector.dy / steps));

        EnemyBulletController enemyBulletController =
                EnemyBulletController.create(x, y, bulletMoveVector);

        ControllerManager.enemyBullet.add(enemyBulletController);
    }
}
