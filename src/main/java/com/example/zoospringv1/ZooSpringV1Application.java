package com.example.zoospringv1;

import com.example.zoospringv1.ticketOffice.Currency;
import com.example.zoospringv1.ticketOffice.Ticket;
import com.example.zoospringv1.ticketOffice.TicketType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ZooSpringV1Application {
    public static void main(String[] args) {

        SpringApplication.run(ZooSpringV1Application.class, args);

        Ticket ticketNormal = new Ticket(4, TicketType.ticketNormal, Currency.PLN);
        Ticket ticketReduced = new Ticket(4, TicketType.ticketReduced, Currency.PLN);

        System.out.println("Sprzedano: " + ticketNormal.getNumberOfTickets() + " normalne bilety.");
        System.out.println("Sprzedano: " + ticketReduced.getNumberOfTickets() + " ulgowe bilety.");
        System.out.print("W sumie zakupiono: " + ((ticketNormal.getNumberOfTickets()) + (ticketReduced.getNumberOfTickets())) + " wszystkich biletów.");
    }
}