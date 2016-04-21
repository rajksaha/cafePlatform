package com.cafe.mybatis.persistence;

import java.util.List;
import java.util.Map;

import com.cafe.common.exception.BfpbException;
import com.cafe.mybatis.domain.MainOrderData;
import com.cafe.mybatis.domain.RestaurantTableData;

public interface MainOrderMapper {
	

	 void create(MainOrderData data) throws BfpbException;

	 void update(MainOrderData data) throws BfpbException;

     List<MainOrderData> getMainOrderByParam(Map<String, Object> params) throws BfpbException;

     Integer getMainOrderCountByParam(Map<String, Object> params) throws BfpbException;
     
     MainOrderData getMainOrderByID(Integer orderID) throws BfpbException;
	
     Integer getDuplicateCount(Map<String, Object> params) throws BfpbException;
	    
     Integer delete(Map<String, Object> params) throws BfpbException;


}
