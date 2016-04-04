package com.cafe.mybatis.domain;

import java.util.List;

/**
 * Created by raj on 3/20/2016.
 */
public class RaydarUserDetail {

    private List<UserGroupPermissionData> userGroupPermissionDataList;

    public List<UserGroupPermissionData> getUserGroupPermissionDataList() {
        return userGroupPermissionDataList;
    }

    public void setUserGroupPermissionDataList(List<UserGroupPermissionData> userGroupPermissionDataList) {
        this.userGroupPermissionDataList = userGroupPermissionDataList;
    }
}
