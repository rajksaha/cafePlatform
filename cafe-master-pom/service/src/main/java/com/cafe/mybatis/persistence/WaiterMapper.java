package com.cafe.mybatis.persistence;

import java.util.List;
import java.util.Map;

import com.cafe.common.exception.CafeException;
import com.cafe.mybatis.domain.WaiterData;

public interface WaiterMapper {

	
	 void create(WaiterData data) throws CafeException;

	 void update(WaiterData data) throws CafeException;

	 List<WaiterData> getWaiterByParam(Map<String, Object> params) throws CafeException;

	 Integer getWaiterCountByParam(Map<String, Object> params) throws CafeException;

	 WaiterData getWaiterByID(Integer waiterID) throws CafeException;

	 Integer getDuplicateCount(Map<String, Object> params) throws CafeException;
	    
	 Integer delete(Map<String, Object> params) throws CafeException;

}

