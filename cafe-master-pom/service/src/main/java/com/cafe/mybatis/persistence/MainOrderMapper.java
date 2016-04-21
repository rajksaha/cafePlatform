package com.cafe.mybatis.persistence;

import java.util.List;
import java.util.Map;

import com.cafe.common.exception.CafeException;
import com.cafe.mybatis.domain.MainOrderData;

public interface MainOrderMapper {
	

	 void create(MainOrderData data) throws CafeException;

	 void update(MainOrderData data) throws CafeException;

     List<MainOrderData> getMainOrderByParam(Map<String, Object> params) throws CafeException;

     Integer getMainOrderCountByParam(Map<String, Object> params) throws CafeException;
     
     MainOrderData getMainOrderByID(Integer orderID) throws CafeException;
	
     Integer getDuplicateCount(Map<String, Object> params) throws CafeException;
	    
     Integer delete(Map<String, Object> params) throws CafeException;


}
