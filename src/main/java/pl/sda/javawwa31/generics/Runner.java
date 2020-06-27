package pl.sda.javawwa31.generics;

import java.util.*;

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

        List<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.add(s5);

        System.out.println("Przed sortowaniem: " + students);

        Collections.sort(students);
        System.out.println("Po sortowaniu wg naturalnego porzadku (Comparable): " + students);

        Comparator<Student> customComparator = new StudentEquationComparator();
        Collections.sort(students, customComparator);
        System.out.println("Po sortowaniu wg ustalonego porzadku (Comparator): " + students);
    }

    public static class StudentEquationComparator implements Comparator<Student> {
        @Override
        public int compare(Student s1, Student s2) {
            return (int)(eq(s1) - eq(s2));
        }

        private double eq(Student s) {
            return s.getLastName().length() + s.getYear() * s.getAvg();
        }
    }

}
