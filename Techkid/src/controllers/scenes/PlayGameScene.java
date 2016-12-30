package controllers.scenes;

import controllers.BaseController;
import controllers.GameSetting;
import controllers.PlaneController;
import controllers.manangers.BodyManager;
import controllers.manangers.BombControllerManager;
import controllers.manangers.ControllerManager;
import controllers.manangers.EnemyControllerManager;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Vector;

import static utils.Utils.loadImage;

/**
 * Created by PT-LS on 12/30/2016.
 */
public class PlayGameScene extends GameScene {
    Image background;
    Font fontHP = new Font("Arial", Font.BOLD, 20);

    Vector<BaseController> controllers;

    public PlayGameScene(){
        controllers = new Vector<>();
        controllers.add(ControllerManager.explosion);
        controllers.add(new EnemyControllerManager());
        controllers.add(PlaneController.instance);
        controllers.add(BodyManager.instance);
        controllers.add(ControllerManager.enemyBullet);
        controllers.add(new BombControllerManager());

        background = loadImage("resources/background.png");
    }

    @Override
    public void update(Graphics g) {
        g.drawImage(background, 0, 0, GameSetting.instance.getWidth(), GameSetting.instance.getHeight(), null);
        g.setFont(fontHP);
        String healthPlane = "HP: "+"\t"+ PlaneController.getHP();
        g.drawString( healthPlane,30,70);
        for (BaseController baseController : this.controllers) {
            baseController.draw(g);
        }
    }

    @Override
    public void run() {
        for(BaseController baseController: controllers) {
            baseController.run();
        }
        if (PlaneController.getHP() < 0){
            this.sceneListener.replaceScene(new GameOverScene(), true);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        PlaneController.instance.keyPressed(e);
    }
}
