package controllers;

import models.Model;

/**
 * Created by MeoMunm on 12/14/2016.
 */
public interface Body {
    public abstract Model getModel();
    public abstract void onContact(Body other);
}
