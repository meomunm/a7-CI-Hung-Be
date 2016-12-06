package views;

import models.BulletModel;

import java.awt.*;

/**
 * Created by MeoMunm on 12/5/2016.
 */
public class BulletView {
    Image image;

    public BulletView(Image image) {
        this.image = image;
    }

    public void draw(Graphics  g, BulletModel bulletModel){
        g.drawImage(image, bulletModel.getX(), bulletModel.getY(),13,33,null);
    }
}
