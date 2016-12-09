package controllers;

import models.Model;
import utills.Utills;
import views.View;

/**
 * Created by MeoMunm on 12/9/2016.
 */
public class EnmBullletController extends Controller {
    public EnmBullletController(Model model, View view) {
        super(model, view);
    }

    public void run() {
        this.model.move(0, 5);
    }

    public static EnmBullletController createEnmBulletController(int x, int y) {
        EnmBullletController enmBullletController = new EnmBullletController(
                new Model(x, y, 32, 32),
                new View(Utills.loadImage("resources/enemy_bullet.png"))
        );
        return enmBullletController;
    }
}
