package com.company;

public class MetaCommand {

    enum MetaCommandType {
        META_COMMAND_EXIT(".exit", "Exit command"),
        META_COMMAND_UNREOGNIZED_COMMAND("", "Unrecognized meta command");

        String description;
        String command;

        MetaCommandType(String command, String description) {
            this.command = command;
            this.description = description;
        }

        /**
         * Method to get command type description
         *
         * @return description of command type
         */
        public String getDescription() {
            return this.description;
        }

        public String getCommand() {
            return this.command;
        }
    }

    /**
     * Method to process meta command
     */
    public void process(String command) {
        if (command.equalsIgnoreCase(MetaCommandType.META_COMMAND_EXIT.getCommand())) {
            System.exit(0);
        } else {

        }
    }
}
