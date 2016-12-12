package controllers;

import models.Model;
import utills.Utills;
import views.View;

import java.util.Vector;

/**
 * Created by MeoMunm on 12/12/2016.
 */
public class EnemyController1 extends EnemyController {
    private static final int SPEED = 4;
    public Vector<EnemyController1> enemyControllers1;

    public EnemyController1(Model model, View view) {
        super(model, view);
        enemyControllers1 = new Vector<>();
    }

    public void run(){
        timeCount++;
        model.move(0, SPEED);
        if (timeCount % 30 == 0 | timeCount ==0){
            this.shot();
        }
        if(timeCount>500) {
            this.model.move(0, SPEED);
            timeCount = 0;
        }
        for (EnemyBulletController enemyBulletController:  enemyBulletControllers){
            enemyBulletController.run();
        }
    }


    public static EnemyController1 create (int x, int y) {
        EnemyController1 enemyController1 = new EnemyController1(
                new Model(x, y, 35, 30),
                new View(Utills.loadImage("resources/enemy_plane_yellow.png"))
        );
        return enemyController1;
    }
}
