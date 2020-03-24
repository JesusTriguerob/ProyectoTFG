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

import com.tfg.model.entity.Usuario;
import com.tfg.model.service.UsuarioService;



@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class UsuarioRestController {

	@Autowired
	private UsuarioService usuarioService;
	
	//LISTA TODOS LOS ALUMNOS
	@GetMapping("/usuarios")
	public List<Usuario> index(){
		return usuarioService.findAll();
	}
	
	//BUSCA UN ALUMNO
	@GetMapping("/usuarios/{id}")
	public Usuario show(@PathVariable Long id) {
		return usuarioService.findById(id);
	}
	
	//CREAR ALUMNO
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario create(@RequestBody Usuario usuario) {
		return usuarioService.create(usuario);
	}
	
	//ACTUALIZA ALUMNO
	@PutMapping("/usuarios/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario update(@RequestBody Usuario alumno , @PathVariable Long id) {
//		Usuario alumnoAct = usuarioService.findById(id);
//		
//		alumnoAct.setApellido(alumno.getApellido());
//		alumnoAct.setNombre(alumno.getNombre());
//		alumnoAct.setCurso(alumno.getCurso());
//		alumnoAct.setFechaNac(alumno.getFechaNac());
		
//		return usuarioService.save(alumnoAct);
		return null;
	}
	
	//BORRA UN ALUMNO
	@DeleteMapping("/usuarios/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		usuarioService.delete(id);
	}
}
