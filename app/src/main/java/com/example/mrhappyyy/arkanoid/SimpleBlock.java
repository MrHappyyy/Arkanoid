package com.example.mrhappyyy.arkanoid;

public class SimpleBlock {

    protected int color;
    protected int left;
    protected int top;
    protected int right;
    protected int bottom;
    protected int lengthX;
    protected int lengthY;

    public SimpleBlock(int x, int y, int lengthX, int lengthY) {
        left = x;
        top = y;
        this.lengthX = lengthX;
        this.lengthY = lengthY;
        right = x + lengthX;
        bottom = y + lengthY;
    }

    public SimpleBlock(int x, int y, int lengthX, int lengthY, int color) {
        left = x;
        top = y;
        this.lengthX = lengthX;
        this.lengthY = lengthY;
        right = x + lengthX;
        bottom = y + lengthY;
        this.color = color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getLeft() {
        return left;
    }

    public int getTop() {
        return top;
    }

    public int getRight() {
        return right;
    }

    public int getBottom() {
        return bottom;
    }

    public int getLengthX() {
        return lengthX;
    }

    public int getLengthY() {
        return lengthY;
    }

    public int getColor() {
        return color;
    }


    /*public boolean isIntersect(SimpleCircle circle) {

        return false;
    }*/
}
