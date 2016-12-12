package controllers;

/**
 * Created by MeoMunm on 12/9/2016.
 */
public class KeySetting {
    public int keyUp;
    public int keyDown;
    public int keyLeft;
    public int keyRight;

    public KeySetting(int keyUp, int keyDown, int keyLeft, int keyRight) {
        this.keyUp = keyUp;
        this.keyDown = keyDown;
        this.keyLeft = keyLeft;
        this.keyRight = keyRight;
    }
}
