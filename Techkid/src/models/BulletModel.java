package models;

/**
 * Created by MeoMunm on 12/5/2016.
 */
public class BulletModel {
    private int x;
    private int y;
    public static final int widthBullet = 13;
    public static final int heightBullet = 33;

    public BulletModel(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void move(int dx, int dy){
        x  += dx ;
        y += dy;
    }


}
