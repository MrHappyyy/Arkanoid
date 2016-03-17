package com.example.mrhappyyy.arkanoid;

import android.graphics.Color;

import java.util.Random;

public class MainCircle extends SimpleCircle {
    private static final int MAIN_CIRCLE_COLOR = Color.BLACK;
    private static final int CIRCLE_RADIUS = 20;
    private static final int CIRCLE_SPEED = 15;
    private int dx;
    private int dy;

    public MainCircle(int x, int y) {
        super(x - CIRCLE_RADIUS/2, y - CIRCLE_RADIUS, CIRCLE_RADIUS, MAIN_CIRCLE_COLOR);
        int i = new Random().nextInt(2);

        if (i == 0) {
            dx = CIRCLE_SPEED;
        } else {
            dx = - CIRCLE_SPEED;
        }
        dy = -CIRCLE_SPEED;
    }

    public boolean moveOneStep() {
        x += dx;
        y += dy;
        return checkBounds();
    }

    private boolean checkBounds() {

        if (x > GameManager.getWidth() || x <= 0) {
            moveBackX();
        }

        if (y <= 0) {
            moveBackY();
        }

        if (y > GameManager.getHeight()) {
            return false;
        }
        return true;
    }

    public void moveBackX() {
        dx = - dx;
    }


    public void moveBackY() {
        dy = -dy;
    }
}
