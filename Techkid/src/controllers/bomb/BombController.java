package controllers.bomb;

import controllers.Body;
import controllers.Controller;
import controllers.PlaneController;
import controllers.manangers.BodyManager;
import models.Model;
import utils.Utils;
import views.SingleView;
import views.View;

import java.awt.*;

/**
 * Created by MeoMunm on 12/27/2016.
 */
public class BombController extends Controller implements Body {
    private static final int WIDTH = 55;
    private static final int HEIGHT = 50;
    public static boolean isAliveBomb = true;

    public BombController(Model model, View view) {
        super(model, view);
        BodyManager.instance.register(this);
    }

    public static BombController creatBomb(int x,int y){
        return new BombController(new Model(x,y,WIDTH,HEIGHT),new SingleView(Utils.loadImage("resources/bomb.png")));
    }

    @Override
    public void run(){
        super.run();
        this.model.move(0,1);
    }

    @Override
    public void draw(Graphics g) {
        if (model.isAlive()) {
            super.draw(g);
        }
    }

    @Override
    public void onContact(Body other) {
        System.out.println("hhhhh");
        if (other instanceof PlaneController){
            System.out.println("kkkkkkk");
            this.getModel().setAlive(false);
            isAliveBomb =false;
        }
    }
}
