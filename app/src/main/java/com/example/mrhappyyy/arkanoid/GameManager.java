package com.example.mrhappyyy.arkanoid;

import android.graphics.Color;

import java.util.ArrayList;

public class GameManager {
    private static int width;
    private static int height;
    private static final int COUNT_COLUMN_BLoCK = 10;
    private static final int COUNT_ROWS_BLOCK = 10;
    private int lengthBlockX;
    private int lengthBlockY;
    private CanvasView view;
    private Skateboard skateboard;
    private MainCircle mainCircle;
    private ArrayList<Block> blockList;
    private int startWidth;
    private int startHeight;

    public GameManager(CanvasView canvasView, int width, int height) {
        view = canvasView;
        this.width = width;
        this.height = height;
        startWidth = width/2;
        startHeight = height - 100;

        lengthBlockX = width / COUNT_COLUMN_BLoCK;
        lengthBlockY = (height / 2) / COUNT_ROWS_BLOCK;
        initBlock();
        initSkateboard();
        initMainCircle();
    }

    private void initBlock() {
        int blockX = 0;
        int blockY = 50;
        int color;
        blockList = new ArrayList<Block>();

        for (int i = 0; i < COUNT_ROWS_BLOCK; i++) {
            for (int k = 0; k < COUNT_COLUMN_BLoCK; k++) {
                color = Color.CYAN;

                blockList.add(new Block(blockX, blockY, lengthBlockX - 5, lengthBlockY - 5, color));
                blockX += lengthBlockX;
            }
            blockY += lengthBlockY;
            blockX = 0;
        }
    }

    private void initMainCircle() {
        mainCircle = new MainCircle(startWidth, startHeight - 10);
    }

    private void initSkateboard() {
        skateboard = new Skateboard(startWidth, startHeight);
    }

    public static int getWidth() {
        return width;
    }

    public static int getHeight() {
        return height;
    }

    public void onDraw() {
        view.drawCircle(mainCircle);
        view.drawBlock(skateboard);

        for (Block block : blockList) {
            view.drawBlock(block);
        }
    }


    public void onTouch(int x, int y) {
        skateboard.moveMainBlockWhenTouchAt(x);

        if (mainCircle.isIntersect(skateboard)) {
            mainCircle.moveBackY();
        } else {
            for (Block block : blockList) {

                if (mainCircle.isIntersect(block)) {

                    if (mainCircle.getCollisionY())
                        mainCircle.moveBackY();
                    else if (mainCircle.getCollisionX())
                        mainCircle.moveBackX();

                    blockList.remove(block);
                    break;
                }
            }
        }

        if (!mainCircle.moveOneStep())
            gameAnd("you lose!");
        else if (blockList.isEmpty())
            gameAnd("you win!");
    }

    private void gameAnd(String text) {
        view.showMessage(text);
        initBlock();
        initMainCircle();
        initSkateboard();
    }
}
