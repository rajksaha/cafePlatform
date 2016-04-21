package com.cafe.mybatis.persistence;

import com.cafe.common.exception.CafeException;
import com.cafe.mybatis.domain.RestaurantData;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 4/11/2016.
 */
public interface RestaurantMapper {

    void create(RestaurantData data) throws CafeException;

    void update(RestaurantData data) throws CafeException;

    List<RestaurantData> getRestaurantByParam(Map<String, Object> params) throws CafeException;

    Integer getRestaurantCountByParam(Map<String, Object> params) throws CafeException;

    RestaurantData getRestaurantByID(Integer divisionId) throws CafeException;

    Integer getDuplicateCount(Map<String, Object> params) throws CafeException;
    
    Integer delete(Map<String, Object> params) throws CafeException;
}
