package com.cafe.mybatis.persistence;

import java.util.List;
import java.util.Map;

import com.cafe.common.exception.CafeException;
import com.cafe.mybatis.domain.RestaurantTableData;

public interface RestaurantTableMapper {
	
	void create(RestaurantTableData data) throws CafeException;

	void update(RestaurantTableData data) throws CafeException;

    List<RestaurantTableData> getRestaurantTableByParam(Map<String, Object> params) throws CafeException;

    Integer getRestaurantTableCountByParam(Map<String, Object> params) throws CafeException;

	RestaurantTableData getRestaurantTableByID(Integer tableID) throws CafeException;

    Integer getDuplicateCount(Map<String, Object> params) throws CafeException;
	    
    Integer delete(Map<String, Object> params) throws CafeException;

}
