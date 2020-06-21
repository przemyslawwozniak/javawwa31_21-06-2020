package pl.sda.javawwa31.oop;

public class MovablePoint implements Movable, Cloneable {   //implementujemy interfejs Cloneable aby moc uzyc metody java.lang.Object#clone

    private int x, y, xSpeed, ySpeed;

    public MovablePoint() {
        this.x = 0;
        this.y = 0;
        setxSpeed(1);
        setySpeed(1);
    }

    public MovablePoint(int x, int y) {
        this.x = x;
        this.y = y;
        setxSpeed(1);
        setySpeed(1);
    }

    public MovablePoint(int x, int y, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        setxSpeed(xSpeed);
        setySpeed(ySpeed);
    }

    @Override
    public void moveUp() {
        this.y += ySpeed;
    }

    @Override
    public void moveDown() {
        this.y -= ySpeed;
    }

    @Override
    public void moveRight() {
        this.x += xSpeed;
    }

    @Override
    public void moveLeft() {
        this.x -= xSpeed;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new MovablePoint(x, y, xSpeed, ySpeed);
    }

    @Override
    public String toString() {
        return super.toString() +
                "{x=" + x +
                ", y=" + y +
                ", xSpeed=" + xSpeed +
                ", ySpeed=" + ySpeed +
                '}';
    }

    public void setxSpeed(int xSpeed) {
        if(xSpeed > 0)
            this.xSpeed = xSpeed;
        else
            this.xSpeed = 1;
    }

    public void setySpeed(int ySpeed) {
        if(ySpeed > 0)
            this.ySpeed = ySpeed;
        else
            this.ySpeed = 1;
    }
}
