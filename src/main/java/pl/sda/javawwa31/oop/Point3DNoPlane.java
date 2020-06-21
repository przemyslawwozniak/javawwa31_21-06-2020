package pl.sda.javawwa31.oop;

//Zadania-pdf/ex3
public class Point3DNoPlane extends Point2D {

    private int z;

    public Point3DNoPlane() {
        super();
    };

    public Point3DNoPlane(int x, int y, int z) {
        super(x, y);    //odwolanie do rodzica - super - na samym poczatku metody; tu: konstruktor
        this.z = z;
    }

    @Override
    public double distance() {
        return distance(0, 0, 0);
    }

    public double distance(int x, int y, int z) {
        return Math.sqrt(Math.pow(this.x - x, 2) + Math.pow(this.y - y, 2) + Math.pow(this.z - z, 2));
    }

    public double distance(Point3DNoPlane another) {
        return distance(another.x, another.y, another.z);
    }

    //mowie, ze nie mozna skorzystac z tych metod w kontekscie tej klasy
    @Override
    public double distance(int x, int y) {
        throw new UnsupportedOperationException();
    }

    @Override
    public double distance(Point2D another) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        return String.format("(%d, %d, %d)", x, y, z);
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }
}
