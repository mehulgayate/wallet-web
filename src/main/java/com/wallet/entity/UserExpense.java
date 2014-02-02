package com.wallet.entity;

import javax.persistence.Entity;

import com.evalua.entity.support.EntityBase;

@Entity
public class UserExpense extends EntityBase{

	private User user;
	private Expense expense;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Expense getExpense() {
		return expense;
	}
	public void setExpense(Expense expense) {
		this.expense = expense;
	}
	
	
}
