package com.wallet.entity.support;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.wallet.entity.Expense.ExpenseType;

public class ExpenseForm {
	
	public static final String key="expenseForm";
	
	private Double spentMoney;
	private String type;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	

}
