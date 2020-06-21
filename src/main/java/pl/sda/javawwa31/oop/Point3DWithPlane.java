package pl.sda.javawwa31.oop;

public class Point3DWithPlane extends Point2D {

    private int z;

    public Point3DWithPlane() {}

    public Point3DWithPlane(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    public double distanceInSpace() {
        return distanceInSpace(0, 0, 0);
    }

    public double distanceInSpace(int x, int y, int z) {
        return Math.sqrt(Math.pow(this.x - x, 2) + Math.pow(this.y - y, 2) + Math.pow(this.z - z, 2));
    }

    public double distanceInSpace(Point3DWithPlane another) {
        return distanceInSpace(another.x, another.y, another.z);
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }
}
