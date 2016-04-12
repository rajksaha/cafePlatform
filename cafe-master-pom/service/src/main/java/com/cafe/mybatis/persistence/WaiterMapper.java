package com.cafe.mybatis.persistence;

import java.util.List;
import java.util.Map;

import com.cafe.common.exception.BfpbException;
import com.cafe.mybatis.domain.RestaurantTableData;
import com.cafe.mybatis.domain.WaiterData;

public interface WaiterMapper {

	
	 void create(WaiterData data) throws BfpbException;

	 void update(WaiterData data) throws BfpbException;

	 List<WaiterData> getWaiterByParam(Map<String, Object> params) throws BfpbException;

	 Integer getWaiterCountByParam(Map<String, Object> params) throws BfpbException;

	 WaiterData getWaiterByID(Integer waiterID) throws BfpbException;

	 Integer getDuplicateCount(Map<String, Object> params) throws BfpbException;
	    
	 Integer delete(Map<String, Object> params) throws BfpbException;

}

