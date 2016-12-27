package utils;

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

/**
 * Created by apple on 12/7/16.
 */
public class Utils {

    public static BufferedImage loadImage(String path) {
        try {
            BufferedImage image = ImageIO.read(new File(path));
            return image;
        } catch (IOException e) {
            e.printStackTrace();
            return  null;
        }
    }

    public static void playSound(String audioUrl, boolean repeat) {

        File soundFile = new File(audioUrl);
        try {
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
            if(repeat) {
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }
            else {
                clip.loop(0);
            }
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public static Vector<BufferedImage> loadSheet(String URL, int width, int height,int border, int imageCount) {
        BufferedImage image = Utils.loadImage(URL);
        Vector<BufferedImage> bufferedImages = new Vector<>();
          for (int index = 0; index < imageCount; index++){
              int x = index * width + border * (index + 1);
              int y = border;
              BufferedImage subImage =  image.getSubimage(x, y, width, height);
              bufferedImages.add(subImage);
          }
          return bufferedImages;
    }
}
