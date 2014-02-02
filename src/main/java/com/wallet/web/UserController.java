package com.wallet.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wallet.entity.support.UserForm;
import com.wallet.web.support.UserService;

@Controller
public class UserController {

	@Resource
	private UserService userService;
	
	@RequestMapping("/register")
	public ModelAndView registerNewUser(HttpServletRequest request,@ModelAttribute(UserForm.key) UserForm userForm){
		ModelAndView mv=new ModelAndView("signup/complete");
		userService.addUser(userForm);
		return mv;
	}
}
