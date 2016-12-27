package controllers.manangers;

import controllers.Controller;
import controllers.bomb.BombController;
import controllers.enemies.EnemyController;
import controllers.enemies.EnemyType;

/**
 * Created by apple on 12/10/16.
 */
public class EnemyControllerManager extends ControllerManager {

    int counter;
    @Override
    public void run() {
        super.run();
        counter++;
        if (counter == 100) {
            spawn();
            counter = 0;
        }if (!BombController.isAliveBomb){
            for (Controller controller : controllers) {
                controller.getModel().setAlive(false);
                if(controller instanceof EnemyController){
                    ((EnemyController) controller).destroy();
                }
                BombController.isAliveBomb = true;
            }
        }

    }

    private int enemyCount;

    private void spawn() {
        //1: Create enemy
        enemyCount++;
        EnemyController enemyController = null;
        if(enemyCount%2 == 0) {
            enemyController = EnemyController.create(220, 0, EnemyType.WHITE);
        }else {
            enemyController = EnemyController.create(220, 0, EnemyType.BROWN);
        }
            //2: Add new enemy to vector
        this.controllers.add(enemyController);
    }
}
