package controllers.scenes;

/**
 * Created by PT-LS on 12/31/2016.
 */
public interface SceneListener {
    void replaceScene(GameScene newScene, boolean addToBackStack);
}
