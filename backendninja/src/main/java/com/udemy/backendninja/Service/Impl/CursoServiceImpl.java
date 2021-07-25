package com.udemy.backendninja.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.udemy.backendninja.Repository.CursoJpaRepository;
import com.udemy.backendninja.Service.CursoService;
import com.udemy.backendninja.entity.Curso;

public class CursoServiceImpl implements CursoService{
	
	@Autowired
	@Qualifier("cursoJpaRepository")
	CursoJpaRepository cursoJpaRepository;
	
	@Override
	public List<Curso> listAllCursos() {
		return cursoJpaRepository.findAll();
	}

	@Override
	public Curso addCurso(Curso curso) {
		return cursoJpaRepository.save(curso);
	}

	@Override
	public int removeCurso(int id) {
		cursoJpaRepository.deleteById(id);
		return 0;
	}

	@Override
	public Curso updateCurso(Curso curso) {
		return cursoJpaRepository.save(curso);
	}

}
