package com.workshop.workshop.util.exeptions;

public class OptionsAreNull extends RuntimeException{
    private static final String ERROR_MESSAGE = "... are null, change the ... type or write the ... ";

    public OptionsAreNull() {
        super(String.format(ERROR_MESSAGE));
    }
}
