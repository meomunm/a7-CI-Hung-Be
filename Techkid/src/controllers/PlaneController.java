package controllers;



import models.PlaneModel;
import views.PlaneView;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by MeoMunm on 12/5/2016.
 */
public class PlaneController {
    public PlaneModel planeModel;
    public PlaneView planeView;


    public KeySetting keySetting;
    public PlaneController(PlaneModel planeModel, PlaneView planeView) {
        this.planeModel = planeModel;
        this.planeView = planeView;
    }

    public void keyPressed(KeyEvent e){
        if (keySetting != null){
            int keyCode = e.getKeyCode();
            if (keyCode == keySetting.keyUp){
                planeModel.PlaneMove(0,-5);
            }else  if (keyCode == keySetting.keyDown){
                planeModel.PlaneMove(0,5);
            }else  if (keyCode == keySetting.keyLeft){
                planeModel.PlaneMove(-5,0);
            }else  if (keyCode == keySetting.keyRight){
                planeModel.PlaneMove(5, 0);
            }
        }
    }

    public void draw(Graphics g){
        planeView.draw(g, planeModel);

    }

    public void run(){

    }

}
