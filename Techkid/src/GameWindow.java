import controllers.BulletController;
import controllers.EnemyController;
import controllers.KeySetting;
import controllers.PlaneController;
import controllers.managers.EnemyControllerManager;
import utills.Utills;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.util.Vector;

/**
 * Created by MeoMunm on 12/9/2016.
 */
public class GameWindow extends Frame implements Runnable {
    Image backGround;
    PlaneController planeController;
    BulletController bulletController;
    EnemyControllerManager enemyControllerManager;

    Vector<BulletController> bulletControllers;


    BufferedImage backbuffer;

    public GameWindow() {
        System.out.println();
        bulletControllers = new Vector<>();
        enemyControllerManager = new EnemyControllerManager();

        backbuffer = new BufferedImage(600, 800, BufferedImage.TYPE_INT_ARGB);

        planeController = PlaneController.create(400, 500);

        planeController.keySetting = new KeySetting(
                KeyEvent.VK_UP,
                KeyEvent.VK_DOWN,
                KeyEvent.VK_LEFT,
                KeyEvent.VK_RIGHT
        );

        setVisible(true);
        setSize(600,800);

        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent windowEvent) {
                System.out.println("windowOpened");
            }

            @Override
            public void windowClosing(WindowEvent windowEvent) {
                System.out.println("windowClosing");
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent windowEvent) {
                System.out.println("windowClosed");
            }

            @Override
            public void windowIconified(WindowEvent windowEvent) {

            }

            @Override
            public void windowDeiconified(WindowEvent windowEvent) {

            }

            @Override
            public void windowActivated(WindowEvent windowEvent) {

            }

            @Override
            public void windowDeactivated(WindowEvent windowEvent) {

            }
        });

        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {
                System.out.println("keyTyped");
            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {

                System.out.println("keyPressed");
                planeController.keyPressed(keyEvent);

                if (keyEvent.getKeyCode() == KeyEvent.VK_SPACE) {
                    int x = planeController.getModel().getX() + planeController.getModel().getWidth()/2 - 6 ;
                    int y = planeController.getModel().getY() - 40;
                    bulletController = BulletController.create(x , y);
                    bulletControllers.add(bulletController);
                }
            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {
                System.out.println("keyReleased");
            }
        });

        backGround = Utills.loadImage("resources/background.png");


    }

    @Override
    public void update(Graphics g) {
        Graphics bufferedGraphics = backbuffer.getGraphics();
        bufferedGraphics.drawImage(backGround, 0, 0, 600, 800, null);
        planeController.draw(bufferedGraphics);
        for(BulletController bulletController: bulletControllers) {
            bulletController.draw(bufferedGraphics);
        }

        enemyControllerManager.draw(bufferedGraphics);
        g.drawImage(backbuffer, 0, 0, 600, 800, null);
    }

    public void run() {
        try {
            while (true) {
                this.repaint();
                Thread.sleep(17);
                for (BulletController bulletController: bulletControllers){
                    bulletController.run();
                }
                enemyControllerManager.run();

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
