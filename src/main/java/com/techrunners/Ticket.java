package com.techrunners;

public class Ticket {
    String[] seating;
    int total_needed = 0;
    int seats_filled = 0;
    boolean filled = false;

    Ticket(int seats) {
        this.total_needed = seats;
        this.seating = new String[seats];
    }

}
