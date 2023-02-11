package com.example.zoospringv1.ticketOffice;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "ticketoffices")
public class TicketOffice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "Ticket office descriptions cannot be empty.")
    private String description;
    private boolean done;

    public TicketOffice() {
    }

    public void setId(final int id) {
        this.id = id;
    }

   public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    void setDescription(final String description) {
        this.description = description;
    }

    public boolean isDone() {
        return done;
    }

    void setDone(final boolean done) {
        this.done = done;
    }
}
