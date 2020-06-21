package pl.sda.javawwa31.oop;

public class Runner {

    //Ex 1
    /*public static void main(String[] args) {
        Point p1 = new Point(); //0,0
        Point p2 = new Point(5, 10);

        System.out.println("Odleglosc p1 do srodka ukladu wsp: " + p1.distance());
        System.out.println("Odleglosc p2 od srodka ukl wsp: " + p2.distance());
        System.out.println("Odleglosc p2 od p1: " + p2.distance(p1));
        System.out.println("Odleglosc p1 od p2: " + p1.distance(p2));
        System.out.println("Odleglosc p1 od (5, 10): " + p1.distance(5, 10));
    }*/

    //Ex 2
    /*public static void main(String[] args) {
        Point p1 = new Point(); //0,0
        Point p2 = new Point(5, 10);
        Line l1 = new Line(p1, p2);
        Line l2 = new Line(1, 2, 3, 4);

        System.out.println("Dlugosc odcinka L1 wynosi: " + l1.getLength() + ". Jego parametry to: " + l1);
        System.out.println("Dlugosc odcinka L2 wynosi: " + l2.getLength() + ". Jego parametry to: " + l2);
    }*/

    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(5, 10, "niebieski");
        System.out.println(r1);

        Triangle t1 = new Triangle(5, 10, "żółty");
        System.out.println(t1);

        //rodzic jako klasa wiekszego agregatu; polimorfizm
        Shape[] shapes = {r1, t1, new Triangle(10, 12, "zielony")};
        for(Shape s : shapes)
            System.out.println(s);

    }

}
