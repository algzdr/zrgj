package com.wyt.shoppingCar.domain;

import java.io.Serializable;

/**
 * 商品项, 就是购物车中的每一类商品
 */
@SuppressWarnings("serial")
public class CartItem implements Serializable{

	// 商品id
	private String id;
	// 商品名称
	private String name;
	// 购买数量
	private Integer number;
	// 商品单价
	private Double price;
	//价格
	private Double oneTotalPrice;

	public CartItem() {
		super();
	}

	public CartItem(String id, String name, Integer number, Double price) {
		super();
		this.id = id;
		this.name = name;
		this.number = number;
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "CartItem [id=" + id + ", name=" + name + ", number=" + number + ", price=" + price + "]";
	}

}
