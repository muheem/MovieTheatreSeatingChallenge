package com.techrunners;

import org.junit.jupiter.api.Test;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.CsvFileSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.awt.Point;

public class AllocateSeatingTest {

    @Test
    public void CheckAllocatingFirstSeats() {

        AllocateSeating seating = new AllocateSeating(1);
        Ticket ticket =  seating.GetAllocation();
        assertEquals( "A1", ticket.seating[0]);

        }

}
