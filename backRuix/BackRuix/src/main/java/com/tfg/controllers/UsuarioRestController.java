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
	private UsuarioService Usuarioservice;
	
	//LISTA TODOS LOS ALUMNOS
	@GetMapping("/usuario")
	public List<Usuario> index(){
		return Usuarioservice.findAll();
	}
	
	//BUSCA UN ALUMNO
	@GetMapping("/usuario/{id}")
	public Usuario show(@PathVariable Long id) {
		return Usuarioservice.findById(id);
	}
	
	//CREAR ALUMNO
	@PostMapping("/alumnos")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario create(@RequestBody Usuario alumno) {
		return Usuarioservice.save(alumno);
	}
	
	//ACTUALIZA ALUMNO
	@PutMapping("/alumnos/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario update(@RequestBody Usuario usuario , @PathVariable Long id) {
		Usuario usuarioAct = Usuarioservice.findById(id);
//		TODO rellenar con los sets
//		usuarioAct.setApellido1(usuario.getApellido1());
//		usuarioAct.setNombre(usuario.getNombre());
//		usuarioAct.setCurso(alumno.getCurso());
//		usuarioAct.setFechaNac(alumno.getFechaNac());
		
		return Usuarioservice.save(usuarioAct);
	}
	
	//BORRA UN ALUMNO
	@DeleteMapping("/alumnos/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		Usuarioservice.delete(id);
	}
}
