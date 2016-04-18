package com.cafe.mybatis.domain;

public class RestaurantTableData {
	
	private Integer tableID;
	private Integer restaurantID;
	private Integer level;
	private String name;
	private String commentOrder;

	private String restaurantName;
	
	public Integer getTableID() {
		return tableID;
	}
	public void setTableID(Integer tableID) {
		this.tableID = tableID;
	}
	public Integer getRestaurantID() {
		return restaurantID;
	}
	public void setRestaurantID(Integer restaurantID) {
		this.restaurantID = restaurantID;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCommentOrder() {
		return commentOrder;
	}
	public void setCommentOrder(String commentOrder) {
		this.commentOrder = commentOrder;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
}
