package com.cafe.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe.common.exception.BfpbException;
import com.cafe.mybatis.domain.ProductData;
import com.cafe.mybatis.persistence.ProductMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProductService {

	@Autowired
	private ProductMapper productMapper;
	
	public void create (ProductData productData) throws BfpbException {
		productMapper.create(productData);
	}
	
	 public void update(ProductData productData) throws BfpbException {
			this.productMapper.update(productData);
		}

		public Integer delete(Map<String, Object> params) throws BfpbException {
			return this.productMapper.delete(params);
		}

		public List<ProductData> getProductByParam(Map<String, Object> params) throws BfpbException {
			return this.productMapper.getProductByParam(params);
		}

		public Integer getProductCountByParam(Map<String, Object> params) throws BfpbException {
			return this.productMapper.getProductCountByParam(params);
		}

		public ProductData getProductByID(Integer productID) throws BfpbException {
			return this.productMapper.getProductByID(productID);
		}

		public Integer getDuplicateCount(Map<String, Object> params) throws BfpbException {
			return this.productMapper.getDuplicateCount(params);
		}
}
