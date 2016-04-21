package com.cafe.mybatis.persistence;

import com.cafe.common.exception.CafeException;
import com.cafe.mybatis.domain.ProductData;

import java.util.List;
import java.util.Map;

public interface ProductMapper {

    void create(ProductData data) throws CafeException;

    void update(ProductData data) throws CafeException;

    List<ProductData> getProductByParam(Map<String, Object> params) throws CafeException;

    Integer getProductCountByParam(Map<String, Object> params) throws CafeException;

    ProductData getProductByID(Integer productID) throws CafeException;

    Integer getDuplicateCount(Map<String, Object> params) throws CafeException;
    
    Integer delete(Map<String, Object> params) throws CafeException;
}
