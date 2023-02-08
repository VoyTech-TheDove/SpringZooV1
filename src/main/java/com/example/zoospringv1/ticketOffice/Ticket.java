package com.example.zoospringv1.ticketOffice;

public class Ticket {
    int numberOfTickets;

    public Ticket(final int numberOfTickets, final String ticketNormal, Currency pln) {
        this.numberOfTickets = numberOfTickets;
    }

    public Ticket() {
    }

    public int getNumberOfTickets() {
        return this.numberOfTickets;
    }
}
