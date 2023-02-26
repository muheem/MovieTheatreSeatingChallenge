package com.techrunners;

public class Ticket {
    String[] seating;
    private int total_needed = 0;
    private int seats_filled = 0;
    private int customerId = 0;

    Ticket(int customerId, int seats) {
        this.total_needed = seats;
        this.seating = new String[seats];
        this.customerId = customerId;
    }

    public void  SetSeatNumber(String num) {
        seating[seats_filled] = num;
        ++seats_filled;
    }

    public boolean complete() {
        return seats_filled == total_needed;
    }

    public int unfilled() {
        return total_needed - seats_filled;
    }
}
