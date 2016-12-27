package views;

import com.sun.prism.*;
import models.Model;

import java.awt.*;
import java.awt.Graphics;
import java.awt.Image;

/**
 * Created by apple on 12/7/16.
 */
public interface View {

    void draw(Graphics g, Model model);

//    public Image image;
//
//    public View(Image image) {
//        this.image = image;
//    }
//
//    public void draw(Graphics g, Model model) {
//        g.drawImage(image, model.getX(), model.getY(), model.getWidth(), model.getHeight(), null);
//    }
}
