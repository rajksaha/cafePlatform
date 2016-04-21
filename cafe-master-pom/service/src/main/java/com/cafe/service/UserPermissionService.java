package com.cafe.service;

import com.cafe.common.exception.CafeException;
import com.cafe.mybatis.domain.UserGroupPermissionData;
import com.cafe.mybatis.persistence.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by raj on 3/19/2016.
 */
@Service
public class UserPermissionService {

    @Autowired
    private UserMapper userMapper;

    public List<UserGroupPermissionData> getUserPermissionByUserID (Integer userID) throws CafeException {
        return null;
    }
}
