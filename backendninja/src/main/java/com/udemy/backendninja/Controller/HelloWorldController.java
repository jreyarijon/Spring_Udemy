package com.udemy.backendninja.Controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.backendninja.component.ExampleComponent;
import com.udemy.backendninja.model.Person;

@Controller
@RequestMapping("/say")
public class HelloWorldController {
	
	public static final String HELLO_FILE = "helloworld";
	
	@Autowired
	@Qualifier("exampleComponent")
	private ExampleComponent exampleComponent;
	
	//Formas de retornar una plantilla
	// 1 --> Nos ahorramos escribir todo el rato la variable method
	@GetMapping("/helloWorld")
	public String helloWorld(Model model) {
		model.addAttribute("people", getPeople());
		return HELLO_FILE;
	}
	
	// 2
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public String hello() {
		exampleComponent.sayHello();
		return HELLO_FILE;
	}
	
	// 3
	@RequestMapping(value="/mav", method=RequestMethod.GET)
	public ModelAndView helloMAV() {
		ModelAndView mav = new ModelAndView("helloworld");
		mav.addObject("person", new Person("Mikel", 30));
		
		return mav;
	}
	
	private List<Person> getPeople(){
		List<Person> people = new ArrayList();
		people.add(new Person("Jon", 23));
		people.add(new Person("Mikel", 34));
		people.add(new Person("Pablo", 25));
		people.add(new Person("Paula", 62));
		people.add(new Person("Ana", 12));
		return people;
	}
	
}
