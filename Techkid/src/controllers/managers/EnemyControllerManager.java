package controllers.managers;

import controllers.EnemyController;
import controllers.EnemyController1;

import java.util.Vector;

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

        EnemyController enemyController = EnemyController.create(0,0);
        this.add(enemyController);

        EnemyController1 enemyController1 = EnemyController1.create(335,0);
       this.add(enemyController1);

    }

}
