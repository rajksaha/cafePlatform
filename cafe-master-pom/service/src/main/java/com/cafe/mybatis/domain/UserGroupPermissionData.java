package com.cafe.mybatis.domain;

/**
 * Created by raj on 3/19/2016.
 */
public class UserGroupPermissionData extends UserPermissionData{

    private Integer userGroupAssignmentID;
    private Integer userGroupID;
    private Integer userPermissionID;
    private Integer statusValue;

    public Integer getUserGroupAssignmentID() {
        return userGroupAssignmentID;
    }

    public void setUserGroupAssignmentID(Integer userGroupAssignmentID) {
        this.userGroupAssignmentID = userGroupAssignmentID;
    }

    public Integer getUserGroupID() {
        return userGroupID;
    }

    public void setUserGroupID(Integer userGroupID) {
        this.userGroupID = userGroupID;
    }

    public Integer getUserPermissionID() {
        return userPermissionID;
    }

    public void setUserPermissionID(Integer userPermissionID) {
        this.userPermissionID = userPermissionID;
    }

    public Integer getStatusValue() {
        return statusValue;
    }

    public void setStatusValue(Integer statusValue) {
        this.statusValue = statusValue;
    }
}
