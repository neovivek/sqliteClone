package com.company;

import static com.company.Statement.StatementType;

public class PrepareStatement {

    private static Logger logger;

    static {
        logger = new Logger();
    }

    enum PrepareResult {
        PREAPRE_SUCCESS("Prepare successful"),
        PREPARE_UNRECOGNIZED_STATEMENT("Unrecognized prepare statement");

        String description;

        PrepareResult(String desc) {
            this.description = desc;
        }

        /**
         * Method to get result description
         *
         * @return
         */
        public String getDescription() {
            return this.description;
        }
    }

    /**
     * Method to prepare statement for execution
     *
     * @param command   command as fetched from repl
     * @param statement statement object to be modified
     */
    public void process(String command, Statement statement) {
        String[] parts = command.split("[ ]");
        try {
            switch (StatementType.valueOf(parts[0].toUpperCase())) {
                case INSERT:
                    statement.setType(StatementType.INSERT);
                    break;
                case SELECT:
                    statement.setType(StatementType.SELECT);
                    break;
                default:
                    logger.printErrorMessage("Unrecognized keyword " + parts[0] + " at the start of \"" + command + "\"");
            }
        } catch (IllegalArgumentException e) {
            logger.printErrorMessage("Unrecognized keyword " + parts[0] + " at the start of \"" + command + "\"");
        }
    }
}
