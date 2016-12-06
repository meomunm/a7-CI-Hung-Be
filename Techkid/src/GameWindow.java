import controllers.BulletController;
import controllers.KeySetting;
import controllers.PlaneController;
import models.BulletModel;
import models.PlaneModel;
import views.BulletView;
import views.PlaneView;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.security.Key;
import java.util.Vector;

/**
 * Created by MeoMunm on 12/4/2016.
 */
public class GameWindow extends JFrame implements Runnable {
    Image background;

    PlaneController planeController;
    PlaneModel planeModel;
    PlaneView planeView;
    BulletModel bulletModel;
    BulletView bulletView;
    BulletController bulletController;

    Vector<BulletController> bulletControllers;

    BufferedImage backBuffer;

    public GameWindow() {
        bulletControllers = new Vector<>();

        planeModel = new PlaneModel(350, 500);
        planeView = new PlaneView(loadImage("resources/plane3.png"));
        planeController = new PlaneController(planeModel, planeView);
        bulletView = new BulletView(loadImage("resources/bullet.png"));


        planeController.keySetting = new KeySetting(
                KeyEvent.VK_UP,
                KeyEvent.VK_DOWN,
                KeyEvent.VK_LEFT,
                KeyEvent.VK_RIGHT);

        setVisible(true);
        setSize(800, 600);

        backBuffer = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);

        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent windowEvent) {
                System.out.println("WindowOpened");
            }

            @Override
            public void windowClosing(WindowEvent windowEvent) {
                System.out.println("WindowClosing");
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent windowEvent) {
                System.out.println("WindowClosed");
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

        background = loadImage("resources/background.png");

        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println("Key Typed");
            }

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("Key Pressed");
                planeController.keyPressed(e);

                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    int x = planeModel.getX() + 35 - 6;
                    int y = planeModel.getY() - 40;
                    bulletModel = new BulletModel(x, y);
                    bulletController = new BulletController(bulletModel, bulletView);
                    bulletControllers.add(bulletController);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println("Key Released");
            }
        });
    }

    private Image loadImage(String path) {
        try {
            Image image = ImageIO.read(new File(path));
            return image;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void paint(Graphics g) {
        Graphics backBufferGraphics = backBuffer.getGraphics();
        backBufferGraphics.drawImage(background, 0, 0, 800, 600, null);
        planeController.draw(backBufferGraphics);
        for (BulletController bulletController : bulletControllers) {
            bulletController.draw(backBufferGraphics);
        }

        g.drawImage(backBuffer,
                0, 0, 800, 600, null);
    }

    public void run() {
        while (true) {
            try {
                this.repaint();
                Thread.sleep(17);
                for (BulletController bulletController : bulletControllers) {
                    bulletController.bulletModel.move(0, -5);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
