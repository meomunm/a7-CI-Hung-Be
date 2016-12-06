package models;

/**
 * Created by MeoMunm on 12/5/2016.
 */
public class PlaneModel {
   private int x;
   private int y;
   public final int widthPlane = 70;
   public final int heightPlane = 50;

    public PlaneModel(int x, int y) {
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

    public void PlaneMove(int dx, int dy){
        x += dx;
        y += dy;
    }
}
