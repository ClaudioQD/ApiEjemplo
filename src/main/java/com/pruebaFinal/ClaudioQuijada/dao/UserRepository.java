package com.pruebaFinal.ClaudioQuijada.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pruebaFinal.ClaudioQuijada.models.User;

public interface UserRepository extends JpaRepository<User, Long>{

	List<User> findAll();
	
	User findByUsername(String username);
	
	User findByEmail(String email);
	
}
