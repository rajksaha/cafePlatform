package com.cafe.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe.common.exception.BfpbException;
import com.cafe.mybatis.domain.OrderByProductData;
import com.cafe.mybatis.domain.WaiterData;
import com.cafe.mybatis.persistence.OrderByProductMapper;
import com.cafe.mybatis.persistence.WaiterMapper;


@Service
public class WaiterService {
	
	@Autowired
	 private WaiterMapper waiterMapper;


	    public void create(WaiterData data) throws BfpbException {
	        this.waiterMapper.create(data);
	    }

	    public void update(WaiterData data) throws BfpbException {
	        this.waiterMapper.update(data);
	    }
	    
	    public Integer delete(Map<String, Object> params) throws BfpbException {
	    	return this.waiterMapper.delete(params);
	    }

	    public List<WaiterData> getWaiterByParam(Map<String, Object> params) throws BfpbException {
	        return this.waiterMapper.getWaiterByParam(params);
	    }

	    public Integer getWaiterCountByParam(Map<String, Object> params) throws BfpbException {
	        return this.waiterMapper.getWaiterCountByParam(params);
	    }

	    public WaiterData getWaiterByID(Integer waiterID) throws BfpbException {
	        return this.waiterMapper.getWaiterByID(waiterID);
	    }

	    public Integer getDuplicateCount(Map<String, Object> params) throws BfpbException {
	        return this.waiterMapper.getDuplicateCount(params);
	    }

}
