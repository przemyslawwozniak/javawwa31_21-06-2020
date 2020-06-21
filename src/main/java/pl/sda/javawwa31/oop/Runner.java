package pl.sda.javawwa31.oop;

public class Runner {

    //psvm
    public static void main(String[] args) {
        Point p1 = new Point(); //0,0
        Point p2 = new Point(5, 10);

        System.out.println("Odleglosc p1 do srodka ukladu wsp: " + p1.distance());
        System.out.println("Odleglosc p2 od srodka ukl wsp: " + p2.distance());
        System.out.println("Odleglosc p2 od p1: " + p2.distance(p1));
        System.out.println("Odleglosc p1 od p2: " + p1.distance(p2));
        System.out.println("Odleglosc p1 od (5, 10): " + p1.distance(5, 10));
    }

}
