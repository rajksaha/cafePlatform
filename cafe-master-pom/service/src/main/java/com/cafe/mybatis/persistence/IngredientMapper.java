package com.cafe.mybatis.persistence;

import java.util.List;
import java.util.Map;

import com.cafe.common.exception.CafeException;
import com.cafe.mybatis.domain.IngredientData;

public interface IngredientMapper {
	
	void create(IngredientData data) throws CafeException;

	 void update(IngredientData data) throws CafeException;

	 List<IngredientData> getIngredientByParam(Map<String, Object> params) throws CafeException;

	 Integer getIngredientCountByParam(Map<String, Object> params) throws CafeException;

	 IngredientData getIngredientByID(Integer ingredientID) throws CafeException;

	 Integer getDuplicateCount(Map<String, Object> params) throws CafeException;
	    
	 Integer delete(Map<String, Object> params) throws CafeException;

}
