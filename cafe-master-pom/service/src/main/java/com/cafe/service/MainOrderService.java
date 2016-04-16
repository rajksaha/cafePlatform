package com.cafe.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe.common.exception.BfpbException;
import com.cafe.mybatis.domain.IngredientData;
import com.cafe.mybatis.domain.MainOrderData;
import com.cafe.mybatis.persistence.IngredientMapper;
import com.cafe.mybatis.persistence.MainOrderMappr;

@Service
public class MainOrderService {
	
	@Autowired
	 private MainOrderMappr mainOrderMapper;


	    public void create(MainOrderData data) throws BfpbException {
	        this.mainOrderMapper.create(data);
	    }

	    public void update(MainOrderData data) throws BfpbException {
	        this.mainOrderMapper.update(data);
	    }
	    
	    public Integer delete(Map<String, Object> params) throws BfpbException {
	    	return this.mainOrderMapper.delete(params);
	    }

	    public List<MainOrderData> getMainOrderByParam(Map<String, Object> params) throws BfpbException {
	        return this.mainOrderMapper.getMainOrderByParam(params);
	    }

	    public Integer getMainOrderCountByParam(Map<String, Object> params) throws BfpbException {
	        return this.mainOrderMapper.getMainOrderCountByParam(params);
	    }

	    public MainOrderData getMainOrderByID(Integer orderID) throws BfpbException {
	        return this.mainOrderMapper.getMainOrderByID(orderID);
	    }

	    public Integer getDuplicateCount(Map<String, Object> params) throws BfpbException {
	        return this.mainOrderMapper.getDuplicateCount(params);
	    }

}
