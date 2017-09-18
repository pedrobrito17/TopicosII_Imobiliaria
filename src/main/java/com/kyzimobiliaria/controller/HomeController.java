package com.kyzimobiliaria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public ModelAndView getHome(){
		return new ModelAndView("pages/home");
	}
	
	@RequestMapping("/login")
	public String getLogin(){
		return "/entrar";
	}

}
