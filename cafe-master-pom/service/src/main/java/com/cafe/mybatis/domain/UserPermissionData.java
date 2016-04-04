package com.cafe.mybatis.domain;

/**
 * Created by raj on 3/19/2016.
 */
public class UserPermissionData extends Base{

    private Integer userPermissionID;
    private Integer companyModuleID;
    private String functionCode;
    private String shortName;

    public Integer getUserPermissionID() {
        return userPermissionID;
    }

    public void setUserPermissionID(Integer userPermissionID) {
        this.userPermissionID = userPermissionID;
    }

    public Integer getCompanyModuleID() {
        return companyModuleID;
    }

    public void setCompanyModuleID(Integer companyModuleID) {
        this.companyModuleID = companyModuleID;
    }

    public String getFunctionCode() {
        return functionCode;
    }

    public void setFunctionCode(String functionCode) {
        this.functionCode = functionCode;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
}
