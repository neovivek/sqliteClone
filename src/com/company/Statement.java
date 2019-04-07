package com.company;

public class Statement {
    private StatementType type;

    enum StatementType {
        INSERT("insert"), SELECT("select");

        private String keyword;

        StatementType(String keyword) {
            this.keyword = keyword;
        }

        public String getKeyword() {
            return this.keyword;
        }
    }

    public Statement() {
    }

    public StatementType getType() {
        return type;
    }

    public void setType(StatementType type) {
        this.type = type;
    }

    public String execute() {
        try {
            switch (this.getType()) {
                case INSERT:
                    return "This is where we would do an insert";
                case SELECT:
                    return "This is where we would do a select";
                default:
                    return "";
            }
        } catch (Exception e) {
            return ""; // currently just return empty string
        }
    }
}
