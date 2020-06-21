package pl.sda.javawwa31.oop;

//Cwiczenie #1
public class Point2D {    //extends java.lang.Object

    protected int x, y;   //0

    //Alt+Insert -> Generate
    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point2D() {}

    @Override
    public String toString() {
        return String.format("(%d, %d)", x, y); //("1, 5"); %d - liczba calkowita; %s - napis; %f - liczba zmiennoprzecinkowa itd.
    }

    public int[] getXY() {
        int[] pos = {x, y};
        return pos;
    }

    public void setXY(int x, int y) {
        setX(x);
        setY(y);
    }

    //pa, pb
    //Math.sqrt((pb.x - pa.x) ^ 2 + (pb.y - pa.y) ^ 2)
    //Math.pow(a, b) = a^b
    //this - (0,0)
    public double distance() {
        return distance(0, 0);
    }

    //this - (x, y)
    public double distance(int x, int y) {
        return Math.sqrt(Math.pow(this.x - x, 2) + Math.pow(this.y - y, 2));
    }

    //this - another
    public double distance(Point2D another) {
        return distance(another.x, another.y);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
