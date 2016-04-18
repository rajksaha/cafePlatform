package com.cafe.mybatis.domain;

import java.math.BigDecimal;

public class ProductData {
	
	private Integer productID;
	private Integer restaurantID;
	private String name;
	private BigDecimal price;
	private BigDecimal cost;

	private String restaurantName;
	
	public Integer getProductID() {
		return productID;
	}
	public void setProductID(Integer productID) {
		this.productID = productID;
	}
	public Integer getRestaurantID() {
		return restaurantID;
	}
	public void setRestaurantID(Integer restaurantID) {
		this.restaurantID = restaurantID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public BigDecimal getCost() {
		return cost;
	}
	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
}
