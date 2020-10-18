package com.tfg.back.service;

import java.util.List;

import com.tfg.back.entity.Libro;

public interface LibroService {

	public List<Libro> findAll();
	
	public void save(Libro libro);
	
	public Libro findById(Long id);
	
	public void delete(Libro libro);
	
}
