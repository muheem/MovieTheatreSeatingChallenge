package com.techrunners;

import java.security.InvalidParameterException;


public class AllocateSeating {

    enum Occupied { EMPTY, FILLED };

    static final int MAX_SEATS_IN_ONE_ALLOCATION = 3;
    static final int SEATING_ROWS = 3;
    static  final int SEATS_IN_A_ROWS = 5;

    static final int TOTAL_SEATS = 15; // may not be a constant
    int remaining_seats = TOTAL_SEATS;

    Occupied[] seats = new Occupied[TOTAL_SEATS];
    int next_free = 0;
    Ticket ticket;

    AllocateSeating(int amount) {
        this.ticket = new Ticket(amount);
    }

    public void  SetSeatNumber(int index) {
        // seats from 0 to max.
        // find row
        char row_letter = (char) (index % SEATS_IN_A_ROWS + 'A');
        int seat_number =  (index / SEATING_ROWS) + 1;

        ticket.seating[ticket.seats_filled] = String.valueOf(row_letter) + seat_number;
        ++ticket.seats_filled;

    }
    public Ticket GetAllocation() {

        boolean allocated = false;

        if (ticket.total_needed <=  0)
            throw new InvalidParameterException("Invalid amout: " + ticket.total_needed + " specified/");
        if (ticket.total_needed > MAX_SEATS_IN_ONE_ALLOCATION)
            throw new InvalidParameterException("amount: " + ticket.total_needed + " greater than " + MAX_SEATS_IN_ONE_ALLOCATION);

        for (int i = next_free; i < ticket.total_needed; i++) {
            if (seats[i] == Occupied.EMPTY)
                continue;
            seats[i] = Occupied.FILLED;
            SetSeatNumber(i);
        }

        System.out.print("Seats available= ");
        for (int i = 0; i < TOTAL_SEATS; i++) {
            System.out.print( seats[i] + " ");
        }
        System.out.println("");

        return ticket;
    }

}
