package com.wyt.shoppingCar.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.wyt.shoppingCar.Utils.MyDBUtils;
import com.wyt.shoppingCar.dao.IGoodsDAO;
import com.wyt.shoppingCar.domain.Goods;

public class GoodsDAO implements IGoodsDAO{

	@Override
	public List<Goods> findAll() {
		QueryRunner runner = new QueryRunner(MyDBUtils.getDataSource());
		try {
			return runner.query("select * from goods", new BeanListHandler<Goods>(Goods.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	
}
