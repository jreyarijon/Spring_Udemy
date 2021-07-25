package com.udemy.backendninja.Repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.udemy.backendninja.entity.Curso;

@Repository("coursejparepository")
public interface CursoJpaRepository extends JpaRepository<Curso, Serializable>{
	
	//Crea queries automaticamente

	public abstract Curso findByPrice(int price);
	
	public abstract Curso findByPriceAndName(int price, String name);
	
	public abstract List<Curso> findByNameOrderByHours(String name);
	
	public abstract Curso findByNameOrPrice(String name, int price);
}
