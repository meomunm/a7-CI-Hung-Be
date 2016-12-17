package controllers;

import controllers.managers.BodyManager;
import models.Model;
import utills.Utills;
import views.View;

import java.awt.*;
import java.util.Iterator;
import java.util.Vector;

/**
 * Created by MeoMunm on 12/12/2016.
 */
public class EnemyController extends Controller implements Body{
    protected int timeCount = 500;
    public static final int SPEED = 2;
    double x = 0, y = 0, r = 200;
    public Vector<EnemyBulletController> enemyBulletControllers;

    public EnemyController(Model model, View view) {

        super(model, view);
        enemyBulletControllers = new Vector<>();
        BodyManager.instance.register(this);
    }

    public void run(){
        timeCount++;

        this.model.move(0, SPEED);

        if (timeCount > 30){
            shot();
            timeCount = 0;
        }
        for (EnemyBulletController enemyBulletController: enemyBulletControllers){
            enemyBulletController.run();
        }
        Iterator<EnemyBulletController> iterator = this.enemyBulletControllers.iterator();
        while(iterator.hasNext()){
            EnemyBulletController enemyBulletController = iterator.next();
            if (!enemyBulletController.getModel().isAlive()){
                iterator.remove();
            }
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

    @Override
    public void onContact(Body other) {
        if (other instanceof BulletController) {
            System.out.println("Hu hu");
            this.model.setAlive(false);
        }
    }
}
