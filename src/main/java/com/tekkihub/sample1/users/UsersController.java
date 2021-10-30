package com.tekkihub.sample1.users;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tekkihub.sample1.users.model.Users;
import com.tekkihub.sample1.users.service.UsersService;

@RestController
public class UsersController {

	@Autowired
	private UsersService usersService;
	
	
	@PostMapping("/createUser")
	ResponseEntity<Map<String,Object>> createUser(@RequestBody Users userObj){	
		return new ResponseEntity<Map<String,Object>>(usersService.createUser(userObj),  HttpStatus.OK);
	}
	
	@PutMapping("/updateUser")
	ResponseEntity<Map<String,Object>> updateUser(@RequestBody Users userObj){	
		return new ResponseEntity<Map<String,Object>>(usersService.updateUser(userObj),  HttpStatus.OK);
	}
	
	@GetMapping("/getAllUsers")
	ResponseEntity<List<Users>> getAllUsers(){	
		return new ResponseEntity<List<Users>>(usersService.getAllUsers(),  HttpStatus.OK);
	}
	
	@GetMapping("/getUserById/{id}")
	ResponseEntity<Users> getUserById(@PathVariable Long id){	
		return new ResponseEntity<Users>(usersService.getUsersById(id),  HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteByUserId/{id}")
	ResponseEntity<Map<String,Object>> deleteUserById(@PathVariable Long id){	
		return new ResponseEntity<Map<String,Object>>(usersService.deleteUserById(id),  HttpStatus.OK);
	}
	
	
	
}
