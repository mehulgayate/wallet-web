package com.wallet.entity;

import java.util.Date;

import javax.persistence.Entity;

import com.evalua.entity.support.EntityBase;

@Entity
public class Expense extends EntityBase {
	
	public enum ExpenseType{
		FOOD,GROCERY,DONATION,OTHER;
	}

	private Double spentMoney;
	private ExpenseType type;
	private Date time;
	
	
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
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}	
}
