package com.mitrais.rmsspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.mitrais.rmsspring.model.User;
import com.mitrais.rmsspring.repository.UserRepository;

@Service
public class UserService implements IUserService {

	@Autowired UserRepository userRepo;

	@Override
	public List<User> retrieveAllUser() {
		return userRepo.findAll();
	}

	@Override
	public void addUser(User user) {
		user.setId(0L);
		user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(4)));
		userRepo.save(user);
	}

	@Override
	public void deleteUser(Long id) {
		userRepo.deleteById(id);;
	}

	@Override
	public User findUser(Long id) {
		return userRepo.findById(id).get();
	}

	@Override
	public void updateUser(User user) {
		user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(4)));
		userRepo.save(user);
	}
	
	
}
