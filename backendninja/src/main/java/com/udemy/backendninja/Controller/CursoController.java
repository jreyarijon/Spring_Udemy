package com.udemy.backendninja.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.backendninja.Service.CursoService;
import com.udemy.backendninja.entity.Curso;

@Controller
@RequestMapping("/cursos")
public class CursoController {
	
	private static final String CURSOS_VIEW = "cursos";
	
	@Autowired
	@Qualifier("cursoServiceImpl")
	private CursoService cursoService;
	
	@GetMapping("/listCursos")
	public ModelAndView listAllCursos() {
		ModelAndView mav = new ModelAndView(CURSOS_VIEW);
		mav.addObject("cursos", cursoService.listAllCursos());
		return mav;
	}
	
	@PostMapping("/addCurso")
	public String addCurso(@ModelAttribute("cursos") Curso curso) {
		cursoService.addCurso(curso);
		return "redirect:/listCursos";
	}
	
}
