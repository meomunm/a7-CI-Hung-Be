package controllers;

import com.sun.javafx.sg.prism.NGShape;
import controllers.managers.BodyManager;
import models.Model;
import utills.Utills;
import views.View;


import java.awt.*;
import java.awt.event.KeyEvent;


/**
 * Created by MeoMunm on 12/12/2016.
 */
public class PlaneController extends Controller implements Body {
    public KeySetting keySetting;

    public int health = 3;

    private static final int SPEED = 8;

    public PlaneController(Model model, View view) {
        super(model, view);
        BodyManager.instance.register(this);
    }

    public void keyPressed(KeyEvent e) {
        if (keySetting != null) {
            int keyCode = e.getKeyCode();
            if (keyCode == keySetting.keyUp) {
                this.model.move(0, -SPEED);
            } else if (keyCode == keySetting.keyDown) {
                this.model.move(0, SPEED);
            } else if (keyCode == keySetting.keyLeft) {
                this.model.move(-SPEED, 0);
            } else if (keyCode == keySetting.keyRight) {
                this.model.move(SPEED, 0);
            }
        }
    }

    public static PlaneController create(int x, int y) {
        PlaneController planeController = new PlaneController(
                new Model(x, y, 70, 50),
                new View(Utills.loadImage("resources/plane3.png"))
        );
        return planeController;
    }

    @Override
    public void onContact(Body other) {
        if (other instanceof EnemyBulletController) {
            System.out.println("Da bi ban");
            health--;
            if (health == 0){
                this.model.setAlive(false);
            }
        }
    }
}
