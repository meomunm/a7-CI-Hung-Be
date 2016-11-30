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
    Image background;
    Image plane3;
    int planeX = 300;
    int planeY = 300;

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
            background = ImageIO.read(new File("resources/background.png"));
            plane3 = ImageIO.read(new File("resources/plane3.png"));
        } catch (IOException e) {
            System.out.println("Load Image Failed");
            e.printStackTrace();
        }
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {
                System.out.println("keyTyped");
            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {
                System.out.println("keyPressed");
                switch (keyEvent.getKeyCode()) {

                    case KeyEvent.VK_UP:
                        planeY -= 3;
                        repaint();
                        break;

                    case KeyEvent.VK_DOWN:
                        planeY += 3;
                        repaint();
                        break;

                    case KeyEvent.VK_LEFT:
                        planeX -= 3;
                        repaint();
                        break;

                    case KeyEvent.VK_RIGHT:
                        planeX += 3;
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
        graphics.drawImage(plane3, planeX, planeY, 70, 51, null); //vi tri x, y, kich co may bay, null, X -, y |
    }
}
