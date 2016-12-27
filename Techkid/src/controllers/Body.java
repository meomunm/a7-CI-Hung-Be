package controllers;

import models.Model;

/**
 * Created by apple on 12/14/16.
 */
public interface Body { //Pure abstract
    Model getModel();
    void onContact(Body other);
}
