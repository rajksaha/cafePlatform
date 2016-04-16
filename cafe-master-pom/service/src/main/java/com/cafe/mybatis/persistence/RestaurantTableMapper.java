package com.cafe.mybatis.persistence;

import java.util.List;
import java.util.Map;

import com.cafe.common.exception.BfpbException;
import com.cafe.mybatis.domain.RestaurantData;
import com.cafe.mybatis.domain.RestaurantTableData;

public interface RestaurantTableMapper {
	
	void create(RestaurantTableData data) throws BfpbException;

	void update(RestaurantTableData data) throws BfpbException;

    List<RestaurantTableData> getRestaurantTableByParam(Map<String, Object> params) throws BfpbException;

    Integer getRestaurantTableCountByParam(Map<String, Object> params) throws BfpbException;

	RestaurantTableData getRestaurantTableByID(Integer tableID) throws BfpbException;

    Integer getDuplicateCount(Map<String, Object> params) throws BfpbException;
	    
    Integer delete(Map<String, Object> params) throws BfpbException;

}
