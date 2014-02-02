package com.wallet.entity.support;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.wallet.entity.User;

public class Repository {
	
	
	@Resource
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	public User findUserByEmail(String email){
		return (User) getSession().createQuery("From "+User.class.getName()+" where email=:email")
				.setParameter("email",email).uniqueResult();
	}

	public User findUserById(Long id){
		return (User) getSession().createQuery("From "+User.class.getName()+" where id=:id")
				.setParameter("id",id).uniqueResult();	
	}

}
