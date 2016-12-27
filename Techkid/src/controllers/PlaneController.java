package controllers;

import controllers.enemies.EnemyBulletController;
import controllers.manangers.BodyManager;
import controllers.manangers.ControllerManager;
import models.Model;
import utils.Utils;
import views.Animation;
import views.SingleView;
import views.View;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by apple on 12/3/16.
 */
public class PlaneController extends Controller implements Body {

    private static final int SPEED = 5;
    private static int HP = 10;

    public KeySetting keySetting;

    private ControllerManager bulletManager;

    public static final PlaneController instance = createPlane(220, 530);

    private PlaneController(Model model, View view) {
        super(model, view);
        bulletManager = new ControllerManager();
        BodyManager.instance.register(this);
    }

    public static int getHP() {
        return HP;
    }

    public static void setHP(int HP) {
        PlaneController.HP = HP;
    }

    public void keyPressed(KeyEvent e) {
        if (keySetting != null) {
            int keyCode = e.getKeyCode();
            if (keyCode == keySetting.keyUp) {
                model.move(0, -SPEED);
            } else if (keyCode == keySetting.keyDown) {
                model.move(0, SPEED);
            } else if (keyCode == keySetting.keyLeft) {
                model.move(-SPEED, 0);
            } else if (keyCode == keySetting.keyRight) {
                model.move(SPEED, 0);
            } else if (keyCode == keySetting.keyShoot) {
                shoot();
            }
        }
    }

    @Override
    public void run() {
        super.run();
        bulletManager.run();
        if (this.model.isAlive() == false){
            this.model.move(0,-2);
            if (this.model.getY() < 500){
                this.model.setAlive(true);
                BodyManager.instance.register(this);
                setHP(10);
            }
        }
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        bulletManager.draw(g);
    }

    private void shoot() {
        Utils.playSound("resources/shoot.wav", false);
        BulletController bulletController = BulletController.create(this.model.getMidX() - BulletController.WIDTH / 2,
                this.model.getY() - BulletController.HEIGHT);
        bulletManager.add(bulletController);
    }

    // Design pattern
    // Factory
    private static PlaneController createPlane(int x, int y) {
        PlaneController planeController = new PlaneController(
                new Model(x, y, 70, 50),
                new SingleView(Utils.loadImage("resources/plane3.png"))
        );
        return planeController;
    }

    @Override
    public void onContact(Body other) {
        if (other instanceof EnemyBulletController) {
            System.out.println("Da trung dan");
            this.HP--;
            if (this.HP <= 0) {
                Utils.playSound("resources/planeBang.wav",false);
                destroy();
                this.model.setX(220);
                this.model.setY(900);
                this.model.setAlive(false);
            }
        }
    }

    private void destroy() {
        ExplosionController explosionController = new ExplosionController(
                new Model(this.getModel().getX(), this.getModel().getY(), 50, 50),
                new Animation(Utils.loadSheet("resources/explosion.png", 32, 32, 1, 6))
        );
        ControllerManager.explosion.add(explosionController);
    }
}
