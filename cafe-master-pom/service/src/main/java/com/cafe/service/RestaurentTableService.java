package com.cafe.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe.common.exception.CafeException;
import com.cafe.mybatis.domain.RestaurantTableData;
import com.cafe.mybatis.persistence.RestaurantTableMapper;

/**
 * 
 * @author Farzia on 4/10/16
 * @version 1.0
 *
 */

@Service
public class RestaurentTableService {
	
	@Autowired
	 private RestaurantTableMapper restaurentTableMapper;

	/**
	 * create new RestaurantTable
	 * @param RestaurantTableData data
	 * @return void
	 * @throws CafeException
	 **/
	
	    public void create(RestaurantTableData data) throws CafeException {
	        this.restaurentTableMapper.create(data);
	    }
	    
	    /**
		 * update RestaurantTable
		 * @param RestaurantTableData data
		 * @return void
		 * @throws CafeException
		 **/

	    public void update(RestaurantTableData data) throws CafeException {
	        this.restaurentTableMapper.update(data);
	    }
	    
	    /**
		 * delete RestaurantTable
		 * @param HashMap
		 * @return Integer
		 * @throws CafeException
		 **/
	    
	    public Integer delete(Map<String, Object> params) throws CafeException {
	    	return this.restaurentTableMapper.delete(params);
	    }
	    
	    /**
		 * gets RestaurantTable by param
		 * @param HashMap
		 * @return List
		 * @throws CafeException
		 **/

	    public List<RestaurantTableData> getRestaurantTableByParam(Map<String, Object> params) throws CafeException {
	        return this.restaurentTableMapper.getRestaurantTableByParam(params);
	    }

	    /**
		 * gets RestaurantTable count by param
		 * @param HashMap
		 * @return Integer
		 * @throws CafeException
		 **/
	    
	    public Integer getRestaurantTableCountByParam(Map<String, Object> params) throws CafeException {
	        return this.restaurentTableMapper.getRestaurantTableCountByParam(params);
	    }
	    
	    /**
		 * gets Waiter by id
		 * @param tableID
		 * @return RestaurantTableData
		 * @throws CafeException
		 **/

	    public RestaurantTableData getRestaurantTableByID(Integer tableID) throws CafeException {
	        return this.restaurentTableMapper.getRestaurantTableByID(tableID);
	    }

	    
	    /**
		 * counts duplicate RestaurantTable
		 * @param HashMap
		 * @return Integer
		 * @throws CafeException
		 **/
	    
	    public Integer getDuplicateCount(Map<String, Object> params) throws CafeException {
	        return this.restaurentTableMapper.getDuplicateCount(params);
	    }

}
