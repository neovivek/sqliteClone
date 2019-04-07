package com.company;

public class PrepareStatement {

    enum PrepareResult {
        PREAPRE_SUCCESS("Prepare successful"),
        PREPARE_UNRECOGNIZED_STATEMENT("Unrecognized prepare statement");

        String description;

        PrepareResult(String desc){
            this.description = desc;
        }

        /**
         * Method to get result description
         * @return
         */
        public String getDescription(){
            return this.description;
        }
    }
}
