package pl.sda.javawwa31.oop;

import java.util.Arrays;

public class MovableRectangle implements Movable {

    private MovablePoint[] points = new MovablePoint[4];
    private int xSpeed, ySpeed;

    public MovableRectangle(MovablePoint a, MovablePoint b, MovablePoint c, MovablePoint d, int xSpeed, int ySpeed) {
        try {
            this.points[0] = (MovablePoint) a.clone();  //utworz nowa instancje obiektu ale o tych samych wartosciach pol
            this.points[1] = (MovablePoint) b.clone();
            this.points[2] = (MovablePoint) c.clone();
            this.points[3] = (MovablePoint) d.clone();
        }
        catch(Exception ex) {
            System.err.println("No worries ;)");
        }

        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        //this.points = Arrays.asList(a, b, c, d).toArray();
        //zapewniam, ze wszystkie punkty prostokata ruszaja sie z ta sama predkoscia
        for(MovablePoint mp : points) {
            mp.setxSpeed(xSpeed);
            mp.setySpeed(ySpeed);
        }
    }

    public MovableRectangle() {
        this.xSpeed = 1;
        this.ySpeed = 1;
        this.points[0] = new MovablePoint();
        this.points[1] = new MovablePoint();
        this.points[2] = new MovablePoint();
        this.points[3] = new MovablePoint();
    }

    @Override
    public void moveUp() {
        for(MovablePoint mp : points)
            mp.moveUp();
    }

    @Override
    public void moveDown() {
        for(MovablePoint mp : points)
            mp.moveDown();
    }

    @Override
    public void moveRight() {
        for(MovablePoint mp : points)
            mp.moveRight();
    }

    @Override
    public void moveLeft() {
        for(MovablePoint mp : points)
            mp.moveLeft();
    }

    @Override
    public String toString() {
        return "MovableRectangle{" +
                "points=" + Arrays.toString(points) +
                '}';
    }
}
