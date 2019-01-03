package com.mitrais.rmsspring.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mitrais.rmsspring.model.User;
import com.mitrais.rmsspring.repository.UserRepository;
import com.mitrais.rmsspring.security.MyUserPrincipal;

@Service
public class MyUserDetailService implements UserDetailsService {

	@Autowired
	UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = userRepo.findByUserName(username);
		user.orElseThrow(() -> new UsernameNotFoundException("Username Not Found"));
		
		UserDetails myUserDetail = new MyUserPrincipal(user.get());
		return myUserDetail;
	}

}
