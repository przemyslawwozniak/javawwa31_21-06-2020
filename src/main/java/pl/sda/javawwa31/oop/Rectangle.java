package pl.sda.javawwa31.oop;

public class Rectangle extends Shape {

    private int a, b;

    public Rectangle(int a, int b, String color) {
        this.a = a;
        this.b = b;
        this.color = color;
    }

    @Override
    public double getArea() {
        return a * b;
    }

}
