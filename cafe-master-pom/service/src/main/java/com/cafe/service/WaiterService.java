package com.cafe.service;

import java.util.List;
import java.util.Map;

import com.cafe.common.exception.CafeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe.mybatis.domain.WaiterData;
import com.cafe.mybatis.persistence.WaiterMapper;


@Service
public class WaiterService {
	
	@Autowired
	 private WaiterMapper waiterMapper;


	    public void create(WaiterData data) throws CafeException {
	        this.waiterMapper.create(data);
	    }

	    public void update(WaiterData data) throws CafeException {
	        this.waiterMapper.update(data);
	    }
	    
	    public Integer delete(Map<String, Object> params) throws CafeException {
	    	return this.waiterMapper.delete(params);
	    }

	    public List<WaiterData> getWaiterByParam(Map<String, Object> params) throws CafeException {
	        return this.waiterMapper.getWaiterByParam(params);
	    }

	    public Integer getWaiterCountByParam(Map<String, Object> params) throws CafeException {
	        return this.waiterMapper.getWaiterCountByParam(params);
	    }

	    public WaiterData getWaiterByID(Integer waiterID) throws CafeException {
	        return this.waiterMapper.getWaiterByID(waiterID);
	    }

	    public Integer getDuplicateCount(Map<String, Object> params) throws CafeException {
	        return this.waiterMapper.getDuplicateCount(params);
	    }

}
