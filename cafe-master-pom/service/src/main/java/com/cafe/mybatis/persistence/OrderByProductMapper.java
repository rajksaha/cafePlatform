package com.cafe.mybatis.persistence;

import java.util.List;
import java.util.Map;

import com.cafe.common.exception.CafeException;
import com.cafe.mybatis.domain.OrderByProductData;

public interface OrderByProductMapper {

	void create(OrderByProductData data) throws CafeException;

	void update(OrderByProductData data) throws CafeException;

    List<OrderByProductData> getOrderByProductByParam(Map<String, Object> params) throws CafeException;

    Integer getOrderByProductCountByParam(Map<String, Object> params) throws CafeException;

	OrderByProductData getOrderByProductByID(Integer orderByProductID) throws CafeException;

    Integer getDuplicateCount(Map<String, Object> params) throws CafeException;
	    
    Integer delete(Map<String, Object> params) throws CafeException;
}
