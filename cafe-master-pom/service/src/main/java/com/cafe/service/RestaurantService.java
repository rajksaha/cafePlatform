package com.cafe.service;

import com.cafe.common.exception.CafeException;
import com.cafe.mybatis.domain.RestaurantData;
import com.cafe.mybatis.persistence.RestaurantMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 
 * Created by Farzia on 1/13/16.
 * @version 1.0
 * 
 */

@Service
public class RestaurantService {

    @Autowired
    private RestaurantMapper restaurantMapper;

    /**
	 * create new Restaurant
	 * @param RestaurantData restaurantData
	 * @return void
	 * @throws CafeException
	 **/
    
    public void create(RestaurantData data) throws CafeException {
        this.restaurantMapper.create(data);
    }
    
    /**
	 * update Restaurant
	 * @param RestaurantData restaurantData
	 * @return void
	 * @throws CafeException
	 **/

    public void update(RestaurantData data) throws CafeException {
        this.restaurantMapper.update(data);
    }
    
    /**
	 * delete Restaurant
	 * @param HashMap
	 * @return Integer
	 * @throws CafeException
	 **/
    
    public Integer delete(Map<String, Object> params) throws CafeException {
    	return this.restaurantMapper.delete(params);
    }
    
    /**
	 * gets Restaurant by param
	 * @param HashMap
	 * @return List
	 * @throws CafeException
	 **/

    public List<RestaurantData> getRestaurantByParam(Map<String, Object> params) throws CafeException {
        return this.restaurantMapper.getRestaurantByParam(params);
    }
    
    /**
	 * gets Restaurant count by parm
	 * @param HashMap
	 * @return Integer
	 * @throws CafeException
	 **/

    public Integer getRestaurantCountByParam(Map<String, Object> params) throws CafeException {
        return this.restaurantMapper.getRestaurantCountByParam(params);
    }
    
    /**
	 * gets Restaurant by id
	 * @param RestaurantID
	 * @return RestaurantData
	 * @throws CafeException
	 **/

    public RestaurantData getRestaurantByID(Integer RestaurantID) throws CafeException {
        return this.restaurantMapper.getRestaurantByID(RestaurantID);
    }
    
    /**
	 * counts duplicate Restaurant
	 * @param HashMap
	 * @return Integer
	 * @throws CafeException
	 **/
    
    public Integer getDuplicateCount(Map<String, Object> params) throws CafeException {
        return this.restaurantMapper.getDuplicateCount(params);
    }
}
