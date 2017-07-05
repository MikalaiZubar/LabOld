package com.epam.zubar.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.epam.zubar.service.AddService;

@Controller          //defines class as controller
public class AddController {
	/*
	@RequestMapping("/add")  // according to action value in view form
	public ModelAndView add(HttpServletRequest request, HttpServletResponse response){
		
		int a = Integer.parseInt(request.getParameter("t1"));
		int b = Integer.parseInt(request.getParameter("t2"));
		
		int c = new AddService(a, b).add();
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("firstpage");  // setting view page name
		mv.addObject("result", c);   //adding info to model with name - result and value - c
		
		// return "firstpage.jsp"; // returning name of the .jsp file when method returns String
		
		return mv; // returning model and view
	}
	
	*/
	
	//the same code using RequestParam annotation
	
	@RequestMapping("/add")  // according to action value in view form
	public ModelAndView add(@RequestParam("t1") int a, @RequestParam("t2") int b, HttpServletRequest request, HttpServletResponse response){
				
		int c = new AddService(a, b).add();
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("firstpage");   //name of view page
		mv.addObject("result", c);  
		
		System.out.println(c);
		
		return mv; // returning model and view
	}
}
