package shipsinker;

import java.util.Random;
import java.util.Scanner;

public class ShipSinker {

    public static void main(String[] args) {
        //Potapanje broda

        Scanner s = new Scanner(System.in);

        //Unos dimenzije za igru
        System.out.println("Unesite dimenzije table za igru:");
        int m = s.nextInt();
        int n = s.nextInt();
        s.nextLine();
        //Kreiranje table za igru i popunjavanje
        int[][] table = tableCreate(m, n);

        //Tablin prikaz
        printMatrix(table);

        //brojac popunjenih elemenata
        counterOfShips(table);

        //igra
        game(table, s);

    }

    public static int[][] tableCreate(int m, int n) {

        int[][] table = new int[m][n];
        fillShips(table);

        return table;
    }

    public static void fillShips(int[][] table) {
        Random random = new Random();
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                table[i][j] = random.nextInt(2);
                System.out.println("Stavljena vrednost na poziciju " + i + "  " + j + " je " + table[i][j]);
            }
        }
        System.out.println("");
    }

    public static void printMatrix(int[][] matrica) {
        System.out.println("Vasa tabla za igru je popunjena: ");

        for (int i = 0; i < matrica.length; i++) {
            for (int j = 0; j < matrica[i].length; j++) {
                System.out.printf("%4d", matrica[i][j]);
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public static void counterOfShips(int[][] table) {
        int counter = 0;

        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                if (table[i][j] == 1) {
                    counter++;
                }
            }
        }

        System.out.println("Brodova na tabli ima: " + counter);
        if (counter == 0) {
            System.exit(1);
        }
    }

    public static void game(int[][] table, Scanner s) {

        while (true) {
            System.out.println("Gadjajte unosom koordinata: ");

            int a = s.nextInt();
            int b = s.nextInt();

            if (table[a][b] == 1) {
                System.out.println("Pogodili ste brod!");
                table[a][b] = 0;
                counterOfShips(table);
                printMatrix(table);
            } else {
                System.out.println("Niste pogodili brod.");
            }

        }
    }
}
