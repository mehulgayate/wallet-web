package com.wallet.entity.support;

import java.util.Date;

import com.wallet.entity.Expense.ExpenseType;

public class ExpenseForm {
	
	private Double spentMoney;
	private ExpenseType type;
	private String time;
	private Long id;	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getSpentMoney() {
		return spentMoney;
	}
	public void setSpentMoney(Double spentMoney) {
		this.spentMoney = spentMoney;
	}
	public ExpenseType getType() {
		return type;
	}
	public void setType(ExpenseType type) {
		this.type = type;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	

}
