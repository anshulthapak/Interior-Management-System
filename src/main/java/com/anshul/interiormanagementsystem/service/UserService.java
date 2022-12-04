package com.anshul.interiormanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.anshul.interiormanagementsystem.entity.User;
import com.anshul.interiormanagementsystem.repo.UserRepository;

@Service
public class UserService{

	@Autowired
	private UserRepository userRepo;
	
	public User saveUser(User u) {
		return userRepo.save(u);
	}
	
	public List<User> saveAllUser(List<User> users){
		return (List<User>) userRepo.saveAll(users);
	}
	
	public User getUserById(Long id) {
		return userRepo.findById(id).orElse(null);
	}
	
//	public Item getItemByName(String name, String brand) {
//		return itemRepo.findByNameAndBrand(name,brand);
//	}
	
	public List<User> getAllUser(){
		return userRepo.findAll(Sort.by(Sort.Direction.DESC,"date"));
	}
	
	public void updateUser(User i) {
		userRepo.save(i);
	}
	
	public void deleteUser(User i) {
		userRepo.delete(i);
	}
	

}
