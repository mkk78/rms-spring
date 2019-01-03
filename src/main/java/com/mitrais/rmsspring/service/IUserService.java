package com.mitrais.rmsspring.service;

import java.util.List;

import com.mitrais.rmsspring.model.User;

public interface IUserService {
	
	public List<User> retrieveAllUser();
	
	public void addUser(User user);
	
	public void deleteUser(Long id);
	
	public void updateUser(User user);
	
	public User findUser(Long id);
}
