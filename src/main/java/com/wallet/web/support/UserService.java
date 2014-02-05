package com.wallet.web.support;

import com.evalua.entity.support.DataStoreManager;
import com.wallet.entity.User;
import com.wallet.entity.support.Repository;
import com.wallet.entity.support.UserForm;



public class UserService {
	
	private DataStoreManager dataStoreManager;
	
	public void setDataStoreManager(DataStoreManager dataStoreManager) {
		this.dataStoreManager = dataStoreManager;
	}
	
	private Repository repository;
	public void setRepository(Repository repository) {
		this.repository = repository;
	}




	public void addUser(UserForm userForm){
		User user=new User();
		user.setEmail(userForm.getEmail());
		user.setName(userForm.getName());
		user.setPassword(userForm.getPassword());
		dataStoreManager.save(user);
	}
	
	public User authenticate(String email,String password){
		User user=repository.findUserByEmail(email);
		if(user!=null){
			if(user.getPassword().equals(password)){
				return user;
			}
		}
		return null;
	}

}
