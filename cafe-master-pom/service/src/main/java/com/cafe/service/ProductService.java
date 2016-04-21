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

/**
 * 
 * @author Salis on 4/12/16
 * @version 1.0
 *
 */

@Service
public class ProductService {

	@Autowired
	private ProductMapper productMapper;

	/**
	 * create new Product
	 * @param ProductData productData
	 * @return void
	 * @throws CafeException
	 **/

	public void create (ProductData productData) throws CafeException {
		productMapper.create(productData);
	}

	/**
	 * update Product
	 * @param ProductData productData
	 * @return void
	 * @throws CafeException
	 **/

	public void update(ProductData productData) throws CafeException {
		this.productMapper.update(productData);
	}

	/**
	 * delete Product
	 * @param HashMap
	 * @return Integer
	 * @throws CafeException
	 **/


	public Integer delete(Map<String, Object> params) throws CafeException {
		return this.productMapper.delete(params);
	}

	/**
	 * gets Product by parm
	 * @param HashMap
	 * @return List
	 * @throws CafeException
	 **/

	public List<ProductData> getProductByParam(Map<String, Object> params) throws CafeException {
		return this.productMapper.getProductByParam(params);
	}

	/**
	 * gets Product count by parm
	 * @param HashMap
	 * @return Integer
	 * @throws CafeException
	 **/

	public Integer getProductCountByParam(Map<String, Object> params) throws CafeException {
		return this.productMapper.getProductCountByParam(params);
	}

	/**
	 * gets Product by id
	 * @param productID
	 * @return ProductData
	 * @throws CafeException
	 **/

	public ProductData getProductByID(Integer productID) throws CafeException {
		return this.productMapper.getProductByID(productID);
	}

	/**
	 * counts duplicate Product
	 * @param HashMap
	 * @return Integer
	 * @throws CafeException
	 **/

	public Integer getDuplicateCount(Map<String, Object> params) throws CafeException {
		return this.productMapper.getDuplicateCount(params);
	}
}