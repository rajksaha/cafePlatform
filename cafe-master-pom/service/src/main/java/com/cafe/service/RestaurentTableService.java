package com.cafe.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe.common.exception.CafeException;
import com.cafe.mybatis.domain.RestaurantTableData;
import com.cafe.mybatis.persistence.RestaurantTableMapper;

@Service
public class RestaurentTableService {
	
	@Autowired
	 private RestaurantTableMapper restaurentTableMapper;


	    public void create(RestaurantTableData data) throws CafeException {
	        this.restaurentTableMapper.create(data);
	    }

	    public void update(RestaurantTableData data) throws CafeException {
	        this.restaurentTableMapper.update(data);
	    }
	    
	    public Integer delete(Map<String, Object> params) throws CafeException {
	    	return this.restaurentTableMapper.delete(params);
	    }

	    public List<RestaurantTableData> getRestaurantTableByParam(Map<String, Object> params) throws CafeException {
	        return this.restaurentTableMapper.getRestaurantTableByParam(params);
	    }

	    public Integer getRestaurantTableCountByParam(Map<String, Object> params) throws CafeException {
	        return this.restaurentTableMapper.getRestaurantTableCountByParam(params);
	    }

	    public RestaurantTableData getWaiterByID(Integer tableID) throws CafeException {
	        return this.restaurentTableMapper.getRestaurantTableByID(tableID);
	    }

	    public Integer getDuplicateCount(Map<String, Object> params) throws CafeException {
	        return this.restaurentTableMapper.getDuplicateCount(params);
	    }

}
