package com.udemy.backendninja.Controller;

import org.apache.commons.logging.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.udemy.backendninja.model.Person;


@Controller
@RequestMapping("/form")
public class FormController {
	
	public static final Log LOGGER = LogFactory.getLog(FormController.class);

	public static final String FORM_VIEW = "form";
	public static final String RESULT_VIEW = "result";
	
	//Primera forma de redireccionar
	/*@GetMapping("/")
	public String redirect() {
		
		return "redirect:/form/showForm";
	}*/
	
	//Segunda forma
	@GetMapping("/")
	public RedirectView redirectView() {
		
		return new RedirectView("/form/showForm");
	}
	
	@GetMapping("/showForm")
	public String showForm(Model model) {
		//Tipos de logs
		LOGGER.info("INFO TRACE");
		LOGGER.warn("WARNING TRACE");
		LOGGER.error("ERROR TRACE");
		LOGGER.debug("DEBUG TRACE");
		
		model.addAttribute("person", new Person());
		//int i = 6 / 0;
		return FORM_VIEW;
	}
	
	@PostMapping("/addperson")
	public ModelAndView addPerson(@ModelAttribute("person") Person person) {
		LOGGER.info("METHOD: 'addPerson' --- PARAMS: '" + person + "'");
		
		ModelAndView mav = new ModelAndView(RESULT_VIEW);
		mav.addObject("person", person);
		LOGGER.info("TEMPLATE: '" + RESULT_VIEW +"' -- DATA: '" + person + "'");
		
		return mav;
	}
}
