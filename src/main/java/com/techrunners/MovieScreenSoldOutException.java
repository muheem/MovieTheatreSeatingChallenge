package com.techrunners;

public class MovieScreenSoldOutException extends Exception {
    public MovieScreenSoldOutException(String errorMessage) {
        super(errorMessage);
    }
}
