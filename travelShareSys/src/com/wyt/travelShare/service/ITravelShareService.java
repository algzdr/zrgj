package com.wyt.travelShare.service;

import java.util.List;

import com.wyt.travelShare.domain.User;

public interface ITravelShareService {

	/**
	 * 登录功能
	 * @param name
	 * @param password
	 * @return
	 */
	User Login(String name,String password);
	
	/**
	 * 查找所有员工信息
	 * @return
	 */
	List<User> findAll();
	
	/**
	 * 用户注册
	 * @param user
	 */
	void register(User user);
	
	/**
	 * 删除用户
	 */
	void deleteUser(int id);

	/**
	 * 修改用户
	 * @param user
	 */
	void updateUser(User user);

	/**
	 * 通过id搜索
	 * @param id
	 * @param name
	 */
	void searchById(String id);
	
	/**
	 * 通过名字搜索
	 * @param name
	 */
	void searchByName(String name);

	List<User> search(String sql);
}




