package com.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.manager.UserManager;
import com.model.RegisterUser;
import com.model.User;

@Controller
public class LoginController {

		@Autowired
		private UserManager userManager;
	
		@RequestMapping(value ="/login", method=RequestMethod.POST)
		public ModelAndView executeLogin(HttpServletRequest request, HttpServletResponse response, 
				@ModelAttribute("User")User user) {
			ModelAndView model = null;
			try{
				boolean isUserExists = userManager.validateUserIdentity(user.getUserName(), user.getPassword());
				
				if(isUserExists) {
					request.setAttribute("LoggedInUser", user.getUserName());
					model = new ModelAndView("welcome");
				}
				else {
					model = new ModelAndView("login");
					model.addObject("user", user);
					request.setAttribute("message", "Invalid username or password");
				}
			}catch(Exception e) {
				e.printStackTrace();
				model = new ModelAndView("error");
			}
			
			return model; 
		}
		
		@RequestMapping(value="/register", method=RequestMethod.POST)
		public ModelAndView registerUser(HttpServletRequest request, HttpServletResponse response,
				@ModelAttribute("registerForm") RegisterUser registerUser) {
			
			ModelAndView model = null;
			
			try {
				// call to UserManager for register user.
				Map<String, Object> regUser = new HashMap<String, Object>();
				regUser.put("username", registerUser.getUsername());
				regUser.put("name", registerUser.getName());
				regUser.put("password", registerUser.getPassword());
				regUser.put("email", registerUser.getEmail());
				
				boolean success = userManager.registerUser(regUser);
				model = new ModelAndView("login");
				request.setAttribute("message", "registration successful");
				
			}catch(Exception e) {
				e.printStackTrace();
				model = new ModelAndView("register");
				request.setAttribute("message", "Registration failed");
			}
			
			return model;
		} 
		
}
	
		