package controllers;

import java.util.DoubleSummaryStatistics;

/**
 * Created by apple on 12/24/16.
 */
public class GameVector {
    public int dx;
    public int dy;

    public GameVector(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public Double getLength() {
        return Math.sqrt(dx * dx + dy * dy);
    }
}
