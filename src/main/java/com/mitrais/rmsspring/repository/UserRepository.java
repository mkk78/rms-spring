package com.mitrais.rmsspring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mitrais.rmsspring.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	Optional<User> findByUserName(String userName);
}
