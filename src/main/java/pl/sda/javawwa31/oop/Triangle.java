package pl.sda.javawwa31.oop;

public class Triangle extends Shape {

    private int a, h;

    public Triangle(int a, int h, String color) {
        this.a = a;
        this.h = h;
        this.color = color;
    }

    @Override
    public double getArea() {
        return 0.5 * a * h;
    }
}
