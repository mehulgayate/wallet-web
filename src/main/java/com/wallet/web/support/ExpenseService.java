package com.wallet.web.support;

import java.util.Date;
import java.util.List;

import net.sf.json.JSONObject;

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
	private DateTimeUtil dateTimeUtil;

	public void addExpnse(ExpenseForm form){
		Expense expense=new Expense();
		expense.setSpentMoney(form.getSpentMoney());
		expense.setTime(dateTimeUtil.provideDate(form.getTime()));
		expense.setType(ExpenseType.valueOf(form.getType()));

		dataStoreManager.save(expense);
		User user=repository.findUserById(form.getId());

		UserExpense userExpense=new UserExpense();
		userExpense.setUser(user);
		userExpense.setExpense(expense);
		dataStoreManager.save(userExpense);
	}

	public JSONObject getExpenses(Date startDate,Date endDate,User user){
		List<Expense> expenses= repository.listExpenses(user, startDate, endDate);
		JSONObject jsonObject=new JSONObject();
		System.out.println("***** "+expenses.size());
		int i=0;
		for (Expense expense : expenses) {
			JSONObject innrObject=new JSONObject();
			innrObject.put("date", dateTimeUtil.formatDate(expense.getTime(),"dd-MM-yyyy"));
			innrObject.put("amount", expense.getSpentMoney());
			innrObject.put("type", expense.getType().toString());
			jsonObject.put(i,innrObject);
			i++;
		}
		return jsonObject;
	}



	public void setDataStoreManager(DataStoreManager dataStoreManager) {
		this.dataStoreManager = dataStoreManager;
	}

	public void setRepository(Repository repository) {
		this.repository = repository;
	}

	public void setDateTimeUtil(DateTimeUtil dateTimeUtil) {
		this.dateTimeUtil = dateTimeUtil;
	}
	
}
