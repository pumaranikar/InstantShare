package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {

	@RequestMapping("/welcome")
	public ModelAndView InstaShare(){
		
		String message = "<br><div style='text-align:center;'>"
				+ "<h3>********** WECLOME ********</h3></div><br><br>";
		return new ModelAndView("welcome", "message", message);
	}
}
