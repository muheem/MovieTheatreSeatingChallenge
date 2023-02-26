package com.techrunners;

public class Ticket {
    String[] seating;
    private int total_needed = 0;
    private int seats_filled = 0;

    static  final int SEATS_IN_A_ROWS = 5;
    private int customerId = 0;

    Ticket(int customerId, int seats) {
        this.total_needed = seats;
        this.seating = new String[seats];
        this.customerId = customerId;
    }

    public void  SetSeatNumber(int index) {
        // seats from 0 to max.
        // find row
        char row_letter = (char)(index / SEATS_IN_A_ROWS + 'A');
        int seat_number = (index % SEATS_IN_A_ROWS) + 1;

        seating[seats_filled] = String.valueOf(row_letter) + seat_number;
        ++seats_filled;
    }

    public boolean complete() {
        return seats_filled == total_needed;
    }

    public int unfilled() {
        return total_needed - seats_filled;
    }
}
