package controllers.managers;

import controllers.Controller;

import java.awt.*;
import java.util.Iterator;
import java.util.Vector;

/**
 * Created by MeoMunm on 12/12/2016.
 */
public class ControllerManager {
    public Vector<Controller> controllers;

    public ControllerManager(){
        controllers = new Vector<>();
    }

    public void draw(Graphics g){
        for (Controller controller: controllers){
            controller.draw(g);
        }

    }

    public void run(){
        for (Controller controller: controllers){
            controller.run();
        }
        Iterator<Controller> iterator = this.controllers.iterator();
        while(iterator.hasNext()){
            Controller controller = iterator.next();
            if (!controller.getModel().isAlive()){
                iterator.remove();
            }
        }
    }

    public void add(Controller controller){
        controllers.add(controller);
    }

    public void remove(Controller controller){
        controllers.remove(controller);
    }

}
