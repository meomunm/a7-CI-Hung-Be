package controllers.enemies;

import controllers.Body;
import controllers.BulletController;
import controllers.Controller;
import controllers.ExplosionController;
import controllers.manangers.BodyManager;
import controllers.manangers.ControllerManager;
import models.Model;
import utils.Utils;
import views.Animation;
import views.SingleView;
import views.View;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Vector;

/**
 * Created by apple on 12/10/16.
 */

public class EnemyController extends Controller implements Body {

    private static final int WIDTH = 35;
    private static final int HEIGHT = 30;
    private int timeCounter;

//    private Vector<EnemyBulletController> enemyBulletControllers;

    private MoveBehavior moveBehavior;
    private ShootBehavior shootBehavior;

//    public void add(EnemyBulletController enemyBulletController) {
//        this.enemyBulletControllers.add(enemyBulletController);
//    }

    public EnemyController(Model model, View view, MoveBehavior moveBehavior, ShootBehavior shootBehavior) {
        super(model, view);

        timeCounter = 0;
        this.moveBehavior = moveBehavior;
        BodyManager.instance.register(this);

        this.shootBehavior = shootBehavior;
    }

    @Override
    public void run() {
        if(moveBehavior != null) {
            moveBehavior.doMove(this);
        }
        timeCounter++;
        if (timeCounter > 30) {
            shoot();
            timeCounter = 0;
        }
    }

    private void shoot() {
        if (shootBehavior != null){
            shootBehavior.doShot(this);
        }
    }

    public static EnemyController create(int x, int y, EnemyType type) {
        switch (type) {
            case BROWN:
                return new EnemyController(
                        new Model(x, y, WIDTH, HEIGHT),
                        new SingleView(Utils.loadImage("resources/plane1.png")),
                        new MoveStraightDownBehavior(),
                        new ShootStraightBehavior()
                );
            case GREEN:
                return new EnemyController(
                        new Model(x, y, WIDTH, HEIGHT),
                        new SingleView(Utils.loadImage("resources/enemy-green-3.png")),
                        new MoveZigZagBehavior(),
                        new ShootOnTargetBehavior()
                );
            case WHITE:
                Vector<BufferedImage>images = new Vector<>();
                images.add(Utils.loadImage("resources/enemy_plane_white_1.png"));
                images.add(Utils.loadImage("resources/enemy_plane_white_2.png"));
                images.add(Utils.loadImage("resources/enemy_plane_white_3.png"));



                return new EnemyController(
                        new Model(x, y, WIDTH, HEIGHT),
                        new Animation(images),
                        new MoveZigZagBehavior(),
                        new ShootOnTargetBehavior()
                );

        }
        return null;
    }

    @Override
    public void onContact(Body other) {
        if (other instanceof BulletController) {
            System.out.println("HuhuHuhuHuhuHuhuHuhuHuhuHuhuHuhuHuhuHuhu");
            this.model.setAlive(false);


        }
    }

    public void destroy(){
        ExplosionController explosionController = new ExplosionController(
                new Model(this.getModel().getX(), this.getModel().getY(), 32, 32),
                new Animation(Utils.loadSheet("resources/explosion.png", 32,32,1,6))
        );
        ControllerManager.explosion.add(explosionController);
    }
}
