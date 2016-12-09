import controllers.*;
import utills.Utills;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.util.Random;
import java.util.Vector;

/**
 * Created by MeoMunm on 12/4/2016.
 */
public class GameWindow extends Frame implements Runnable {
    Image background;

    PlaneController planeController;
    EnemyController enemyController;

    Vector<BulletController> bulletControllers;
    Vector<EnemyController> enemyControllers;
    Vector<EnmBullletController> enmBullletControllers;

    BufferedImage backBuffer;

    public GameWindow() {
        bulletControllers = new Vector<>();
        enemyControllers = new Vector<>();
        enmBullletControllers = new Vector<>();

        planeController = PlaneController.createPlane(400, 500);
        enemyController = EnemyController.createEnemy(400, 100);

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

        background = Utills.loadImage("resources/background.png");

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
                    int x = planeController.getModel().getX() + 35 - 6;
                    int y = planeController.getModel().getY() - 40;
                    BulletController bulletController = BulletController.createBullet(x, y);
                    bulletControllers.add(bulletController);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println("Key Released");
            }
        });
    }

    @Override
    public void update(Graphics g) {
        Graphics backBufferGraphics = backBuffer.getGraphics();
        backBufferGraphics.drawImage(background, 0, 0, 800, 600, null);
        planeController.draw(backBufferGraphics);
        enemyController.draw(backBufferGraphics);
        for (BulletController bulletController : bulletControllers) {
            bulletController.draw(backBufferGraphics);
        }
        for (EnmBullletController enmBullletController : enmBullletControllers) {
            enmBullletController.draw(backBufferGraphics);
        }

        g.drawImage(backBuffer,
                0, 0, 800, 600, null);
    }

    public void run() {
        int em_khong_nghi_dc_cach_nao_hay_hon = 250;
        boolean dontDelete = true;
        while (true) {
            try {
                this.repaint();
                Thread.sleep(17);
                for (BulletController bulletController : bulletControllers) {
                    bulletController.run();
                }

                for (int i = 0; i < bulletControllers.size(); i++) {
                    if (bulletControllers.get(i).getModel().getY() < 0)
                        bulletControllers.remove(bulletControllers.get(i));
                }

                if (enemyController.getModel().getY() >= 600 | dontDelete) {
                    dontDelete = false;
                    Random rd = new Random();
                    int range = 769;
                    int xrd = rd.nextInt(range);
                    enemyController = EnemyController.createEnemy(xrd, 0);
                    enemyControllers.add(enemyController);
                    int x = enemyController.getModel().getX();
                    int y = enemyController.getModel().getY() + 20;
                    EnmBullletController enmBullletController = EnmBullletController.createEnmBulletController(x, y);
                    enmBullletControllers.add(enmBullletController);
                }
                if (enemyController.getModel().getY() == em_khong_nghi_dc_cach_nao_hay_hon){
                    int x = enemyController.getModel().getX();
                    int y = enemyController.getModel().getY() + 20;
                    EnmBullletController enmBullletController = EnmBullletController.createEnmBulletController(x, y);
                    enmBullletControllers.add(enmBullletController);
                }

                for (int i = 0; i < enemyControllers.size(); i++) {
                    if (enemyControllers.get(i).getModel().getY() == 600)
                        enemyControllers.remove(enemyControllers.get(i));
                }

                for (int i = 0; i < enmBullletControllers.size(); i++) {
                    if (enmBullletControllers.get(i).getModel().getY() == 600)
                        enmBullletControllers.remove(enmBullletControllers.get(i));
                }

                for (EnmBullletController enmBullletController: enmBullletControllers){
                    enmBullletController.run();
                }

                enemyController.run();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
