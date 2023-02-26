package com.techrunners;

import java.security.InvalidParameterException;

public class MovieScreen {

    enum Occupied { EMPTY, FILLED };

    String[] seatNumber = new String[TOTAL_SEATS];
    static final int MAX_SEATS_IN_ONE_ALLOCATION = 3;
    static  final int SEATS_IN_A_ROWS = 5;
    public static final int TOTAL_SEATS = 15; // may not be a constant
    int remaining_seats = TOTAL_SEATS;

    Occupied[] seats = new Occupied[TOTAL_SEATS];
    int next_free = 0;

    MovieScreen(){
        GenerateSeatNumbers();
    }
    public Ticket AllocateSeating(Customer customer, int n) throws MovieScreenSoldOutException {
        Ticket ticket = new Ticket(customer.id(), n);
        boolean allocated = false;

        if ( n <=  0)
            throw new InvalidParameterException("Invalid seating amount: " + n + " specified.");
        if ( n > MAX_SEATS_IN_ONE_ALLOCATION)
            throw new InvalidParameterException("Seating amount: " + n + " greater than " + MAX_SEATS_IN_ONE_ALLOCATION);
        if (remaining_seats == 0)
            throw new MovieScreenSoldOutException("Cannot Allocate Seats. SOLD OUT!");
        if (remaining_seats < n)
                throw new MovieScreenSoldOutException("Cannot Allocate Seats. Only " + (n - ticket.unfilled()) + " seats available");

        for (int i = next_free; i < TOTAL_SEATS ; i++) {
            if (seats[i] == Occupied.FILLED)
                continue;
            seats[i] = Occupied.FILLED;
            ticket.SetSeatNumber(seatNumber[i]);
            remaining_seats--;
            next_free++;
            if (ticket.complete())
                break;
        }
        return ticket;
    }

    public void  GenerateSeatNumbers() {
        char row_letter;
        int seat_number;

        for (int i = 0; i < TOTAL_SEATS; i++){
            row_letter = (char)(i / SEATS_IN_A_ROWS + 'A');
            seat_number = (i % SEATS_IN_A_ROWS) + 1;
            seatNumber[i] = String.valueOf(row_letter) + seat_number;
        }
    }

}
