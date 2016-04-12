package com.cafe.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.cafe.common.exception.BfpbException;
import com.cafe.mybatis.domain.ProductData;
import com.cafe.mybatis.persistence.ProductMapper;

public class ProductService {

	@Autowired
	private ProductMapper productMapper;
	
	public void create (ProductData productData) throws BfpbException {
		productMapper.create(productData);
	}
}
