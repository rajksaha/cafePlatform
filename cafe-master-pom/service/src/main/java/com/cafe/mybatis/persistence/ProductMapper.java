package com.cafe.mybatis.persistence;

import com.cafe.common.exception.BfpbException;
import com.cafe.mybatis.domain.Division;
import com.cafe.mybatis.domain.ProductData;
import com.cafe.mybatis.domain.RestaurantData;

import java.util.List;
import java.util.Map;

public interface ProductMapper {

    void create(ProductData data) throws BfpbException;

    void update(ProductData data) throws BfpbException;

    List<ProductData> getProductByParam(Map<String, Object> params) throws BfpbException;

    Integer getProductCountByParam(Map<String, Object> params) throws BfpbException;

    ProductData getProductByID(Integer productID) throws BfpbException;

    Integer getDuplicateCount(Map<String, Object> params) throws BfpbException;
    
    Integer delete(Map<String, Object> params) throws BfpbException;
}
