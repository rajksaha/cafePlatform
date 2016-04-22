package com.cafe.mybatis.domain;

import java.sql.Timestamp;

/**
 * Created by raj on 4/21/2016.
 */
public class SearchData {

    private Integer entityID;
    private String entityType;
    private String entityName;
    private Timestamp entityStartDate;
    private Timestamp entityEndDate;


    public Integer getEntityID() {
        return entityID;
    }

    public void setEntityID(Integer entityID) {
        this.entityID = entityID;
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public Timestamp getEntityStartDate() {
        return entityStartDate;
    }

    public void setEntityStartDate(Timestamp entityStartDate) {
        this.entityStartDate = entityStartDate;
    }

    public Timestamp getEntityEndDate() {
        return entityEndDate;
    }

    public void setEntityEndDate(Timestamp entityEndDate) {
        this.entityEndDate = entityEndDate;
    }
}
