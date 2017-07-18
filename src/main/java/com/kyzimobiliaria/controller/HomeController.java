package com.kyzimobiliaria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/kyzimobiliaria")
public class HomeController {
	
	@RequestMapping("/home")
	public ModelAndView getHome(){
		return new ModelAndView("pages/home");
	}

}
