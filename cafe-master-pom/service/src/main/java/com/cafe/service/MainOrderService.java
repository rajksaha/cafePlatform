package com.cafe.service;


import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.cafe.common.exception.CafeException;
import com.cafe.mybatis.domain.OrderByProductData;
import com.cafe.mybatis.persistence.OrderByProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe.mybatis.domain.MainOrderData;
import com.cafe.mybatis.persistence.MainOrderMapper;

/**
 * 
 * @author Farzia on 4/10/16
 * @version 1.0
 *
 */ 

@Service
public class MainOrderService {
	
	@Autowired
	private MainOrderMapper mainOrderMapper;

	@Autowired
	private OrderByProductMapper orderByProductMapper;

	/**
	 * create new MainOrderData
	 * @param MainOrderData mainorderData
	 * @return void
	 * @throws CafeException
	 **/

	    public void create(MainOrderData data) throws CafeException {
			Date date = new Date();
			data.setDate(date);
			date.getTime();
			data.setTime(new Timestamp(date.getTime()));
	        this.mainOrderMapper.create(data);

			if(data.getSubOrderList() != null){
				this.addOrUpdateSubOrder(data);
			}
	    }

	    
	    /**
		 * update MainOrderData
		 * @param MainOrderData
		 * @return void
		 * @throws CafeException
		 **/
	    
	    public void update(MainOrderData data) throws CafeException {
	        this.mainOrderMapper.update(data);
			if(data.getSubOrderList() != null){
				this.addOrUpdateSubOrder(data);
			}
	    }
	    
	    /**
		 * add/update SubOrder
		 * @param MainOrderData mainorderData
		 * @return void
		 * @throws CafeException
		 **/

	private void addOrUpdateSubOrder(MainOrderData mainOrderData)throws CafeException {

		for(OrderByProductData subOrder : mainOrderData.getSubOrderList()){

			subOrder.setOrderID(mainOrderData.getOrderID());
			if(subOrder.getOrderByProductID() != null){
				this.orderByProductMapper.update(subOrder);
			}else{
				this.orderByProductMapper.create(subOrder);
			}
		}
	}
	
	/**
	 * delete MainOrder
	 * @param HashMap
	 * @return Integer
	 * @throws CafeException
	 **/
	    
	    public Integer delete(Map<String, Object> params) throws CafeException {
	    	return this.mainOrderMapper.delete(params);
	    }
	    
	    /**
		 * gets MainOrderData by parm
		 * @param HashMap
		 * @return List
		 * @throws CafeException
		 **/


	    public List<MainOrderData> getMainOrderByParam(Map<String, Object> params) throws CafeException {
	        return this.mainOrderMapper.getMainOrderByParam(params);
	    }

	    /**
		 * gets MainOrder count by parm
		 * @param HashMap
		 * @return Integer
		 * @throws CafeException
		 **/
	    
	    
	    public Integer getMainOrderCountByParam(Map<String, Object> params) throws CafeException {
	        return this.mainOrderMapper.getMainOrderCountByParam(params);
	    }

	    /**
		 * gets MainOrder by id
		 * @param orderID
		 * @return OrderData
		 * @throws CafeException
		 **/
	    
	    public MainOrderData getMainOrderByID(Integer orderID) throws CafeException {
	        return this.mainOrderMapper.getMainOrderByID(orderID);
	    }

	    /**
		 * counts duplicate MainOrder
		 * @param HashMap
		 * @return Integer
		 * @throws CafeException
		 **/
	    
	    public Integer getDuplicateCount(Map<String, Object> params) throws CafeException {
	        return this.mainOrderMapper.getDuplicateCount(params);
	    }

}
