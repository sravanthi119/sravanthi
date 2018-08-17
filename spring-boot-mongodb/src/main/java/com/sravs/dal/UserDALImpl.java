package com.sravs.dal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.sravs.model.User;

@Repository
public class UserDALImpl implements UserDAL {

	@Autowired
	private MongoTemplate mongoTemplate;

	
	@Override
	public User addNewUser(User user) {
		mongoTemplate.save(user);
		// Now, user object will contain the ID as well
		return user;
	}


	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return mongoTemplate.findAll(User.class);
	}


	@Override
	public User getIdUsers(String id) {
		// TODO Auto-generated method stub
		return mongoTemplate.findById(id, User.class);
	}


	@Override
	public String deleteUsers(String id) {
		// TODO Auto-generated method stub
		System.out.println("DELETE================");
		User user=getIdUsers(id);
		mongoTemplate.remove(user);
		return "sucess";
	}


	@Override
	public User updateUsers(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	
	  
}
