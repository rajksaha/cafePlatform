package com.cafe.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe.common.exception.BfpbException;
import com.cafe.mybatis.domain.OrderByProductData;
import com.cafe.mybatis.persistence.OrderByProductMapper;

@Service
public class OrderByProductService {
	
	@Autowired
	 private OrderByProductMapper orderByProductMapper;


	    public void create(OrderByProductData data) throws BfpbException {
	        this.orderByProductMapper.create(data);
	    }

	    public void update(OrderByProductData data) throws BfpbException {
	        this.orderByProductMapper.update(data);
	    }
	    
	    public Integer delete(Map<String, Object> params) throws BfpbException {
	    	return this.orderByProductMapper.delete(params);
	    }

	    public List<OrderByProductData> getOrderByProductByParam(Map<String, Object> params) throws BfpbException {
	        return this.orderByProductMapper.getOrderByProductByParam(params);
	    }

	    public Integer getOrderByProductCountByParam(Map<String, Object> params) throws BfpbException {
	        return this.orderByProductMapper.getOrderByProductCountByParam(params);
	    }

	    public OrderByProductData getOrderByProductByID(Integer orderByProductID) throws BfpbException {
	        return this.orderByProductMapper.getOrderByProductByID(orderByProductID);
	    }

	    public Integer getDuplicateCount(Map<String, Object> params) throws BfpbException {
	        return this.orderByProductMapper.getDuplicateCount(params);
	    }

}
