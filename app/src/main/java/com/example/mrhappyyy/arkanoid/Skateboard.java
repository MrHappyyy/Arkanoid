package com.example.mrhappyyy.arkanoid;

import android.graphics.Color;

public class Skateboard extends SimpleBlock {
    public static final int SKATEBOARD_SPEED = 35;
    public static final int SKATEBOARD_COLOR = Color.BLACK;
    private static final int SKATEBOARD_LENGTH_X = 300;
    private static final int SKATEBOARD_LENGTH_Y = 25;

    public Skateboard(int x, int y) {
        super(x - SKATEBOARD_LENGTH_X /2, y, SKATEBOARD_LENGTH_X, SKATEBOARD_LENGTH_Y, SKATEBOARD_COLOR);
    }

    public void moveMainBlockWhenTouchAt(int x1) {

        int dx = ((x1 - SKATEBOARD_LENGTH_X/2) - left) * SKATEBOARD_SPEED / GameManager.getWidth();

        left += dx;
        right = left + SKATEBOARD_LENGTH_X;
    }
}
