package com.cafe.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe.common.exception.CafeException;
import com.cafe.mybatis.domain.ProductData;
import com.cafe.mybatis.persistence.ProductMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProductService {

	@Autowired
	private ProductMapper productMapper;

	/**
	 * Author: farzia
	 * create new Product
	 * @param ProductData productData
	 * @return void
	 * @throws CafeException
	 **/

	public void create (ProductData productData) throws CafeException {
		productMapper.create(productData);
	}

	/**
	 * Author: farzia
	 * update Product
	 * @param ProductData productData
	 * @return void
	 * @throws CafeException
	 **/

	public void update(ProductData productData) throws CafeException {
		this.productMapper.update(productData);
	}

	/**
	 * Author: farzia
	 * delete Product
	 * @param HashMap
	 * @return Integer
	 * @throws CafeException
	 **/


	public Integer delete(Map<String, Object> params) throws CafeException {
		return this.productMapper.delete(params);
	}

	/**
	 * Author: farzia
	 * gets Product by parm
	 * @param HashMap
	 * @return List
	 * @throws CafeException
	 **/

	public List<ProductData> getProductByParam(Map<String, Object> params) throws CafeException {
		return this.productMapper.getProductByParam(params);
	}

	/**
	 * Author: farzia
	 * gets Product count by parm
	 * @param HashMap
	 * @return Integer
	 * @throws CafeException
	 **/

	public Integer getProductCountByParam(Map<String, Object> params) throws CafeException {
		return this.productMapper.getProductCountByParam(params);
	}

	/**
	 * Author: farzia
	 * gets Product by id
	 * @param productID
	 * @return ProductData
	 * @throws CafeException
	 **/

	public ProductData getProductByID(Integer productID) throws CafeException {
		return this.productMapper.getProductByID(productID);
	}

	/**
	 * Author: farzia
	 * counts duplicate Product
	 * @param HashMap
	 * @return Integer
	 * @throws CafeException
	 **/

	public Integer getDuplicateCount(Map<String, Object> params) throws CafeException {
		return this.productMapper.getDuplicateCount(params);
	}
}