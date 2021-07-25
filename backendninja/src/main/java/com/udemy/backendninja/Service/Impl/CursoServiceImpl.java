package com.udemy.backendninja.Service.Impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.udemy.backendninja.Controller.CursoController;
import com.udemy.backendninja.Repository.CursoJpaRepository;
import com.udemy.backendninja.Service.CursoService;
import com.udemy.backendninja.entity.Curso;

@Service("cursoServiceImpl")
public class CursoServiceImpl implements CursoService{
	
	private static final Log LOG = LogFactory.getLog(CursoServiceImpl.class);
	
	@Autowired
	@Qualifier("cursoJpaRepository")
	private CursoJpaRepository cursoJpaRepository;
	
	@Override
	public List<Curso> listAllCursos() {
		LOG.info("Call: 'listAllCursos()'");
		return cursoJpaRepository.findAll();
	}

	@Override
	public Curso addCurso(Curso curso) {
		LOG.info("Call: 'addCurso()'");
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
