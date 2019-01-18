package com.wyt.travelShare.service.impl;

import java.util.List;

import com.wyt.travelShare.dao.IUserDAO;
import com.wyt.travelShare.dao.impl.UserDAO;
import com.wyt.travelShare.domain.User;
import com.wyt.travelShare.service.ITravelShareService;

public class TravelShareService implements ITravelShareService{

	
	IUserDAO dao = new UserDAO();

	@Override
	public User Login(String name, String password) {
		return dao.login(name,password);
	}

	@Override
	public List<User> findAll() {
		return dao.findAll();
	}

	@Override
	public void register(User user) {
		dao.register(user);
	}

	@Override
	public void deleteUser(int id) {
		dao.deleteUser(id);
	}

	@Override
	public void updateUser(User user) {
		dao.updateUser(user);
	}

	@Override
	public void searchById(String id) {
		dao.searchById(id);
	}

	@Override
	public void searchByName(String name) {
		dao.searchByName(name);
	}

	@Override
	public List<User> search(String sql) {
		return dao.search(sql);
	}
	
	

}
