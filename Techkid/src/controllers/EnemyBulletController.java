package controllers;

import models.Model;
import utills.Utills;
import views.View;

/**
 * Created by MeoMunm on 12/12/2016.
 */
public class EnemyBulletController extends Controller {

    public static final int SPEED = 7;
    public static final int WIDTH = 13;
    public static final int HEIGHT = 33;


    public EnemyBulletController(Model model, View view) {
        super(model, view);
    }

    public void run() {
        this.model.move(0, SPEED);
    }

    public static EnemyBulletController create(int x, int y) {
        EnemyBulletController enemyBulletController = new EnemyBulletController(
                new Model(x, y, WIDTH, HEIGHT),
                new View(Utills.loadImage("resources/enemy_bullet.png"))
        );
        return enemyBulletController;
    }
}
