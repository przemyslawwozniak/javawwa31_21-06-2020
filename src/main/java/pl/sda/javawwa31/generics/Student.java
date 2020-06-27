package pl.sda.javawwa31.generics;

public class Student {
    private String firstName, lastName;
    private int year;
    private double avg;

    public Student(String firstName, String lastName, int year, double avg) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.year = year;
        this.avg = avg;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getYear() {
        return year;
    }

    public double getAvg() {
        return avg;
    }
}
