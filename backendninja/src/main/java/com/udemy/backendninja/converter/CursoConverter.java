package com.udemy.backendninja.converter;

import org.springframework.stereotype.Component;

import com.udemy.backendninja.entity.Curso;
import com.udemy.backendninja.model.CursoModel;

@Component("cursoConverter")
public class CursoConverter {
	
	//Entity >> Model
	public CursoModel entity2Model(Curso curso) {
		CursoModel cursoModel = new CursoModel();
		cursoModel.setName(curso.getName());
		cursoModel.setDescription(curso.getDescription());
		cursoModel.setPrice(curso.getPrice());
		cursoModel.setHours(curso.getHours());
		
		return cursoModel;
	}
	
	//Model >> Entity
	public Curso model2Entity(CursoModel cursoModel) {
		Curso curso = new Curso();
		curso.setName(cursoModel.getName());
		curso.setDescription(cursoModel.getDescription());
		curso.setPrice(cursoModel.getPrice());
		curso.setHours(cursoModel.getHours());
		
		return curso;
	}
}
