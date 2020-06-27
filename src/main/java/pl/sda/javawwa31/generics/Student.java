package pl.sda.javawwa31.generics;

public class Student implements Comparable<Student> {
    private String firstName, lastName;
    private int year;
    private double avg;

    public Student(String firstName, String lastName, int year, double avg) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.year = year;
        this.avg = avg;
    }

    //1.0
    //1.75
    //10*(1 - 1.75) = 10*0.75 = 7.5 -> 7 > 0
    //1.0
    //1.01
    //1 - 1.01 = -0.01
    @Override
    public int compareTo(Student other) {
        return (int)(100 * (this.avg - other.avg));
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

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", year=" + year +
                ", avg=" + avg +
                '}';
    }
}
