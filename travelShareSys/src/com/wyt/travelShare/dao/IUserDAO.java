package com.wyt.travelShare.dao;

import java.util.List;

import com.wyt.travelShare.domain.User;

public interface IUserDAO {

	
	/**
	 * 用户登录
	 * @param name
	 * @param password
	 * @return
	 */
	User login(String name, String password);
	
	List<User> findAll();
	
	/**
	 * 用户注册
	 * @param user
	 */
	void register(User user);
	
	/**
	 * 删除用户信息
	 * @param id
	 */
	void deleteUser(int id);

	/**
	 * 修改用户信息
	 * @param user
	 */
	void updateUser(User user);

	/**
	 * 通过id搜索
	 * @param id
	 */
	void searchById(String id);

	/**
	 * 通过name查找
	 * @param name
	 */
	void searchByName(String name);

	List<User> search(String sql);
	
}
