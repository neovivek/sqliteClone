package com.company;

public class Logger {

    public Logger() {
    }

    /**
     * Method to print error message and prompt user
     *
     * @param message message to be printed on the console
     */
    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    /**
     * Method to print prompt to the command line
     */
    public void printPrompt() {
        System.out.print("db > ");
    }
}
