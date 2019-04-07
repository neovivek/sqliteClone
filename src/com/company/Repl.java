package com.company;

import java.util.Scanner;

class Repl {
    private static Repl instance = null;
    private static Scanner scanner;

    static {
        scanner = new Scanner(System.in);
    }

    private Repl() {
    }

    /**
     * Method to get instance of singleton class
     *
     * @return Repl object
     */
    static Repl getInstance() {
        if (instance == null) {
            instance = new Repl();
        }
        return instance;
    }

    /**
     * Method to start the repl
     */
    void run() {
        this.printWelcomePrompt();
        while (true) {
            this.printPrompt();
            String command = this.readCommands();
            if (command.equals(".exit")) {
                break;
            } else {
                System.out.println("Invalid transaction request");
            }
        }
    }

    /**
     * Welcome message printer
     */
    private void printWelcomePrompt(){
        System.out.println("Welcome to Malasite db");
        System.out.println("Enter sql commands to be executed in each line");
        System.out.println("Enter .exit to exit the application");
    }

    /**
     * Method to print prompt to the command line
     */
    private void printPrompt() {
        System.out.print("db > ");
    }

    /**
     * Method to read commands
     *
     * @return command that is fed from the repl
     */
    private String readCommands() {
        String command = scanner.nextLine();
        while (command.isEmpty()) {
            this.printPrompt();
        }
        return command;
    }
}
