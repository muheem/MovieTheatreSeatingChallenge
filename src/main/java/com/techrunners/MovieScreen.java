package com.techrunners;

import java.security.InvalidParameterException;

public class MovieScreen {

    enum Occupied { EMPTY, FILLED };

    static final int MAX_SEATS_IN_ONE_ALLOCATION = 3;

    public static final int TOTAL_SEATS = 15; // may not be a constant
    int remaining_seats = TOTAL_SEATS;

    Occupied[] seats = new Occupied[TOTAL_SEATS];
    int next_free = 0;
    Ticket ticket;


    public Ticket AllocateSeating(int n) throws MovieScreenSoldOutException {

        if ( n <=  0)
            throw new InvalidParameterException("Invalid seating amount: " + n + " specified.");
        if ( n > MAX_SEATS_IN_ONE_ALLOCATION)
            throw new InvalidParameterException("Seating amount: " + n + " greater than " + MAX_SEATS_IN_ONE_ALLOCATION);
        if (remaining_seats == 0)
            throw new MovieScreenSoldOutException("Cannot Allocate Seats. SOLD OUT!");
        if (remaining_seats < n)
                throw new MovieScreenSoldOutException("Cannot Allocate Seats. Only " + (n - ticket.unfilled()) + " seats available");

        ticket = null; // delete for now.
        ticket = new Ticket(n);

        boolean allocated = false;

        for (int i = next_free; i < TOTAL_SEATS ; i++) {
            if (seats[i] == Occupied.FILLED)
                continue;
            seats[i] = Occupied.FILLED;
            ticket.SetSeatNumber(i);
            remaining_seats--;
            next_free++;
            if (ticket.complete())
                break;
        }

        /*
        System.out.print("Seats available= ");
        for (int i = 0; i < TOTAL_SEATS; i++) {
            System.out.print( seats[i] + " ");
        }
        System.out.println("");
*/
        return ticket;
    }

}
