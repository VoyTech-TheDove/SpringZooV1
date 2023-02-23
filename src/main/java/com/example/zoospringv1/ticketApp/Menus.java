package com.example.zoospringv1.ticketApp;

import java.util.Scanner;

public class Menus {
    public static int menu() {
        System.out.println();
        System.out.println("     ****************************************");
        System.out.println("     *             KASA BILETOWA            *");
        System.out.println("     ****************************************");
        System.out.println("     *  1. Informacja o biletach.           *");
        System.out.println("     *  2. Wybierz bilety.                  *");
        System.out.println("     *  0. Koniec.                          *");
        System.out.println("     ****************************************");
        System.out.println();
        System.out.println("(wpisz cyfre od 0 do 2 włącznie poniżej... )");

        Scanner in = new Scanner(System.in);
        int w = in.nextInt();
        return w;
    }

}
