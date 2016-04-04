package com.cafe.common.type;

/**
 * Created by mamun on 1/25/16.
 */
public enum AuditEntityName {
    DIVISION("Division");

    private String shortName;

    AuditEntityName(String shortName) {
        this.setShortName(shortName);
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
}
