package com.tfg.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tfg.model.entity.Alumno;
import com.tfg.model.service.IAlumnoService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class AlumnoRestController {

	@Autowired
	private IAlumnoService alumnoService;
	
	//LISTA TODOS LOS ALUMNOS
	@GetMapping("/alumnos")
	public List<Alumno> index(){
		return alumnoService.findAll();
	}
	
	//BUSCA UN ALUMNO
	@GetMapping("/alumnos/{id}")
	public Alumno show(@PathVariable Long id) {
		return alumnoService.findById(id);
	}
	
	//CREAR ALUMNO
	@PostMapping("/alumnos")
	@ResponseStatus(HttpStatus.CREATED)
	public Alumno create(@RequestBody Alumno alumno) {
		return alumnoService.save(alumno);
	}
	
	//ACTUALIZA ALUMNO
	@PutMapping("/alumnos/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Alumno update(@RequestBody Alumno alumno , @PathVariable Long id) {
		Alumno alumnoAct = alumnoService.findById(id);
		
		alumnoAct.setApellido(alumno.getApellido());
		alumnoAct.setNombre(alumno.getNombre());
		alumnoAct.setCurso(alumno.getCurso());
		alumnoAct.setFechaNac(alumno.getFechaNac());
		
		return alumnoService.save(alumnoAct);
	}
	
	//BORRA UN ALUMNO
	@DeleteMapping("/alumnos/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		alumnoService.delete(id);
	}
}
