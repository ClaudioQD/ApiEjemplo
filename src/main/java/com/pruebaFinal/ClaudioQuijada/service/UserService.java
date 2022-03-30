package com.pruebaFinal.ClaudioQuijada.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.pruebaFinal.ClaudioQuijada.dao.RoleRepository;
import com.pruebaFinal.ClaudioQuijada.dao.UserRepository;
import com.pruebaFinal.ClaudioQuijada.models.User;

@Service
public class UserService {

	// Leer 1
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public void saveWithUserRole(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRoles(roleRepository.findByName("ROLE_USER"));
		userRepository.save(user);

	}

	public void saveWithAdminRole(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRoles(roleRepository.findByName("ROLE_ADMIN"));
		userRepository.save(user);

	}

	//Reade one by username
	public User findByUserName(String username) {
		return userRepository.findByUsername(username);

	}
	//Reade one by id
	public User findUserById(Long id) {
		Optional<User> optionalUser = userRepository.findById(id);
		if (optionalUser.isPresent()) {
			return optionalUser.get();
		} else {
			return null;
		}
	}
	//Reade one  by email
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	//Reade all
	public List<User> findAllUsers(){
		return userRepository.findAll();
				
	}
	
	//create user
	public void createUser(User user) {
		 userRepository.save(user);
		
	}
	
	//update
	public void updateUser(User user) {
		 userRepository.save(user);
	}
	//delete
	
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}


}
