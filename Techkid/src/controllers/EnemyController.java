package controllers;

import models.Model;
import utills.Utills;
import views.View;

/**
 * Created by MeoMunm on 12/8/2016.
 */
public class EnemyController extends Controller {
    public EnemyController(Model model, View view) {
        super(model, view);
    }

    public void run() {
        this.model.move(0, 2);
        if (this.model.getY() >= 600){

        }
    }

    public static EnemyController createEnemy (int x, int y){
       EnemyController enemyController = new EnemyController(
               new Model(x, y, 32, 32),
               new View(Utills.loadImage("resources/enemy_plane_white_1.png"))
       );
       return enemyController;
    }
}
