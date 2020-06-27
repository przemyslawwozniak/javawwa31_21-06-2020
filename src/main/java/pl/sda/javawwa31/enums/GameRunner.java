package pl.sda.javawwa31.enums;

import java.util.Scanner;

public class GameRunner {

    public static void main(String[] args) {
        System.out.println("Witaj w grze \"PAPIER, KAMIEŃ, NOŻYCE\"!\n\n");
        Scanner sc = new Scanner(System.in);

        //gra az gracz wpisze -99
        boolean more = false;
        do {
            Gesture playerGesture = getGesture(playerInput(sc), "Wybrałeś gest: ");
            Gesture pcGesture = getGesture((int)(Math.random() * 3), "Komputer wybrał gest: ");

            System.out.println("Wynik: " + playerGesture.play(pcGesture) + "\n\n");

            more = playMore(sc);
        }
        while(more);
    }

    public static Gesture getGesture(int ordinal, String info) {
        Gesture playerGesture = Gesture.values()[ordinal];
        System.out.println(info + playerGesture.name());
        return playerGesture;
    }

    public static int playerInput(Scanner sc) {
        System.out.println("Wybierz swoj gest:\n0 - PAPIER\n1 - KAMIEŃ\n2 - NOŻYCE\n");

        int playerChoice = sc.nextInt();

        while(playerChoice < 0 || playerChoice > 2) {
            System.out.println("Wartosc spoza zakresu! Musisz podac wartosc 0, 1 lub 2 aby kontynuowac");
            playerChoice = sc.nextInt();
        }

        return playerChoice;
    }

    public static boolean playMore(Scanner sc) {
        System.out.println("Czy gramy dalej? [y = TAK]");
        sc.nextLine(); //czyszczenie Scannera
        char answ = sc.nextLine().charAt(0);
        if(answ == 'y')
            return true;
        else
            return false;
    }

}
