package com.tfg.back.service;

import java.util.List;

import com.tfg.back.entity.Libro;
import com.tfg.back.enums.Alquilado;

public interface LibroService {

	public List<Libro> findAll();
	
	public List<Libro> getBooksForState();
	
	public void save(Libro libro);
	
	public Libro findById(Long id);
	
	public void delete(Libro libro);
	
}
