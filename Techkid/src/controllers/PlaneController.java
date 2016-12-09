package controllers;



import models.Model;
import utills.Utills;
import views.View;

import java.awt.event.KeyEvent;

/**
 * Created by MeoMunm on 12/5/2016.
 */
public class PlaneController extends Controller {
    private static final int SPEED = 10;

    public KeySetting keySetting;

    public PlaneController(Model model, View view) {
        super(model, view);
    }

    public void keyPressed(KeyEvent e){
        if (keySetting != null){
            int keyCode = e.getKeyCode();
            if (keyCode == keySetting.keyUp){
                model.move(0,-SPEED);
            }else  if (keyCode == keySetting.keyDown){
                model.move(0,SPEED);
            }else  if (keyCode == keySetting.keyLeft){
                model.move(-SPEED,0);
            }else  if (keyCode == keySetting.keyRight){
                model.move(SPEED, 0);
            }
        }
    }

    public static PlaneController createPlane(int x, int y){
        PlaneController planeController = new PlaneController(
                new Model(x, y, 70, 50),
                new View(Utills.loadImage("resources/plane3.png"))
        );
        return planeController;
    }
}
