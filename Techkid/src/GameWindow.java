import controllers.*;
import controllers.bomb.BombController;
import controllers.manangers.BodyManager;
import controllers.manangers.BombControllerManager;
import controllers.manangers.ControllerManager;
import controllers.manangers.EnemyControllerManager;

import java.awt.*;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.util.Vector;

import static utils.Utils.loadImage;

// Data abstraction

/**
 * Created by apple on 11/30/16.
 */
public class GameWindow extends Frame implements Runnable {
    Image background;

    BufferedImage backBuffer;
    GameSetting gameSetting;
    Font fontHP = new Font("Arial", Font.BOLD, 20);

    Vector<BaseController> controllers;

    public GameWindow() {

        configSettings();

        controllers = new Vector<>();
        controllers.add(ControllerManager.explosion);
        controllers.add(new EnemyControllerManager());
        controllers.add(PlaneController.instance);
        controllers.add(BodyManager.instance);
        controllers.add(ControllerManager.enemyBullet);
        controllers.add(new BombControllerManager());


        setVisible(true);
        setSize(gameSetting.getWidth(), gameSetting.getHeight());

        backBuffer = new BufferedImage(gameSetting.getWidth(), gameSetting.getHeight(), BufferedImage.TYPE_INT_ARGB);

        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println("windowOpened");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("windowClosing");
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("windowClosed");

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
        background = loadImage("resources/background.png");

        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println( " keyTyped");
            }

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("keyPressed");
                PlaneController.instance.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println("keyReleased");
            }
        });
    }

    private void configSettings() {
        PlaneController.instance.keySetting = new KeySetting(
                KeyEvent.VK_UP,
                KeyEvent.VK_DOWN,
                KeyEvent.VK_LEFT,
                KeyEvent.VK_RIGHT,
                KeyEvent.VK_SPACE
        );
        gameSetting = GameSetting.instance;
    }


    //Utilities


    @Override
    public void update(Graphics g) {
        // Prepare backbuffer
        Graphics backBufferGraphics = backBuffer.getGraphics();
        backBufferGraphics.drawImage(background, 0, 0, gameSetting.getWidth(), gameSetting.getHeight(), null);

        for (BaseController baseController : this.controllers) {
            baseController.draw(backBufferGraphics);
        }
        backBufferGraphics.setFont(fontHP);
        String healthPlane = "HP: "+"\t"+ PlaneController.getHP();
        backBufferGraphics.drawString( healthPlane,30,70);

        // Update window
        g.drawImage(backBuffer, 0, 0, gameSetting.getWidth(), gameSetting.getHeight(), null);
    }

    @Override
    public void run() {
        while (true) {
            try {
                this.repaint();
                Thread.sleep(17);

                for(BaseController baseController: controllers) {
                    baseController.run();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
