package com.techrunners;

import org.junit.jupiter.api.Test;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.CsvFileSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.awt.Point;

public class AllocateSeatingTest {

    @Test
    public void CheckAllocatingFirstSeats() {
        MovieSeats seating = new MovieSeats();
        Ticket ticket =  seating.AllocateSeating(3);
        assertEquals( "A1", ticket.seating[0]);
        assertEquals( "A2", ticket.seating[1]);
        assertEquals( "A3", ticket.seating[2]);
        assertEquals( true, ticket.complete());
        }

    @Test
    public void CheckAllocatingNextNextThreeSeats() {
        MovieSeats seating = new MovieSeats();
        Ticket ticket =  seating.AllocateSeating(3);
        Ticket ticket2 =  seating.AllocateSeating(3);
        assertEquals( "A4", ticket2.seating[0]);
        assertEquals( "A5", ticket2.seating[1]);
        assertEquals( "B1", ticket2.seating[2]);
        assertEquals( true, ticket2.complete());
    }

    @Test
    public void CheckAllocatingAfterAllFilled() {
        MovieSeats seating = new MovieSeats();
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

}
