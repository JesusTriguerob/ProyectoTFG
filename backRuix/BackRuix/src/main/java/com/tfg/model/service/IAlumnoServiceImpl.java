package com.tfg.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tfg.model.dao.IAlumnoDao;
import com.tfg.model.entity.Alumno;

@Service
public class IAlumnoServiceImpl implements IAlumnoService{

	//Inyección del alumnoDao.
	@Autowired
	private IAlumnoDao alumnoDao;
	
	@Override
	@Transactional(readOnly = true) // evitable en los implementados del dao de spring, obligatorio en las queries propias
	public List<Alumno> findAll() {
		return (List<Alumno>) alumnoDao.findAll(); //Casteo porque devuelve un Iterable
	}

	@Transactional(readOnly = true)
	@Override
	public Alumno findById(Long id) {
		return alumnoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Alumno save(Alumno alumno) {
		return alumnoDao.save(alumno);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		alumnoDao.deleteById(id);
	}

}
