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
 * 
 * Created by raj on 4/11/16.
 * @version 1.0
 * 
 */

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    /**
	 * create new UserData
	 * @param RestaurantTableData data
	 * @return void
	 * @throws CafeException
	 **/
    
    
    public void create(UserData data) throws CafeException {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        data.setPassword(passwordEncoder.encode(data.getPassword()));
        this.userMapper.create(data);
    }
    
    /**
	 * update UserData
	 * @param UserData data
	 * @return void
	 * @throws CafeException
	 **/

    public void update(UserData data) throws CafeException {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        data.setPassword(passwordEncoder.encode(data.getPassword()));
        this.userMapper.update(data);
    }
    
    /**
	 * delete user
	 * @param HashMap
	 * @return Integer
	 * @throws CafeException
	 **/
    
    public Integer delete(Map<String, Object> params) throws CafeException {
    	return this.userMapper.delete(params);
    }

    /**
	 * gets User by param
	 * @param HashMap
	 * @return List
	 * @throws CafeException
	 **/
    
    public List<UserData> getUserByParam(Map<String, Object> params) throws CafeException {
        return this.userMapper.getUserByParam(params);
    }
    
    /**
	 * gets User count by param
	 * @param HashMap
	 * @return Integer
	 * @throws CafeException
	 **/

    public Integer getUserCountByParam(Map<String, Object> params) throws CafeException {
        return this.userMapper.getUserCountByParam(params);
    }
    
    /**
	 * gets User by id
	 * @param userID
	 * @return UserData
	 * @throws CafeException
	 **/

    public UserData getUserByID(Integer userID) throws CafeException {
        return this.userMapper.getUserByID(userID);
    }

    /**
	 * counts duplicate User
	 * @param HashMap
	 * @return Integer
	 * @throws CafeException
	 **/
    
    public Integer getDuplicateCount(Map<String, Object> params) throws CafeException {
        return this.userMapper.getDuplicateCount(params);
    }
    
    /**
	 * gets user by Username 
	 * @param userName
	 * @return UserData
	 * @throws CafeException
	 **/

    public UserData getUserByUserName(String userName) throws CafeException {
        return this.userMapper.getUserByUserName(userName);
    }
}
