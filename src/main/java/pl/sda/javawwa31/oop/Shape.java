package pl.sda.javawwa31.oop;

public abstract class Shape {

    //modyfikator 'protected' jest czesto uzywany w przypadu klas abstrakcyjnych
    protected String color;

    public abstract double getArea();

    @Override
    public String toString() {
        return String.format("Nazwa ksztaltu: %s\nKolor: %s\nPowierzchnia: %s\n",
                this.getClass().getSimpleName(),   //pobiera nazwe klasy 'z pliku'
                color,
                getArea());
    }

}
