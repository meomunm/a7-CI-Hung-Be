package controllers.scenes;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by PT-LS on 12/31/2016.
 */
public class MenuScene extends GameScene {

    public MenuScene(){

    }

    @Override
    public void update(Graphics g) {

    }

    @Override
    public void run() {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        this.sceneListener.replaceScene(
                new PlayGameScene(), true
        );
    }
}
