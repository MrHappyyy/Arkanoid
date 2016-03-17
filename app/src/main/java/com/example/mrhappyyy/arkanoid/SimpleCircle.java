package com.example.mrhappyyy.arkanoid;

public class SimpleCircle {
    protected int color;
    protected int x;
    protected int radius;
    protected int y;
    private boolean collisionX = false;
    private boolean collisionY = false;

    public SimpleCircle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;

    }


    public SimpleCircle(int x, int y, int radius, int color) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
    }

    public void setX(int x) {
        this.x = x;
    }

    public boolean getCollisionX() {
        return collisionX;
    }

    public boolean getCollisionY() {
        return collisionY;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getColor() {
        return color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRadius() {
        return radius;
    }

    public void setColor(int color) {
        this.color = color;
    }

    private int distSquared(int x, int y) {
        int distX = this.x - x;
        int distY = this.y - y;

        if (distX < 0)
            distX *= -1;
        if (distY < 0)
            distY *= -1;

        return distX * distX + distY * distY;
    }

    private int hypotenuse(int x1, int y1, int x2, int y2) {
        int cathetusX = x1 - x2;
        int cathetusY = y1 - y2;

        if (cathetusX < 0)
            cathetusX *= -1;
        if (cathetusY < 0)
            cathetusY *= -1;

        return (int) Math.sqrt(Math.pow(cathetusX, 2) + Math.pow(cathetusY, 2));
    }

    private int onANaturalNumberVerification(int number) {
        if (number < 0)
            number *= -1;
        return number;
    }

    private int distance(int x1, int y1, int x2, int y2) {
        int distance = -1;

        if (x1 == x2 && y1 == y2) {
            return 0;
        } else if (x1 != x2 && y1 != y2) {
            distance = onANaturalNumberVerification(hypotenuse(x1, y1, x2, y2));
        } else if (x1 == x2) {
            distance = onANaturalNumberVerification(y1 - y2);
        } else if (y1 == y2) {
            distance = onANaturalNumberVerification(x1 - x2);
        }

        return distance;
    }

    public boolean isIntersect(SimpleBlock block) {

        /*if (getX() + radius <= block.getRight()
                && getX() - radius >= block.getLeft()
                && getY() + radius <= block.getBottom()
                && getY() - radius >= block.getTop()) {
            System.out.println(1);
            return true;
        }*/
        int closestX = getX();
        int closestY = getY();

        if (getX()  < block.getLeft()) {
            closestX = block.getLeft();
        } else if (getX()  > block.getRight()) {
            closestX = block.getRight();
        }

        if (getY()  < block.getTop()) {
            closestY = block.getTop();
        } else if (getY() > block.getBottom()) {
            closestY = block.getBottom();
        }

        int distance = distance(closestX, closestY, getX(), getY());

        if (distance < 0)
            return false;

        determineCollision(block, closestX, closestY);

        return distance <= radius;
    }

    private void determineCollision(SimpleBlock block, int closestX, int closestY) {
        collisionX = false;
        collisionY = false;

        if (getX() >= block.getLeft() && getX() <= block.getRight()) {
            collisionY = true;
        }

        if (getY() >= block.getTop() && getY() <= block.getBottom()) {
            collisionX = true;
        }

        if (collisionX && collisionY) {

            if (getDist(closestX, getX()) < getDist(closestY, getY())) {
                collisionX = true;
            } else if (getDist(closestX, getX()) > getDist(closestY, getY())) {
                collisionY = true;
            } else {
                setY(getY() + 2);
                collisionY = true;
            }
        }
    }

    private int getDist(int point1, int point2) {
        int res = point1 - point2;

        if (res < 0)
            res *= -1;
        return res;
    }
}
