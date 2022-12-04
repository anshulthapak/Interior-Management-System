package com.anshul.interiormanagementsystem.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.anshul.interiormanagementsystem.entity.User;
import com.anshul.interiormanagementsystem.repo.UserRepository;

public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User u = userRepo.getUserByUsername(username);
		if(u==null) {
			throw new UsernameNotFoundException("Combination of email and password is invalid!!");
		}
		
		CustomUserDetails custUserDetails = new CustomUserDetails(u);
		return custUserDetails;
	}

}
