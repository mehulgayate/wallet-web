package com.wallet.entity.support;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.wallet.entity.Expense;
import com.wallet.entity.User;
import com.wallet.entity.UserExpense;

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
	
	public List<Expense> listExpenses(User user,Date startDate,Date endDate){
		return getSession().createQuery("select expense From "+UserExpense.class.getName()+" ex where ex.user=:user AND ex.expense.time>=:startDate AND ex.expense.time<=:endDate")
				.setParameter("user", user)
				.setParameter("startDate", startDate)
				.setParameter("endDate",endDate).list();
	}

}
