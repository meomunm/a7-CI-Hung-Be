package utills;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by MeoMunm on 12/9/2016.
 */
public class Utills {
    Image image;
    public static Image loadImage(String path){
        try {
            Image image = ImageIO.read(new File(path));
            return image;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
