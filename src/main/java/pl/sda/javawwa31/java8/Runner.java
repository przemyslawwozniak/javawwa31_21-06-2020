package pl.sda.javawwa31.java8;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Runner {

    /*public static void main(String[] args) {
        Supplier<List<String>> citiesSupplier = () ->
                Arrays.asList("Warsaw,Berlin,Frankfurt,Stuttgart,Danzig".split(","));

        print(() ->
                Arrays.asList("Warsaw,Berlin,Frankfurt,Stuttgart,Danzig".split(",")));

        Supplier<List<String>> mySupp = new MyCitiesSupplier();
        mySupp.get();
    }

    public static void print(Supplier<List<String>> toPrint) {
        System.out.println(toPrint);
    }*/

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();

        User u1 = new User("Jan", "Kowalski",
                LocalDate.of(1985, 2, 20),
                3500.0,
                CivicState.FREE,
                1);
        User u2 = new User("Julia", "Konradcka",
                LocalDate.of(1987, 3, 20),
                10000.0,
                CivicState.OCCUPIED,
                2);
        User u3 = new User("Konrad", "Karwowski",
                LocalDate.of(1992, 10, 22),
                2500.0,
                CivicState.FREE,
                0);
        User u4 = new User("Norbert", "Urbanski",
                LocalDate.of(1972, 5, 6),
                7500.0,
                CivicState.OCCUPIED,
                3);
        User u5 = new User("Ula", "Gwozdz",
                LocalDate.of(1967, 12, 5),
                6500.0,
                CivicState.OCCUPIED,
                4);
        User u6 = new User("Janek", "Poranek",
                LocalDate.of(1998, 2, 5),
                8500.0,
                CivicState.FREE,
                0);
        User u7 = new User("Karol", "Bobko",
                LocalDate.of(1928, 1, 25),
                2500.0,
                CivicState.OCCUPIED,
                5);
        User u8 = new User("Marek", "Starek",
                LocalDate.of(1978, 2, 5),
                18500.0,
                CivicState.OCCUPIED,
                10);
        User u9 = new User("Marek", "Warek",
                LocalDate.of(2010, 6, 7),
                0.0,
                CivicState.FREE,
                0);
        User u10 = new User("Zbyszek", "Kiszek",
                LocalDate.of(1948, 12, 23),
                500.0,
                CivicState.FREE,
                2);

        users.add(u1);
        users.add(u2);
        users.add(u3);
        users.add(u4);
        users.add(u5);
        users.add(u6);
        users.add(u7);
        users.add(u8);
        users.add(u9);
        users.add(u10);

        //dalej kod
        //1 - osoby zarabiajace > 5000
        List<User> usersWhoEarnMoreThan5k = users.stream()
                .filter(u -> u.getSalary() > 5000)
                .collect(Collectors.toList());

        System.out.println("Oto uzytkownicy ktorzy zarabiaja ponad 5k:");
        printUsers(usersWhoEarnMoreThan5k);

        //2 - liczba osob w zwiazku
        List<User> usersInRelationship = users.stream()
                .filter(u -> u.getCs().equals(CivicState.OCCUPIED))
                .collect(Collectors.toList());

        //3 - osoby z dziecmi w stanie wolnym
        List<User> usersWithChildrenButFree = users.stream()
                .filter(u -> u.getCs().equals(CivicState.FREE))
                .filter(u -> u.getChildren() > 0)
                .collect(Collectors.toList());

        System.out.println("Osoby z dziecmi, w stanie wolnym: ");
        printUsers(usersWithChildrenButFree);

        //4 - liczba dzieci osob w wieku > 30
        int sumOfTheChildrenOfUsersOlderThan30 = users.stream()
                .filter(u -> ChronoUnit.YEARS.between(u.getBrithday(), LocalDate.now()) > 30)
                .mapToInt(User::getChildren)    //mapuje userow na liczby odpowiadajace liczbie dzieci poszczegolnych userow
                .sum(); //sum jest metoda IntStream sluzaca sumowaniu elementow strumienia liczb calkowitych

        System.out.println("Liczba dzieci osob w wieku ponad 30 lat: " + sumOfTheChildrenOfUsersOlderThan30);

        //5 - dane osoby majacej najwieksza pensje
        User topUser = users.stream()
                .sorted(Comparator.comparingDouble(User::getSalary).reversed())    //(u1, u2) -> u1.getSalary - u2.getSalary ---> implementacja interfejsu funkcyjnego komparatora
                .findFirst()
                .get();//wiem, ze kolekcja jest niepusta, wiec sa tam jakies elementy, biore pierwszy z nich

        System.out.println("Osoba ktora zarabia najwiecej: " + topUser);

        //6 - lista osob posortowana wg wieku rosnaco
        List<User> usersSortedByAge = users.stream()
                .sorted((us, ue) -> ue.getBrithday().compareTo(us.getBrithday()))   //Comparator.comparing(User::getBirthday)
                .collect(Collectors.toList());

        System.out.println("Lista osob posortowana po wieku rosnaco: ");
        printUsers(usersSortedByAge);

    }

    public static void printUsers(List<User> users) {
        for(User u : users)
            System.out.println(u);
    }

}
