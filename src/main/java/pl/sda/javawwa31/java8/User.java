package pl.sda.javawwa31.java8;

import java.time.LocalDate;

public class User {

    private String name;
    private String lastName;
    private LocalDate brithday;
    private double salary;
    private CivicState cs;
    private int children;

    public User(String name, String lastName, LocalDate brithday, double salary, CivicState cs, int children) {
        this.name = name;
        this.lastName = lastName;
        this.brithday = brithday;
        this.salary = salary;
        this.cs = cs;
        this.children = children;
    }

}