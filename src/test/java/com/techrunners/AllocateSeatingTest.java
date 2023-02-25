package com.techrunners;

import org.junit.jupiter.api.Test;

//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.CsvFileSource;
import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.*;

public class AllocateSeatingTest {

    @Test
    public void CheckAllocatingFirstSeats() {
        MovieScreen seating = new MovieScreen();
        Ticket ticket =  seating.AllocateSeating(3);
        assertEquals( "A1", ticket.seating[0]);
        assertEquals( "A2", ticket.seating[1]);
        assertEquals( "A3", ticket.seating[2]);
        assertEquals( true, ticket.complete());
        }

    @Test
    public void CheckAllocatingNextNextThreeSeats() {
        MovieScreen seating = new MovieScreen();
        Ticket ticket =  seating.AllocateSeating(3);
        Ticket ticket2 =  seating.AllocateSeating(3);
        assertEquals( "A4", ticket2.seating[0]);
        assertEquals( "A5", ticket2.seating[1]);
        assertEquals( "B1", ticket2.seating[2]);
        assertEquals( true, ticket2.complete());
    }

    @Test
    public void CheckAllocatingAfterAllFilled() {
        MovieScreen seating = new MovieScreen();
        Ticket ticket =  seating.AllocateSeating(3);
        Ticket ticket2 =  seating.AllocateSeating(3);
        Ticket ticket3 =  seating.AllocateSeating(3);
        Ticket ticket4 =  seating.AllocateSeating(3);
        Ticket ticket5 =  seating.AllocateSeating(3);
        Ticket ticket6 =  seating.AllocateSeating(3);
        assertEquals( null, ticket6.seating[0]);
        assertEquals( null, ticket6.seating[1]);
        assertEquals( null, ticket6.seating[2]);
        assertEquals( false, ticket6.complete());
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
}
