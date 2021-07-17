package com.udemy.backendninja.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/say2")
public class HelloWorldController1 {
	
	private static final String HELLO_VIEW = "example2";
	
	//localhost:8080/say2/request1?nm=JON
	//localhost:8080/say2/request1?nm=MIKEL
	@GetMapping("/request1")
	public ModelAndView request1(@RequestParam(name ="nm", required=false, defaultValue = "World") String name) {
		ModelAndView mav = new ModelAndView(HELLO_VIEW);
		mav.addObject("nm_in_model", name);
		
		return mav;
	}
	
	//localhost:8080/say2/request2/JON
	//localhost:8080/say2/request2/MIKEL
	
	@GetMapping("request2/{nm}")
	public ModelAndView request2(@PathVariable("nm") String name) {
		ModelAndView mav = new ModelAndView(HELLO_VIEW);
		mav.addObject("nm_in_model", name);
		
		return mav;
	}
}
