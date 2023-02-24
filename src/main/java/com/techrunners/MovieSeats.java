package com.techrunners;

import java.security.InvalidParameterException;


public class MovieSeats {

    enum Occupied { EMPTY, FILLED };

    static final int MAX_SEATS_IN_ONE_ALLOCATION = 3;

    static final int TOTAL_SEATS = 15; // may not be a constant
    int remaining_seats = TOTAL_SEATS;

    Occupied[] seats = new Occupied[TOTAL_SEATS];
    int next_free = 0;
    Ticket ticket;


    public Ticket AllocateSeating(int n) {
        ticket = null; // delete for now.
        ticket = new Ticket(n);

        boolean allocated = false;

        if ( n <=  0)
            throw new InvalidParameterException("Invalid amout: " + n + " specified/");
        if ( n > MAX_SEATS_IN_ONE_ALLOCATION)
            throw new InvalidParameterException("amount: " + n + " greater than " + MAX_SEATS_IN_ONE_ALLOCATION);

        for (int i = next_free; i < TOTAL_SEATS ; i++) {
            if (seats[i] == Occupied.FILLED)
                continue;
            seats[i] = Occupied.FILLED;
            ticket.SetSeatNumber(i);
            next_free++;
            if (ticket.complete())
                break;
        }

        System.out.print("Seats available= ");
        for (int i = 0; i < TOTAL_SEATS; i++) {
            System.out.print( seats[i] + " ");
        }
        System.out.println("");

        return ticket;
    }

}
