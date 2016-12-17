package controllers.managers;

import controllers.EnemyController;

/**
 * Created by MeoMunm on 12/12/2016.
 */
public class EnemyControllerManager extends ControllerManager {
    private int timeCount = 500;

    public void run(){
        timeCount++;
        super.run();
        if (timeCount > 300){
            spawn();
            timeCount = 0;
        }
    }

    private void spawn() {
        EnemyController enemyController = EnemyController.create(265,35);
        this.add(enemyController);
    }

}
