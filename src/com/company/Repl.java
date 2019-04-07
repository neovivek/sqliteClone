package com.company;

import java.util.Scanner;

class Repl {
    private static Repl instance = null;
    private static Scanner scanner;
    private static Logger logger;

    private MetaCommand metaCommand;
    private PrepareStatement prepareStatement;

    static {
        scanner = new Scanner(System.in);
        logger = new Logger();
    }

    private Repl() {
        this.metaCommand = new MetaCommand();
        this.prepareStatement = new PrepareStatement();
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
            logger.printPrompt();
            String command = this.readCommands();
            if (command.isEmpty()) {
                continue;
            }
            if (command.substring(0, 1).equals(".")) {
                this.metaCommand.process(command);
            } else {
                Statement statement = new Statement();
                this.prepareStatement.process(command, statement);
                String result = statement.execute();
                logger.printErrorMessage(result);
            }
        }
    }

    /**
     * Welcome message printer
     */
    private void printWelcomePrompt() {
        System.out.println("Welcome to Malasite db");
        System.out.println("Enter sql commands to be executed in each line");
        System.out.println("Enter .exit to exit the application");
    }

    /**
     * Method to read commands
     *
     * @return command that is fed from the repl
     */
    private String readCommands() {
        String command = scanner.nextLine();
        if (command.isEmpty()) {
            logger.printErrorMessage("Empty request received");
        }
        return command;
    }
}
