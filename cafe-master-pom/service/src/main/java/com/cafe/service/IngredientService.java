package com.cafe.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe.common.exception.BfpbException;
import com.cafe.mybatis.domain.IngredientData;
import com.cafe.mybatis.persistence.IngredientMapper;

@Service
public class IngredientService {
	
	 @Autowired
	    private IngredientMapper ingredientMapper;


	    public void create(IngredientData data) throws BfpbException {
	        this.ingredientMapper.create(data);
	    }

	    public void update(IngredientData data) throws BfpbException {
	        this.ingredientMapper.update(data);
	    }
	    
	    public Integer delete(Map<String, Object> params) throws BfpbException {
	    	return this.ingredientMapper.delete(params);
	    }

	    public List<IngredientData> getIngredientByParam(Map<String, Object> params) throws BfpbException {
	        return this.ingredientMapper.getIngredientByParam(params);
	    }

	    public Integer getIngredientCountByParam(Map<String, Object> params) throws BfpbException {
	        return this.ingredientMapper.getIngredientCountByParam(params);
	    }

	    public IngredientData getIngredientByID(Integer ingredientID) throws BfpbException {
	        return this.ingredientMapper.getIngredientByID(ingredientID);
	    }

	    public Integer getDuplicateCount(Map<String, Object> params) throws BfpbException {
	        return this.ingredientMapper.getDuplicateCount(params);
	    }
	

}
