package com.example.zoospringv1;


import com.example.zoospringv1.ticketApp.TicketApp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.example.zoospringv1.ticketApp.PriceConstants.*;


@SpringBootApplication
public class ZooSpringV1Application {
    public static void main(String[] args) {

        SpringApplication.run(ZooSpringV1Application.class, args);
        TicketApp ticketOffice = new TicketApp(NORMAL_T, 0, REDUCED_T, 0);
        ticketOffice.choose();

    }


}