package controllers;

import controllers.enemies.EnemyController;
import controllers.manangers.BodyManager;
import models.Model;
import utils.Utils;
import views.SingleView;
import views.View;

/**
 * Created by apple on 12/7/16.
 */
public class BulletController extends Controller implements Body {

    public static final int WIDTH = 10;
    public static final int HEIGHT = 30;

    public BulletController(Model model, View view) {
        super(model, view);
        BodyManager.instance.register(this);
    }

    public void run() {
        this.model.move(0, -5);
    }

    @Override
    public void onContact(Body other) {
        if(other instanceof EnemyController) {
            System.out.println("Say Oh yeahhhhhhhhhhhhh");
            Utils.playSound("resources/enemyBang.wav", false);
            this.model.setAlive(false);
            ((EnemyController) other).destroy();
        }
    }

    public static BulletController create(int x, int y) {
        Model bullet = new Model(x, y, WIDTH, HEIGHT);
        SingleView singleView = new SingleView(Utils.loadImage("resources/bullet.png"));
        return new BulletController(bullet, singleView);
    }
}
