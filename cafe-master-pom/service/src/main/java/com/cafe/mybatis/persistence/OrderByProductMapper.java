package com.cafe.mybatis.persistence;

import java.util.List;
import java.util.Map;

import com.cafe.common.exception.BfpbException;
import com.cafe.mybatis.domain.OrderByProductData;
import com.cafe.mybatis.domain.RestaurantTableData;

public interface OrderByProductMapper {

	void create(OrderByProductData data) throws BfpbException;

	void update(OrderByProductData data) throws BfpbException;

    List<OrderByProductData> getOrderByProductByParam(Map<String, Object> params) throws BfpbException;

    Integer getOrderByProductCountByParam(Map<String, Object> params) throws BfpbException;

	OrderByProductData getOrderByProductByID(Integer orderByProductID) throws BfpbException;

    Integer getDuplicateCount(Map<String, Object> params) throws BfpbException;
	    
    Integer delete(Map<String, Object> params) throws BfpbException;
}
