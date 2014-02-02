package com.wallet.web.support;

import com.evalua.entity.support.DataStoreManager;
import com.wallet.entity.Expense;
import com.wallet.entity.Expense.ExpenseType;
import com.wallet.entity.User;
import com.wallet.entity.UserExpense;
import com.wallet.entity.support.ExpenseForm;
import com.wallet.entity.support.Repository;

public class ExpenseService {

	private DataStoreManager dataStoreManager;
	private Repository repository;

	public void addExpnse(ExpenseForm form){
		Expense expense=new Expense();
		expense.setSpentMoney(form.getSpentMoney());
		expense.setTime(form.getTime());
		expense.setType(ExpenseType.valueOf(form.getType()));

		dataStoreManager.save(expense);
		User user=repository.findUserById(form.getId());

		UserExpense userExpense=new UserExpense();
		userExpense.setUser(user);
		userExpense.setExpense(expense);
		dataStoreManager.save(userExpense);
	}

	public void setDataStoreManager(DataStoreManager dataStoreManager) {
		this.dataStoreManager = dataStoreManager;
	}

	public void setRepository(Repository repository) {
		this.repository = repository;
	}
	
	

}
