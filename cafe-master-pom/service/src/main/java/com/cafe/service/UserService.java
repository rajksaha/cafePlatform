package com.cafe.service;

import com.cafe.common.exception.CafeException;
import com.cafe.mybatis.domain.UserData;
import com.cafe.mybatis.persistence.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 4/11/16.
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;


    public void create(UserData data) throws CafeException {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        data.setPassword(passwordEncoder.encode(data.getPassword()));
        this.userMapper.create(data);
    }

    public void update(UserData data) throws CafeException {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        data.setPassword(passwordEncoder.encode(data.getPassword()));
        this.userMapper.update(data);
    }
    
    public Integer delete(Map<String, Object> params) throws CafeException {
    	return this.userMapper.delete(params);
    }

    public List<UserData> getUserByParam(Map<String, Object> params) throws CafeException {
        return this.userMapper.getUserByParam(params);
    }

    public Integer getUserCountByParam(Map<String, Object> params) throws CafeException {
        return this.userMapper.getUserCountByParam(params);
    }

    public UserData getUserByID(Integer userID) throws CafeException {
        return this.userMapper.getUserByID(userID);
    }

    public Integer getDuplicateCount(Map<String, Object> params) throws CafeException {
        return this.userMapper.getDuplicateCount(params);
    }

    public UserData getUserByUserName(String userName) throws CafeException {
        return this.userMapper.getUserByUserName(userName);
    }
}
