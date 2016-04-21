package com.cafe.service;

import java.util.List;
import java.util.Map;

import com.cafe.common.exception.CafeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe.mybatis.domain.OrderByProductData;
import com.cafe.mybatis.persistence.OrderByProductMapper;

/**
 * 
 * @author Salis on 4/12/16
 * @version 1.0
 *
 */

@Service
public class OrderByProductService {
	
	@Autowired
	 private OrderByProductMapper orderByProductMapper;

	/** 
	 * create new order by Product
	 * @param OrderByProductData data
	 * @return void
	 * @throws CafeException
	 **/
	
	    public void create(OrderByProductData data) throws CafeException {
	        this.orderByProductMapper.create(data);
	    }

	    /**
		 * update Order by Product
		 * @param OrderByProductData data
		 * @return void
		 * @throws CafeException
		 **/
	    
	    
	    public void update(OrderByProductData data) throws CafeException {
	        this.orderByProductMapper.update(data);
	    }
	    
	    /**
		 * delete Order by Product
		 * @param HashMap
		 * @return Integer
		 * @throws CafeException
		 **/
	    
	    public Integer delete(Map<String, Object> params) throws CafeException {
	    	return this.orderByProductMapper.delete(params);
	    }

	    /**
		 * gets Product by param
		 * @param HashMap
		 * @return List
		 * @throws CafeException
		 **/
	    
	    public List<OrderByProductData> getOrderByProductByParam(Map<String, Object> params) throws CafeException {
	        return this.orderByProductMapper.getOrderByProductByParam(params);
	    }

	    /**
		 * gets order by Product count by param
		 * @param HashMap
		 * @return Integer
		 * @throws CafeException
		 **/
	    
	    public Integer getOrderByProductCountByParam(Map<String, Object> params) throws CafeException {
	        return this.orderByProductMapper.getOrderByProductCountByParam(params);
	    }

	    /**
		 * gets order by Product by id
		 * @param orderByProductID
		 * @return OrderByProductData
		 * @throws CafeException
		 **/
	    
	    public OrderByProductData getOrderByProductByID(Integer orderByProductID) throws CafeException {
	        return this.orderByProductMapper.getOrderByProductByID(orderByProductID);
	    }

	    /**
		 * counts duplicate orderbyProduct
		 * @param HashMap
		 * @return Integer
		 * @throws CafeException
		 **/
	    
	    public Integer getDuplicateCount(Map<String, Object> params) throws CafeException {
	        return this.orderByProductMapper.getDuplicateCount(params);
	    }

}
