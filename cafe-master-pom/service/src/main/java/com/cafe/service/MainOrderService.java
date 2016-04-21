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

@Service
public class MainOrderService {
	
	@Autowired
	private MainOrderMapper mainOrderMapper;

	@Autowired
	private OrderByProductMapper orderByProductMapper;


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

	    public void update(MainOrderData data) throws CafeException {
	        this.mainOrderMapper.update(data);
			if(data.getSubOrderList() != null){
				this.addOrUpdateSubOrder(data);
			}
	    }

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
	    
	    public Integer delete(Map<String, Object> params) throws CafeException {
	    	return this.mainOrderMapper.delete(params);
	    }

	    public List<MainOrderData> getMainOrderByParam(Map<String, Object> params) throws CafeException {
	        return this.mainOrderMapper.getMainOrderByParam(params);
	    }

	    public Integer getMainOrderCountByParam(Map<String, Object> params) throws CafeException {
	        return this.mainOrderMapper.getMainOrderCountByParam(params);
	    }

	    public MainOrderData getMainOrderByID(Integer orderID) throws CafeException {
	        return this.mainOrderMapper.getMainOrderByID(orderID);
	    }

	    public Integer getDuplicateCount(Map<String, Object> params) throws CafeException {
	        return this.mainOrderMapper.getDuplicateCount(params);
	    }

}
