package com.example.zoospringv1.ticketApp;

import static com.example.zoospringv1.ticketApp.PriceConstants.*;

public class Information {

    public void printInformation() {
        System.out.println(">> Bilety do wyboru:\n1. " + NORMAL_T + ". " + PRICE_TO_PAY + PRICE + CURRENCY +
                "\n2. " + REDUCED_T + ". " + PRICE_TO_PAY + REDUCED_TICKET + CURRENCY + "(50% ceny biletu normalnego, dla dzieci do lat 10.)\n>> ");
    }

}
