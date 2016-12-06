package controllers;

import models.BulletModel;
import views.BulletView;

import java.awt.*;

/**
 * Created by MeoMunm on 12/6/2016.
 */
public class BulletController {
    public BulletModel bulletModel;
    public BulletView bulletView;

    public BulletController(BulletModel bulletModel, BulletView bulletView) {
        this.bulletModel = bulletModel;
        this.bulletView = bulletView;
    }

    public void draw(Graphics g){
        bulletView.draw(g, bulletModel);
    }
}
