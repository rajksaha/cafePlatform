package com.cafe.mybatis.persistence;

import com.cafe.common.exception.BfpbException;
import com.cafe.mybatis.domain.RestaurantData;
import com.cafe.mybatis.domain.UserData;
import com.cafe.mybatis.domain.UserGroupPermissionData;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 3/19/2016.
 */
public interface UserMapper {


    void create(UserData data) throws BfpbException;

    void update(UserData data) throws BfpbException;

    List<UserData> getUserByParam(Map<String, Object> params) throws BfpbException;

    Integer getUserCountByParam(Map<String, Object> params) throws BfpbException;

    UserData getUserByID(Integer userID) throws BfpbException;

    Integer getDuplicateCount(Map<String, Object> params) throws BfpbException;

    Integer delete(Map<String, Object> params) throws BfpbException;
}
