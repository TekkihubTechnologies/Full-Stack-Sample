package com.tekkihub.sample1.users.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.tekkihub.sample1.users.model.Users;
import com.tekkihub.sample1.users.repository.UsersRepository;

@Service
@Component
public class UsersService {

	@Autowired
	private UsersRepository usersRepository;
	
	public Map<String, Object> createUser(Users userObj){
		Map<String,Object> returnMap = new HashMap<String,Object>();
		String serviceMessage = "";
		String serviceStatus = "";
		
		try {
			
			Users userObjIp = userObj;
			usersRepository.save(userObjIp);
			
			serviceMessage = "User created with registration id : "+ userObjIp.getId();
			serviceStatus = "Success";

		}catch (Exception ex) {
			ex.printStackTrace();
			serviceStatus = "Exception";
			serviceMessage = ex.getLocalizedMessage();
		}
		
		returnMap.put("serviceStatus", serviceStatus);
		returnMap.put("serviceMessage", serviceMessage);		
		return returnMap;
	}
	
	public Map<String, Object> updateUser(Users userObj){
		Map<String,Object> returnMap = new HashMap<String,Object>();
		String serviceMessage = "";
		String serviceStatus = "";
		
		try {
			
			Users userObjIp = userObj;
			usersRepository.save(userObjIp);
			
			serviceMessage = "User update";
			serviceStatus = "Success";

		}catch (Exception ex) {
			ex.printStackTrace();
			serviceStatus = "Exception";
			serviceMessage = ex.getLocalizedMessage();
		}
		
		returnMap.put("serviceStatus", serviceStatus);
		returnMap.put("serviceMessage", serviceMessage);		
		return returnMap;
	}
	
	public List<Users> getAllUsers(){
		return usersRepository.findAll();
	}
	
	public Users getUsersById(Long id){
		return usersRepository.getById(id);
	}
	
	public Map<String, Object> deleteUserById(Long id){
		Map<String,Object> returnMap = new HashMap<String,Object>();
		String serviceMessage = "";
		String serviceStatus = "";
		
		try {
			Users userObj = usersRepository.getById(id);
			usersRepository.delete(userObj);
			serviceMessage = "User deleted";
			serviceStatus = "Success";
		}catch (Exception ex) {
			ex.printStackTrace();
			serviceStatus = "Exception";
			serviceMessage = ex.getLocalizedMessage();
		}
		
		returnMap.put("serviceStatus", serviceStatus);
		returnMap.put("serviceMessage", serviceMessage);		
		return returnMap;
	}
	
}
