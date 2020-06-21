package pl.sda.javawwa31.oop;

/*
konstruktory
getBegin():Point
getEnd():Point
getBeginX():int
setEndY(y:int):void
getBeginXY():int[2] -> Point.getXY()
toString():String
getLength():double
 */

//Cwiczenie #2
public class Line {

    private Point2D begin, end;

    public Line(Point2D begin, Point2D end) {
        this.begin = begin;
        this.end = end;
    }

    public Line(int x1, int y1, int x2, int y2) {   //new Line(1, 2, 3, 4)
        this.begin = new Point2D(x1, y1);
        this.end = new Point2D(x2, y2);
    }

    public int getBeginX() {
        return this.begin.getX();
    }

    public void setBeginX(int x) {
        this.begin.setX(x);
    }

    public void setEndY(int y) {
        this.end.setY(y);
    }

    public int[] getBeginXY() {
        return this.begin.getXY();
    }

    public Point2D getBegin() {
        return this.begin;
    }

    @Override
    public String toString() {
        return String.format("Odcinek: [początek = %s, koniec = %s]",
                this.begin, //przekazanie obiektu do sout powoduje wywolanie jego metody toString
                this.end.toString());
    }

    public double getLength() {
        return this.begin.distance(this.end);
    }

    public Point2D getEnd() {
        return this.end;
    }
}
