package com.wyt.shoppingCar.dao;

import java.util.List;

import com.wyt.shoppingCar.domain.Goods;

public interface IGoodsDAO {

	List<Goods> findAll();

}
