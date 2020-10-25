package com.tfg.back.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tfg.back.dao.LibroDao;
import com.tfg.back.entity.Libro;
import com.tfg.back.enums.Alquilado;

@Service
public class LibroServiceImpl implements LibroService{

	@Autowired
	private LibroDao libroDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Libro> findAll() {
		return (List<Libro>) libroDao.findAll();
	}

	@Override
	@Transactional
	public void save(Libro libro) {
		libroDao.save(libro);
	}

	@Override
	@Transactional(readOnly = true)
	public Libro findById(Long id) {
		return libroDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Libro libro) {
		libroDao.delete(libro);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Libro> getBooksForState() {
		return (List<Libro>) libroDao.findAll();
	}

}
