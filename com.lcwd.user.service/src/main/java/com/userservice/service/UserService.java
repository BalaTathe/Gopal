package com.userservice.service;

import java.util.List;

import com.userservice.entity.User;

public interface UserService {
	//user opration 
	//create
	
	User saveUser(User user);
	
	//get all user
	List<User>getAllUser();
	
	//get single user with of given userID
	
	User getUser(String userId);
	

}
