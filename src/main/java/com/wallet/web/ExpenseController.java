package com.wallet.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wallet.entity.User;
import com.wallet.entity.support.ExpenseForm;
import com.wallet.entity.support.Repository;
import com.wallet.web.support.DateTimeUtil;
import com.wallet.web.support.ExpenseService;

@Controller
public class ExpenseController {
	
	@Resource
	private ExpenseService expenseService;
	
	@Resource
	private Repository repository;
	
	@Resource
	private DateTimeUtil dateTimeUtil;

	@RequestMapping("/expense/add")
	public ModelAndView addExpnse(HttpServletRequest request,@ModelAttribute(ExpenseForm.key) ExpenseForm form){
	ModelAndView mv=new ModelAndView("json-string");
		expenseService.addExpnse(form);
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("success", "success");
		mv.addObject("response", jsonObject);
		return mv;
	}
	
	@RequestMapping("/expense/get.json")
	public ModelAndView addExpnse(HttpServletRequest request,@RequestParam String startDate,@RequestParam String endDate,@RequestParam Long id){
	ModelAndView mv=new ModelAndView("json-string");
	    User user=repository.findUserById(id);		
		mv.addObject("expenses", expenseService.getExpenses(dateTimeUtil.provideDate(startDate), dateTimeUtil.provideDate(endDate), user));
		return mv;
	}
	
	 
}
