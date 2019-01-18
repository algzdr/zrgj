package com.wyt.shoppingCar.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 购物车: 商品项的集合
 */
@SuppressWarnings("serial")
public class ShoppingCart implements Serializable{

	// 商品项集合
	private List<CartItem> items = new ArrayList<>();

	public List<CartItem> getItems() {
		return items;
	}

	public void setItems(List<CartItem> items) {
		this.items = items;
	}
	
	/**
	 * 添加商品到购物车
	 * @param item
	 *//*
	public List<CartItem> addItem(CartItem item) {
		// 如果该商品已经存在于购物车, 则加1
		for (CartItem cartItem : items) {
			if(item.getId().equals(cartItem.getId())) {
				cartItem.setNumber(cartItem.getNumber() + 1);
				return items;
			}
			
		}
		
		// 如果该商品没有存在于购物车, 则保存
		items.add(item);
		return items;
	}*/
	
	/**
	 * 删除商品
	 * @param id
	 */
	public void delItem(String id) {
		for (CartItem cartItem : items) {
			if(cartItem.getId().equals(id)) {
				items.remove(cartItem);
			}
		}
	}

}
