package com.techrunners;

import java.util.ArrayList;

public class Customer {
    public String name;
    private int customerId = 0;
    //public Stack<Ticket> tickets;
    ArrayList<Ticket> tickets = new ArrayList<>();

    Customer(String name) {
        this.name = name;
        customerId = customerId+1;
    }
    public int id() {
        return customerId;
    }
    void setTicket(Ticket ticket) {
        tickets.add(ticket);
    }
    Ticket getLatestTicket() {
        return tickets.get(tickets.size() - 1);
    }

}
