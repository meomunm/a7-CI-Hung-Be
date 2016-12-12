package models;

/**
 * Created by MeoMunm on 12/9/2016.
 */
public class Model {
    private int x;
    private int y;
    private int WIDTH;
    private int HEIGHT;

    public Model(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.WIDTH = width;
        this.HEIGHT = height;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return WIDTH;
    }

    public int getHeight() {
        return HEIGHT;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setWidth(int width) {
        this.WIDTH = width;
    }

    public void setHeight(int height) {
        this.HEIGHT = height;
    }

    public void move(int dx, int dy){
        x += dx;
        y += dy;
    }

    public int getMidX() {
        return this.x + this.WIDTH/2;
    }

    public int getMidY() {
        return this.y + this.HEIGHT/2;
    }

    public int bottom(){
        return this.y + HEIGHT;
    }
}
