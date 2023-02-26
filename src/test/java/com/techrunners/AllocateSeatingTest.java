package com.techrunners;

import org.junit.jupiter.api.Test;

//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.CsvFileSource;
import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Random;
import static java.lang.Math.*;

public class AllocateSeatingTest {

    @Test
    public void CheckAllocatingFirstSeats() {
        MovieScreen seating = new MovieScreen();
        Ticket ticket = null;
        try {
            ticket = seating.AllocateSeating(3);
        } catch (MovieScreenSoldOutException e) {
            System.out.print( "Unexpected exception" + e);
        };
        assertEquals( "A1", ticket.seating[0]);
        assertEquals( "A2", ticket.seating[1]);
        assertEquals( "A3", ticket.seating[2]);
        assertEquals( true, ticket.complete());
        }

    @Test
    public void CheckAllocatingNextNextThreeSeats() {
        MovieScreen seating = new MovieScreen();
        Ticket ticket=null, ticket2=null;
        try {
            ticket =  seating.AllocateSeating(3);
            ticket2 =  seating.AllocateSeating(3);
        } catch (MovieScreenSoldOutException e) {
            System.out.print( "Unexpected exception" + e);
        };

        assertEquals( "A4", ticket2.seating[0]);
        assertEquals( "A5", ticket2.seating[1]);
        assertEquals( "B1", ticket2.seating[2]);
        assertEquals( true, ticket2.complete());
    }

    @Test
    public void CheckAllocatingAfterAllFilled() {
        MovieScreen seating = new MovieScreen();
        Ticket ticket=null, ticket2=null, ticket3=null, ticket4=null, ticket5=null, ticket6=null;
        try {
            ticket =  seating.AllocateSeating(3);
            ticket2 =  seating.AllocateSeating(3);
            ticket3 =  seating.AllocateSeating(3);
            ticket4 =  seating.AllocateSeating(3);
            ticket5 =  seating.AllocateSeating(3);
            Exception exception = assertThrows(MovieScreenSoldOutException.class, () -> {
                seating.AllocateSeating(3);
            });
        } catch (MovieScreenSoldOutException e) {
            assertTrue(e.getMessage().contains("SOLD OUT! No more seats available."));
        };
    }


    @Test
    public void CheckInvalidInputForAllocateSeating() {
        MovieScreen seating = new MovieScreen();
        Ticket ticket;

        // Test a seat number too large.
        Exception exception = assertThrows(InvalidParameterException.class, () -> {
            seating.AllocateSeating(4);
        });
        assertTrue(exception.getMessage().contains("Seating amount: 4 greater than 3"));

        // Test a seat number too small.
        exception = assertThrows(InvalidParameterException.class, () -> {
            seating.AllocateSeating(0);
        });
        assertTrue(exception.getMessage().contains("Invalid seating amount: 0 specified."));
    }


    @Test
    public void CheckFillingUpAllSeatingInAllocateSeating() {
        MovieScreen seating = new MovieScreen();
        Ticket ticket;

        Random rand = new Random();
        int upperbound = 3;

        Exception exception = assertThrows(MovieScreenSoldOutException.class, () -> {
            for (int i = 0; i < seating.TOTAL_SEATS; i++) {
                seating.AllocateSeating(rand.nextInt(upperbound)+1);
            }
        });
        
        assertTrue(exception.getMessage().contains("Cannot Allocate Seats."));
    }
}
