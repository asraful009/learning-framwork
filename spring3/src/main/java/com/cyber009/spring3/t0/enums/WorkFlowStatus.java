package com.cyber009.spring3.t0.enums;

public enum WorkFlowStatus {
    IN_PROGRESS("IN_PROGRESS"),
    PENDING("PENDING"),
    CLOSED("CLOSED"),
    UNDEFINED("UNDEFINED");

    private final String DB_PROPERTY;

    WorkFlowStatus(String DB_PROPERTY) {
        this.DB_PROPERTY = DB_PROPERTY;
    }

    public String getDB_PROPERTY() {
        return DB_PROPERTY;
    }

}
