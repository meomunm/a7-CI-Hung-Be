package controllers;

import com.sun.javafx.sg.prism.NGShape;
import models.Model;

/**
 * Created by apple on 12/24/16.
 */
public class GameSetting {
    private int width;
    private int height;

    public static final GameSetting instance = new GameSetting(500, 600);

    private GameSetting(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isInScreen(Model model) {
        return model.getY() < this.height;
    }

    public boolean isInScreen(Controller controller) {
        return controller.getModel().getY() < this.height;
    }
}
