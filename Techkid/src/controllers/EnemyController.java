package controllers;

import models.Model;
import utills.Utills;
import views.View;

import java.awt.*;
import java.util.Vector;

/**
 * Created by MeoMunm on 12/12/2016.
 */
public class EnemyController extends Controller {
    protected int timeCount = 500;
    public static final int SPEED = 2;
    public Vector<EnemyBulletController> enemyBulletControllers;

    public EnemyController(Model model, View view) {

        super(model, view);
        enemyBulletControllers = new Vector<>();
    }

    public void run(){
        timeCount++;
        this.model.move(SPEED, SPEED);
        if (timeCount > 30){
            shot();
            timeCount = 0;
        }
        for (EnemyBulletController enemyBulletController: enemyBulletControllers){
            enemyBulletController.run();
        }
    }

    public void shot(){
        EnemyBulletController enemyBulletController = EnemyBulletController.create(
                this.getModel().getMidX() - EnemyBulletController.WIDTH/2,
                this.getModel().bottom()
        );
        enemyBulletControllers.add(enemyBulletController);

    }

    public void draw(Graphics g){
        super.draw(g);
        for (EnemyBulletController enemyBulletController: enemyBulletControllers){
            enemyBulletController.draw(g);
        }

    }

    public static EnemyController create(int x, int y) {
        EnemyController enemyController = new EnemyController(
                new Model(x, y, 35, 30),
                new View(Utills.loadImage("resources/plane1.png"))
        );
        return enemyController;
    }
}
