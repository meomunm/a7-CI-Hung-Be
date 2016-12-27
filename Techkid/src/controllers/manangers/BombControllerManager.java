package controllers.manangers;

import controllers.bomb.BombController;

import java.util.Random;

/**
 * Created by MeoMunm on 12/27/2016.
 */
public class BombControllerManager extends ControllerManager {
    private int timerCount=0;

    public void spawnBomb(){

        BombController bombController = BombController.creatBomb(new Random().nextInt(535),0);
        controllers.add(bombController);
    }

    @Override
    public void run() {
        super.run();
        timerCount++;
        if (timerCount>500) {
            spawnBomb();
            timerCount =0;
        }
    }

}
