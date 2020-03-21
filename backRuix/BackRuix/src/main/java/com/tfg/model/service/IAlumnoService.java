package com.tfg.model.service;

import java.util.List;

import com.tfg.model.entity.Alumno;

public interface IAlumnoService {

	public List<Alumno> findAll();
	
	public Alumno findById(Long id);
	
	public Alumno save(Alumno alumno);
	
	public void delete(Long id);
	
}
