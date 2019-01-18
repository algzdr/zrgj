package com.wyt.shoppingCar.service.impl;

import java.util.List;

import com.wyt.shoppingCar.dao.IGoodsDAO;
import com.wyt.shoppingCar.dao.impl.GoodsDAO;
import com.wyt.shoppingCar.domain.Goods;
import com.wyt.shoppingCar.service.IShoppingCarService;

public class ShoppingCarService implements IShoppingCarService{

	IGoodsDAO dao = new GoodsDAO();

	@Override
	public List<Goods> findAll() {
		
		return dao.findAll();
	}
	
}
