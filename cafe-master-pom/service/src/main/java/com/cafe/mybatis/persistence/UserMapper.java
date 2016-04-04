package com.cafe.mybatis.persistence;

import com.cafe.common.exception.BfpbException;
import com.cafe.mybatis.domain.UserGroupPermissionData;

import java.util.List;

/**
 * Created by raj on 3/19/2016.
 */
public interface UserMapper {

    public List<UserGroupPermissionData> getUserPermissionByUserID(Integer userID) throws BfpbException;
}
