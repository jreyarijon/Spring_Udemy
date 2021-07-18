package com.udemy.backendninja.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/show")
public class EjercicioErroresController {
	
	@GetMapping("/404error")
	public String error404() {
		return "404";
	}
	
	@GetMapping("/500error")
	public String error500() {
		return "500";
	}
}
