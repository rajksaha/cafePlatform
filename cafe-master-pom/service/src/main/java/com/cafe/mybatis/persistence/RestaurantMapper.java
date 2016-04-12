package com.cafe.mybatis.persistence;

import com.cafe.common.exception.BfpbException;
import com.cafe.mybatis.domain.RestaurantData;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 4/11/2016.
 */
public interface RestaurantMapper {

    void create(RestaurantData data) throws BfpbException;

    void update(RestaurantData data) throws BfpbException;

    List<RestaurantData> getRestaurantByParam(Map<String, Object> params) throws BfpbException;

    Integer getRestaurantCountByParam(Map<String, Object> params) throws BfpbException;

    RestaurantData getRestaurantByID(Integer divisionId) throws BfpbException;

    Integer getDuplicateCount(Map<String, Object> params) throws BfpbException;
    
    Integer delete(Map<String, Object> params) throws BfpbException;
}
