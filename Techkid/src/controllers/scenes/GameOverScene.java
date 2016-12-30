package controllers.scenes;

import utils.Utils;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by PT-LS on 12/31/2016.
 */
public class GameOverScene extends GameScene {
    Image backgroundGameOver = Utils.loadImage("resources/gameOver.png");
    @Override
    public void update(Graphics g) {
        g.drawImage(backgroundGameOver,0,0,500,600,null );
    }

    @Override
    public void run() {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }
}
