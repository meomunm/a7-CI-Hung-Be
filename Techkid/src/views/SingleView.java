package views;

import models.Model;

import java.awt.*;

/**
 * Created by apple on 12/24/16.
 */
public class SingleView implements View {
    public Image image;

    public SingleView(Image image) {
        this.image = image;
    }

    public void draw(Graphics g, Model model) {
        g.drawImage(image, model.getX(), model.getY(), model.getWidth(), model.getHeight(), null);
    }
}
