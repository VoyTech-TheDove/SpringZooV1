package com.example.zoospringv1.ticketApp;

import java.io.IOException;
import java.util.Scanner;

import static com.example.zoospringv1.ticketApp.Menus.menu;
import static com.example.zoospringv1.ticketApp.PriceConstants.*;


public class TicketApp extends Information implements TicketMachine, TicketService, TODOPay {
    static Scanner scanner = new Scanner(System.in);
    private int choose = menu();

    public TicketApp(final String normal, final int numberNormal, final String reduced, final int numberReduced) {
        super();
        this.numberNormal = numberNormal;
        this.numberReduced = numberReduced;
    }


    public void choose() {
        while (choose != 0) {
            switch (choose) {
                case 1:
                    printInformation();
                    break;
                case 2:
                    printInformation();
                    System.out.println("Wybierz rodzaj biletu:");
                    chooseATicketMenu();
                    break;
                case 3:
                    exitProgram();
                default:
                    throw new IllegalStateException("Unexpected value: " + choose);
            }
            System.out.println("\nWciśnij Enter, aby kontynuować...");
            try {
                System.in.read();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            choose = menu();
        }
        System.out.println("     ****************************************");
        System.out.println("\n     *  Koniec programu\n\n");
        exitProgram();
    }

    @Override
    public void chosenAnormalTicket() {
        System.out.println(YOU_CHOSEN + NORMAL_T + "\n" + ENTER_VALUE);
        numberOfTicketNormal();
        chooseMore();

    }

    @Override
    public void chosenAreducedTicket() {
        System.out.println(YOU_CHOSEN + REDUCED_T + "\n" + ENTER_VALUE);
        numberOfTicketReduced();
        chooseMore();
    }

    @Override
    public void chooseATicketMenu() {
        int optionNumber;
        optionNumber = scanner.nextInt();
        switch (optionNumber) {
            case 1 -> chosenAnormalTicket();
            case 2 -> chosenAreducedTicket();
            default -> System.out.println("Nie ma takiej możliwości.");
        }

    }

    private int numberNormal;

    int getNumberNormal() {
        numberNormal = scanner.nextInt();
        return numberNormal;
    }

    public void numberOfTicketNormal() {
        System.out.println("Wybrałeś: " + getNumberNormal() + " sztuki/ę ");
    }

    private int numberReduced;

    int getNumberReduced() {
        numberReduced = scanner.nextInt();
        return numberReduced;
    }

    public void numberOfTicketReduced() {
        System.out.println("Wybrałeś: " + getNumberReduced() + " sztuki/ę ");
    }

    int sumTicketN(int numberNormal) {
        int sum;
        sum = this.numberNormal + numberNormal;
        return sum;
    }

    int sumTicketR(int numberReduced) {
        int sum;
        sum = this.numberReduced + numberReduced;
        return sum;
    }

    @Override
    public void chooseMore() {
        System.out.println(">> Jeśli chcesz wybrać więcej biletów wpisz: (1) >> \n" + ">> Jeśli chcesz zsumować wybrane bilety:     (2) >> \n" + ">> Jeśli chcesz przejść do zapłaty wciśnij:  (3) >> ");
        int optionNumber;
        optionNumber = scanner.nextInt();
        if (optionNumber == 1) {
            printInformation();
            chooseATicketMenu();
        } else if (optionNumber == 2) {
            System.out.println(NORMAL_T + "- " + sumTicketN(numberNormal));
            System.out.println(REDUCED_T + "- " + sumTicketR(numberReduced));
            System.out.println("Suma wybranych biletów: " + (sumTicketN(numberNormal) + sumTicketR(numberReduced)));
            System.out.println(PRICE_TO_PAY + (sumTicketN(numberNormal) * PRICE + sumTicketR(numberReduced) * REDUCED_TICKET) + CURRENCY);
        } else {
            TODOpay();
        }
    }

    @Override
    public void TODOpay() {
        System.out.println("TODO: Płacę.");
    }

    public void exitProgram() {
        System.exit(0);
    }
}


