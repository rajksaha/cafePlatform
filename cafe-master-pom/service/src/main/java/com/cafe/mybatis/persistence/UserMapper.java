package com.cafe.mybatis.persistence;

import com.cafe.common.exception.CafeException;
import com.cafe.mybatis.domain.UserData;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 3/19/2016.
 */
public interface UserMapper {


    void create(UserData data) throws CafeException;

    void update(UserData data) throws CafeException;

    List<UserData> getUserByParam(Map<String, Object> params) throws CafeException;

    Integer getUserCountByParam(Map<String, Object> params) throws CafeException;

    UserData getUserByID(Integer userID) throws CafeException;

    Integer getDuplicateCount(Map<String, Object> params) throws CafeException;

    Integer delete(Map<String, Object> params) throws CafeException;

    UserData getUserByUserName(String username) throws CafeException;
}
