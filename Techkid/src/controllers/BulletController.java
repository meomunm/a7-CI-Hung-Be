package controllers;

import models.Model;
import utills.Utills;
import views.View;


/**
 * Created by MeoMunm on 12/6/2016.
 */
public class BulletController extends Controller {
    public BulletController(Model model, View view) {
        super(model, view);
    }

    public void run() {
        this.model.move(0, -5);
    }

    public static BulletController createBullet(int x, int y){
        BulletController bulletController = new BulletController(
                new Model(x, y, 13, 33),
                new View(Utills.loadImage("resources/bullet.png"))
        );
        return bulletController;
    }
}
