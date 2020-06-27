package pl.sda.javawwa31.generics;

import java.util.Set;
import java.util.TreeSet;

public class Runner {

    /*public static void main(String[] args) {
        Pair<String, String> capitalCountry = new Pair<>("Warsaw", "Poland");
        Pair<Integer, String> marketShare = new Pair<>(1, "Apple");

        Set<String> names = new TreeSet<>();
        names.add("Oliwia");
        names.add("oliwia");
        names.add("Emilia");    //E - 69
        names.add("emilia");    //e - 101
        names.add("Przemek");
        names.add("przemek");

        System.out.println(names);
    }*/

    public static void main(String[] args) {
        Student s1 = new Student("Andrzej", "Tuk", 5, 4.5);
        Student s2 = new Student("Sebastian", "Wlazly", 2, 3.0);
        Student s3 = new Student("Robert", "Gwiazdowski", 4, 4.75);
        Student s4 = new Student("Krzystof", "Czech", 1, 3.0);
        Student s5 = new Student("Adrian", "Polak", 3, 3.25);
    }

}
