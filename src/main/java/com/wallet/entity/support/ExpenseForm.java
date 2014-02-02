package com.wallet.entity.support;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.wallet.entity.Expense.ExpenseType;

public class ExpenseForm {
	
	private Double spentMoney;
	private String type;
	private Date time;
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
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
	

}
