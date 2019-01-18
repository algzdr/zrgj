package com.wyt.travelShare.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.wyt.travelShare.dao.IUserDAO;
import com.wyt.travelShare.domain.User;
import com.wyt.travelShare.util.MyDBUtils;

public class UserDAO implements IUserDAO{
	
	User user;
	@Override
	public User login(String name, String password) {
		QueryRunner runner = new QueryRunner(MyDBUtils.getDataSource());
		try {
			user = runner.query("select * from user where UserName=? and Password=?", new BeanHandler<User>(User.class),name,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	@Override
	public List<User> findAll() {
		QueryRunner runner = new QueryRunner(MyDBUtils.getDataSource());
		try {
			return runner.query("select * from user", new BeanListHandler<User>(User.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public void register(User user) {
		QueryRunner runner = new QueryRunner(MyDBUtils.getDataSource());
		try {
			runner.update("insert into user value(null,?,?,?)",user.getUserName(),user.getPassword(),user.getPhoneNum());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void deleteUser(int id) {
		QueryRunner runner = new QueryRunner(MyDBUtils.getDataSource());
		try {
			runner.update("delete from user where UserId=?",id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void updateUser(User user) {
		QueryRunner runner = new QueryRunner(MyDBUtils.getDataSource());
		try {
			runner.update("update user set UserName=?,Password=?,PhoneNum=? where UserId=?",user.getUserName(),user.getPassword(),user.getPhoneNum(),user.getUserId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void searchById(String id) {
		QueryRunner runner = new QueryRunner(MyDBUtils.getDataSource());
		try {
			runner.query("select * from user where UserId=?", new BeanHandler<User>(User.class),id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void searchByName(String name) {
		QueryRunner runner = new QueryRunner(MyDBUtils.getDataSource());
		try {
			runner.query("select * from user where UserName=?", new BeanHandler<User>(User.class),name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public List<User> search(String sql) {
		QueryRunner runner = new QueryRunner(MyDBUtils.getDataSource());
		try {
			return runner.query(sql, new BeanListHandler<User>(User.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
