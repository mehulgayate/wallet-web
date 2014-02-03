package com.wallet.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wallet.entity.support.UserForm;
import com.wallet.web.support.UserService;

@Controller
public class UserController {

	@Resource
	private UserService userService;
	
	@RequestMapping("/register")
	public ModelAndView registerNewUser(HttpServletRequest request,@ModelAttribute(UserForm.key) UserForm userForm){
		ModelAndView mv=new ModelAndView("json-string");
		userService.addUser(userForm);
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("success", "success");
		mv.addObject("response", jsonObject);
		return mv;
	}
	
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request,@RequestParam String email,@RequestParam String password){
		ModelAndView mv=new ModelAndView("json-string");
		JSONObject jsonObject=new JSONObject();		
		if(userService.authenticate(email,password)){
			jsonObject.put("success", "success");
		}else{
			jsonObject.put("fail", "fail");
		}
		mv.addObject("response", jsonObject);
		return mv;
	}
	
	@RequestMapping("/page")
	public ModelAndView display(){
		ModelAndView mv=new ModelAndView("get-expenses");
		
		return mv;
	}
}
