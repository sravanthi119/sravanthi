package com.sravs.dal;


import java.util.List;

import com.sravs.model.User;

public interface UserDAL {


	User addNewUser(User user);

	List<User> getAllUsers();
	
	User getIdUsers(String id);
	
	String deleteUsers(String id);
	
	User updateUsers(User user);
}