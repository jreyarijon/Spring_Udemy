package com.udemy.backendninja.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import com.udemy.backendninja.entity.Curso;
import com.udemy.backendninja.entity.QCurso;

@Repository("queryDSLExampleRepo")
public class QueryDSLExampleRepo {

	private QCurso qCurso = QCurso.curso;
	
	@PersistenceContext
	private EntityManager em;
	
	//select(tabla), from(tabla), where(condicion)
	public Curso find(boolean exist) {
		JPAQuery<Curso> query = new JPAQuery<Curso>(em);
		
		Predicate predicate1 = qCurso.description.endsWith("OP");
		BooleanBuilder predicateBuilder = new BooleanBuilder(predicate1);
		
		if(exist) {
			Predicate predicate2 = qCurso.id.eq(23);
			predicateBuilder.and(predicate2);
		}else {
			Predicate predicate3 = qCurso.name.endsWith("OP");
			predicateBuilder.or(predicate3);
		}
		//Curso curso1 = query.select(qCurso).from(qCurso).where(qCurso.id.eq(23)).fetchOne();
		Curso curso1 = query.select(qCurso).from(qCurso).where(predicateBuilder).fetchOne();
		//List<Curso> cursos = query.select(qCurso).from(qCurso).where(qCurso.hours.between(20, 50)).fetch();
		return curso1;
	}
}
