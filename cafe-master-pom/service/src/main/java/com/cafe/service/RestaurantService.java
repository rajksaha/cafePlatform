package com.cafe.service;

import com.cafe.common.exception.CafeException;
import com.cafe.mybatis.domain.RestaurantData;
import com.cafe.mybatis.persistence.RestaurantMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by farzia on 1/13/16.
 */
@Service
public class RestaurantService {

    @Autowired
    private RestaurantMapper restaurantMapper;


    public void create(RestaurantData data) throws CafeException {
        this.restaurantMapper.create(data);
    }

    public void update(RestaurantData data) throws CafeException {
        this.restaurantMapper.update(data);
    }
    
    public Integer delete(Map<String, Object> params) throws CafeException {
    	return this.restaurantMapper.delete(params);
    }

    public List<RestaurantData> getRestaurantByParam(Map<String, Object> params) throws CafeException {
        return this.restaurantMapper.getRestaurantByParam(params);
    }

    public Integer getRestaurantCountByParam(Map<String, Object> params) throws CafeException {
        return this.restaurantMapper.getRestaurantCountByParam(params);
    }

    public RestaurantData getRestaurantByID(Integer RestaurantID) throws CafeException {
        return this.restaurantMapper.getRestaurantByID(RestaurantID);
    }

    public Integer getDuplicateCount(Map<String, Object> params) throws CafeException {
        return this.restaurantMapper.getDuplicateCount(params);
    }
}
