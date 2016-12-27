package views;

import models.Model;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Vector;

/**
 * Created by apple on 12/24/16.
 */
public class Animation implements  View {

    public Animation(Vector<BufferedImage> images) {
        this.images = images;
    }

    private Vector<BufferedImage> images;
    private int count;
    private int imageCount;

    private boolean animationReachEnd = false;

    public boolean isAnimationReachEnd() {
        return animationReachEnd;
    }

    @Override
    public void draw(Graphics g, Model model) {

        BufferedImage image = images.get(imageCount);
        g.drawImage(
                image,
                model.getX(), model.getY(),
                model.getWidth(), model.getHeight(),
                null);

        count++;
        if (count > 2) {
            count = 0;
            imageCount++;
            if (imageCount > images.size()-1) {
                animationReachEnd = true;
                imageCount = 0;
            }
        }
    }
}
