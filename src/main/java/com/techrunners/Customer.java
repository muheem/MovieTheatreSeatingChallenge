package com.techrunners;

import java.util.Stack;
public class Customer {
    Customer(String name) {
        this.name = name;
        customerID = customerID+1;
    }
    public int id() {
        return customerID;
    }
    public String name;
    private int customerID = 0;
    public Stack<Ticket> tickets;
}
