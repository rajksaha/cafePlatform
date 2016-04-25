package com.cafe.mybatis.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang.BooleanUtils;

import java.io.Serializable;

/**
 * Created by raj on 1/11/16.
 */
public class Base implements Serializable {

    private Boolean isSelected;

    @JsonIgnore
    private Boolean skipAudit;

    private Integer serial;     // used in pagination to show serial

    public Boolean getIsSelected() {
        return BooleanUtils.toBoolean(isSelected);
    }

    public void setIsSelected(Boolean isSelected) {
        this.isSelected = isSelected;
    }

    public Boolean getSkipAudit() {
        return skipAudit;
    }

    public void setSkipAudit(Boolean skipAudit) {
        this.skipAudit = skipAudit;
    }

    public Integer getSerial() {
        return serial;
    }

    public void setSerial(Integer serial) {
        this.serial = serial;
    }
}
