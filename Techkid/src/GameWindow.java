import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;


/**
 * Created by MeoMunm on 11/30/2016.
 */
public class GameWindow extends Frame {
    Image background;//khai bao cac vat the
    Image plane1;
    Image plane2;
    Image enemy_plane_white_1;
    Image enemy_plane_white_2;
    Image enemy_plane_white_3;
    int planeX = 500;
    int planeY = 500;
    int plane2_X = 300;
    int plane2_Y = 500;

    public GameWindow() {
        setVisible(true);
        setSize(800, 600);// tao 1 windows
        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent windowEvent) {
                System.out.println("windowOpenned");
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
        try {
            background = ImageIO.read(new File("resources/background.png"));//them duong dan file png, vi dang o thu muc techkid nen khong can them techkid/resources/xxx.png
            plane1 = ImageIO.read(new File("resources/plane3.png"));
            plane2 = ImageIO.read(new File("resources/plane2.png"));
            enemy_plane_white_1 = ImageIO.read(new File("resources/enemy_plane_white_1.png"));
            enemy_plane_white_2 = ImageIO.read(new File("resources/enemy_plane_white_1.png"));
            enemy_plane_white_3 = ImageIO.read(new File("resources/enemy_plane_white_1.png"));
        } catch (IOException e) {
            System.out.println("Load Image Failed");
            e.printStackTrace();
        }
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {
                System.out.println("keyTyped");
                switch (keyEvent.getKeyChar()){

                    case 'w':
                        plane2_Y -=5;
                        repaint();
                        break;

                    case 's':
                        plane2_Y +=5;
                        repaint();
                        break;

                    case 'a':
                        plane2_X -=5;
                        repaint();
                        break;

                    case 'd':
                        plane2_X +=5;
                        repaint();
                        break;
                }
            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {
                System.out.println("keyPressed");
                switch (keyEvent.getKeyCode()) {

                    case KeyEvent.VK_UP:
                        planeY -= 5;
                        repaint();
                        break;

                    case KeyEvent.VK_DOWN:
                        planeY += 5;
                        repaint();
                        break;

                    case KeyEvent.VK_LEFT:
                        planeX -= 5;
                        repaint();
                        break;

                    case KeyEvent.VK_RIGHT:
                        planeX += 5;
                        repaint();
                        break;


                }
            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {
                System.out.println("keyReleased");
            }
        });
        repaint();// pain chi thay doi khi co su thay doi?, repain = ve lai
    }

    @Override
    public void paint(Graphics graphics) {
        graphics.drawImage(background, 0, 0, 800, 600, null);
        graphics.drawImage(plane1, planeX, planeY, 70, 51, null); //vi tri x, y, kich co may bay, null, X -, y |
        graphics.drawImage(plane2, plane2_X, plane2_Y, 70, 56, null);
        graphics.drawImage(enemy_plane_white_1, 100,100,32,32,null);
        graphics.drawImage(enemy_plane_white_2, 400, 100,32,32,null);
        graphics.drawImage(enemy_plane_white_3, 700,100,32,32,null);
    }
}
