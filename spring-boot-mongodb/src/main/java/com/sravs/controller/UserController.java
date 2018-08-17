package com.sravs.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sravs.dal.UserDAL;
import com.sravs.dal.UserRepository;
import com.sravs.model.User;

@RestController
@RequestMapping(value = "/")
public class UserController {

	private final Logger LOG = LoggerFactory.getLogger(getClass());

	private final UserRepository userRepository;
@Autowired
	private final UserDAL userDAL;
  
	public UserController(UserRepository userRepository, UserDAL userDAL) {
		this.userRepository = userRepository;
		this.userDAL = userDAL;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public User addNewUsers(@RequestBody User user) {
		LOG.info("Saving user!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		return userRepository.save(user);
	}

	
	@RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
	public List<User> getAllUsers() {
		LOG.info("getAllUsers user!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		return userDAL.getAllUsers();
	}
	
	
	@RequestMapping(value = "/getIdUsers/{userId}", method = RequestMethod.GET)
	public User getIdUsers(@PathVariable String userId) {
		LOG.info("Getting user with ID: {}.", userId);
		User user = userDAL.getIdUsers(userId);
		return user;
	}
	
	
	@RequestMapping(value = "/deleteUsers/{userId}", method = RequestMethod.GET)
	public String deleteUsers(@PathVariable String userId) {
		LOG.info("deleteUsers user!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		 userDAL.deleteUsers(userId);
		 return "success";
	}
	
	
	@RequestMapping(value = "/updateUsers", method = RequestMethod.POST)
	public User updateUsers(@RequestBody User user) {
		LOG.info("updateUsers user!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		return null;
	}
}