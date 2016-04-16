package com.cafe.mybatis.persistence;

import java.util.List;
import java.util.Map;

import com.cafe.common.exception.BfpbException;
import com.cafe.mybatis.domain.IngredientData;
import com.cafe.mybatis.domain.WaiterData;

public interface IngredientMapper {
	
	void create(IngredientData data) throws BfpbException;

	 void update(IngredientData data) throws BfpbException;

	 List<IngredientData> getIngredientByParam(Map<String, Object> params) throws BfpbException;

	 Integer getIngredientCountByParam(Map<String, Object> params) throws BfpbException;

	 IngredientData getIngredientByID(Integer ingredientID) throws BfpbException;

	 Integer getDuplicateCount(Map<String, Object> params) throws BfpbException;
	    
	 Integer delete(Map<String, Object> params) throws BfpbException;

}
