package com.wallet.web.support;

import com.evalua.entity.support.DataStoreManager;
import com.wallet.entity.User;
import com.wallet.entity.support.UserForm;



public class UserService {
	
	private DataStoreManager dataStoreManager;
	
	public void setDataStoreManager(DataStoreManager dataStoreManager) {
		this.dataStoreManager = dataStoreManager;
	}
	public void addUser(UserForm userForm){
		User user=new User();
		user.setEmail(userForm.getEmail());
		user.setName(userForm.getName());
		user.setPassword(userForm.getPassword());
		dataStoreManager.save(user);
	}

}
