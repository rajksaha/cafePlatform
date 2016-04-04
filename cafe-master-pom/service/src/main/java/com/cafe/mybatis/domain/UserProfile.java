package com.cafe.mybatis.domain;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by asmrussel on 1/11/16.
 */

public class UserProfile extends Base {

    private Integer userProfileId;
    private String username;
    private String password;
    private Boolean isBlocked;
    private Integer status;
    private Boolean resetPassword;
    private Integer loginFailedAttempt;
    private Date blockedDate;
    private Date resetRequestDate;
    private List<UserGroupPermissionData> userGroupPermissionDataList;
    private String userType;
    private String email;
    private String phone;
    private String address;
    private String mobile;
    private Integer divisionId;
    private Integer companyId;
    private Integer agencyId;
    private Integer wingId;
    private Integer branchId;
    private Integer sectionId;
    private String fullName;
    private String designation;
    private Date appointmentDate;
    private Date releaseDate;
    private Map<String, Boolean> permissions;


    public Integer getUserProfileId() {
        return userProfileId;
    }

    public void setUserProfileId(Integer userProfileId) {
        this.userProfileId = userProfileId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Boolean getResetPassword() {
        return resetPassword;
    }

    public void setResetPassword(Boolean resetPassword) {
        this.resetPassword = resetPassword;
    }

    public Integer getLoginFailedAttempt() {
        return loginFailedAttempt;
    }

    public void setLoginFailedAttempt(Integer loginFailedAttempt) {
        this.loginFailedAttempt = loginFailedAttempt;
    }

    public Date getBlockedDate() {
        return blockedDate;
    }

    public void setBlockedDate(Date blockedDate) {
        this.blockedDate = blockedDate;
    }

    public Date getResetRequestDate() {
        return resetRequestDate;
    }

    public void setResetRequestDate(Date resetRequestDate) {
        this.resetRequestDate = resetRequestDate;
    }

    public Boolean getIsBlocked() {
        return isBlocked;
    }

    public void setIsBlocked(Boolean isBlocked) {
        this.isBlocked = isBlocked;
    }


    public Map<String, Boolean> getPermissions() {
        return permissions;
    }

    public void setPermissions(Map<String, Boolean> permissions) {
        this.permissions = permissions;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(Integer divisionId) {
        this.divisionId = divisionId;
    }

    public Integer getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(Integer agencyId) {
        this.agencyId = agencyId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }



    public Integer getWingId() {
        return wingId;
    }

    public void setWingId(Integer wingId) {
        this.wingId = wingId;
    }

    public Integer getBranchId() {
        return branchId;
    }

    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }

    public Integer getSectionId() {
        return sectionId;
    }

    public void setSectionId(Integer sectionId) {
        this.sectionId = sectionId;
    }

    public List<UserGroupPermissionData> getUserGroupPermissionDataList() {
        return userGroupPermissionDataList;
    }

    public void setUserGroupPermissionDataList(List<UserGroupPermissionData> userGroupPermissionDataList) {
        this.userGroupPermissionDataList = userGroupPermissionDataList;
    }
}
