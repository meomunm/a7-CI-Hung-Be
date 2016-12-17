package controllers;

import controllers.managers.BodyManager;
import models.Model;
import utills.Utills;
import views.View;

/**
 * Created by MeoMunm on 12/12/2016.
 */
public class BulletController extends Controller implements Body {
    public static final int SPEED = 5;

    public BulletController(Model model, View view) {
        super(model, view);
        BodyManager.instance.register(this);
    }

    public void run(){
        this.model.move(0, -SPEED);
    }

    public static BulletController create(int x, int y){
        BulletController bulletController = new BulletController(
                new Model(x, y, 13, 33),
                new View(Utills.loadImage("resources/bullet.png"))
        );
                return bulletController;
    }

    @Override
    public void onContact(Body other) {
        if (other instanceof EnemyController) {
            System.out.println("Ohyeah");
            this.model.setAlive(false);
        }
    }
}
